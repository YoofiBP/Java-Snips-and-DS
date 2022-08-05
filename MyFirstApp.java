import java.util.ArrayList;

public class MyFirstApp {
    public static void main(String[] args) {
        int age = 45;
        System.out.println("Hello world");
        System.out.println("Second line");
        System.out.println("I am " + String.valueOf(age));
        Integer myValue = Integer.valueOf(1);
        int text = myValue.intValue();
        int[] intList = { 1, 2, 3, 4 };
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        Duck d1 = new Duck();
        Duck d2 = new Duck();
        System.out.println(Duck.duckCount);
    }
}

class Duck {
    static int duckCount = 0;

    public Duck() {
        Duck.duckCount++;
        System.out.println(Duck.duckCount);
    }

    void checkInteger(Integer i) {
    }
}

class MyClass {
    public static final int VAL;

    static {
        VAL = 1;
    }
}