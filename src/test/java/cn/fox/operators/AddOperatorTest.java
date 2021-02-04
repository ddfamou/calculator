package cn.fox.operators;

import cn.fox.exceptions.OperatorInternalException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

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
        Assert.assertTrue(op.operate().equals(new BigDecimal("3")));
    }

    @Test
    public void operateTest2() {
        AddOperator op = new AddOperator();
        BigDecimal ob1 = new BigDecimal("1.1");
        BigDecimal ob2 = new BigDecimal("2");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().equals(new BigDecimal("3.1")));
    }

    @Test
    public void operateTest3() {
        AddOperator op = new AddOperator();
        BigDecimal ob1 = new BigDecimal("1.1");
        BigDecimal ob2 = new BigDecimal("2.3");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().equals(new BigDecimal("3.4")));
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
}
