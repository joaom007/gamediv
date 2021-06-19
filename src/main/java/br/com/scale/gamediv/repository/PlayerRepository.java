package br.com.scale.gamediv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scale.gamediv.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{
    
}
