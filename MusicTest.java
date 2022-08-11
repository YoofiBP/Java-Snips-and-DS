import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicTest {

    public void play() {

        try {
            Sequencer sequencer = MidiSystem.getSequencer();

            System.out.println("Successfully got a sequencer");
        } catch (MidiUnavailableException e) {

        }
    }

    public static String getName(String name) throws Exception {
        if (name.length() < 3) {
            throw new Exception("wrong");
        }
        return name;
    }

    public static void main(String[] args) {
        MusicTest mt = new MusicTest();
        mt.play();
    }

}