package ch.fhnw.oop2.module01;

/**
 * @author Dieter Holz
 */
public class Person {
    private int    age;
    private double weight;
    private double height;
    private Person[] allFriends = new Person[30];

    public Person(int age, double weight, double height) {
        this.age    = age;
        this.weight = weight;
        this.height = height;
    }

    public double getBMI() {
        return weight / (height * height);
    }

    //alle Getter und Setter

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getNumberOfFriends() {
        int counter = 0;
        for (int i=0; i<allFriends.length; i++){
            if (allFriends[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    public void addFriend(Person person) {
        if (!hasAsFriend(person)) {
            for (int i=0; i<allFriends.length; i++){
                if (allFriends[i] == null) {
                    allFriends[i] = person;
                }
                break;
            }
            person.addFriend(this);
        }
    }

    public boolean hasAsFriend(Person person) {
        for (int i=0; i<allFriends.length; i++){
            if (allFriends[i] != null && allFriends[i].equals(person)) {
                return true;
            }
        }
        return false;
    }
}
