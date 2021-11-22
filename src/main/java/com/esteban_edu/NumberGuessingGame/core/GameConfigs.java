package com.esteban_edu.NumberGuessingGame.core;

import static com.esteban_edu.NumberGuessingGame.core.GameConstants.GUESSES_ALLOWED;

/**
 * GameConfigs holds the overall game configurations
 * change these values to adjust the game as you wish
 */
public class GameConfigs {
    public int getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void increaseGuessesLeft() {
        this.guessesLeft++;
    }

    public void decreaseGuessesLeft() {
        this.guessesLeft--;
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public int getCurrentGuess() {
        return currentGuess;
    }

    public void setCurrentGuess(int currentGuess) {
        this.currentGuess = currentGuess;
    }


    private int maxRange;
    private GameState gameState;
    private int secretNumber;
    private int currentScore;
    private int guessesLeft = GUESSES_ALLOWED;
    private int currentGuess;
}
