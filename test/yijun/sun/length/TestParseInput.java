package yijun.sun.length;


import org.junit.Test;
import yijun.sun.length.bean.Expression;
import yijun.sun.length.bean.Unit;

import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;


/**
 * @author SunYiJun
 */
public class TestParseInput {

    @Test
    public void test_parse_input_file_get_units() {
        Map<String, Unit> allUnits = InputRepos.getAllDefinedUnit();
        assertEquals(1609.344f, allUnits.get("mile").getToMeters());
        assertEquals(0.9144f, allUnits.get("yard").getToMeters());
        assertEquals(AllTest.INCH_LENGTH, allUnits.get("inch").getToMeters());
        assertEquals(AllTest.FOOT_LENGTH, allUnits.get("foot").getToMeters());
        assertEquals(AllTest.FATH_LENGTH, allUnits.get("fath").getToMeters());
        assertEquals(AllTest.FURLONG_LENGTH, allUnits.get("furlong").getToMeters());
        assertEquals(1f, allUnits.get("m").getToMeters());
    }

    @Test
    public void test_parse_input_file_get_expressions() {
        List<Expression> allExpressions = InputRepos.getAllExpressions();
        assertEquals(10, allExpressions.size());
        validateExpression(1, 1.2f, allExpressions.get(0));
        validateExpression(2, 1f, allExpressions.get(6));
        validateExpression(3, 3.02f, allExpressions.get(9));
    }

    private void validateExpression(int lengthsSize, float fistLength,
            Expression expression) {
        assertEquals(lengthsSize, expression.getLengths().size());
        assertEquals(lengthsSize - 1, expression.getOperators().size());
        assertEquals(fistLength, expression.getLengths().get(0).getWeight());
    }

}
