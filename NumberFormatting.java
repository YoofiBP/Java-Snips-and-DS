class NumberFormatting {
    public static void main(String[] args) {
        double myBillion = 1000000000;
        System.out.println(String.format("%,.2f", myBillion));
        Age.name.sayHello();
    }
}

class Name {
    public static final String NAME = "Yoofi";

    public void sayHello() {
        System.out.println("Hello world");
    }

}

class Age {
    public static final Name name = null;
}