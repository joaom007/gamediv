package br.com.scale.gamediv.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.scale.gamediv.model.Player;
import br.com.scale.gamediv.service.PlayerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value="/players")
public class PlayerController {

    @Autowired
    private PlayerService service;
    
    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
       List<Player> list = service.findAll();

        return ResponseEntity.ok().body(list);
        
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Player> findById(@PathVariable Long id) {
        Player obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
