package br.com.scale.gamediv.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.scale.gamediv.model.Game;
import br.com.scale.gamediv.service.GameService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value="/games")
public class GameController {

    @Autowired
    private GameService service;
    
    @GetMapping
    public ResponseEntity<List<Game>> findAll() {
       List<Game> list = service.findAll();

        return ResponseEntity.ok().body(list);
        
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id) {
        Game obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
