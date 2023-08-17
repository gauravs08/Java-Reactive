import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFlux().subscribe(
//                item -> System.out.println(item),
//                err -> System.out.println(err.getMessage()),
//                () -> System.out.println("Complete!!!")
//        );

        ReactiveSources.intNumberMono().subscribe(
                item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete!!!")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // This gives you more control on rate of receiving and processing request
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>()
        );

        System.out.println("Press a key to end");
        System.in.read();
    }

}

 class MySubscriber<T> extends BaseSubscriber<T>{

     @Override
     protected void hookOnSubscribe(Subscription subscription) {
         System.out.println("Subscribe happened.");
        // super.hookOnSubscribe(subscription);
         request(1);   // this means it can handle n number of elements. (back presser control) if request(n) is commented then it wont work.
     }

     @Override
     protected void hookOnNext(T value) {
         System.out.println(value.toString()+" received");
        //super.hookOnNext(value);
         request(1);  // this means after completion it is requesting 1 more element.(back presser control)
     }
 }