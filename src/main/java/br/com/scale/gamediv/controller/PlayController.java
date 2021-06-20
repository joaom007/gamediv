package br.com.scale.gamediv.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.scale.gamediv.model.Play;
import br.com.scale.gamediv.service.PlayService;

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

    //return cod 201 created and end point get in header
    @PostMapping
    public ResponseEntity<Play> insert(@RequestBody Play obj) {
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
    public ResponseEntity<Play> update(@PathVariable Long id, @RequestBody Play obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
