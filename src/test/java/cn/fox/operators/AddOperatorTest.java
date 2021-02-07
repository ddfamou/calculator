package cn.fox.operators;

import cn.fox.exceptions.OperatorInternalException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class AddOperatorTest {
    @Test
    public void getOperationNameTest() {
        AddOperator op = new AddOperator();
        Assert.assertTrue(op.getOperatorName().equals("+"));
    }

    @Test
    public void operateTest() {
        AddOperator op = new AddOperator();
        BigDecimal ob1 = new BigDecimal("1");
        BigDecimal ob2 = new BigDecimal("2");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().get(0).equals(new BigDecimal("3")));
    }

    @Test
    public void operateTest2() {
        AddOperator op = new AddOperator();
        BigDecimal ob1 = new BigDecimal("1.1");
        BigDecimal ob2 = new BigDecimal("2");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().get(0).equals(new BigDecimal("3.1")));
    }

    @Test
    public void operateTest3() {
        AddOperator op = new AddOperator();
        BigDecimal ob1 = new BigDecimal("1.1");
        BigDecimal ob2 = new BigDecimal("2.3");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().get(0).equals(new BigDecimal("3.4")));
    }

    @Test
    public void operateTest4() {
        AddOperator op = new AddOperator();
        Assert.assertThrows(OperatorInternalException.class, () -> op.operate());
    }

    @Test
    public void addTest() {
        AddOperator op = new AddOperator();
        op.add(new BigDecimal("1"));
        op.add(new BigDecimal("1"));
        Assert.assertThrows(OperatorInternalException.class, () -> op.add(new BigDecimal("3")));
    }

    @Test
    public void numOfInputsTest() {
        AddOperator op = new AddOperator();
        Assert.assertEquals(2, op.numOfInputs());
    }

    @Test
    public void numOfOutputTest() {
        AddOperator op = new AddOperator();
        Assert.assertEquals(1, op.numOfOutputs());
    }

    @Test
    public void undoTest() {
        AddOperator op = new AddOperator();
        op.add(BigDecimal.ZERO);
        op.add(BigDecimal.TEN);
        List<BigDecimal> res = op.undo();
        Assert.assertTrue(res.get(0).equals(BigDecimal.ZERO));
        Assert.assertTrue(res.get(1).equals(BigDecimal.TEN));
    }
}
