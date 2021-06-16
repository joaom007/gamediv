package br.com.scale.gamediv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
     
    @GetMapping(value = "/")
    public String Index() {
        return "index";
    }    
    
}
