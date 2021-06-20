package br.com.scale.gamediv.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.scale.gamediv.model.Game;
import br.com.scale.gamediv.repository.GameRepository;
import br.com.scale.gamediv.service.exception.DataBaseException;
import br.com.scale.gamediv.service.exception.ResourceNotFoundException;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<Game> findAll() {
        return repository.findAll();
    }
    
    public Game findById(Long id) {
        Optional<Game> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Game insert(Game obj) {
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

    public Game update(Long id, Game obj) {
        try {
            Game entity = repository.getById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Game entity, Game obj) {
        entity.setFinish(obj.getFinish());
    }
}
