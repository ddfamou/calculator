package cn.fox.exceptions;

import cn.fox.consts.CalculatorConst;

public class NothingUndoException extends CalculatorException {
    public NothingUndoException() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nothing to undo (position: ");
        sb.append(CalculatorConst.POSITION_PLACEHOLDER);
        sb.append(").");
        this.calculatorExceptionMessage = sb.toString();
    }
}
