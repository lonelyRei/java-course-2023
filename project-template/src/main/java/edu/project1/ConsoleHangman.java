package edu.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class ConsoleHangman {
    private final HashSet<Character> receivedSymbols = new HashSet<>();
    private final static Logger LOGGER = LogManager.getLogger("Hangman");
    private final Session session;
    private final String stopWord = "stop";

    public ConsoleHangman() {
        this.session = new Session();
    }

    public String getStopWord() {
        return this.stopWord;
    }

    public Session getSession() {
        return this.session;
    }

    public void run() throws IOException {
        LOGGER.info("Start of game");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        while (true) {
            LOGGER.info("Guess a letter:");
            String input = reader.readLine().toLowerCase();

            States resultState = this.tryGuess(input).state();

            if (resultState == States.GIVE_UP || resultState == States.DEFEAT || resultState == States.WIN) {
                break;
            }
        }
    }

    public GuessResult tryGuess(String input) {
        if (input.equals(this.stopWord)) {
            GuessResult interrupt = this.session.giveUp();
            LOGGER.info(interrupt.message());
            return interrupt;
        }

        if (validateUserInput(input)) {
            Character letter = input.charAt(0);
            receivedSymbols.add(letter);
            GuessResult currentState = this.session.guess(letter);

            LOGGER.info(currentState.message());
            LOGGER.info(this.session.getSessionInfo());

            return currentState;
        } else {
            GuessResult incorrectInput = new GuessResult.IncorrectInput();
            LOGGER.info(incorrectInput.message());
            return incorrectInput;
        }
    }

    private boolean validateUserInput(@NotNull String input) {
        return input.length() == 1 && input.matches("[a-z]") && !receivedSymbols.contains(input.charAt(0));
    }
}
