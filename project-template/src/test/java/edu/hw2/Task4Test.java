package edu.hw2;

import edu.hw2.Task4.Calling;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    public void callingInfoTestMethodName() {
        assertEquals("callingInfoTestMethodName", Calling.callingInfo().methodName());
    }

    @Test
    public void callingInfoTestClassName() {
        assertEquals("edu.hw2.Task4Test", Calling.callingInfo().className());
    }
}
