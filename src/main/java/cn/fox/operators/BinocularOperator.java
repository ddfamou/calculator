package cn.fox.operators;

import cn.fox.exceptions.OperatorInternalException;
import cn.fox.exceptions.OperatorInternalException;
import cn.fox.operators.spec.Operator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BinocularOperator implements Operator {

    private static final int NUMBER_OF_INPUTS = 2;

    List<BigDecimal> obs;

    BinocularOperator() {
        obs = new ArrayList<>();
    }

    @Override
    public void add(BigDecimal ob) {
        if (obs.size() >= 2) {
            throw new OperatorInternalException("Binocular operator should take only 2 inputs.");
        }
        obs.add(ob);
    }

    void validate() {
        if (obs.size() != 2) {
            throw new OperatorInternalException("Binocular operator should take 2 inputs.");
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



}
