package cn.fox.exceptions;

import cn.fox.consts.CalculatorConst;

public class ZeroDivisorException extends OperationException {
    public ZeroDivisorException() {
        StringBuilder sb = new StringBuilder();
        sb.append("Divisor cannot be ZERO. Operation position: ");
        sb.append(CalculatorConst.POSITION_PLACEHOLDER);
        sb.append(".");
        this.calculatorExceptionMessage = sb.toString();
    }
}
