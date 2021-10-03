package com.example.bowling.gamelogic;

public class Frame implements com.example.bowling.interfaces.IFrame {

    int FrameNumber = 1;
    int MaxBowlsPerFrame = 2;
    int MaxFrames = 10;

    @Override
    public int getFrameNumber() {
        return FrameNumber;
    }

    @Override
    public void setFrameNumber(int frameNumber) {
        FrameNumber = frameNumber + FrameNumber;
    }

    @Override
    public int getMaxFrames() {
        return MaxFrames;
    }

    @Override
    public void setMaxFrames(int maxFrames) {
        MaxFrames = maxFrames + MaxFrames;
    }

    @Override
    public int getMaxBowlsPerFrame() {
        return MaxBowlsPerFrame;
    }
}