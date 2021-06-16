package br.com.scale.gamediv.model;

import java.io.Serializable;
import java.sql.Time;
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

@Entity
@Table(name = "tb_game")
public class Game implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Time time;

    @OneToMany(mappedBy = "play")
    private List<Play> plays = new ArrayList<>();

    private int nPlay;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;


    public Game() {
    }

    public Game(Long id, Time time, int nPlay, Player player) {
        this.id = id;
        this.time = time;
        this.nPlay = nPlay;
        this.player = player;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getNPlay() {
        return this.nPlay;
    }

    public void setNPlay(int nPlay) {
        this.nPlay = nPlay;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
