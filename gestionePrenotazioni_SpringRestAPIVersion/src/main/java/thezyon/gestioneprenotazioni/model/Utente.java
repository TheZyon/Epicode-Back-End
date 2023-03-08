package thezyon.gestioneprenotazioni.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull //used for the @RequiredArgsConstructor included in @Data
    private String username;
    @NonNull
    private String nomeCompleto;
    @NonNull
    private String email;

    //bidirectional 1-* with Prenotazione
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utente")
    List<Prenotazione> prenotazioni;

    //convenience method
    public void addPrenotazione(Prenotazione p){
        if(prenotazioni==null) prenotazioni=new ArrayList<Prenotazione>();
        prenotazioni.add(p);
    }

    public Utente(Integer id, @NonNull String username, @NonNull String nomeCompleto, @NonNull String email) {
        this.id = id;
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }
}
