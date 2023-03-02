package thezyon.godfathersdemo_jpa.model;


import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.tuple.Pair;


import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "ordine")
@NoArgsConstructor
@Data
public class Ordine {
//@Value("#{new Double('${item.priceFactor}')}")
    //@Value("#{new Double('${godfathersPizza.prezzoCoperto}')}")



    @Column
    private double prezzo_coperto=5;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int numeroOrdine;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_tavolo")
    private Tavolo tavolo;

//    private com.GodfathersPizza.model.StatoOrdine statoOrdine;

    private int numeroCoperti;

    private Timestamp oraAcquisizione;

    /*private List<Pair<Prodotto, String>> elementi;

    public Ordine(int numeroOrdine, Tavolo tavolo, com.GodfathersPizza.model.StatoOrdine statoOrdine, int numeroCoperti, Timestamp oraAcquisizione, List<Pair<com.GodfathersPizza.model.Prodotto, String>> elementi) {
        this.numeroOrdine = numeroOrdine;
        this.tavolo = tavolo;
        this.statoOrdine = statoOrdine;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = oraAcquisizione;
        this.elementi = elementi;
    }

    public Ordine(int numeroOrdine, Tavolo tavolo, com.GodfathersPizza.model.StatoOrdine statoOrdine, int numeroCoperti, Timestamp oraAcquisizione) {
        this.numeroOrdine = numeroOrdine;
        this.tavolo = tavolo;
        this.statoOrdine = statoOrdine;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = oraAcquisizione;
    }

    public void addElemento(Pair<com.GodfathersPizza.model.Prodotto, String>elemento){
        elementi.add(elemento);
    }

    public double importoTotale(){

        var sommaCostiElementi= elementi.stream()
                .mapToDouble(e->((Pair<com.GodfathersPizza.model.Prodotto,String>)e).getKey().getPrezzo())
                .sum();
        var sommaCoperti= numeroCoperti*prezzoCoperto;

        return sommaCoperti+sommaCostiElementi;
    }*/

}
