package cn.fox.operators;

import cn.fox.exceptions.ZeroDivisorException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DivideOperatorTest {
    @Test
    public void getOperationNameTest() {
        DivideOperator op = new DivideOperator();
        Assert.assertTrue(op.getOperatorName().equals("/"));
    }

    @Test
    public void operateTest() {
        DivideOperator op = new DivideOperator();
        BigDecimal ob1 = new BigDecimal("1");
        BigDecimal ob2 = new BigDecimal("2");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().get(0).equals(new BigDecimal("2")));
    }


    @Test
    public void operateTest2() {
        DivideOperator op = new DivideOperator();
        BigDecimal ob1 = new BigDecimal("2");
        BigDecimal ob2 = new BigDecimal("1");
        op.add(ob1);
        op.add(ob2);
        Assert.assertTrue(op.operate().get(0).equals(new BigDecimal("0.5")));
    }

    @Test
    public void operateTest3() {
        DivideOperator op = new DivideOperator();
        BigDecimal ob1 = new BigDecimal("3");
        BigDecimal ob2 = new BigDecimal("1");
        op.add(ob1);
        op.add(ob2);
        Assert.assertEquals(op.operate().get(0).setScale(10, BigDecimal.ROUND_DOWN).toString(), "0.3333333333");
    }

    @Test
    public void operateTest4() {
        DivideOperator op = new DivideOperator();
        BigDecimal ob1 = new BigDecimal("0");
        BigDecimal ob2 = new BigDecimal("1");
        op.add(ob1);
        op.add(ob2);
        Assert.assertThrows(ZeroDivisorException.class, () -> op.operate());
    }
}
