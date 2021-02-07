package cn.fox.operators;

import java.math.BigDecimal;
import java.util.List;

public class PutOperator extends NoOperator {

    private static final String OPERATE_NAME = "Push";


    public PutOperator() {
        super();
    }

    @Override
    public List<BigDecimal> operate() {
        return null;
    }

    @Override
    public String getOperatorName() {
        return OPERATE_NAME;
    }
}
