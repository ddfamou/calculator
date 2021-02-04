package cn.fox;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CalculatorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private static final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void exampleTest1() {
        Calculator calculator = new Calculator();
        calculator.run("5 2");
        Assert.assertTrue(calculator.output().equals("stack: 5 2"));
    }

    @Test
    public void exampleTest2() {
        Calculator calculator = new Calculator();
        calculator.run("2 sqrt");
        Assert.assertTrue(calculator.output().equals("stack: 1.4142135623"));
        calculator.run("clear 9 sqrt");
        Assert.assertTrue(calculator.output().equals("stack: 3"));
    }

    @Test
    public void exampleTest3() {
        Calculator calculator = new Calculator();
        calculator.run("5 2 -");
        Assert.assertTrue(calculator.output().equals("stack: 3"));
        calculator.run("3 -");
        Assert.assertTrue(calculator.output().equals("stack: 0"));
        calculator.run("clear");
        Assert.assertTrue(calculator.output().equals("stack:"));
    }

    @Test
    public void exampleTest4() {
        Calculator calculator = new Calculator();
        calculator.run("5 4 3 2");
        Assert.assertTrue(calculator.output().equals("stack: 5 4 3 2"));
        calculator.run("undo undo *");
        Assert.assertTrue(calculator.output().equals("stack: 20"));
        calculator.run("5 *");
        Assert.assertTrue(calculator.output().equals("stack: 100"));
        calculator.run("undo");
        Assert.assertTrue(calculator.output().equals("stack: 20 5"));
    }

    @Test
    public void exampleTest5() {
        Calculator calculator = new Calculator();
        calculator.run("7 12 2 /");
        Assert.assertTrue(calculator.output().equals("stack: 7 6"));
        calculator.run("*");
        Assert.assertTrue(calculator.output().equals("stack: 42"));
        calculator.run("4 /");
        Assert.assertTrue(calculator.output().equals("stack: 10.5"));
    }

    @Test
    public void exampleTest6() {
        Calculator calculator = new Calculator();
        calculator.run("1 2 3 4 5");
        Assert.assertTrue(calculator.output().equals("stack: 1 2 3 4 5"));
        calculator.run("*");
        Assert.assertTrue(calculator.output().equals("stack: 1 2 3 20"));
        calculator.run("clear 3 4 -");
        Assert.assertTrue(calculator.output().equals("stack: -1"));
    }

    @Test
    public void exampleTest7() {
        Calculator calculator = new Calculator();
        calculator.run("1 2 3 4 5");
        Assert.assertTrue(calculator.output().equals("stack: 1 2 3 4 5"));
        calculator.run("* * * *");
        Assert.assertTrue(calculator.output().equals("stack: 120"));
    }

    @Test
    public void exampleTest8() {
        Calculator calculator = new Calculator();
        calculator.run("1 2 3 * 5 + * * 6 5");

        // I do not think 'insucient' is a right word. So I use 'insufficient' for this case.
        Assert.assertEquals("operator * (position: 15): insufficient parameters\n", outContent.toString());
        Assert.assertEquals("stack: 11", calculator.output());
    }

    @Test
    public void divideTest() {
        Calculator calculator = new Calculator();
        calculator.run("1 3 /");
        Assert.assertEquals("stack: 0.3333333333", calculator.output());
    }

    @Test
    public void divideTest2() {
        Calculator calculator = new Calculator();
        calculator.run("1 0 /");
        Assert.assertEquals("Divisor cannot be ZERO. Operation position: 5.\n", outContent.toString());
        Assert.assertEquals("stack: 1 0", calculator.output());
    }

    @Test
    public void sqrtTest() {
        Calculator calculator = new Calculator();
        calculator.run("-1 sqrt");
        Assert.assertEquals("Input of sqrt should not be negative. Operation position: 4.\n",
                outContent.toString());
        Assert.assertEquals("stack: -1", calculator.output());
    }

}
