import org.junit.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static javax.management.Query.times;

public class Exercise8Error {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // TODO: Print values from intNumbersFluxWithException and print a message when error happens
//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(e -> System.out.println("on Error :"+e.getMessage())) // it doesn't swallow the error,
//                // it is used to do some actions on error like analytics etc. + it will pass the error to subscribe
//                .subscribe(System.out::println,
//                        err -> System.out.println("Error occurred")
//                );

        // TODO: Print values from intNumbersFluxWithException and continue on errors
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((e,item) -> System.out.println("on Error, but will continue:"+e.getMessage())) //Error is ignored here
//                .subscribe(System.out::println,
//                        err -> System.out.println("Error occurred")
//                );

        // TODO: Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorResume(e -> Flux.just(-1, -2))
//                .subscribe(System.out::println,
//                        err -> System.out.println("Error occurred")
//                );

        Flux.interval(Duration.ofMillis(100))
                    .doOnCancel(() -> System.out.println("Flux Canceled"))
                    .doFinally(signalType -> {
                        if (signalType== SignalType.ON_COMPLETE)
                            System.out.println("DONE!");
                        else if(signalType==SignalType.ON_ERROR)
                            System.out.println("ON ERROR!");
                        else if (signalType == SignalType.CANCEL) {
                            System.out.println("Flux Completed due to Cancellation");

                    }});

        System.out.println("Press a key to end");
        System.in.read();
    }


}