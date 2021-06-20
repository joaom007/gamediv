package br.com.scale.gamediv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.scale.gamediv.model.Player;
import br.com.scale.gamediv.repository.PlayerRepository;
import br.com.scale.gamediv.service.exception.ResourceNotFoundException;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public List<Player> findAll() {
        return repository.findAll();
    }
    
    public Player findById(Long id) {
        Optional<Player> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Player insert(Player obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Player update(Long id, Player obj) {
        Player entity = repository.getById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Player entity, Player obj) {
        entity.setName(obj.getName());
    }
}
