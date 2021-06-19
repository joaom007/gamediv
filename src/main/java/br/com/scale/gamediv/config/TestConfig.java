package br.com.scale.gamediv.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.scale.gamediv.model.Game;
import br.com.scale.gamediv.model.Play;
import br.com.scale.gamediv.model.Player;
import br.com.scale.gamediv.repository.GameRepository;
import br.com.scale.gamediv.repository.PlayRepository;
import br.com.scale.gamediv.repository.PlayerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    //class of Data base seeding tests

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;
    
    @Autowired
    private PlayRepository playRepository; 

    @Override
    public void run(String... args) throws Exception {
        
        Player p1 = new Player(null, "Maria");
        Player p2 = new Player(null, "Silvana");

        Game g1 = new Game(null, Instant.parse("2020-12-20T19:53:07Z"), Instant.now(), 5, p1);
        Game g2 = new Game(null, Instant.parse("2020-12-20T19:53:07Z"), Instant.now(), 18, p2);
        Game g3 = new Game(null, Instant.parse("2020-12-20T19:53:07Z"), Instant.now(), 3, p1);
        Game g4 = new Game(null, Instant.parse("2020-12-20T19:53:07Z"), Instant.now(), 20, p2);

        Play py1 = new Play(null, 12, g1);
        Play py2 = new Play(null, 15, g1);
        Play py3 = new Play(null, 18, g1);
        Play py4 = new Play(null, 25, g1);
        Play py5 = new Play(null, 97, g1);

        Play py6 = new Play(null, 12, g2);
        Play py7 = new Play(null, 15, g2);
        Play py8 = new Play(null, 18, g2);
        Play py9 = new Play(null, 25, g2);
        Play py10 = new Play(null, 97, g2);

        playerRepository.saveAll(Arrays.asList(p1, p2));
        gameRepository.saveAll(Arrays.asList(g1, g2, g3, g4));
        playRepository.saveAll(Arrays.asList(py1, py2, py3, py4, py5, py6, py7, py8, py9, py10));
    }

}
