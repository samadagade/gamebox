package com.samarth.dev.gamebox.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samarth.dev.gamebox.game.model.Game;
import com.samarth.dev.gamebox.game.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired 
    GameService service;

    GameController(GameService service){
        this.service = service;
    }

    @PostMapping("/create")
    public void createGame(@RequestBody Game game){
        service.createGame(game);
    }
    
    @GetMapping("/games")
    public List<Game> getAllGames(){
        return service.getAllGames();
    }
    

    public void updatedGame(){

    }

    public void deleteGame(){

    }

}
