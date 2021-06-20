package br.com.scale.gamediv.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.scale.gamediv.model.Play;
import br.com.scale.gamediv.repository.PlayRepository;
import br.com.scale.gamediv.service.exception.DataBaseException;
import br.com.scale.gamediv.service.exception.ResourceNotFoundException;

@Service
public class PlayService {

    @Autowired
    private PlayRepository repository;

    public List<Play> findAll() {
        return repository.findAll();
    }
    
    public Play findById(Long id) {
        Optional<Play> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Play insert(Play obj) {
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

    public Play update(Long id, Play obj) {
        try {
            Play entity = repository.getById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Play entity, Play obj) {
        entity.setPlay(obj.getPlay());
    }
}

