package ch.fhnw.oop2.module03.trashcan;

/**
 * @author Dieter Holz
 */
public class TrashCan {

    private Object[] allTheWaste;

    public void trash(Object object){
    }

    public Object getLast(){
        return null;
    }

    public Object[] purge(){
        return null;
    }

    public static void main(String[] args) {
        TrashCan trashCan = new TrashCan();

        Banana banana = new Banana();

        trashCan.trash(banana);

        Object o = trashCan.getLast();
        if(o instanceof Banana){
            banana = (Banana) o;
        }

    }

    static class Banana {

    }
}
