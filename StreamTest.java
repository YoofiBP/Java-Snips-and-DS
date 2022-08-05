import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>(List.of("Yoofi", "Naa", "George", "John"));
        names.forEach(name -> {
            System.out.println("Lambdas are so cool!");
            System.out.println(name);
        });
        System.out.println(names);
        names = names.stream().limit(1).collect(Collectors.toUnmodifiableList());
        System.out.println(names);
    }

    static void takeSomething(Processor processor) {

    }

}

@FunctionalInterface
interface Processor {
    int accept(String name);
}