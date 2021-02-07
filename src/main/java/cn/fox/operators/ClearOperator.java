package cn.fox.operators;

import cn.fox.exceptions.OperatorInternalException;
import cn.fox.operators.spec.Operator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClearOperator implements Operator {

    List<BigDecimal> obs;

    private static final String OPERATE_NAME = "clear";

    @Override
    public String getOperatorName() {
        return OPERATE_NAME;
    }

    public ClearOperator() {
        obs = new ArrayList<>();
    }

    @Override
    public void add(BigDecimal ob) {
        obs.add(ob);
    }

    @Override
    public int numOfInputs() {
        return obs.size();
    }

    @Override
    public List<BigDecimal> undo() {
        return obs;
    }

    @Override
    public List<BigDecimal> operate() {
        throw new OperatorInternalException("clear operator.operate should not be called");
    }

    @Override
    public int numOfOutputs() {
        // Clear operator has no output
        return 0;
    }
}
