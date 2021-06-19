package br.com.scale.gamediv.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_game")
public class Game implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant init;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant finish;
    private int nPlay;

    @JsonIgnore
    @OneToMany(mappedBy = "play")
    private List<Play> plays = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;


    public Game() {
    }

    public Game(Long id, Instant init, Instant finish, int nPlay, Player player) {
        this.id = id;
        this.init = init;
        this.finish = finish;
        this.nPlay = nPlay;
        this.player = player;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getInit() {
        return this.init;
    }

    public void setInit(Instant init) {
        this.init = init;
    }

    public Instant getFinish() {
        return this.finish;
    }

    public void setFinish(Instant finish) {
        this.finish = finish;
    }

    public int getNPlay() {
        return this.nPlay;
    }

    public void setNPlay(int nPlay) {
        this.nPlay = nPlay;
    }

    public List<Play> getPlays() {
        return this.plays;
    }

 
}
