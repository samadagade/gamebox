package com.samarth.dev.gamebox.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samarth.dev.gamebox.game.model.Game;
import com.samarth.dev.gamebox.game.service.GameService;

@RestController
@CrossOrigin("*")
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService service;

    GameController(GameService service) {
        this.service = service;
    }

    @PostMapping
    public void createGame(@RequestBody Game game) {
        service.createGame(game);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return service.getAllGames();
    }

    @PutMapping("/{id}")
    public void updateGame(@RequestBody Game game, @PathVariable Long id) {
        service.updateGame(game, id);
    }

    @DeleteMapping("/id")
    public void deleteGame(@PathVariable Long id) {
        service.deleteGame(id);
    }

}
