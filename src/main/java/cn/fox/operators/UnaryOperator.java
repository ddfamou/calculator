package cn.fox.operators;

import cn.fox.exceptions.OperatorInternalException;
import cn.fox.operators.spec.Operator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class UnaryOperator implements Operator {

    private static final int NUMBER_OF_INPUTS = 1;

    List<BigDecimal> obs;

    UnaryOperator() {
        obs = new ArrayList<>();
    }

    @Override
    public void add(BigDecimal ob) {
        if (!obs.isEmpty()) {
            throw new OperatorInternalException("Unary operator should take only 1 input.");
        }
        obs.add(ob);
    }

    void validate() {
        if (obs.size() != 1) {
            throw new OperatorInternalException("Unary operator should take 1 input.");
        }

    }

    @Override
    public int numOfInputs() {
        return NUMBER_OF_INPUTS;
    }

    @Override
    public List<BigDecimal> undo() {
        return obs;
    }

    @Override
    public int numOfOutputs() {
        return 1;
    }
}
