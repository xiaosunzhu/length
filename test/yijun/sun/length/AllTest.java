package yijun.sun.length;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * @author SunYiJun
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        { TestParseInput.class, TestAnyLengthToMeter.class, TestUnitNameTransform.class,
                TestExpressionExecute.class })
public class AllTest {

    public static final float FOOT_LENGTH = 0.03048f;
    public static final float INCH_LENGTH = 0.00254f;
    public static final float FATH_LENGTH = 1.8288f;
    public static final float FURLONG_LENGTH = 201.17f;
}
