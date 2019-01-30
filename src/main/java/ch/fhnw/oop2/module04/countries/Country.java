package ch.fhnw.oop2.module04.countries;

import java.util.Locale;

/**
 * @author Dieter Holz
 */
public class Country {
    public static final Locale CH = new Locale("de", "CH");

    private final String name;
    private final double area;

    public Country(String name, double area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return String.format(CH, "%s (%,.2f km\u00B2)", name, area);
    }
}