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
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String nome;
    @NonNull
    private String indirizzo;
    @NonNull
    private String citta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edificio")
    List<Postazione> postazioni;

    //convenience method
    public void addPostazione(Postazione p){
        if(postazioni==null) postazioni=new ArrayList<Postazione>();
        postazioni.add(p);
    }

}
