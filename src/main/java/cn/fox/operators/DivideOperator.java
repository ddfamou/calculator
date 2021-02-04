package cn.fox.operators;

import cn.fox.consts.CalculatorConst;
import cn.fox.exceptions.ZeroDivisorException;
import cn.fox.utils.NumberUtils;

import java.math.BigDecimal;

public class DivideOperator extends BinocularOperator {

    private static final String OPERATE_NAME = "/";

    public DivideOperator() {

    }

    @Override
    public BigDecimal operate() {
        super.validate();
        BigDecimal ob1 = obs.get(1);
        BigDecimal ob2 = obs.get(0);
        if (ob2.setScale(NumberUtils.SQRT_DIG.intValue())
                .equals(BigDecimal.ZERO.setScale(NumberUtils.SQRT_DIG.intValue()))) {
            throw new ZeroDivisorException();
        }
        try {
            return ob1.divide(ob2);
        } catch (ArithmeticException e){
            return ob1.divide(ob2, NumberUtils.SQRT_DIG.intValue(), CalculatorConst.ROUND_WAY);
        }
    }

    @Override
    public String getOperatorName() {
        return OPERATE_NAME;
    }
}
