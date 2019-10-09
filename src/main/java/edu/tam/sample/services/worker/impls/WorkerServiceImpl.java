package edu.tam.sample.services.worker.impls;

import edu.tam.sample.model.Speciality;
import edu.tam.sample.model.Worker;
import edu.tam.sample.repository.WorkerRepository;
import edu.tam.sample.services.worker.interfaces.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WorkerServiceImpl implements IWorkerService {
    List<Worker> workers = new ArrayList<>();

    @Autowired
    WorkerRepository repository;
    List<Speciality> specialityList;

    @PostConstruct
    void init(){
        specialityList = new ArrayList<>(
                Arrays.asList(
                        new Speciality("1","Coder", 25, 100),
                        new Speciality("2","Designer", 15, 5),
                        new Speciality("3","Tester", 3, 50)
                )
        );
        repository.deleteAll();
        Worker ivan = new Worker("Ivan","Coder",1000,specialityList.get(0));
        Worker stepan = new Worker("Stepan","Coder",2000,specialityList.get(1));
        Worker johnLenon = new Worker("JohnLenon","guitar",20000,specialityList.get(2));
        workers.add(ivan);
        workers.add(stepan);
        workers.add(johnLenon);
        repository.saveAll(workers);
    }
    @Override
    public List<Worker> getAll() {
        return repository.findAll();
    }

    @Override
    public Worker get(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Speciality> getSpecialityList() {
        return specialityList;
    }

    public void setSpecialityList(List<Speciality> specialityList) {
        this.specialityList = specialityList;
    }

    @Override
    public Worker create(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker update(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker delete(String id) {
        Worker worker = this.get(id);
        repository.deleteById(id);
        return worker;
    }

}
