package org.example.demo1.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import org.example.demo1.Audio.Synth;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.util.*;

public class MainController {

    @FXML
    public TextArea textArea;
    Synth synth = new Synth();
    @FXML
    private Label welcomeText;

    private ArrayList<ArrayList<String>> soundMatrix = new ArrayList<ArrayList<String>>();


    public void getNewRow(KeyEvent keyEvent) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {

        soundMatrix.clear();
        ObservableList<CharSequence> paragraphs = textArea.getParagraphs();
        for (CharSequence paragraph : paragraphs){
            ArrayList<String> row = new ArrayList<>();
            String line = paragraph.toString();
            if (!line.trim().isEmpty()){
                String[] words = line.split("\\s+");
                row.addAll(Arrays.asList(words));
            }soundMatrix.add(row);
        }
        System.out.println(soundMatrix);
        synth.PlaySound(soundMatrix);
    }


    public void checkMatrix(ActionEvent actionEvent) {
        System.out.println("mtrx: " + soundMatrix);
    }
}



