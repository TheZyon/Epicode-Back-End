package articoli.franchise;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@NoArgsConstructor
@Component
public class MegaHentaiGiaEquipaggiato extends ArticoloFranchiseBase{

    @Autowired
    private SciarpettaElegante sciarpettaElegante;

    @Autowired
    private PelucheOmoCunigghio pelucheOmoCunigghio;

    @Autowired
    private StivalettiGiallini stivalettiGiallini;
    @Autowired
    private SpadaNellaRoccia spadaNellaRoccia;
    @Autowired
    private EquipaggiamentoTheyThem equipaggiamentoTheyThem;


    @Override
    public double getPrice(){

        return List.of(sciarpettaElegante, pelucheOmoCunigghio, stivalettiGiallini,
                spadaNellaRoccia, equipaggiamentoTheyThem).stream()
                .mapToDouble(t->t.getPrice()).sum();

    }



}
