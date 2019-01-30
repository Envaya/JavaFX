package ch.fhnw.oop2.module04.countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class CountryTest {

	private Country       ch;
	private Country       de;
	private Country       fr;
	private Country       it;
	private Country       au;
	private List<Country> countries;

	@BeforeEach
	public void setUp()  {
		ch = new Country("Schweiz"        ,  41_285);
		de = new Country("Deutschland"    , 357_121.41);
		fr = new Country("Frankreich"     , 668_763.00);
		it = new Country("Italien"        , 301_338);
		au = new Country("\u00D6sterreich",  83_878.99);

		countries = new ArrayList<>();
		countries.add(fr);
		countries.add(de);
		countries.add(ch);
		countries.add(it);
		countries.add(au);
	}

    private Country getFirst() {
        return countries.get(0);
  	}

  	private Country getLast() {
  		return countries.get(countries.size() - 1);
  	}

	@Test
	public void testSortByAreaViaSeparateComparatorClass(){
		//when
		Collections.sort(countries, new InnerCountryByAreaComparator());

		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}
	public class InnerCountryByAreaComparator implements Comparator<Country> {

		@Override
		public int compare(Country o1, Country o2) {
			return (int) ((o1).getArea() - o2.getArea());
		}
	}


	@Test
	public void testSortByAreaViaInnerClass(){
		//when
		Collections.sort(countries, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				return (int) ((o1).getArea() - o2.getArea());
			}
		});

		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}


//	@Test
//	public void testSortByAreaViaAnonymousInnerClass(){
//		//when
//		Collections.sort(countries, ...);
//
//		//then
//		assertSame(ch, getFirst());
//		assertSame(fr, getLast());
//	}

//	@Test
//	public void testSortByNameViaInnerClass(){
//		//when
//		Collections.sort(countries, ...);
//
//		//then
//		assertSame(de, getFirst());
//		assertSame(au, getLast());
//	}


	@Test
	public void testSortByNameViaLambda(){
		//when
		Collections.sort(countries, (o1, o2) -> (o1.getName().compareTo(o2.getName())));


		//then
		assertSame(de, getFirst());
		assertSame(au, getLast());
	}


	@Test
	public void testSortByAreaViaLambda(){
		//when
		Collections.sort(countries, (o1, o2) -> (int) (o1.getArea() - o2.getArea()));

		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}


	@Test
	public void testSortByAreaViaSortMethod(){
		//when
		countries.sort(((o1, o2) -> (int) ((o1).getArea() - o2.getArea())));

		//then
		assertSame(ch, getFirst());
		assertSame(fr, getLast());
	}


	@Test
	public void testSortByNameViaMethodReference(){
		//when
		countries.sort(((o1, o2) -> (o1.getName().compareTo(o2.getName()))));

		// weiter kuerzen
		countries.sort(Comparator.comparing(country -> country.getName()));

		// noch weiter kuerzen
		countries.sort(Comparator.comparing(Country::getName));

		//then
		assertSame(de, getFirst());
		assertSame(au, getLast());
	}



//	@Test
//	public void testSortByAreaViaMethodReference(){
//		//when
//		countries.sort(...);
//
//		//then
//		assertSame(ch, getFirst());
//		assertSame(fr, getLast());
//	}



//	@Test
//	public void testSortReversedByAreaViaMethodReference(){
//		//when
//		countries.sort(...);
//
//		//then
//		assertSame(fr, getFirst());
//		assertSame(ch, getLast());
//	}


//	@Test
//	public void testSortReversedByNameViaMethodReference(){
//		//when
//		countries.sort(...);
//
//		//then
//		assertSame(au, getFirst());
//		assertSame(de, getLast());
//	}


//	@Test
//	public void testRemoveCountriesSmallerThan100_000(){
//		//when
//		countries.removeIf(...);
//
//		//then
//		assertSame(3, countries.size());
//
//		assertTrue(countries.contains(de));
//		assertTrue(countries.contains(fr));
//		assertTrue(countries.contains(it));
//	}



}
