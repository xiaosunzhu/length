package yijun.sun.length.bean;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Contains lengths and operators.
 *
 * @author SunYiJun
 */
public class Expression {

    /**
     * length to be calculate with order.
     */
    private List<Length> lengths;

    /**
     * operators to calculate with order.
     */
    private List<String> operators;

    /**
     * Parse one expression line,and create Expression object.
     *
     * @param expressionLine one line expression.
     * @return Expression object
     */
    public static Expression createExpression(String expressionLine) {
        Expression expression = new Expression();
        expression.lengths = new ArrayList<Length>();
        expression.operators = new ArrayList<String>();
        Pattern splitPattern = Pattern.compile("([\\d\\.]+ \\w+)(?: ([+-]) )?");
        Matcher matcher = splitPattern.matcher(expressionLine);
        while(matcher.find()) {
            int count = matcher.groupCount();
            if(count >= 1) {
                expression.lengths.add(Length.createLength(matcher.group(1)));
            }
            if(count >= 2) {
                String operator = matcher.group(2);
                if(operator != null) {
                    expression.operators.add(operator);
                }
            }
            expressionLine = expressionLine.replace(matcher.group(0), "");
            matcher = splitPattern.matcher(expressionLine);
        }
        return expression;
    }

    public List<Length> getLengths() {
        return lengths;
    }

    public List<String> getOperators() {
        return operators;
    }

    /**
     * Execute expression.
     *
     * @return result length.
     */
    public Length execute() {
        Length result = null;
        for(int i = 0; i < lengths.size(); i++) {
            if(i == lengths.size() - 1) {
                result = lengths.get(i).toMeter();
            } else {
                result = executeOne(operators.get(i), lengths.get(i), lengths.get(i + 1));
                lengths.set(i + 1, result);
            }
        }
        return result;
    }

    private Length executeOne(String operator, Length one, Length two) {
        Length result;
        if("+".equals(operator)) {
            result = one.plus(two);
        } else {
            result = one.minus(two);
        }
        return result;
    }

}
