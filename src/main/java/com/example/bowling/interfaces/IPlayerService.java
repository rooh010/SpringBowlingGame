package com.example.bowling.interfaces;

import com.example.bowling.models.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPlayerService {

    List<Player> getAllPlayers();
    void newPlayer(Player player);
    Player getPlayerById(long id);
    void deletePlayerById(long id);
}
