package edu.project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleHangmanTests {
    @Test
    public void testHangmanAttempts() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("f");
        hangman.tryGuess("t");

        assertEquals(hangman.getSession().getAttempts(), 2);
    }

    @Test
    public void testHangmanAttemptsDuplicate() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("f");
        hangman.tryGuess("f");

        assertEquals(hangman.getSession().getAttempts(), 1);
    }

    @Test
    public void testHangmanAttemptsIncorrectInput() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("fa");

        assertEquals(hangman.getSession().getAttempts(), 0);
    }

    @Test
    public void testHangmanAttemptsIncorrectInputWithNumbers() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("1");

        assertEquals(hangman.getSession().getAttempts(), 0);
    }

    @Test
    public void testHangmanLose() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("a");
        hangman.tryGuess("b");
        hangman.tryGuess("c");
        hangman.tryGuess("d");
        hangman.tryGuess("e");
        hangman.tryGuess("f");
        hangman.tryGuess("g");
        States res = hangman.tryGuess("h").state();

        assertEquals(res, States.DEFEAT);
    }

    @Test
    public void testHangmanInterruptGame() {
        ConsoleHangman hangman = new ConsoleHangman();
        States res = hangman.tryGuess(hangman.getStopWord()).state();

        assertEquals(res, States.GIVE_UP);
    }
}
