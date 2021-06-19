package br.com.scale.gamediv.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_play")
public class Play implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int play;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;


    public Play() {
    }

    public Play(Long id, int play) {
        this.id = id;
        this.play = play;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPlay() {
        return this.play;
    }

    public void setPlay(int play) {
        this.play = play;
    }
    
}
