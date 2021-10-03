package com.example.bowling.gamelogic;

public class Scoreboard implements com.example.bowling.interfaces.IScoreboard {

    @Override
    public int getScore() {
        return Score;
    }

    @Override
    public int setScore(int score) {
        Score = score;
        return score;
    }

    int Score;

    public Scoreboard(int score) {
        Score = score;
    }
}
