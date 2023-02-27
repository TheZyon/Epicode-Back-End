package articoli.toppings;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Mozzarella extends Topping {
    public Mozzarella(){
        super.setCalories(44);
        super.setPrice(0.50);
    }

}
