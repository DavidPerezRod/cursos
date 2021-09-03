package guru.springframework;

import org.junit.jupiter.api.*;

class GreetingTest {

    private Greeting greeting;


    @BeforeAll
    public static void beforeClass(){
        System.out.println("Before Class - I am only called Once!!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("In Before Each Method ...");
        this.greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        System.out.println(this.greeting.helloWorld());
    }

    @Test
    void testHelloWorld() {
        System.out.println(this.greeting.helloWorld("John"));
    }

    @AfterEach
    void afterAll() {
        System.out.println("In After Each Method ...");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After Class - I am only called Once!!!");
    }
}