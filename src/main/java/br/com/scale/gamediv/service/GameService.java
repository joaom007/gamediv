package br.com.scale.gamediv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.scale.gamediv.model.Game;
import br.com.scale.gamediv.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<Game> findAll() {
        return repository.findAll();
    }
    
    public Game findById(Long id) {
        Optional<Game> obj = repository.findById(id);
        return obj.get();
    }
}
