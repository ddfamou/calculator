package cn.fox.operators;

import java.math.BigDecimal;

public class PutOperator extends NoOperator {

    private static final String OPERATE_NAME = "Push";


    public PutOperator() {
        super();
    }

    @Override
    public BigDecimal operate() {
        return null;
    }

    @Override
    public String getOperatorName() {
        return OPERATE_NAME;
    }
}
