package articoli.pizze;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Hamburger extends ArticoloFoodBase {


   public Hamburger(){
       super.price=10.50;
       super.calories=1000;
   }
}
