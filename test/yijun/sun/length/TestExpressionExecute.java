package yijun.sun.length;


import org.junit.Test;
import yijun.sun.length.bean.Expression;

import static junit.framework.Assert.assertEquals;


/**
 * @author SunYiJun
 */
public class TestExpressionExecute {

    @Test
    public void test_one_length_execute() {
        Expression expression = Expression.createExpression("127.93 feet");
        assertEquals(127.93f * AllTest.FOOT_LENGTH, expression.execute().getWeight());
    }

    @Test
    public void test_two_length_execute() {
        Expression expression = Expression.createExpression("1 furlong + 2.5 feet");
        assertEquals(AllTest.FURLONG_LENGTH + 2.5f * AllTest.FOOT_LENGTH,
                expression.execute().getWeight());
    }

    @Test
    public void test_three_length_execute() {
        Expression expression =
                Expression.createExpression("1 fath - 1 foot + 12.5 inches");
        assertEquals(
                AllTest.FATH_LENGTH - AllTest.FOOT_LENGTH + 12.5f * AllTest.INCH_LENGTH,
                expression.execute().getWeight());
    }

}
