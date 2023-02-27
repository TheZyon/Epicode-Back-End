package articoli.toppings;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Tomato extends Topping  {

public Tomato(){
    super.setCalories(50);
    super.setPrice(0.50);
}


}
