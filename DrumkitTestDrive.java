class DrumKitTestDrive {
    public static void main(String[] args) {
        Drumkit d = new Drumkit();

        if (d.snare == true) {
            d.playSnare();
        }
        d.snare = false;

        d.playTopHat();
    }
}

class Drumkit {
    boolean topHat = true;
    boolean snare = true;
    int g = 17;
    int y = g;

    void playTopHat() {
        System.out.println("ding ding da-ding");
    }

    void playSnare() {
        System.out.println("bang bang ba-bang");
    }
}
