package ch.fhnw.oop2.module04.countries;

import java.util.Comparator;

public class CountryByAreaComparator implements Comparator<Country> {

    @Override
    public int compare(Country o1, Country o2) {
        return (int) ((o1).getArea() - o2.getArea());
    }
}
