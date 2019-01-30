package ch.fhnw.oop2.module03.trashcan;

/**
 * @author Dieter Holz
 */
public class RecyclingBin<T> {
    private T[] allTheWaste;

    public void trash(T object){
    }

    public T getLast(){
        return null;
    }

    public T[] purge(){
        return null;
    }

    public static void main(String[] args) {
        RecyclingBin<Banana> recyclingBin = new RecyclingBin<>();

        Banana banana = new Banana();

        recyclingBin.trash(banana);

        banana = recyclingBin.getLast();

    }

    static class Banana {

    }
}
