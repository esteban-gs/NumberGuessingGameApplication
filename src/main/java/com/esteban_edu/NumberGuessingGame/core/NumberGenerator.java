package com.esteban_edu.NumberGuessingGame.core;

import java.util.Random;

public class NumberGenerator {
    public static int getFromRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
