package edu.tam.sample.controllers.rest;

import edu.tam.sample.model.Worker;
import edu.tam.sample.services.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/worker")
@CrossOrigin("*")
@RestController
public class WorkerController {

    @Autowired
    WorkerServiceImpl workerService;

    @RequestMapping("/list")
    public List<Worker> showAll(){
        return workerService.getAll();
    }

    @RequestMapping("/worker/delete/{id}")
    public Worker delete(@PathVariable(value = "id")String id){
        return workerService.delete(id);
    }

    @RequestMapping("/Worker/get/{id}")
    public Worker get(@PathVariable(value = "id")String id){
        return workerService.get(id);
    }

    @PostMapping("/Worker/create")
    public Worker create(@Valid @RequestBody Worker worker){
        return workerService.create(worker);
    }

    @PostMapping("/Worker/update")
    public Worker update(@Valid @RequestBody Worker worker){
        return workerService.update(worker);
    }
}
