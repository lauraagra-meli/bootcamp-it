package dh.meli.jewelry.repository;

import dh.meli.jewelry.model.Jewel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IJewelRepo extends CrudRepository<Jewel, Long> {
    //void delete(long id);
    //void delete(Optional<Jewel> jewelFound);
}
