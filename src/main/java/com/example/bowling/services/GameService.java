package com.example.bowling.services;

import com.example.bowling.interfaces.IGameRepository;
import com.example.bowling.interfaces.IGameService;

import com.example.bowling.models.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService implements IGameService {

    @Autowired
    private IGameRepository gameRepository;

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public void newGame(Game game) {
        game.setFrameNumber(1);
        game.setScore(0);
        game.setMaxBowlsPerFrame(2);
        game.setMaxFrames(10);
        game.setLastScoreSpare(false);
        game.setLastScoreStrike(false);
        game.setFirstBowlPins(0);
        game.setSecondBowlPins(0);
        this.gameRepository.save(game);
    }

    @Override
    public void saveGame(Game game) {
        this.gameRepository.save(game);
    }

    @Override
    public Game getGameById(long id) {
        Optional<Game> optional = gameRepository.findById(id);
        Game game = null;
        if(optional.isPresent()){
            game = optional.get();
        }else{
            throw new RuntimeException("Game not found for id : " + id);
        }
        return game;
    }

    @Override
    public void deleteGameById(long id) {
        this.gameRepository.deleteById(id);
    }

    @Override
    public Game bowl(long id) throws Exception {
        Optional<Game> optional = gameRepository.findById(id);
        Game game = null;
        if(optional.isPresent()){
            game = optional.get();
            game.Bowl(game);
        }else{
            throw new RuntimeException("Game not found for id : " + id);
        }
        return game;
    }

}
