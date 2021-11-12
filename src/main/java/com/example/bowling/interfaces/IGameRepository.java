package com.example.bowling.interfaces;

import com.example.bowling.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameRepository extends JpaRepository<Game, Long> {

}
