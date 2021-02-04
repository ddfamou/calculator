package cn.fox.exceptions;

import cn.fox.operators.spec.Operator;

import static cn.fox.consts.CalculatorConst.POSITION_PLACEHOLDER;

public class NoEnoughParameterException extends CalculatorException {

    public NoEnoughParameterException() {
        super();
    }

    public NoEnoughParameterException(Operator op, int num) {
        StringBuilder sb = new StringBuilder();
        sb.append("operator ");
        sb.append(op.getOperatorName());
        sb.append(" (position: ");
        sb.append(POSITION_PLACEHOLDER);
        sb.append("): insufficient parameters");
        this.calculatorExceptionMessage = sb.toString();
    }

}
