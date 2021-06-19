package br.com.scale.gamediv.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.scale.gamediv.model.Player;
import br.com.scale.gamediv.repository.PlayerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    //class of Data base seeding tests

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Player p1 = new Player(null, "Maria");
        Player p2 = new Player(null, "Silvana");

        playerRepository.saveAll(Arrays.asList(p1, p2));
    }

}
