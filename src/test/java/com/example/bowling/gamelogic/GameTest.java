package com.example.bowling.gamelogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    public Game TestGame;
    public Frame TestFrame;
    public Scoreboard TestScore;
    private LastBowl TestLastBowl;

    @BeforeEach
    void init()
    {
        TestFrame = new Frame();
        TestScore = new Scoreboard(0);
        TestGame = new Game(TestScore, TestFrame);
        TestLastBowl = new LastBowl();
    }

    @Test
    public void TestBowl()
    {
        try {
            TestGame.score.setScore(BowlLogic.Bowl(2, 3, TestGame.score.getScore(), TestLastBowl, TestFrame));
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(5, TestGame.score.getScore());
    }

    @Test
    public void TestMaxPins()
    {
        assertThrows(Exception.class,()->{
            TestGame.score.setScore(BowlLogic.Bowl(20, 30, TestGame.score.getScore(), TestLastBowl, TestFrame));
        });
    }


    @Test
    public void Strike() throws Exception {
        TestGame.score.setScore(BowlLogic.Bowl(10, 0, TestGame.score.getScore(), TestLastBowl, TestFrame));
        TestGame.score.setScore(BowlLogic.Bowl(2, 2, TestGame.score.getScore(), TestLastBowl, TestFrame));
        assertEquals(18, TestGame.score.getScore());
    }

    @Test
    public void Spare() throws Exception {
        TestGame.score.setScore(BowlLogic.Bowl(5, 5, TestGame.score.getScore(), TestLastBowl, TestFrame));
        TestGame.score.setScore(BowlLogic.Bowl(4, 2, TestGame.score.getScore(), TestLastBowl, TestFrame));
        assertEquals(20, TestGame.score.getScore());
    }

    @Test
    public void FullGameBadBowler() throws Exception {
        for (int i = 0; i < 10; i++) {
            TestGame.score.setScore(BowlLogic.Bowl(0, 0, TestGame.score.getScore(), TestLastBowl, TestFrame));
        }
        assertEquals(0, TestGame.score.getScore());
    }

    @Test
    public void FullGameGoodBowler() throws Exception {
        for (int i = 0; i < 10; i++) {
            TestGame.score.setScore(BowlLogic.Bowl(2, 2, TestGame.score.getScore(), TestLastBowl, TestFrame));
        }
        assertEquals(40, TestGame.score.getScore());
    }

    @Test
    void FullGameSpare() throws Exception {
        TestGame.score.setScore(BowlLogic.Bowl(1, 9, TestGame.score.getScore(), TestLastBowl, TestFrame));
        for (int i = 0; i < 9; i++) {
            TestGame.score.setScore(BowlLogic.Bowl(2, 2, TestGame.score.getScore(), TestLastBowl, TestFrame));
        }
        assertEquals(48, TestGame.score.getScore());
    }

    @Test
    void FullGameStrike() throws Exception {
        TestGame.score.setScore(BowlLogic.Bowl(10, 0, TestGame.score.getScore(), TestLastBowl, TestFrame));
        for (int i = 0; i < 9; i++) {
            TestGame.score.setScore(BowlLogic.Bowl(2, 2, TestGame.score.getScore(), TestLastBowl, TestFrame));
        }
        assertEquals(50, TestGame.score.getScore());
    }

    @Test
    public void FullGameMaxBowls() throws Exception {
        assertThrows(Exception.class, () -> {
            for (int i = 0; i < 11; i++) {
                TestGame.score.setScore(BowlLogic.Bowl(0, 0, TestGame.score.getScore(), TestLastBowl, TestFrame));
            }
        });
    }

}
