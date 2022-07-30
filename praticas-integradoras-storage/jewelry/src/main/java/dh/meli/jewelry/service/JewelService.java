package dh.meli.jewelry.service;

import dh.meli.jewelry.model.Jewel;
import dh.meli.jewelry.repository.IJewelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelService implements IJewelService {

    @Autowired
    private IJewelRepo repo;

    @Override
    public Jewel insertNewJewel(Jewel jewel) {
        return repo.save(jewel);
    }

    @Override
    public Optional<Jewel> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public List<Jewel> listAll() {
        return (List<Jewel>) repo.findAll();
    }

    @Override
    public void deleteById(long id) {
        Optional<Jewel> jewelFound = findById(id);
        repo.deleteById(id);
    }
}
