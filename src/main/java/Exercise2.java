import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        ReactiveSources.intNumbersFlux().subscribe(System.out::println);

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(System.out::println);

        // This is here to wait for elements to flow
        System.out.println("Press a key to end");
        System.in.read();
    }

}