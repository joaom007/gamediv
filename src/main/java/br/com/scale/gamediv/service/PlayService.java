package br.com.scale.gamediv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.scale.gamediv.model.Play;
import br.com.scale.gamediv.repository.PlayRepository;

@Service
public class PlayService {

    @Autowired
    private PlayRepository repository;

    public List<Play> findAll() {
        return repository.findAll();
    }
    
    public Play findById(Long id) {
        Optional<Play> obj = repository.findById(id);
        return obj.get();
    }
}
