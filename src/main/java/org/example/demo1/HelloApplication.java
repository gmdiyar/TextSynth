package org.example.demo1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.example.demo1.Audio.Synth;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, MidiUnavailableException, InvalidMidiDataException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WritingPad.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        stage.setTitle("AudioType");
        stage.setScene(scene);
        stage.show();



    }
}
