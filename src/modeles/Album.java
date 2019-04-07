/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.tika.metadata.Metadata;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eloir
 */

public class Album implements Serializable
{
    String nom;
    int annee;
    List<Musique> pistes;
    Artiste artiste;
    String genre;
    int numeroPiste;

    public Album(String nom, Artiste artiste,int annee)
    {
        setNom(nom);
        setArtiste(artiste);
        setAnnee(annee);
        setPistesVide();
    }

    public Album(String nom, Artiste artiste, int annee, String genre, int numeroPiste)
    {
        setNom(nom);
        setArtiste(artiste);
        setAnnee(annee);
        setGenre(genre);
        setNumeroPiste(numeroPiste);
        setPistesVide();
    }

    public Artiste getArtiste(){return this.artiste;}
    public List<Musique> getPistes(){return this.pistes;}
    public int getAnnee(){return this.annee;}
    public String getNom(){return this.nom;}
    public String getGenre(){return this.genre;}
    public int getNumeroPiste(){return numeroPiste;}


    private void setAnnee(int annee){this.annee = annee;}
    private void setNom(String nom){this.nom = nom;}
    public void setAllPistes(ArrayList<Musique> allpistes){this.pistes = allpistes;}
    private void setArtiste(Artiste artiste){this.artiste = artiste;}
    private void setPistesVide(){this.pistes = FXCollections.observableArrayList();}
    private void setGenre(String genre){this.genre = genre;}
    private void setNumeroPiste(int numeroPiste){this.numeroPiste = numeroPiste;}

    public String afficher()
    {
        String desc = "Nom: "+getNom()+"\nArtiste: "+getArtiste()+"\nPistes:\n  ";
        for (Musique m : getPistes())
        {
            desc = desc+m+"\n  ";
        }
        desc = desc+"\n";
        return desc;
    }

    public void ajouterPiste(Musique musique){pistes.add(musique);}
    public void supprimerPiste(Musique musique){pistes.remove(musique);}

    @Override
    public String toString()
    {
        return getNom();
    }

    public static List<Album> getAlbum(Map<String, Metadata> metaDataMap)
    {
        List<Album> listeAlbums = new ArrayList<>();
        Metadata metadata;
        Album album = null;
        String nom = null;
        Artiste artiste;
        int annee = 0;
        List<Musique> pistes = new ArrayList<>();
        String genre;
        int numeroPiste = 0;

        for(String key: metaDataMap.keySet())
        {
            metadata = metaDataMap.get(key);
            if(metadata.get("xmpDM:duration") != null)
            {
                if(nom != null || nom != metadata.get("xmpDM:album"))
                {
                    listeAlbums.add(album);
                    pistes = new ArrayList<>();
                    nom = metadata.get("xmpDM:album");
                    artiste = new Artiste(metadata.get("xmpDM:artist"));
                    try{annee = Integer.parseInt(metadata.get("xmpDM:releaseDate"));}
                    catch(NumberFormatException e){System.out.println("Erreur annee pour " + metadata.get("title") + " : valeur: " + metadata.get("xmpDM:releaseDate"));}
                    genre = metadata.get("xmpDM:genre");
                    try{numeroPiste = Integer.parseInt(metadata.get("xmpDM:trackNumber"));}
                    catch(NumberFormatException e2){System.out.println(metadata.get("Erreur annee pour " + metadata.get("title") + " : valeur: " + "xmpDM:trackNumber"));}

                    album = new Album(nom, artiste, annee, genre, numeroPiste);
                }

                try{pistes.add(new Musique(metadata.get("title"), Float.parseFloat(metadata.get("xmpDM:duration")) , key));}
                catch(NumberFormatException e2){System.out.println("Erreur annee pour " + metadata.get("title") + " : valeur: " + metadata.get("xmpDM:duration"));}
            }
        }
        return listeAlbums;
    }

    public static void letMeSee(List<Album> listeAlbums)
    {
        for(Album album : listeAlbums)
        {
            if(album != null){System.out.println(album.afficher());}
        }
    }
}
