package cn.fox;

import cn.fox.exceptions.*;
import cn.fox.operators.*;
import cn.fox.operators.factory.OperatorFactory;
import cn.fox.operators.spec.Operator;
import cn.fox.utils.NumberUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

import static cn.fox.consts.CalculatorConst.POSITION_PLACEHOLDER;

public class Calculator {

    Stack<BigDecimal> numbers;
    Stack<Operator> operators;

    public Calculator() {
        numbers = new Stack<>();
        operators = new Stack<>();
    }


    public void append(String input) {
        // Format
        if (input == null) {
            return;
        }
        String tmp = input.trim().toLowerCase();
        if (tmp.length() == 0) {
            return;
        }

        // Check if it was undo
        if (input.equals("undo")) {
            undo();
            return;
        }

        // Check if it was clear
        if (input.equals("clear")) {
            /*
            * if clear is a function that could be undo, please use clear2()
            * if clear is a function to clear all numbers in stack and all previous operators, please use clear()
            * */
//            clear();
            clear2();
            return;
        }

        Operator op = OperatorFactory.getOperator(input);
        if (op instanceof NoOperator) {
            numbers.push(NumberUtils.stringToNumber(input));
            operators.push(op);
            return;
        }
        operate(op);
    }

    private void clear() {
        this.numbers.clear();
        this.operators.clear();
    }

    private void clear2() {
        Operator op = new ClearOperator();
        while (!numbers.isEmpty()) {
            op.add(numbers.pop());
        }
        this.operators.add(op);
    }

    public void append(String[] inputs) {
        int position = 1;
        try {
            for (String input : inputs) {
                append(input);
                position++;
                position = position + input.length();
            }
        } catch (CalculatorException e) {
            System.out.println(e.getErrorMessage().replace(POSITION_PLACEHOLDER, String.valueOf(position)));
        } finally {
        }
    }

    public String output() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack:");
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(' ');
            sb.append(NumberUtils.decimalToString(numbers.get(i)));
        }
        return sb.toString();
    }

    private void undo() {
        if (operators.isEmpty()) {
            // Nothing to undo exception
            throw new NothingUndoException();
        }
        Operator op = operators.pop();
        if (op instanceof ClearOperator) {

        } else {
            numbers.pop();
        }
        List<BigDecimal> obs = op.undo();
        for (int i = obs.size() - 1; i >= 0; i--) {
            numbers.push(obs.get(i));
        }
        return;
    }

    private void operate(Operator op) {
        int inputNumber = op.numOfInputs();
        if (numbers.size() < inputNumber) {
            throw new NoEnoughParameterException(op, numbers.size());
        }
        for (int i = 0; i < inputNumber; i++) {
            op.add(numbers.pop());
        }
        operators.push(op);
        try {
            numbers.push(op.operate());
        } catch (OperationException e) {
            /*
             * if there was an operation error, such as a/0 or sqrt(-1)
             * we push an number in and call undo t
             */
            numbers.push(BigDecimal.ZERO);
            undo();
            throw e;
        }
        return;
    }

    public void run(String line) {
        append(line.split(" "));
    }
}
