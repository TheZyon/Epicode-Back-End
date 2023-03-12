package com.SpringBoot_SpringSecurity.service;

import com.SpringBoot_SpringSecurity.entity.Dispositivo;
import com.SpringBoot_SpringSecurity.entity.Prenotazione;
import com.SpringBoot_SpringSecurity.entity.Stato;
import com.SpringBoot_SpringSecurity.entity.User;
import com.SpringBoot_SpringSecurity.repository.PrenotazioneRepository;
import com.SpringBoot_SpringSecurity.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired private PrenotazioneRepository repo;
    @Autowired private UserRepository userRepository;
    @Autowired private DispositivoService dispositivoService;

//    create
    @Transactional
    public void create(Prenotazione p){ //crea prenotazione e aggiorna stato dispositivo a ASSEGNATO

        repo.save(p);
        var id_dispositivo= p.getDispositivo().getId();
        dispositivoService.updateStato(Stato.DISMESSO, id_dispositivo);

    }

    public void createAll(List<Prenotazione> prenotazioni){
        repo.saveAll(prenotazioni);
    }

    public void customCreate(List<Triple<Long,Long,Timestamp>> initializer){
    //crea prenotazioni partendo da una lista di terne <user_id, dispositivo_id, data>

    initializer.stream().forEach(triple->{

                User u= userRepository.getById(triple.getLeft());
                Dispositivo d= dispositivoService.getByID((triple.getMiddle()));
                Timestamp t=triple.getRight();
                create(new Prenotazione(u,d,t));
            }
    );


    }

//    retrieve
    public Prenotazione getById(Long id){
        return repo.findById(id)
                .orElseThrow(()->new EntityNotFoundException("La prenotazione con questo id non esiste!"));
    }
    public List<Prenotazione> getAll(){
        return (List<Prenotazione>) repo.findAll();
    }

//    delete
    public void mastroLindo(){
        repo.deleteAll();
    }

    public void deletePrenotazioneById(Long id){
        repo.deleteById(id);
    }

//    accettazione prenotazione
    @Transactional
    public void accettaPrenotazioneById(Long id){
        var p=getById(id);
        dispositivoService.assegnaDispositivoAUser(p.getDispositivo().getId(), p.getUser().getId());
        deletePrenotazioneById(id);
    }


}
