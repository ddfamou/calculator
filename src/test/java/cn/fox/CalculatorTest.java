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
        Assert.assertEquals("stack: 5 2", calculator.output());
    }

    @Test
    public void exampleTest2() {
        Calculator calculator = new Calculator();
        calculator.run("2 sqrt");
        Assert.assertEquals("stack: 1.4142135623", calculator.output());
        calculator.run("clear 9 sqrt");
        Assert.assertEquals("stack: 3", calculator.output());
    }

    @Test
    public void exampleTest3() {
        Calculator calculator = new Calculator();
        calculator.run("5 2 -");
        Assert.assertEquals("stack: 3", calculator.output());
        calculator.run("3 -");
        Assert.assertEquals("stack: 0", calculator.output());
        calculator.run("clear");
        Assert.assertEquals("stack:", calculator.output());
    }

    @Test
    public void exampleTest4() {
        Calculator calculator = new Calculator();
        calculator.run("5 4 3 2");
        Assert.assertEquals("stack: 5 4 3 2", calculator.output());
        calculator.run("undo undo *");
        Assert.assertEquals("stack: 20", calculator.output());
        calculator.run("5 *");
        Assert.assertEquals("stack: 100", calculator.output());
        calculator.run("undo");
        Assert.assertEquals("stack: 20 5", calculator.output());
    }

    @Test
    public void exampleTest5() {
        Calculator calculator = new Calculator();
        calculator.run("7 12 2 /");
        Assert.assertEquals("stack: 7 6", calculator.output());
        calculator.run("*");
        Assert.assertEquals("stack: 42", calculator.output());
        calculator.run("4 /");
        Assert.assertEquals("stack: 10.5", calculator.output());
    }

    @Test
    public void exampleTest6() {
        Calculator calculator = new Calculator();
        calculator.run("1 2 3 4 5");
        Assert.assertEquals("stack: 1 2 3 4 5", calculator.output());
        calculator.run("*");
        Assert.assertEquals("stack: 1 2 3 20", calculator.output());
        calculator.run("clear 3 4 -");
        Assert.assertEquals("stack: -1", calculator.output());
    }

    @Test
    public void exampleTest7() {
        Calculator calculator = new Calculator();
        calculator.run("1 2 3 4 5");
        Assert.assertEquals("stack: 1 2 3 4 5", calculator.output());
        calculator.run("* * * *");
        Assert.assertEquals("stack: 120", calculator.output());
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

    @Test
    public void undoTest() {
        Calculator calculator = new Calculator();
        calculator.run("1 undo undo");
        Assert.assertEquals("Nothing to undo (position: 8).\n", outContent.toString());
    }

    @Test
    /*
     * this test only available for cle
     */
    public void clearTest() {
        Calculator calculator = new Calculator();
        calculator.run("1 2 3 clear");
        Assert.assertEquals("stack:", calculator.output());
        calculator.run("undo");
        Assert.assertEquals("stack: 1 2 3", calculator.output());
    }
}
