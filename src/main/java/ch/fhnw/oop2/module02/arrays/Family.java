package ch.fhnw.oop2.module02.arrays;

import ch.fhnw.oop2.module01.Person;

/**
 * @author Dieter Holz
 */
public class Family {
	private Person[] members;

	public Family(int initialSize){
		members = new Person[initialSize];
	}

	public int size(){
		int count = 0;
		for(Person m : members){
			if(m != null){
				count++;
			}
		}
		return count;
	}

	public void add(Person person){
		for (int i = 0; i < members.length; i++) {
			if(members[i] == null){
				members[i] = person;
				return;
			}
		}
	}

	public Person getOldest(){
		Person oldest = members[0];
		for(Person p : members){
			if(p != null && p.getAge() > oldest.getAge()){
				oldest = p;
			}
		}
		return oldest;
	}

	public boolean isMember(Person person) {
		for(Person m : members){
			if(m != null && m.equals(person)){
				return true;
			}
		}

		return false;
	}
}
