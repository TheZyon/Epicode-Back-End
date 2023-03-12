package com.SpringBoot_SpringSecurity.repository;

import com.SpringBoot_SpringSecurity.entity.Dispositivo;
import com.SpringBoot_SpringSecurity.entity.Stato;
import com.SpringBoot_SpringSecurity.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DispositivoRepository extends CrudRepository<Dispositivo, Long> {

public List<Dispositivo> getDispositivosByUser(User u);
public List<Dispositivo> getDispositivosByStato(Stato stato);

}
