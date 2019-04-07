package controleur;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import modeles.Album;
import modeles.Musique;
import org.apache.tika.metadata.Metadata;
import services.AudioParser;
import services.FileParser;
import services.Player;
import test.TestMusique;
import test.TestParser;

public class Controleur implements Initializable
{
    @FXML
    public void gestionM (ActionEvent event) throws Exception
    {
        BorderPane root2  = FXMLLoader.load(this.getClass().getClassLoader().getResource("ressources/ajouterMusique.fxml"));
        root2.getStylesheets().add(getClass().getResource("/ressources/style2.css").toExternalForm());
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root2,600,400));
        stage1.setTitle("Ajouter une musique");
        stage1.show();
    }

    @FXML
    ListView<Album> listeViewL;
    @FXML
    ListView<Musique> listeViewM;

    public List<Album> listeAlbums = TestMusique.getMediatheque();
    public ObservableList<Album> observableListALbum = FXCollections.observableArrayList((ArrayList)listeAlbums);
    private ListProperty<Album> listPropertyAlbum = new SimpleListProperty<>(observableListALbum);
    public static Musique selectedMusique;

    @FXML
    public void initialize(URL location, ResourceBundle ressources)
    {
        Map<String, List<String>> folderFilesMAp = FileParser.getFoldersFilesMap("src/musiques");
        Map<String, Metadata> musicDataMap = AudioParser.getMusicDataMap(folderFilesMAp);

        listeViewL.itemsProperty().bind(listPropertyAlbum);


        listeViewL.getSelectionModel().selectedItemProperty().addListener((observable,oldV,newV)->
        {
            List<Musique> listeMusiques = newV.getPistes();
            ObservableList<Musique> observableListMusiques = FXCollections.observableArrayList((ArrayList)listeMusiques);
            ListProperty<Musique> listPropertyMusiques = new SimpleListProperty<>(observableListMusiques);
            listeViewM.itemsProperty().bind(listPropertyMusiques);
        });

//        for (Album a: listeAlbums)
//        {
//            System.out.println(a.afficher());
//        }

        listeViewM.getSelectionModel().selectedItemProperty().addListener((observable,oldV,newV)->
        {
            selectedMusique = listeViewM.getSelectionModel().selectedItemProperty().getValue();
            System.out.println(selectedMusique);
        });

//        for (Album a: listeAlbums)
//        {
//            System.out.println(a.afficher());
//        }
    }

    @FXML
    private Button prec;
    @FXML
    private Button pause;
    @FXML
    private Button play;
    @FXML
    private Button suiv;
    @FXML
    private Slider volume;
    @FXML
    private Slider progression;

    @FXML
    public void play (ActionEvent event)
    {
        try
        {
            if(Player.isInstance())
            {
                if(Player.getCurrentMusique() != selectedMusique)
                {
                    Player.stop();
                    Player player = Player.getInstance(prec, pause, play, suiv, volume, progression, selectedMusique);
                }
                else
                {
                    Player.play();
                }
            }
            else
            {
                Player player = Player.getInstance(prec, pause, play, suiv, volume, progression, selectedMusique);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void stop (ActionEvent event)
    {
        try {
            if (Player.isInstance())
            {
                Player.stop();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
