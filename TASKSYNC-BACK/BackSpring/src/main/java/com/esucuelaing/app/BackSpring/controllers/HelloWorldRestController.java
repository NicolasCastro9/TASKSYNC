package com.esucuelaing.app.BackSpring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {


    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hola conchesumadres";
    }
    
}
