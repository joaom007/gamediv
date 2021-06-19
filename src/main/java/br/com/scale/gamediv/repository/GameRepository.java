package br.com.scale.gamediv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scale.gamediv.model.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}
