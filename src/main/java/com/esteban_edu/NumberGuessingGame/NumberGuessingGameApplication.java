package com.esteban_edu.NumberGuessingGame;

import com.esteban_edu.NumberGuessingGame.core.GameConfigs;
import com.esteban_edu.NumberGuessingGame.core.GameState;
import com.esteban_edu.NumberGuessingGame.core.GuessDirection;
import com.esteban_edu.NumberGuessingGame.core.NumberGenerator;
import com.esteban_edu.NumberGuessingGame.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static com.esteban_edu.NumberGuessingGame.core.GameConstants.*;


@SpringBootApplication
//@Profile("import")
public class NumberGuessingGameApplication implements CommandLineRunner {
    // game configs
    public static GameConfigs configs = new GameConfigs();
    private static Logger LOG = LoggerFactory
            .getLogger(NumberGuessingGameApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NumberGuessingGameApplication.class, args);
    }

    private static GameState runPlayPhase() {
        Scanner scn = new Scanner(System.in);
        boolean playPhase = true;
        GameState playState = GameState.NOT_STARTED;
        promptSetCurrentGuess();
        configs.setCurrentGuess(scn.nextInt());
        while (playPhase) {

            boolean won = configs.getCurrentGuess() == configs.getSecretNumber()
                    && configs.getGuessesLeft() != 0;
            if (won) {
                playState = GameState.WON;
                playPhase = false;
            } else {
                configs.decreaseGuessesLeft();
                if (configs.getGuessesLeft() == 0) {
                    playState = GameState.LOST;
                    break;
                }

                GuessDirection guessDirection =
                        configs.getCurrentGuess() > configs.getSecretNumber()
                                ? GuessDirection.HIGH
                                : GuessDirection.LOW;
                promptTryAnotherGuess(configs.getGuessesLeft(), guessDirection.toString());
                promptSetCurrentGuess();
                configs.setCurrentGuess(scn.nextInt());
            }
        }
        return playState;
    }

    /**
     * generates the secret number and stores it in config obj
     */
    private static void runGenerateSecretNumber() {
        int secretNumber = NumberGenerator.getFromRange(0, configs.getMaxRange());
        configs.setSecretNumber(secretNumber);
    }

    /**
     * validates the chosen number against the allowed max and mins
     *
     * @param maxRange
     * @return
     */
    private static boolean validateChosenNumber(int maxRange) {
        return maxRange >= NUMBER_MIN_ALLOWED && maxRange <= NUMBER_MAX_ALLOWED;
    }
    // Game staging methods

    /**
     * Prints the promt to use to enter the difficulty
     */
    private static void promptSetConfigs() {
        Utils.log(
                "Set game difficulty by typing a number between 100 to 1000",
                "Game Configs"
        );
    }

    private static void promptSetCurrentGuess() {
        Utils.log(
                "Enter your next guess",
                "Play"
        );
    }

    private static void promptTryAnotherGuess(int triesLeft, String direction) {
        Utils.log(
                "You guess was too " + direction + ", " + triesLeft + " tries left",
                "Try again"
        );
    }

    private static void handleWonORLostMessage(int secretNumber, int triesLeft, GameState result) {
        String banner = result == GameState.WON
                ? HAPPY_BANNER
                : SAD_BANNER;
        Utils.log(
                "The secret number is "
                        + secretNumber
                        + " and your score is "
                        + triesLeft
                        + banner,
                result == GameState.WON
                        ? banner + "Congratulations, you WON!"
                        : banner + "Game Over"
        );
    }

    /**
     * while loop that repeats the input prompt when difficulty is invalid
     */
    private static void runConfigPhase() {
        boolean configPhase = true;
        Scanner scn = new Scanner(System.in);
        while (configPhase) {
            promptSetConfigs();
            configs.setMaxRange(scn.nextInt());
            if (validateChosenNumber(configs.getMaxRange())) {
                Utils.log(
                        configs.getMaxRange(),
                        "You entered a valid choice"
                );
                configPhase = false;
            } else {
                Utils.log(
                        configs.getMaxRange(),
                        "Invalid Choice"
                );
            }
        }
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("STARTING NumberGuessingGameApplication");

        configs.setGameState(GameState.IN_PROGRESS);
        Utils.log(
                configs.getGameState().toString(),
                "Game Status"
        );
        // player sets game configs
        runConfigPhase();
        runGenerateSecretNumber();
        // !! TODO REMOVE After testing
        Utils.log(configs.getSecretNumber(), "secret Number");
        // while loop for user to enter number until secret number is guessed
        GameState playState = runPlayPhase();
        handleWonORLostMessage(
                configs.getSecretNumber(),
                configs.getGuessesLeft(),
                playState);

        LOG.info("SHUTTING DOWN NumberGuessingGameApplication");
    }
}
