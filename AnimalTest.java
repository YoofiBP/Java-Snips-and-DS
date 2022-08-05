import java.util.ArrayList;
import java.util.List;

class AnimalTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>(List.of("Yoofi", "Naa", "Sarah", "Diego"));
        names.forEach(name -> System.out.println(name));
    }

    static <T extends Animal> List<T> takeAnimal(List<T> animals) {
        return animals;
    }
}

class Animal {

}

class Dog extends Animal {

}