package com.GodfathersPizza.model;



import lombok.*;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;
import java.util.List;




@Getter
@Setter
@ToString
public class Ordine {
//@Value("#{new Double('${item.priceFactor}')}")
    //@Value("#{new Double('${godfathersPizza.prezzoCoperto}')}")
    private double prezzoCoperto=5;
    private int numeroOrdine;

    private Tavolo tavolo;

    private StatoOrdine statoOrdine;

    private int numeroCoperti;

    private Timestamp oraAcquisizione;

    private List<Pair<Prodotto, String>> elementi;

    public Ordine(int numeroOrdine, Tavolo tavolo, StatoOrdine statoOrdine, int numeroCoperti, Timestamp oraAcquisizione, List<Pair<Prodotto, String>> elementi) {
        this.numeroOrdine = numeroOrdine;
        this.tavolo = tavolo;
        this.statoOrdine = statoOrdine;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = oraAcquisizione;
        this.elementi = elementi;
    }

    public Ordine(int numeroOrdine, Tavolo tavolo, StatoOrdine statoOrdine, int numeroCoperti, Timestamp oraAcquisizione) {
        this.numeroOrdine = numeroOrdine;
        this.tavolo = tavolo;
        this.statoOrdine = statoOrdine;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = oraAcquisizione;
    }

    public void addElemento(Pair<Prodotto, String>elemento){
        elementi.add(elemento);
    }

    public double getImportoTotale(){

        var sommaCostiElementi= elementi.stream()
                .mapToDouble(e->((Pair<Prodotto,String>)e).getKey().getPrezzo())
                .sum();
        var sommaCoperti= numeroCoperti*prezzoCoperto;

        return sommaCoperti+sommaCostiElementi;
    }

}
