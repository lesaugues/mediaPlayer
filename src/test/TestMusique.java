package test;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import modeles.Album;
import modeles.Artiste;
import modeles.Musique;

import javax.print.attribute.standard.Media;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eloir
 */
public class TestMusique
{
    private final ObjectProperty<Musique> mesMusiques = new SimpleObjectProperty<>(new Musique("Ties That Bind",3.19f,null));
    public final Musique getMusique(){return mesMusiques.get();}
    public final void setMusique(Musique value) {mesMusiques.set(value);}
    public ObjectProperty<Musique> mesMusiquesProperty() {return mesMusiques;}


    public static List<Album> getMediatheque()
    {
        List<Album> Mediatheque = new ArrayList<>();

        Artiste mammoth_mammoth = new Artiste("Mammoth Mammoth");
        Artiste grand_magus = new Artiste("Grand Magus");


        Album mount_the_mountain = new Album("Mount The Mountain", mammoth_mammoth, 2017);
        List<Musique> mount_the_mountain_musiques = new ArrayList<Musique>()
        {
            {
                add(new Musique("Mount the Mountain", 6.27f,"src/musiques/mammoth_mammoth-Mount_the_Mountain/01-Mount-the-Mountain.mp3"));
                add(new Musique("Sellbound", 3.34f,"src/musiques/mammoth_mammoth-Mount_the_Mountain/02-Spellbound.mp3"));
                add(new Musique("Hole in the Head", 4.29f,"src/musiques/mammoth_mammoth-Mount_the_Mountain/03-Hole-in-the-Head.mp3"));
                add(new Musique("Kickin'My Dog", 3.55f,"src/musiques/mammoth_mammoth-Mount_the_Mountain/04-Kickin´My-Dog.mp3"));
                add(new Musique("Procrastination", 3.36f,"src/musiques/mammoth_mammoth-Mount_the_Mountain/05-Procrastination.mp3"));
                add(new Musique("Sleepwalker", 3.33f,"src/musiques/mammoth_mammoth-Mount_the_Mountain/06-Sleepwalker.mp3"));
                add(new Musique("Epitome", 3.22f,"src/musiques/mammoth_mammoth-Mount_the_Mountain/07-Epitome.mp3"));
                add(new Musique("Hard Way Down", 3.26f,"src/musiques/mammoth_mammoth-Mount_the_Mountain/08-Hard-Way-Down.mp3"));
                add(new Musique("Wild and Dead", 4.22f,"src/musiques/mammoth_mammoth-Mount_the_Mountain/09-Wild-and-Dead.mp3"));
                add(new Musique("Cold Liquor", 3.31f,"src/musiques/mammoth_mammoth-Mount_the_Mountain/10-Cold-Liquor.mp3"));
                add(new Musique("Can't Get You Out of ...Head", 4.04f,"src/musiques/mammoth_mammoth-Mount_the_Mountain/11-Can´t-Get-You-Out-of-My-Head.mp3"));
            }
        };
        mount_the_mountain.setAllPistes((ArrayList)mount_the_mountain_musiques);
//        System.out.println(mount_the_mountain);


        Album sword_song = new Album("Sword Song", grand_magus, 2016);
        List<Musique> sword_song_musiques = new ArrayList<Musique>()
        {
            {
                add(new Musique("Freja's Choice", 4.00f,"src/musiques/grand_magus-sword-songs/01-Freja's-Choice.mp3"));
                add(new Musique("Varangian", 3.41f,"src/musiques/grand_magus-sword-songs/02-Varangian.mp3"));
                add(new Musique("Forged In Iron", 5.38f,"src/musiques/grand_magus-sword-songs/03-Forged-In-Iron-Crowned-In-Steel.mp3"));
                add(new Musique("Born FOr Battle", 3.41f,"src/musiques/grand_magus-sword-songs/04-Born-For-Battle-(Black-Dog-Of-Brocéliande).mp3"));
                add(new Musique("Master Of The Land", 3.51f,"src/musiques/grand_magus-sword-songs/05-Master-Of-The-Land.mp3"));
                add(new Musique("Last One To Fall", 4.00f,"src/musiques/grand_magus-sword-songs/06-Last-One-To-Fall.mp3"));
                add(new Musique("Frost And Fire", 3.16f,"src/musiques/grand_magus-sword-songs/07-Frost-And-Fire.mp3"));
                add(new Musique("Hurg", 2.07f,"src/musiques/grand_magus-sword-songs/08-Hugr.mp3"));
                add(new Musique("Every Day There's a Battle to Fight", 4.30f,"src/musiques/grand_magus-sword-songs/09-Everyday-There's-A-Battle-To-Fight.mp3"));
                add(new Musique("In for the Kill", 3.35f,"src/musiques/grand_magus-sword-songs/10-In-For-The-Kill-(Bonus-Track).mp3"));
                add(new Musique("Stormbringer", 5.04f,"src/musiques/grand_magus-sword-songs/11-Stormbringer-(DEEP-PURPLE-cover)-(Bonus-Track).mp3"));
            }
        };
        sword_song.setAllPistes((ArrayList)sword_song_musiques);
//        System.out.println(sword_song);

        Mediatheque.add(getAlbum());
        Mediatheque.add(mount_the_mountain);
        Mediatheque.add(sword_song);
        return Mediatheque;
    }

    public static Album getAlbum()
    {
        Artiste alter_bridge = new Artiste("Alter Bridge");
        Album blackbird = new Album("Blackbird", alter_bridge, 2007);

        List<Musique> blackbird_musiques = new ArrayList<Musique>()
        {
            {
                add(new Musique("Ties That Bind", 3.19f,"src/musiques/alter_bridge-blackbird/01-Ties-That-Bind.mp3"));
                add(new Musique("Come To Life", 3.51f,"src/musiques/alter_bridge-blackbird/02-Come-To-Life.mp3"));
                add(new Musique("Brand New Start", 4.56f,"src/musiques/alter_bridge-blackbird/03-Brand-New-Start.mp3"));
                add(new Musique("Buried Alive", 4.33f,"src/musiques/alter_bridge-blackbird/04-Buried-Alive.mp3"));
                add(new Musique("Coming Home", 4.22f,"src/musiques/alter_bridge-blackbird/05-Coming-Home.mp3"));
                add(new Musique("Before Tomorrow Comes", 4.5f,"src/musiques/alter_bridge-blackbird/06-Before-Tomorrow-Comes.mp3"));
                add(new Musique("Rise Today", 4.21f,"src/musiques/alter_bridge-blackbird/07-Rise-Today.mp3"));
                add(new Musique("Blackbird", 8.1f,"src/musiques/alter_bridge-blackbird/08-Blackbird.mp3"));
                add(new Musique("One By One", 4.17f,"src/musiques/alter_bridge-blackbird/09-One-By-One.mp3"));
                add(new Musique("Watch Over You", 4.16f,"src/musiques/alter_bridge-blackbird/10-Watch-Over-You.mp3"));
                add(new Musique("Break Me Down", 3.57f,"src/musiques/alter_bridge-blackbird/11-Break-Me-Down.mp3"));
                add(new Musique("White Knuckles", 4.25f,"src/musiques/alter_bridge-blackbird/12-White-Knuckles.mp3"));
                add(new Musique("Wayward One", 4.48f,"src/musiques/alter_bridge-blackbird/13-Wayward-One.mp3"));
                add(new Musique("The Damage Done", 3.47f,"src/musiques/alter_bridge-blackbird/14-The-Damage-Done.mp3"));
            }
        };

        blackbird.setAllPistes((ArrayList)blackbird_musiques);
        return blackbird;
    }
}
