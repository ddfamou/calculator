package cn.fox.operators;

import cn.fox.consts.CalculatorConst;
import cn.fox.exceptions.ZeroDivisorException;
import cn.fox.utils.NumberUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DivideOperator extends BinocularOperator {

    private static final String OPERATE_NAME = "/";

    public DivideOperator() {

    }

    @Override
    public List<BigDecimal> operate() {
        super.validate();
        BigDecimal ob1 = obs.get(1);
        BigDecimal ob2 = obs.get(0);
        List<BigDecimal> res = new ArrayList<>();
        if (ob2.setScale(NumberUtils.SQRT_DIG.intValue())
                .equals(BigDecimal.ZERO.setScale(NumberUtils.SQRT_DIG.intValue()))) {
            throw new ZeroDivisorException();
        }
        try {
            res.add(ob1.divide(ob2));
        } catch (ArithmeticException e){
            res.add(ob1.divide(ob2, NumberUtils.SQRT_DIG.intValue(), CalculatorConst.ROUND_WAY));
        }
        return res;
    }

    @Override
    public String getOperatorName() {
        return OPERATE_NAME;
    }
}
