package br.com.scale.gamediv.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.scale.gamediv.model.Player;
import br.com.scale.gamediv.repository.PlayerRepository;
import br.com.scale.gamediv.service.exception.DataBaseException;
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
        try {
            repository.deleteById(id);
          } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
            
          } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
          }
        
    }

    public Player update(Long id, Player obj) {
        try {
            Player entity = repository.getById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Player entity, Player obj) {
        entity.setName(obj.getName());
    }
}
