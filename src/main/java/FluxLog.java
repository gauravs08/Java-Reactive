import java.io.IOException;
import java.util.List;

public class FluxLog {
    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        List<Integer> list = ReactiveSources
                .intNumbersFlux()
                .log()
                .toStream().toList();
        System.out.println("List is :" + list);
        System.out.println("Size is :" + list.size());

        //below lines are not required as above operation is blocking and list object need to be filled by flux stream
        //System.out.println("Press a key to end");
        //System.in.read();
    }
}
