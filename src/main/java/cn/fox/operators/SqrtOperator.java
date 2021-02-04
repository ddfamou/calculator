package cn.fox.operators;

import java.math.BigDecimal;
import java.math.RoundingMode;

import cn.fox.consts.CalculatorConst;
import cn.fox.exceptions.NegativeSquareRootException;
import cn.fox.utils.NumberUtils;

public class SqrtOperator extends UnaryOperator {

    private static final String OPERATE_NAME = "sqrt";

    public SqrtOperator() {
        super();
    }

    @Override
    public BigDecimal operate() {
        super.validate();
        BigDecimal ob1 = obs.get(0);
        if (ob1.compareTo(BigDecimal.ZERO) == -1) {
            throw new NegativeSquareRootException();
        }
        BigDecimal res = sqrtNewtonRaphson(ob1, new BigDecimal(1),
                new BigDecimal(1).divide(NumberUtils.SQRT_PRE));

        /*
        * If the input is a long value and the square root is also a long,
        * the result should be long. For example, sqrt(4) = 2.
        * However, if the input is a double,
        * the square root should always be a double. For example, sqrt(4.0) = 2.0000000
        * */
        if (!NumberUtils.isDouble(ob1) && NumberUtils.isLong(res)) {
            return new BigDecimal(res.toBigInteger());
        } else {
            return res.setScale(NumberUtils.SQRT_DIG.intValue(), CalculatorConst.ROUND_WAY);
        }
    }

    // Using JDk8 with no BigDecimal.sqrt function
    private BigDecimal sqrtNewtonRaphson(BigDecimal c, BigDecimal xn, BigDecimal precision){
        BigDecimal fx = xn.pow(2).add(c.negate());
        BigDecimal fpx = xn.multiply(new BigDecimal(2));
        BigDecimal xn1 = fx.divide(fpx,2* NumberUtils.SQRT_DIG.intValue(),RoundingMode.HALF_DOWN);
        xn1 = xn.add(xn1.negate());
        BigDecimal currentSquare = xn1.pow(2);
        BigDecimal currentPrecision = currentSquare.subtract(c);
        currentPrecision = currentPrecision.abs();
        if (currentPrecision.compareTo(precision) <= -1){
            return xn1;
        }
        return sqrtNewtonRaphson(c, xn1, precision);
    }

    @Override
    public String getOperatorName() {
        return OPERATE_NAME;
    }
}
