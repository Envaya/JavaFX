package ch.fhnw.oop2.module02.list;

import ch.fhnw.oop2.module01.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dieter Holz
 */
public class Family {
    private List<Person> members = new ArrayList<>();
    // list ist das interface, ArrayList ist eine Implementierung von List
    // empfehlung: immer das gemeinsame interface verwendung, da man z.B. auf LinkedList wechseln könnte
    public int size() {
        return members.size();
    }

    public void add(Person person) {
        if (!isMember(person)) {
            members.add(person);
        }
    }

    public boolean isMember(Person person) {
        return members.contains(person);
    }

    public Person getOldest() {
        Person oldest = members.get(0);
        for(Person p: members) {
            if (p.getAge() > oldest.getAge()) {
                oldest = p;
            }
        }
        return oldest;
    }
}
