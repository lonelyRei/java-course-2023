package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void rectangleAreaTest() {
        Rectangle rectangle = new Rectangle(20, 20);
        assertEquals(400, rectangle.area());
    }

    @Test
    public void rectangleAreaTestAfterChangeWidth() {
        Rectangle rectangle = new Rectangle(100, 200);
        rectangle = rectangle.setWidth(10);
        assertEquals(2000, rectangle.area());
    }

    @Test
    public void rectangleAreaTestAfterChangeHeight() {
        Rectangle rectangle = new Rectangle(100, 200);
        rectangle = rectangle.setHeight(10);
        assertEquals(1000, rectangle.area());
    }

    @Test
    public void rectangleAreaTestAfterChangeWidthAndHeight() {
        Rectangle rectangle = new Rectangle(100, 200);
        rectangle = rectangle.setHeight(30);
        rectangle = rectangle.setWidth(10);
        assertEquals(300, rectangle.area());
    }

    @Test
    public void squareAreaTest() {
        Square square = new Square(5);
        assertEquals(25, square.area());
    }

    @Test
    public void squareAreaTestAfterChangeWidth() {
        Rectangle square = new Square(100);
        square = square.setWidth(20);
        assertEquals(400, square.area());
    }

    @Test
    public void squareAreaTestAfterChangeHeight() {
        Rectangle square = new Square(100);
        square = square.setHeight(20);
        assertEquals(400, square.area());
    }

    @Test
    public void squareAreaTestAfterChangeWidthAndHeight() {
        Rectangle square = new Square(100);
        square = square.setHeight(20);
        square = square.setWidth(30);
        assertEquals(900, square.area());
    }
}
