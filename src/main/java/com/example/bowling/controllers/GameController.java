package com.example.bowling.controllers;

import com.example.bowling.helpers.RandomPins;
import com.example.bowling.models.Game;
import com.example.bowling.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/game")
    public ModelAndView startNewGame(@ModelAttribute("game") Game game)
    {
        gameService.newGame(game);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("game");
        return modelAndView;
    }

    @GetMapping("/bowl/{id}")
    public ModelAndView bowl(@PathVariable ( value = "id") long id, Model model) throws Exception {
        Game game = gameService.getGameById(id);

        game.setFirstBowlPins(new RandomPins().randomPins1());
        game.setSecondBowlPins(new RandomPins().randomPins2(game.getFirstBowlPins()));


        if (game.getFrameNumber() <= 9) {
            game.Bowl(game);
            model.addAttribute("game", game);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("game_in_progress");
            gameService.saveGame(game);
            return modelAndView;
        } else {
            model.addAttribute("game", game);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("score");
            gameService.saveGame(game);
            return modelAndView;
        }

    }


}


