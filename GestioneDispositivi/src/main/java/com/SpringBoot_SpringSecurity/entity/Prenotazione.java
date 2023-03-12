package com.SpringBoot_SpringSecurity.entity;

import com.SpringBoot_SpringSecurity.repository.UserRepository;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "prenotazioni")
public class Prenotazione {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    @NonNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="dispositivo_id")
    private Dispositivo dispositivo;

    @NonNull Timestamp data;

    public Prenotazione(User user, @NonNull Dispositivo dispositivo, @NonNull Timestamp data) {
        this.user = user;
        this.dispositivo = dispositivo;
        this.data = data;
    }
}
