package services;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;

import modeles.Musique;


public class Player
{
    private static Player instance = null;
    private static Musique currentMusique;
    private Media media;
    private static MediaPlayer mediaPlayer;
    private final ObjectProperty<Musique> enLecture = new SimpleObjectProperty<>();

    private Player(Button prec,Button pause,Button play,Button suiv, Slider volume, Slider progression, Musique selectedMusique)
    {
        instance = this;
        currentMusique = selectedMusique;
        lecture(selectedMusique, prec, pause, play, suiv, volume, progression);
    }

    public static Player getInstance(Button prec, Button pause, Button play, Button suiv, Slider volume, Slider progression, Musique selectedMusique)
    {
        if(instance == null) instance = new Player(prec, pause, play, suiv, volume, progression, selectedMusique);
        return instance;
    }

    public static boolean isInstance()
    {
        if(instance == null) return false;
        return true;
    }

    public static Musique getCurrentMusique()
    {
        return currentMusique;
    }

    private void lecture(Musique m, Button prec,Button pause,Button play,Button suiv, Slider volume, Slider progression)
    {
        File f= new File(m.getUrl());
        media = new Media(f.toURI().toString());
        System.out.println(m.getTitre());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.volumeProperty().bind(volume.valueProperty());

        mediaPlayer.setOnReady(new Runnable()
        {
            @Override
            public void run()
            {
                progression.setMin(0.0);
                progression.setValue(0.0);
                progression.setMax(media.getDuration().toMinutes());
            }
        });

        mediaPlayer.currentTimeProperty().addListener((observable,oldValue,newValue)->{
            if(newValue!=null)
            {
                progression.setValue(newValue.toMinutes());
            }
        });

        progression.setOnMouseClicked((event) ->{
            mediaPlayer.seek(Duration.minutes(progression.getValue()));
        });

        pause.setOnMouseClicked((event) -> {
            mediaPlayer.pause();
        });
    }

    public static void play(){mediaPlayer.play();}
    public static void pause(){mediaPlayer.pause();}
    public static void stop()
    {
        mediaPlayer.stop();
        instance = null;
        currentMusique = null;
    }


}
