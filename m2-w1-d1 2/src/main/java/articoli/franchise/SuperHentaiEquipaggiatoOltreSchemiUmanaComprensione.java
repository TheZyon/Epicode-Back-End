package articoli.franchise;

import articoli.toppings.Topping;

import java.util.List;

public class SuperHentaiEquipaggiatoOltreSchemiUmanaComprensione extends ArticoloFranchiseBase{

   List<ArticoloFranchiseBase> equipaggiamento;

    public SuperHentaiEquipaggiatoOltreSchemiUmanaComprensione() {
    super.setPrice(1000);
    }

    @Override
    public double getPrice(){
        return super.getPrice()+equipaggiamento.stream()
                .map(ArticoloFranchiseBase::getPrice).mapToDouble(s->s)
                .sum();
    }

}
