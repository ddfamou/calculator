package cn.fox.operators;

import cn.fox.exceptions.OperatorInternalException;
import cn.fox.utils.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class SqrtOperatorTest {
    @Test
    public void getOperationNameTest() {
        SqrtOperator op = new SqrtOperator();
        Assert.assertEquals("sqrt", op.getOperatorName());
    }

    @Test
    public void operateTest() {
        SqrtOperator op = new SqrtOperator();
        BigDecimal ob = new BigDecimal("4");
        op.add(ob);
        Assert.assertEquals(NumberUtils.decimalToString(op.operate().get(0)), "2");
    }

    @Test
    public void operateTest2() {
        SqrtOperator op = new SqrtOperator();
        BigDecimal ob = new BigDecimal("2");
        op.add(ob);
        Assert.assertEquals(NumberUtils.decimalToString(op.operate().get(0)), "1.4142135623");
    }

    @Test
    public void operateTest3() {
        SqrtOperator op = new SqrtOperator();
        Assert.assertThrows(OperatorInternalException.class, () -> op.operate());
    }

    @Test
    public void addTest() {
        SqrtOperator op = new SqrtOperator();
        op.add(new BigDecimal("1"));
        Assert.assertThrows(OperatorInternalException.class, () -> op.add(new BigDecimal("3")));
    }

    @Test
    public void numOfInputsTest() {
        SqrtOperator op = new SqrtOperator();
        Assert.assertEquals(1, op.numOfInputs());
    }

}
