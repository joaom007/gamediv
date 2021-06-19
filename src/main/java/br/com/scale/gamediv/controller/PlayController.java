package br.com.scale.gamediv.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.scale.gamediv.model.Play;
import br.com.scale.gamediv.service.PlayService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value="/plays")
public class PlayController {

    @Autowired
    private PlayService service;
    
    @GetMapping
    public ResponseEntity<List<Play>> findAll() {
       List<Play> list = service.findAll();

        return ResponseEntity.ok().body(list);
        
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Play> findById(@PathVariable Long id) {
        Play obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
