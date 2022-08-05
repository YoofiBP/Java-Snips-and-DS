import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class SimpleStartupGame {

    public static void main(String[] args) {
    }
}

class StartupBust {
    GameHelper helper = new GameHelper();
    ArrayList<Startup> startups = new ArrayList<Startup>();
    private int numberOfGuesses = 0;

    void setUpGame() {
        startups.add(new Startup("Uber"));
        startups.add(new Startup("HelloFresh"));
        startups.add(new Startup("mPharma"));
        for (Startup startup : startups) {
            startup.setLocation(helper.placeStartUp(startup));
        }
    }

    void startPlaying() {
        while (!this.startups.isEmpty()) {
            String input = helper.getUserInput();
            this.checkUserGuess(input);
        }
    }

    void checkUserGuess(String guess) {
        String result = "miss";
        this.numberOfGuesses++;
        for (Startup startup : startups) {
            result = startup.checkYourself(guess);
            if (result.equals("kill")) {
                startups.remove(startup);
            }
        }
        System.out.println(result);
    }

    void finishGame() {

    }
}

class SimpleStartUp {
    private int numberOfHits = 0;
    private int numberOfGuesses = 0;
    private ArrayList<String> locationCells;

    void runGame() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Startup> startups = new ArrayList<Startup>();

        while (this.numberOfHits < 3) {
            System.out.println("Enter a guess: ");
            String guess = scanner.nextLine();
            String decision = this.checkYourself(guess);
            System.out.println(decision);
            if (decision.equals("hit")) {

            }
            this.numberOfGuesses++;
        }
        scanner.close();
        System.out.println("You took " + this.numberOfGuesses + " guesses");
    }

    String checkYourself(String guess) {
        String decision = "miss";
        for (String cell : this.locationCells) {
            if (guess == cell) {
                this.numberOfHits++;
                decision = "hit";
                this.locationCells.remove(cell);
                break;
            }
        }
        if (this.locationCells.isEmpty()) {
            decision = "kill";
        }

        return decision;
    }

    void setLocationCells(String[] locationCells) {
        this.locationCells.addAll(Arrays.asList(locationCells));
    }
}

class Startup {
    private String name;
    private String location;

    public Startup(String name) {
        this.name = name;
    }

    void setLocation(String location) {
        this.location = location;
    }

    String getLocation() {
        return this.location;
    }

    String checkYourself(String location) {
        return "miss";
    }
}

class GameHelper {
    String placeStartUp(Startup startup) {
        return "";
    }

    String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String guess = scanner.nextLine();
        scanner.close();
        return guess;
    }
}