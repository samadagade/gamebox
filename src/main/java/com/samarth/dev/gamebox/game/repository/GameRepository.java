package com.samarth.dev.gamebox.game.repository;
import com.samarth.dev.gamebox.game.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * GameRepository
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

}
