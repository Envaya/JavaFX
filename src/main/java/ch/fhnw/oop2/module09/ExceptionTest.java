package ch.fhnw.oop2.module09;

/**
 * @author Dieter Holz
 */
public class ExceptionTest {
    public static void main(String[] args) {

        String test = "ja";

        try {
            System.out.println("Anfang try-block");

            ExceptionTest exceptionTest = new ExceptionTest();
            exceptionTest.doSomethingRisky(test);

            System.out.println("Ende try-block");
        } catch (Exception ex) {
            System.out.println("Exception gecatched");
        } finally {
            System.out.println("finally");

        }
        System.out.println("Ende von main");
    }

    private void doSomethingRisky(String test) throws Exception {
        System.out.println("Anfang riskante Methode");
        if ("ja".equals(test)) {
            throw new Exception("'ja' kann nicht korrekt behandelt werden also wird eine Exception geworfen");
        }
        System.out.println("Ende riskante Methode");
    }

}
