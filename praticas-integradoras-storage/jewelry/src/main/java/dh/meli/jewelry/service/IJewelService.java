package dh.meli.jewelry.service;

import dh.meli.jewelry.model.Jewel;

import java.util.List;
import java.util.Optional;

public interface IJewelService {
    Jewel insertNewJewel(Jewel jewel);
    Optional<Jewel> findById(long id);
    List<Jewel> listAll();
    void deleteById(long id);
}
