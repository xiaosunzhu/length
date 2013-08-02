package yijun.sun.length.bean;


/**
 * Length unit define.
 *
 * @author SunYiJun
 */
public class Unit {

    /**
     * Base unit define. Meter.
     */
    public static final Unit METER_UNIT = new Unit("m", 1);

    private String name;

    /**
     * Like: 1 mile = 1609.344 m, toMeters=1609.344
     */
    private float toMeters;

    public Unit(String name, float toMeters) {
        this.name = name;
        this.toMeters = toMeters;
    }

    /**
     * Create an unit from a string.
     *
     * @param unitDescription unit description string,like:1 mile = 1609.344 m
     * @return New unit.
     */
    public static Unit createUnit(String unitDescription) {
        String[] words = unitDescription.split(" ");
        int selfNum = Integer.parseInt(words[0]);
        float meterNum = Float.parseFloat(words[3]);
        String name = words[1];
        return new Unit(name, meterNum / selfNum);
    }

    public String getName() {
        return name;
    }

    public float getToMeters() {
        return toMeters;
    }

}
