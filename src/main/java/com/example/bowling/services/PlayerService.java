package com.example.bowling.services;

import com.example.bowling.interfaces.IPlayerRepository;
import com.example.bowling.interfaces.IPlayerService;
import com.example.bowling.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public void newPlayer(Player player) {
        this.playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(long id) {
        Optional<Player> optional = playerRepository.findById(id);
        Player player = null;
        if(optional.isPresent()){
            player = optional.get();
        }else{
            throw new RuntimeException("Player not found for id : " + id);
        }
        return player;
    }

    @Override
    public void deletePlayerById(long id) {
        this.playerRepository.deleteById(id);
    }
}
