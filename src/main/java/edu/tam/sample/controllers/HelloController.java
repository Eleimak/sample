package edu.tam.sample.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/Hello")
    public String getHelloController(){
        return "<h1>Hello word from Controller</h1>";
    }
}
