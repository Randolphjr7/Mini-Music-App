import javax.sound.midi.*;

public class MiniMusicCmdLine {

    void playCmdLine(int instrument, int note) {

        try {

            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track  = seq.createTrack();

            MidiEvent event = null;

            ShortMessage blue = new ShortMessage();
            blue.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(blue, 1);
            track.add(changeInstrument);

            ShortMessage yellow = new ShortMessage();
            yellow.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(yellow, 1);
            track.add(noteOn);

            ShortMessage green = new ShortMessage();
            green.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(green, 16);
            track.add(noteOff);
            player.setSequence(seq);
            player.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }   // close play

    public static void main(String[] args) {

        MiniMusicCmdLine mini = new MiniMusicCmdLine();

        /* Run this file in terminal: You can use these
        *       java MiniMusicCmdLine 102 30
        *       java MiniMusicCmdLine 80 20
        *       java MiniMusicCmdLine 40 70
        *  */

        if(args.length < 2) {
            System.out.println("Don't forget the instrument and note args");
        } else {
            int instrument = Integer.parseInt(args[0]);
            int note       = Integer.parseInt(args[1]);
            mini.playCmdLine(instrument, note);
        }
    }
}
