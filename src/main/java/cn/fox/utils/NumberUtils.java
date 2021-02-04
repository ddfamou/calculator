package cn.fox.utils;

import cn.fox.consts.CalculatorConst;
import cn.fox.exceptions.UnknownInputException;

import java.math.BigDecimal;


public class NumberUtils {

    public static final BigDecimal SQRT_DIG = new BigDecimal(10);

    public static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());


    /*
        this function is to check if the input could be round to an long with no accuracy lose.
        isLong(new BigDecimal("1")) == true
        isLong(new BigDecimal("1.1")) == false
        isLong(new BigDecimal("1.0")) == true
     */
    public static boolean isLong(BigDecimal decimal) {
        return decimal.setScale(0, CalculatorConst.ROUND_WAY)
                .subtract(decimal).abs().multiply(SQRT_PRE).compareTo(BigDecimal.ONE) <= 0;
    }


    /*
        this function is to check if the input is a double value
        isDouble(new BigDecimal("1")) == false
        isDouble(new BigDecimal("1.1")) == true
        isDouble(new BigDecimal("1.0")) == true
     */
    public static boolean isDouble(BigDecimal decimal) {
        return decimal.toString().indexOf(".") != -1;
    }

    public static BigDecimal stringToNumber(String input) {
        try {
            return new BigDecimal(input);
        } catch (Exception e) {
            throw new UnknownInputException(input);
        }
    }
}
