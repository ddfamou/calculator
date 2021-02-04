package cn.fox.utils;

import cn.fox.consts.CalculatorConst;
import cn.fox.exceptions.UnknownInputException;

import java.math.BigDecimal;

public class NumberUtils {

    public static final BigDecimal SQRT_DIG = new BigDecimal(15);

    public static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());

    public static final int OUTPUT_DIG = 10;

    public static BigDecimal stringToNumber(String input) {
        try {
            return new BigDecimal(input);
        } catch (Exception e) {
            throw new UnknownInputException(input);
        }
    }

    public static String decimalToString(BigDecimal output) {
        return output.setScale(OUTPUT_DIG, CalculatorConst.ROUND_WAY).stripTrailingZeros().toPlainString();
    }
}
