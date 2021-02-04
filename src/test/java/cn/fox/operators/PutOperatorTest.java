package cn.fox.operators;

import cn.fox.exceptions.OperatorInternalException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PutOperatorTest {
    @Test
    public void getOperationNameTest() {
        PutOperator op = new PutOperator();
        Assert.assertTrue(op.getOperatorName().equals("Push"));
    }

    @Test
    public void operateTest() {
        PutOperator op = new PutOperator();
        Assert.assertNull(op.operate());
    }

    @Test
    public void numOfInputsTest() {
        PutOperator op = new PutOperator();
        Assert.assertEquals(0, op.numOfInputs());
    }

    @Test
    public void add() {
        PutOperator op = new PutOperator();
        Assert.assertThrows(OperatorInternalException.class, () -> op.add(new BigDecimal("1")));
    }
}
