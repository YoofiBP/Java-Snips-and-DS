public class Shapes {
    public static void main(String[] args) {
        Square square = new Square();
        square.rotate();
        Square square2 = square;
        square.setArea(12);
        System.out.println("" + square2.area);
        Amoeba amoeba = new Amoeba();
        amoeba.rotate();
    }
}

class Shape {
    int area = 1;

    void setArea(int area) {
        this.area = area;
    }

    public void rotate() {
        System.out.println("Rotating");
    }

    public void playSound() {
        System.out.println("Play Sound");
    }
}

class Square extends Shape {

}

class Amoeba extends Shape {
    public void rotate() {
        System.out.println("Amoeba rotate");
    }
}