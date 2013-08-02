package yijun.sun.length.bean;


import yijun.sun.length.InputRepos;


/**
 * One length information. Include unit and weight.
 *
 * @author SunYiJun
 */
public class Length {

    private Unit unit;

    private float weight;

    private Length(Unit unit, float weight) {
        this.unit = unit;
        this.weight = weight;
    }

    /**
     * Create one length from a string.
     *
     * @param block string like:1 mile
     * @return Length object
     */
    public static Length createLength(String block) {
        String[] words = block.split(" ");
        return new Length(InputRepos.getUnit(words[1]), Float.parseFloat(words[0]));
    }

    /**
     * Plus another length.
     *
     * @param len Another length to plus.
     * @return sum, unit is meter.
     */
    public Length plus(Length len) {
        Length newMeter = toMeter();
        newMeter.weight += len.toMeter().weight;
        return newMeter;
    }

    /**
     * Minus another length.
     *
     * @param len Another length to minus.
     * @return diff, unit is meter.
     */
    public Length minus(Length len) {
        Length newMeter = toMeter();
        newMeter.weight -= len.toMeter().weight;
        return newMeter;
    }

    /**
     * Get new length witch equals current one but use meter unit.
     *
     * @return new length use meter unit.
     */
    public Length toMeter() {
        return new Length(Unit.METER_UNIT, unit.getToMeters() * weight);
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        Length length = toMeter();
        return String.format("%.2f ", length.weight) + length.unit.getName();
    }

}
