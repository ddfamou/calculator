package cn.fox.operators;

import cn.fox.exceptions.OperatorInternalException;
import cn.fox.operators.spec.Operator;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class ClearOperatrorTest {
    @Test
    public void getOperatorNameTest() {
        Operator op = new ClearOperator();
        Assert.assertEquals("clear", op.getOperatorName());
    }

    @Test
    public void numOfInputsTest() {
        Operator op = new ClearOperator();
        Assert.assertEquals(0, op.numOfInputs());
        BigDecimal ob1 = new BigDecimal("1");
        op.add(ob1);
        Assert.assertEquals(1, op.numOfInputs());
        BigDecimal ob2 = new BigDecimal("2");
        op.add(ob2);
        Assert.assertEquals(2, op.numOfInputs());
        BigDecimal ob3 = new BigDecimal("3");
        op.add(ob3);
        Assert.assertEquals(3, op.numOfInputs());
    }

    @Test
    public void numOfOutputsTest() {
        Operator op = new ClearOperator();
        Assert.assertEquals(0, op.numOfOutputs());
    }

    @Test
    public void undoTest() {
        Operator op = new ClearOperator();
        op.add(BigDecimal.ZERO);
        op.add(BigDecimal.ONE);
        op.add(BigDecimal.TEN);
        List<BigDecimal> res = op.undo();
        Assert.assertTrue(res.get(0).equals(BigDecimal.ZERO));
        Assert.assertTrue(res.get(1).equals(BigDecimal.ONE));
        Assert.assertTrue(res.get(2).equals(BigDecimal.TEN));
    }

    @Test
    public void operateTest() {
        Operator op = new ClearOperator();
        Assert.assertThrows(OperatorInternalException.class, () -> op.operate());
    }
}
