package br.com.scale.gamediv.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.scale.gamediv.model.Game;
import br.com.scale.gamediv.service.GameService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //return cod 201 created and end point get in header
    @PostMapping
    public ResponseEntity<Game> insert(@RequestBody Game obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //return cod 204 http
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Return default cod 200 http
    @PutMapping(value = "/{id}")
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
