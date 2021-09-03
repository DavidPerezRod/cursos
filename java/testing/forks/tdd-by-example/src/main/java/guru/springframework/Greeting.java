package guru.springframework;

public class Greeting {
    private static final String HELLO = "Hello";
    private static final String WORLD = "World";

    public static String helloWorld(){
        System.out.println("prueba 1");
        return HELLO + " " + WORLD;
    }

    public static String helloWorld(String name){
        return HELLO + " " + name;
    }
}
