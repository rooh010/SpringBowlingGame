package com.example.bowling.gamelogic;

import com.example.bowling.interfaces.IFrame;
import com.example.bowling.interfaces.IScoreboard;

public class Game {

    IScoreboard score;
    IFrame frame;

    {
        new Scoreboard(0);
    }

    public Game(IScoreboard score, IFrame frame) {
        this.score = score;
        this.frame = frame;
    }

    {
        new Frame();
    }


}
