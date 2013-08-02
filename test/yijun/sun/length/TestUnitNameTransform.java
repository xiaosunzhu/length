package yijun.sun.length;


import org.junit.Test;
import yijun.sun.length.bean.Unit;

import static junit.framework.Assert.assertEquals;


/**
 * @author SunYiJun
 */
public class TestUnitNameTransform {

    @Test
    public void test_get_miles_unit_is_mile_unit() {
        Unit unit = InputRepos.getUnit("miles");
        assertEquals(InputRepos.getUnit("mile"), unit);
    }

    @Test
    public void test_get_inches_unit_is_mile_inch() {
        Unit unit = InputRepos.getUnit("inches");
        assertEquals(InputRepos.getUnit("inch"), unit);
    }

    @Test
    public void test_get_feet_unit_is_mile_foot() {
        Unit unit = InputRepos.getUnit("feet");
        assertEquals(InputRepos.getUnit("foot"), unit);
    }

}
