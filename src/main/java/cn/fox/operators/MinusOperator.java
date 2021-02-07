package cn.fox.operators;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MinusOperator extends BinocularOperator {

    private static final String OPERATE_NAME = "-";

    public MinusOperator() {

    }

    @Override
    public List<BigDecimal> operate() {
        super.validate();
        BigDecimal ob1 = obs.get(1);
        BigDecimal ob2 = obs.get(0);
        List<BigDecimal> res = new ArrayList<>();
        res.add(ob1.subtract(ob2));
        return res;
    }

    @Override
    public String getOperatorName() {
        return OPERATE_NAME;
    }
}
