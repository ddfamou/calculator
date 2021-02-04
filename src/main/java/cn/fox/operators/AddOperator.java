package cn.fox.operators;


import java.math.BigDecimal;

public class AddOperator extends BinocularOperator {

    private static final String OPERATE_NAME = "+";

    public AddOperator() {
    }

    @Override
    public BigDecimal operate() {
        super.validate();
        BigDecimal ob1 = obs.get(1);
        BigDecimal ob2 = obs.get(0);
        return ob1.add(ob2);
    }

    @Override
    public String getOperatorName() {
        return OPERATE_NAME;
    }
}
