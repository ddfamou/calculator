package cn.fox.utils;

import cn.fox.exceptions.UnknownInputException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NumberUtilsTest {
    @Test
    public void stringToNumberTest() {
        Assert.assertTrue(NumberUtils.stringToNumber("1.0").equals(new BigDecimal("1.0")));
    }

    @Test
    public void stringToNumberTest2() {
        Assert.assertTrue(NumberUtils.stringToNumber("1").equals(new BigDecimal("1")));
    }

    @Test
    public void stringToNumberTest3() {
        Assert.assertThrows(UnknownInputException.class, () -> NumberUtils.stringToNumber("1abc"));
    }
}
