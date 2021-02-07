package cn.fox.operators;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MinusOperatorTest {
    @Test
    public void getOperationNameTest() {
        MinusOperator op = new MinusOperator();
        Assert.assertTrue(op.getOperatorName().equals("-"));
    }

    @Test
    public void operateTest() {
        MinusOperator op = new MinusOperator();
        BigDecimal ob1 = new BigDecimal("1");
        BigDecimal ob2 = new BigDecimal("2");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().get(0).equals(new BigDecimal("1")));
    }

    @Test
    public void operateTest2() {
        MinusOperator op = new MinusOperator();
        BigDecimal ob1 = new BigDecimal("1.0");
        BigDecimal ob2 = new BigDecimal("2");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().get(0).equals(new BigDecimal("1.0")));
    }

    @Test
    public void operateTest3() {
        MinusOperator op = new MinusOperator();
        BigDecimal ob1 = new BigDecimal("1.0");
        BigDecimal ob2 = new BigDecimal("2.00");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().get(0).equals(new BigDecimal("1.00")));
    }
}
