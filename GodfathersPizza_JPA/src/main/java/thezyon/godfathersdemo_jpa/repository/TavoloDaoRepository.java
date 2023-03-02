package thezyon.godfathersdemo_jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thezyon.godfathersdemo_jpa.model.Tavolo;


@Repository
public interface TavoloDaoRepository extends CrudRepository<Tavolo, Long> {
}
