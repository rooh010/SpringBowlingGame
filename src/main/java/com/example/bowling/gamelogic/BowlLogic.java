package com.example.bowling.gamelogic;

import com.example.bowling.interfaces.IFrame;

public class BowlLogic {

    public static int Bowl(int firstBowlPins, int secondBowlPins, int CurrentScore, LastBowl lastBowl, IFrame frame) throws Exception {

        int TotalScore = 0;

        if ((firstBowlPins + secondBowlPins) > 10) {
            throw new Exception("More than 10 pins knocked");
        }

        if (frame.getFrameNumber() > frame.getMaxFrames()) {
            throw new Exception("Move than max frames.  Max frames = " + frame.getMaxFrames());
        }

        if (lastBowl.isLastScoreStrike()) {
            TotalScore = CurrentScore + ((firstBowlPins + secondBowlPins) * 2);
        } else if (lastBowl.isLastScoreSpare()) {
            TotalScore = CurrentScore + ((firstBowlPins * 2) + secondBowlPins);
        } else
            TotalScore = CurrentScore + (firstBowlPins + secondBowlPins);

        if (firstBowlPins == 10 && secondBowlPins == 0) {
            lastBowl.setLastScoreStrike(true);
            lastBowl.setLastScoreSpare(false);
        } else if (firstBowlPins + secondBowlPins == 10) {
            lastBowl.setLastScoreStrike(false);
            lastBowl.setLastScoreSpare(true);
        } else {
            lastBowl.setLastScoreStrike(false);
            lastBowl.setLastScoreSpare(false);
        }

        frame.setFrameNumber(1);

        return TotalScore;

    }
}
