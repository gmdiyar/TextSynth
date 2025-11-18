package org.example.demo1.Audio;

import javax.sound.midi.*;
import java.util.*;

public class Synth {

    public void PlaySound(ArrayList<ArrayList<String>> matrix, int multiplier) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {

        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();

        Sequence sequence = new Sequence(Sequence.PPQ, 4);
        int channel = 1;



        for (ArrayList<String> row : matrix){
            Track track = sequence.createTrack();
            track.add(makeEvent(192, channel, 88, 0, 0));

            int tick = 0;
            for (String word : row){
                int note = word.length() * multiplier;
                track.add(makeEvent(144, channel, note, 100, tick));
                track.add(makeEvent(128, channel, note, 0, tick + 3));
                tick += 4;
            }
            channel++;
        }
        sequencer.setSequence(sequence);
        sequencer.setTempoInBPM(144);
        sequencer.start();
    }

    public MidiEvent makeEvent(int command, int channel, int note, int velocity, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(command, channel, note, velocity);
            event = new MidiEvent(message, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

}
