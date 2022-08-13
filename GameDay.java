import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.nio.file.*;

public class GameDay {
    public static void main(String[] args) {
        Weapon[] weapons = { new Weapon("Sword") };
        GameCharacter character1 = new GameCharacter(20, "Elf", weapons);
        saveToFile(List.of(character1));
        unpackFromFile();
        writeFile();
    }

    static void saveToFile(List<GameCharacter> characters) {
        try {
            FileOutputStream fileStream = new FileOutputStream("My Game.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            for (GameCharacter character : characters) {
                os.writeObject(character);
            }
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void unpackFromFile() {
        try {
            FileInputStream fileStream = new FileInputStream("My Game.ser");
            ObjectInputStream is = new ObjectInputStream(fileStream);
            GameCharacter character = (GameCharacter) is.readObject();
            System.out.println(character);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeFile() {
        try {
            File myFile = new File("yoofi.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
            writer.write("Hello world");
            writer.close();
        } catch (Exception e) {

        }
    }

    static void writeToFileNIO() throws IOException {
        Path path = Paths.get("MySecondFile.txt");
        BufferedWriter writer = Files.newBufferedWriter(path);
    }

    static void readFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class GameCharacter implements Serializable {
    // private static final long serialVersionUID = -5240390822536088610L;
    transient private int power;
    private String type;
    private Weapon[] weapons;
    // private String change;

    public GameCharacter(int power, String type, Weapon[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    Weapon getWeapon(String name) {
        return weapons[0];
    }

    void useWeapon() {
    }

    void increasePower(int power) {
        this.power += power;
    }

}

class Weapon implements Serializable {
    private String name;

    public Weapon(String name) {
        this.name = name;
    }
}