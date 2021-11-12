package com.example.bowling.controllers;

import com.example.bowling.models.Player;
import com.example.bowling.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listPlayers",playerService.getAllPlayers());
        return "index";
    }

    @GetMapping("/newPlayerForm")
    public String showNewPlayerForm(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "new_player";
    }

    @GetMapping("/removePlayer/{id}")
    public String removePlayer(@PathVariable ( value = "id") long id,Model model){
        this.playerService.deletePlayerById(id);
        return "redirect:/";
    }

    @GetMapping("/updatePlayer/{id}")
    public String updatePlayer(@PathVariable ( value = "id") long id,Model model){
        Player player = playerService.getPlayerById(id);

        model.addAttribute("player", player);
        return "update_player";
    }


    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute("player") Player player)
    {
        playerService.newPlayer(player);
        return "start_game";
    }

   

}
