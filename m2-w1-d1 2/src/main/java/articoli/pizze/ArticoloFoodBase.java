package articoli.pizze;

import articoli.toppings.Topping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticoloFoodBase {

    protected double price;
    protected int calories;

    private List<Topping> toppings;


    public ArticoloFoodBase(double price, int calories){
        this.price=price;
        this.calories=calories;
    }

    public void addTopping(Topping t){
        toppings.add(t);
    }

    public double getPrice() {
        return price +
                + toppings.stream()
                        .map(Topping::getPrice).mapToDouble(s->s)
                        .sum();
    }

}
