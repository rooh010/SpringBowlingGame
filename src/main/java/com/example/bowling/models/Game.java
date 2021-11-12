package com.example.bowling.models;


import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "id")
    private Player player;


    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    @Column(name = "Score")
    int Score;

    public boolean isLastScoreStrike() {
        return LastScoreStrike;
    }

    public void setLastScoreStrike(boolean lastScoreStrike) {
        LastScoreStrike = lastScoreStrike;
    }

    @Column(name = "LastScoreStrike")
    boolean LastScoreStrike;

    public boolean isLastScoreSpare() {
        return LastScoreSpare;
    }

    public void setLastScoreSpare(boolean lastScoreSpare) {
        LastScoreSpare = lastScoreSpare;
    }

    public int getFrameNumber() {
        return FrameNumber;
    }

    public void setFrameNumber(int frameNumber) {
        FrameNumber = frameNumber;
    }

    public int getMaxBowlsPerFrame() {
        return MaxBowlsPerFrame;
    }

    public void setMaxBowlsPerFrame(int maxBowlsPerFrame) {
        MaxBowlsPerFrame = maxBowlsPerFrame;
    }

    public int getMaxFrames() {
        return MaxFrames;
    }

    public void setMaxFrames(int maxFrames) {
        MaxFrames = maxFrames;
    }

    @Column(name = "LastScoreSpare")
    boolean LastScoreSpare;

    @Column(name = "FrameNumber")
    int FrameNumber;

    @Column(name = "MaxBowlsPerFrame")
    int MaxBowlsPerFrame;

    @Column(name = "MaxFrames")
    int MaxFrames;

    public int getFirstBowlPins() {
        return firstBowlPins;
    }

    public void setFirstBowlPins(int firstBowlPins) {
        this.firstBowlPins = firstBowlPins;
    }

    public int getSecondBowlPins() {
        return secondBowlPins;
    }

    public void setSecondBowlPins(int secondBowlPins) {
        this.secondBowlPins = secondBowlPins;
    }

    @Column(name = "firstBowlPins")
    int firstBowlPins;

    @Column(name = "secondBowlPins")
    int secondBowlPins;

    public void Bowl(Game game) throws Exception {

        if ((game.getFirstBowlPins() + game.getSecondBowlPins()) > 10) {
            throw new Exception("More than 10 pins knocked");
        }

        if (game.getFrameNumber() >= game.getMaxFrames()) {
            throw new Exception("More than max frames.  Max frames = " + game.getMaxFrames());
        }

        if (game.isLastScoreStrike()) {
            game.setScore(game.getScore() + ((game.getFirstBowlPins() + game.getSecondBowlPins()) * 2));
        } else if (game.isLastScoreSpare()) {
            game.setScore(game.getScore() + ((game.getFirstBowlPins() * 2) + game.getSecondBowlPins()));
        } else
            game.setScore(game.getScore() + (game.getFirstBowlPins() + game.getSecondBowlPins()));

        if (game.getFirstBowlPins() == 10 && game.getSecondBowlPins() == 0) {
            game.setLastScoreStrike(true);
            game.setLastScoreSpare(false);
        } else if (game.getFirstBowlPins() + game.getSecondBowlPins() == 10) {
            game.setLastScoreStrike(false);
            game.setLastScoreSpare(true);
        } else {
            game.setLastScoreStrike(false);
            game.setLastScoreSpare(false);
        }

        game.setFrameNumber(game.getFrameNumber()+1);

    }
}
