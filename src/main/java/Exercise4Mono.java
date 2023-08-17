
import java.io.IOException;
import java.util.Optional;

/**
 * MONO 0 or 1
 * FLUX 0 or n
 **/
public class Exercise4Mono {

    public static void main(String[] args) throws IOException {


        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        //ReactiveSources.intNumbersFlux().subscribe(System.out::println);
        ReactiveSources.intNumberMono()
                .subscribe(
                        System.out::println,                         //on item
                        err -> System.out.println(err.getMessage()), //on error
                        () -> System.out.println("Complete SUCCESS"));        //on complete

        // Get the value from the Mono into an integer variable
        var i = ReactiveSources.intNumberMono().block();
        System.out.println(i);

        Optional<Integer> opt = ReactiveSources.intNumberMono().blockOptional(); // can be null
        System.out.println(opt);


        System.out.println("Press a key to end");
        System.in.read();
    }

}