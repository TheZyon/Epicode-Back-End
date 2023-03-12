package com.SpringBoot_SpringSecurity.repository;

import com.SpringBoot_SpringSecurity.entity.Prenotazione;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long> {
}
