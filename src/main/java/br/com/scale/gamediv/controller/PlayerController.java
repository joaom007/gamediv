package br.com.scale.gamediv.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.scale.gamediv.model.Player;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value="/players")
public class PlayerController {
    
    @GetMapping
    public ResponseEntity<Player> findAll() {
        Player p = new Player(1L, "João");
        return ResponseEntity.ok().body(p);
        
    }
}
