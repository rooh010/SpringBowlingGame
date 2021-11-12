package com.example.bowling.interfaces;

import com.example.bowling.models.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGameService {

    List<Game> getAllGames();
    void newGame(Game game);
    void saveGame(Game game);
    Game getGameById(long id);
    void deleteGameById(long id);
    Game bowl(long id) throws Exception;
}
