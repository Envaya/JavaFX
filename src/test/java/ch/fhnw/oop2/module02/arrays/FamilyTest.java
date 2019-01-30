package ch.fhnw.oop2.module02.arrays;

import ch.fhnw.oop2.module02.arrays.Family;
import org.junit.jupiter.api.Test;

import ch.fhnw.oop2.module01.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Dieter Holz
 */
class FamilyTest {

	@Test
	void testInitialSize(){
		//given
		Family family = new Family(2);

		//when
		int size = family.size();

		//then
		assertEquals(0, size);
	}

	@Test
	void testSize(){
		//given
		Family family = new Family(2);
		Person person = new Person(30, 50, 1.70);
		family.add(person);

		//when
		int size = family.size();

		//then
		assertEquals(1, size);
	}

	@Test
	void testAdd() {
		//given
		Family family = new Family(2);
		Person person = new Person(30, 50, 1.70);

		//when
		family.add(person);

		//then
		assertTrue(family.isMember(person));
		assertFalse(family.isMember(new Person(35, 45, 1.60)));
	}

	@Test
	void testGetOldest() {
		//given
		Family family = new Family(2);
		Person personA = new Person(30, 50, 1.70);
		Person personB = new Person(35, 45, 1.60);
		family.add(personA);
		family.add(personB);

		//when
		Person oldest = family.getOldest();

		//then
		assertSame(personB, oldest);
	}

//	@Test
//	public void testFamilyGrows(){
//		//given
//		Family family = new Family(2);
//		Person personA = new Person(30, 50, 1.70);
//		Person personB = new Person(35, 45, 1.60);
//
//		family.add(personA);
//
//		//when
//		family.add(personB);
//
//		//then
//		assertTrue(family.isMember(personA));
//        assertTrue(family.isMember(personB));
//	}
}