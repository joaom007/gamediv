package br.com.scale.gamediv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scale.gamediv.model.Play;

public interface PlayRepository extends JpaRepository<Play, Long>{
    
}
