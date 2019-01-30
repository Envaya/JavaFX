package ch.fhnw.oop2.module02.list;

import org.junit.jupiter.api.Test;

import ch.fhnw.oop2.module01.Person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;


/**
 * @author Dieter Holz
 */
class FamilyTest {


    @Test
    void testInitialSize() {
        //given
        Family family = new Family();

        //when
        int size = family.size();

        //then
        assertEquals(0, size);
    }

    @Test
    void testSize() {
        //given
        Family family = new Family();
        Person person = new Person(30, 50, 1.70);
        family.add(person);

        //when
        int size = family.size();

        //then
        assertEquals(1, size);
    }

    @Test
    void testAdd() throws Exception {
        //given
        Family family = new Family();
        Person person = new Person(30, 50, 1.70);

        //when
        family.add(person);

        //then
        assertTrue(family.isMember(person));
        assertFalse(family.isMember(new Person(35, 45, 1.60)));
    }

    @Test
    void testFamilyGrows() {
        //given
        Family family  = new Family();
        Person personA = new Person(30, 50, 1.70);
        Person personB = new Person(35, 45, 1.60);

        family.add(personA);

        //when
        family.add(personB);

        //then
        assertTrue(family.isMember(personA));
        assertTrue(family.isMember(personB));
    }

    @Test
    void testAddPersonTwice() {
        //given
        Family family  = new Family();
        Person personA = new Person(30, 50, 1.70);
        family.add(personA);

        //when
        family.add(personA);

        //then
        assertEquals(1, family.size());
    }

    @Test
    void testGetOldest() {
        //given
        Family family  = new Family();
        Person personA = new Person(30, 50, 1.70);
        Person personB = new Person(35, 45, 1.60);
        family.add(personA);
        family.add(personB);

        //when
        Person oldest = family.getOldest();

        //then
        assertEquals(personB, oldest);
    }
}