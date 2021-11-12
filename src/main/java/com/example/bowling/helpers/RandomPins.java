package com.example.bowling.helpers;

import java.util.Random;

public class RandomPins {

    public int randomPins1() {
        Random r = new Random();
        int low = 0;
        int high = 11;
        int result = r.nextInt(high - low) + low;
        // System.out.println("first rand: " + result);
        return result;

    }

    public int randomPins2(int firstPins) {
        Random r = new Random();


        if (firstPins <= 8) {
            int low = 0;
            int high = 11 - firstPins;

            int result = r.nextInt(high - low) + low;
            // System.out.println("second rand: " + result);
            return result;
        } else if (firstPins == 9) {
            int result = (int) Math.round(Math.random());
            // System.out.println("second rand:  " + result);
            return result;
        } else {
            int result = 0;

            return result;
        }
    }


}
