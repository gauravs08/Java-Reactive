public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("-----1-----");
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("-----2-----");
        StreamSources.intNumbersStream()
                .filter(e -> e < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("-----3-----");
        StreamSources.intNumbersStream()
                .filter(e -> e > 5)
                .skip(1)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("-----4-----");
        Integer integer = StreamSources.intNumbersStream()
                .filter(e -> e > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(integer);

        // Print first names of all users in userStream
        System.out.println("-----5-----");
        StreamSources.userStream()
                .forEach(e -> System.out.println(e.firstName()));

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("-----6-----");
        StreamSources.intNumbersStream()
                //.map(id -> StreamSources.userStream().filter(u -> u.id() == id)) //this will return stream of user
                .flatMap(id -> StreamSources.userStream().filter(u -> u.id() == id)) //this will return User NOT stream of user
                .forEach(e -> System.out.println(e.firstName()));

        //OR a better approach
        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(i -> i == u.id())) //this will return User NOT stream of user
                .forEach(System.out::println);

    }

}