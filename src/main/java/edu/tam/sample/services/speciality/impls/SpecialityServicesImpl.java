package edu.tam.sample.services.speciality.impls;

import edu.tam.sample.model.Speciality;
import edu.tam.sample.repository.SpecialityRepository;
import edu.tam.sample.services.speciality.interfaces.ISpecialityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SpecialityServicesImpl implements ISpecialityServices {
    List<Speciality> specialityList = new ArrayList<>(
            Arrays.asList(
                    new Speciality("Coder", 25, 100),
                    new Speciality("Designer", 15, 5),
                    new Speciality("Tester", 3, 50)
            )
    );

    @Autowired
    SpecialityRepository repository;

    public List<Speciality> getSpecialityList() {
        return specialityList;
    }

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(specialityList);
    }

    @Override
    public List<Speciality> getAll() {
        return repository.findAll();
    }

    @Override
    public Speciality get(String id) {
        return repository.findById(id).orElse(null);
    }
}
