package cn.fox.exceptions;

import cn.fox.consts.CalculatorConst;

public class OperatorInternalException extends CalculatorException {
    public OperatorInternalException(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        sb.append(" (position: ");
        sb.append(CalculatorConst.POSITION_PLACEHOLDER);
        sb.append(").");
        this.calculatorExceptionMessage = sb.toString();
    }
}
