package com.samarth.dev.gamebox.game.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samarth.dev.gamebox.game.model.Game;
import com.samarth.dev.gamebox.game.repository.GameRepository;

/**
 * GameService
 */
@Service
public class GameService {

    @Autowired
    GameRepository repo;

    GameService(GameRepository repo) {
        this.repo = repo;
    }

    public List<Game> getAllGames() {
        try {
            List<Game> games = repo.findAll();
            return games;
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
        }

        return new ArrayList<Game>();
    }

    public void createGame(Game game) {
        try {
            repo.save(game);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
        }
    }

    public void updateGame(Game game, Long id) {
        try{
            Game existingGame = repo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Game not found"));

            existingGame.setName(game.getName());
            existingGame.setDescription(game.getDescription());
            existingGame.setRules(game.getRules());
            existingGame.setMaxPlayers(game.getMaxPlayers());
            existingGame.setSlotDuration(game.getSlotDuration());

            repo.save(existingGame);
        }
        catch(Exception e){
            System.out.print(e.getStackTrace());
        }
    }

    public void deleteGame(Long id) {
        try{
            repo.deleteById(id);
        }
        catch(Exception e){
            System.out.print(e.getStackTrace());
        }
    }
}
