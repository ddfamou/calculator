package cn.fox.exceptions;

import cn.fox.consts.CalculatorConst;

public class NegativeSquareRootException extends  OperationException{
    public NegativeSquareRootException() {
        StringBuilder sb = new StringBuilder();
        sb.append("Input of sqrt should not be negative. Operation position: ");
        sb.append(CalculatorConst.POSITION_PLACEHOLDER);
        sb.append(".");
        this.calculatorExceptionMessage = sb.toString();
    }
}
