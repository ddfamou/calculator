package cn.fox.operators;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MultipleOperatorTest {
    @Test
    public void getOperationNameTest() {
        MultipleOperator op = new MultipleOperator();
        Assert.assertTrue(op.getOperatorName().equals("*"));
    }

    @Test
    public void operateTest() {
        MultipleOperator op = new MultipleOperator();
        BigDecimal ob1 = new BigDecimal("1");
        BigDecimal ob2 = new BigDecimal("2");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().equals(new BigDecimal("2")));
    }

    @Test
    public void operateTest2() {
        MultipleOperator op = new MultipleOperator();
        BigDecimal ob1 = new BigDecimal("2.0");
        BigDecimal ob2 = new BigDecimal("2.5");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().equals(new BigDecimal("5.00")));
    }

    @Test
    public void operateTest3() {
        MultipleOperator op = new MultipleOperator();
        BigDecimal ob1 = new BigDecimal("2");
        BigDecimal ob2 = new BigDecimal("2.5");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().equals(new BigDecimal("5.0")));
    }

}
