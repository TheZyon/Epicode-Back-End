package articoli.pizze;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaMargherita extends ArticoloFoodBase {

    public PizzaMargherita(){
        super.price=4.99;
        super.calories=1104;
    }

}
