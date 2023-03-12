package com.SpringBoot_SpringSecurity.service;

import com.SpringBoot_SpringSecurity.entity.Dispositivo;
import com.SpringBoot_SpringSecurity.entity.Stato;
import com.SpringBoot_SpringSecurity.entity.User;
import com.SpringBoot_SpringSecurity.exception.DispositioAssegnatoAdUtenteException;
import com.SpringBoot_SpringSecurity.exception.ResourceNotFoundException;
import com.SpringBoot_SpringSecurity.repository.DispositivoRepository;
import com.SpringBoot_SpringSecurity.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

@Autowired private DispositivoRepository repo;
@Autowired private UserRepository repoUser;
//  create
public void createWithNomeAndStato(String nome, Stato stato){
    repo.save(new Dispositivo(nome, stato));
}
public void create(Dispositivo d){
    repo.save(d);
}

public void createFromList(List<Dispositivo> dispositivi){
    repo.saveAll(dispositivi);
}


//  read
    public Dispositivo getByID(Long id){
    return  repo.findById(id).orElseThrow(()-> new EntityNotFoundException("non c'è nessun dispositivo con questo id!"));
    }

    public List<Dispositivo> getDispositiviDisponibili(){
    return repo.getDispositivosByStato(Stato.DISPONIBILE);
    }
    public List<Dispositivo> getAll(){
    return (List<Dispositivo>) repo.findAll();
    }

//    update
    @Transactional
    public void updateStato(Stato nuovo, Long id){
    var d=getByID(id);
    d.setStato(nuovo);
    repo.save(d);
    }

    @Transactional //TODO---> verificare anche eccezioni di assegnaDispositivoAUser()
    /*
    * 1. leggo dispositivo e user dal db
    * 2. verifico che il dispositivo possa essere assegnato
    * 3. lo assegno o lancio eccezione
    *
    * */
    public void assegnaDispositivoAUser(Long id_disp, Long id_user){

    //1.
    Dispositivo d=getByID(id_disp);
    User u= repoUser.findById(id_user).orElseThrow(
            ()->new EntityNotFoundException("utente con questo id non esiste!!")
    );
    //2. & 3.
    if(d.getUser()==null&&(d.getStato().equals(Stato.DISMESSO)||d.getStato().equals(Stato.DISPONIBILE))){
        d.setUser(u);
        d.setStato(Stato.ASSEGNATO);
        repo.save(d);
    }
    else throw new DispositioAssegnatoAdUtenteException("il dispositivo è già assegnato ad un utente!!");

    }

    @Transactional
    public void freeDispositivo(Long id){
    var d=getByID(id);
    d.setUser(null);
    d.setStato(Stato.DISPONIBILE);
    repo.save(d);
    }

//    delete
    public void deleteByID(Long id){
    repo.deleteById(id);
    }

}
