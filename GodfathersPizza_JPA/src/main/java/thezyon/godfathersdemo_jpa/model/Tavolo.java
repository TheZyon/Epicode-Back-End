package thezyon.godfathersdemo_jpa.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;


@Entity
@Table(name="tavolo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tavolo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int numeroTavolo;
@Column(nullable = false)
private int max_coperti;

@Column(nullable = false)
private boolean libero;

    public Tavolo(int max_coperti, boolean libero) {
        this.max_coperti = max_coperti;
        this.libero = libero;
    }
}
