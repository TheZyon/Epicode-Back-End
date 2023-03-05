package thezyon.gestioneprenotazioni.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descrizione; //this field can be null

    @Enumerated(EnumType.STRING) //TODO
    @NonNull
    private Tipo tipo;

    @NonNull
    private Integer numeroMaxOccupanti;

    @NonNull
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,  CascadeType.REFRESH})
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;



    //bidirectional 1-* with Prenotazione
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postazione")
    List<Prenotazione> prenotazioni;

    //convenience method
    public void addPrenotazione(Prenotazione p){
        if(prenotazioni==null) prenotazioni=new ArrayList<Prenotazione>();
        prenotazioni.add(p);
    }





    public Postazione(String descrizione, @NonNull Tipo tipo, @NonNull Integer numeroMaxOccupanti, @NonNull Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroMaxOccupanti = numeroMaxOccupanti;
        this.edificio = edificio;
    }
}
