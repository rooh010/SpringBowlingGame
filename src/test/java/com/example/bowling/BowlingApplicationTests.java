package com.example.bowling;

import com.example.bowling.helpers.RandomPins;
import com.example.bowling.models.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingApplicationTests {

    public Game game;

    @BeforeEach
    void init()
    {
        game = new Game();
        game.setFrameNumber(0);
        game.setScore(0);
        game.setMaxBowlsPerFrame(2);
        game.setMaxFrames(11);
        game.setLastScoreSpare(false);
        game.setLastScoreStrike(false);
        game.setFirstBowlPins(0);
        game.setSecondBowlPins(0);
    }

    @Test
    public void TestBowl()
    {
        try {
            game.setFirstBowlPins(2);
            game.setSecondBowlPins(3);

            game.Bowl(game);

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(5, game.getScore());
    }

    @Test
    public void TestMaxPins()
    {
        assertThrows(Exception.class,()->{
            game.setFirstBowlPins(20);
            game.setSecondBowlPins(30);

            game.Bowl(game);
        });
    }


    @Test
    public void Strike() throws Exception {
        game.setFirstBowlPins(10);
        game.setSecondBowlPins(0);

        game.Bowl(game);

        game.setFirstBowlPins(2);
        game.setSecondBowlPins(2);

        game.Bowl(game);


        assertEquals(18, game.getScore());
    }

    @Test
    public void Spare() throws Exception {
        game.setFirstBowlPins(5);
        game.setSecondBowlPins(5);

        game.Bowl(game);

        game.setFirstBowlPins(4);
        game.setSecondBowlPins(2);

        game.Bowl(game);

        assertEquals(20, game.getScore());
    }

    @Test
    public void FullGameBadBowler() throws Exception {
        for (int i = 0; i < 10; i++) {
            game.setFirstBowlPins(0);
            game.setSecondBowlPins(0);

            game.Bowl(game);
        }
        assertEquals(0, game.getScore());
    }

    @Test
    public void FullGameGoodBowler() throws Exception {
        for (int i = 0; i < 10; i++) {
            game.setFirstBowlPins(2);
            game.setSecondBowlPins(2);

            game.Bowl(game);
        }
        assertEquals(40, game.getScore());
    }

    @Test
    void FullGameSpare() throws Exception {
        game.setFirstBowlPins(1);
        game.setSecondBowlPins(9);

        game.Bowl(game);
        for (int i = 0; i < 9; i++) {
            game.setFirstBowlPins(2);
            game.setSecondBowlPins(2);

            game.Bowl(game);
        }
        assertEquals(48, game.getScore());
    }

    @Test
    void FullGameStrike() throws Exception {
        game.setFirstBowlPins(10);
        game.setSecondBowlPins(0);

        game.Bowl(game);
        for (int i = 0; i < 9; i++) {
            game.setFirstBowlPins(2);
            game.setSecondBowlPins(2);

            game.Bowl(game);
        }
        assertEquals(50, game.getScore());
    }

    @Test
    public void FullGameMaxBowls() throws Exception {
        assertThrows(Exception.class, () -> {
            for (int i = 0; i < 11; i++) {
                game.setFirstBowlPins(10);
                game.setSecondBowlPins(10);

                game.Bowl(game);
            }
        });
    }

    @Test
    public void FullGameMaxBowlsRandomPins() throws Exception {

        game.Bowl(game);
        for (int i = 0; i < 10; i++) {
            System.out.println("Frame: " + game.getFrameNumber());
            game.setFirstBowlPins(new RandomPins().randomPins1());
            game.setSecondBowlPins(new RandomPins().randomPins2(game.getFirstBowlPins()));

            game.Bowl(game);
            System.out.println("Score: " + game.getScore());
        }
        assertTrue(game.getScore() < 301);
    }

}
