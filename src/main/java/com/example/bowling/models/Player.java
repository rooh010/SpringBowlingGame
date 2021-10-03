package com.example.bowling.models;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {


    private Long id;

    public String getPlayerName() {
        return PlayerName;
    }


    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    @Column(name = "PlayerName")
    String PlayerName;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}
