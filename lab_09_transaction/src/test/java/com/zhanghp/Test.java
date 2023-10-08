package com.zhanghp;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhanghp
 * @since 2023/9/27 15:01
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("10.00");
        BigDecimal value = amount.divide(new BigDecimal( "3"), 0, RoundingMode.CEILING);
        BigDecimal value2 = amount.divide(new BigDecimal( "3"),  RoundingMode.CEILING);
        double value3 = amount.divide(new BigDecimal( "3"), RoundingMode.CEILING).setScale(2).intValue();
        System.out.println(value);
        System.out.println(value2);
        System.out.println(value3);
    }
}
