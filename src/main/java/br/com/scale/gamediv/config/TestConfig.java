package br.com.scale.gamediv.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.scale.gamediv.model.Game;
import br.com.scale.gamediv.model.Player;
import br.com.scale.gamediv.repository.GameRepository;
import br.com.scale.gamediv.repository.PlayerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    //class of Data base seeding tests

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;    

    @Override
    public void run(String... args) throws Exception {
        
        Player p1 = new Player(null, "Maria");
        Player p2 = new Player(null, "Silvana");

        Game g1 = new Game(null, Instant.parse("2020-12-20T19:53:07Z"), Instant.now(), 5, p1);
        Game g2 = new Game(null, Instant.parse("2020-12-20T19:53:07Z"), Instant.now(), 18, p2);
        Game g3 = new Game(null, Instant.parse("2020-12-20T19:53:07Z"), Instant.now(), 3, p1);
        Game g4 = new Game(null, Instant.parse("2020-12-20T19:53:07Z"), Instant.now(), 20, p2);

        playerRepository.saveAll(Arrays.asList(p1, p2));
        gameRepository.saveAll(Arrays.asList(g1, g2, g3, g4));
    }

}
