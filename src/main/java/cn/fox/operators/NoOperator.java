package cn.fox.operators;

import cn.fox.exceptions.OperatorInternalException;
import cn.fox.operators.spec.Operator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class NoOperator implements Operator {

    private static final int NUMBER_OF_INPUTS = 0;

    List<BigDecimal> obs;

    @Override
    public void add(BigDecimal ob) {
        throw new OperatorInternalException("NoOperator  should take no input.");
    }

    public NoOperator() {
        obs = new ArrayList<>();
    }

    @Override
    public int numOfInputs() {
        return NUMBER_OF_INPUTS;
    }

    @Override
    public List<BigDecimal> undo() {
        return new ArrayList<>();
    }
}