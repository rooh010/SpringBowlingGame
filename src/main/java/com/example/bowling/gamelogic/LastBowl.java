package com.example.bowling.gamelogic;

public class LastBowl {

    boolean LastScoreStrike = false;

    public boolean isLastScoreStrike() {
        return LastScoreStrike;
    }

    public void setLastScoreStrike(boolean lastScoreStrike) {
        LastScoreStrike = lastScoreStrike;
    }

    public boolean isLastScoreSpare() {
        return LastScoreSpare;
    }

    public void setLastScoreSpare(boolean lastScoreSpare) {
        LastScoreSpare = lastScoreSpare;
    }

    boolean LastScoreSpare = false;
}
