package edu.tam.sample.controllers;

import edu.tam.sample.model.Worker;
import edu.tam.sample.services.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class WorkerController {

    @Autowired
    WorkerServiceImpl workerService;

    @RequestMapping("/Worker/List")
    public List<Worker> showAll(){
        return workerService.getAll();
    }

    @RequestMapping("/Worker/Delete/{id}")
    public Worker delete(Model model, @PathVariable(value = "id")String id){
        return workerService.delete(id);
    }


}
