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

    private int shot;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public Play() {
    }

    public Play(Long id, int shot, Game game) {
        super();
        this.id = id;
        this.shot = shot;
        this.game = game;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getShot() {
        return this.shot;
    }

    public void setShot(int shot) {
        this.shot = shot;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    
}
