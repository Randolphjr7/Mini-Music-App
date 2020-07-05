import javax.sound.midi.*;

public class MiniMusicApp {

    void play() {

        try {
            // get a sequencer (CD player) & open it
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            // the musical piece (CD) sequencer will play
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            // ask the Sequence for a track. Track lives in the sequence
            // and the MIDI data lives in the track
            Track track = seq.createTrack();

            // put some MidiEvents into the track
            ShortMessage a = new ShortMessage(); // make a message
            a.setMessage(144, 9, 44,100); // put instructions in the message
            MidiEvent noteOn = new MidiEvent(a, 1); // make a MidiEvent using the message
            track.add(noteOn); // add MidiEvent to the Track; which holds all the MidiEvent objects

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 9, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 20);
            track.add(noteOff);
            // give the sequence to the sequencer (CD to CD player)
            player.setSequence(seq);
            // play
            player.start();

        } catch(Exception e) {
            e.printStackTrace();
        }
    } // close play

    public static void main(String[] args) {

        MiniMusicApp mini = new MiniMusicApp();
        mini.play();

    }

}
