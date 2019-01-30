package ch.fhnw.oop2.module13.undoredo.presentationmodels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Dieter Holz
 */
class EuropePMTest {
	private EuropePM sut;

	private CountryPM switzerland;
	private CountryPM germany;

	@BeforeEach
	void setup() {
		switzerland = new CountryPM(0, "Schweiz"    , 10.0);
		germany     = new CountryPM(1, "Deutschland", 20.0);

		sut = new EuropePM(switzerland, germany);
	}

	@Test
	void testUndo(){
		//given
		sut.setSelectedCountryId(0);
		switzerland.setName("abc");

		//when
//		sut.undo();

		//then
		assertEquals("Schweiz", switzerland.getName());
	}

	@Test
	void testMultipleUndo(){
		//given
		sut.setSelectedCountryId(0);
		switzerland.setName("abc");
		switzerland.setName("def");

		//when
//		sut.undo();
//		sut.undo();

		//then
		assertEquals("Schweiz", switzerland.getName());
	}

	@Test
	void testProxy() {
		//given

		//when
		sut.setSelectedCountryId(0);

		//then
		assertEquals(switzerland.getId()  , sut.getCountryProxy().getId());
		assertEquals(switzerland.getName(), sut.getCountryProxy().getName());
		assertEquals(switzerland.getArea(), sut.getCountryProxy().getArea());
	}

	@Test
	void testModificationViaProxy() {
		//given
		sut.setSelectedCountryId(0);
		String newName = "Switzerland";

		//when
		sut.getCountryProxy().setName(newName);

		//then
		assertEquals(newName, switzerland.getName());
	}

	@Test
	void testModificationViaCountry() {
		//given
		sut.setSelectedCountryId(0);
		String newName = "Switzerland";

		//when
		switzerland.setName(newName);

		//then
		assertEquals(newName, sut.getCountryProxy().getName());
	}

	@Test
	void testSelectionChange() {
		//given
		sut.setSelectedCountryId(0);

		//when
		sut.setSelectedCountryId(1);

		//then
		assertEquals(germany.getId()  , sut.getCountryProxy().getId());
		assertEquals(germany.getName(), sut.getCountryProxy().getName());
		assertEquals(germany.getArea(), sut.getCountryProxy().getArea());
	}

}