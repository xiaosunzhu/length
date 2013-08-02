package yijun.sun.length;


import org.junit.Test;
import yijun.sun.length.bean.Length;

import static junit.framework.Assert.assertEquals;


/**
 * @author SunYiJun
 */
public class TestAnyLengthToMeter {

    @Test
    public void test_float_127_93_feet_to_meter() {
        Length length = Length.createLength("127.93 feet");
        assertEquals(127.93f * AllTest.FOOT_LENGTH, length.toMeter().getWeight());
    }

}
