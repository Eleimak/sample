package edu.tam.sample.controllers.web;

import edu.tam.sample.forms.WorkerForm;
import edu.tam.sample.model.Speciality;
import edu.tam.sample.model.Worker;
import edu.tam.sample.repository.SpecialityRepository;
import edu.tam.sample.services.speciality.impls.SpecialityServicesImpl;
import edu.tam.sample.services.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/worker")
@CrossOrigin("*")
@Controller
public class WorkerWebController {

    @Autowired
    WorkerServiceImpl workerService;

    @Autowired
    SpecialityServicesImpl specialityServices;

    @RequestMapping("/list")
    public String showAll(Model model){
        List<Worker> list = workerService.getAll();
        model.addAttribute("workers", list);
        return "workerlist";
    }


    @RequestMapping("/delete/{id}")
    public String delete(Model model,@PathVariable(value = "id")String id){
        workerService.delete(id);
        List<Worker> list = workerService.getAll();
        //model.addAttribute("workers", list);
        //return "workerlist";
        return "redirect:/worker/list";
    }
/*
    @RequestMapping("/delete/{id}")
    public RedirectView delete(@PathVariable(value = "id")String id){
        workerService.delete(id);
        return new RedirectView("/worker/list");
    }
*/
    @RequestMapping("/get/{id}")
    public Worker get(@PathVariable(value = "id")String id){
        return workerService.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addWorker(Model model){
        WorkerForm workerForm = new WorkerForm();
        Map<String, String> mavs = (Map<String, String>)
                specialityServices.getAll().stream()
                .collect(Collectors.toMap(Speciality::getId,
                        Speciality::getName));
        model.addAttribute("mavs", mavs);
        model.addAttribute("WorkerForm", workerForm);
        return "workeradd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,@ModelAttribute("WorkerForm")
            WorkerForm workerForm){
        Worker newWorker = new Worker(workerForm.getName(),
                workerForm.getOccupation(),workerForm.getSalary(),
                specialityServices.get(workerForm.getSpeciality()));
        workerService.create(newWorker);
        return "redirect:/worker/list";
    }

   // @PostMapping("/update/{id}")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateWorker(Model model,  @PathVariable("id") String id){
        Worker workerToUpdate = workerService.get(id);
        WorkerForm workerForm = new WorkerForm();
        workerForm.setName(workerToUpdate.getName());
        workerForm.setOccupation(workerToUpdate.getOccupation());
        workerForm.setSalary(workerToUpdate.getSalary());
        workerForm.setSpeciality(workerToUpdate.getSpeciality().getName());
        Map<String, String> mavs = (Map<String, String>)
                specialityServices.getAll().stream()
                .collect(Collectors.toMap(Speciality::getId,
                        Speciality::getName));
        model.addAttribute("mavs", mavs);
        model.addAttribute("WorkerForm", workerForm);
        return "workerupdate";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute("WorkerForm")
            WorkerForm workerForm){
        Worker newWorker = new Worker(workerForm.getName(),
                workerForm.getOccupation(),workerForm.getSalary(),
                specialityServices.get(workerForm.getSpeciality()));
        newWorker.setId(workerForm.getId());
        workerService.update(newWorker);
        return "redirect:/worker/list";
    }

}
