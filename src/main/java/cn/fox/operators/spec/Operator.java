package cn.fox.operators.spec;

import java.math.BigDecimal;
import java.util.List;

public interface Operator {

    // Put input in operator
    void add(BigDecimal ob);

    // Do the operation, return result
    BigDecimal operate();

    // Undo operate
    List<BigDecimal> undo();

    // Number of inputs
    int numOfInputs();

    // Get the operator name.
    String getOperatorName();
}
