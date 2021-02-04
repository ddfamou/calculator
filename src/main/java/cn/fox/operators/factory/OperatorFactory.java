package cn.fox.operators.factory;

import cn.fox.operators.*;
import cn.fox.operators.spec.Operator;

public class OperatorFactory {

    public static Operator getOperator(String op) {
        switch (op) {
            case "sqrt":
                return new SqrtOperator();
            case "+":
                return new AddOperator();
            case "-":
                return new MinusOperator();
            case "*":
                return new MultipleOperator();
            case "/":
                return new DivideOperator();
            // If input was not a operator, process as a number
            default:
                return new PutOperator();
        }
    }
}
