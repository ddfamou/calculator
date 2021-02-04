package cn.fox.exceptions;

import cn.fox.consts.CalculatorConst;

public class UnknownInputException extends CalculatorException {
    public UnknownInputException(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append("Input (");
        sb.append(input);
        sb.append(", position: ");
        sb.append(CalculatorConst.POSITION_PLACEHOLDER);
        sb.append(") was no supported yet.");
        sb.append("Please use +, -, *, /, sqrt, undo, clear and numbers");
        this.calculatorExceptionMessage = sb.toString();
    }
}
