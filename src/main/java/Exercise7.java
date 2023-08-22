
import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // TODO: Print all values from intNumbersFlux that's greater than 5
//        ReactiveSources.intNumbersFlux()
//                .log()                 // location of log is important try switching with below. log is dependent on what flux it has applied on.
//                .filter(e -> e > 5)
//                //.log()
//                .subscribe(System.out::println);
        // TODO: Print 10 multiplied by each value from intNumbersFlux that's greater than 5
//        ReactiveSources.intNumbersFlux()
//                .filter(e -> e > 5)
//                .map(e-> e*10)
//                .subscribe(System.out::println);


        //TODO: Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
//        ReactiveSources.intNumbersFlux()
//                .filter(e -> e > 5)
//                .map(e-> e * 10)
//                .take(3)
//                .subscribe(System.out::println);

        // TODO: Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
//        ReactiveSources.intNumbersFlux()
//                .filter(e -> e > 20)
//                .defaultIfEmpty(-1)
//                .subscribe(System.out::println)
//                ;

        // TODO: Switch ints from intNumbersFlux to the right user from userFlux
//        ReactiveSources.intNumbersFlux()
//                .flatMap(i -> ReactiveSources.userFlux().filter(u -> u.id() == i))
//                .subscribe(System.out::println);
        // TODO: Print only distinct numbers from intNumbersFluxWithRepeat
//        ReactiveSources.intNumbersFluxWithRepeat()
//                .log()
//                .distinct()  // remove duplicates
//                .subscribe(System.out::println);

        // ToDo: Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        ReactiveSources.intNumbersFluxWithRepeat()
                .log()
                .distinctUntilChanged()
//                .distinct()  // remove duplicates
                .subscribe(System.out::println);


        System.out.println("Press a key to end");
        System.in.read();
    }

}