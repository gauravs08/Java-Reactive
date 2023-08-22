import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;

public class Exercise10ZipWith {
    public static void main(String[] args) throws IOException {

        Exercise10ZipWith c1 = new Exercise10ZipWith();

        c1.getProcessOneResult()
                .zipWith(c1.getProcessTwoResult())
                .map(value -> value.getT1() + " " + value.getT2())
                .subscribe(System.out::println);
        System.out.println("Press a key to end");
        System.in.read();
    }

    public Mono<String> getProcessOneResult() {
        return Mono.just("Hello").delayElement(Duration.ofSeconds(5));
    }


    public Mono<String> getProcessTwoResult() {
        return Mono.just("Word").delayElement(Duration.ofSeconds(5));
    }
}
