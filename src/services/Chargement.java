package services;

import modeles.Album;

import java.io.*;
import java.util.List;

public class Chargement
{
    public static void chargementFichierSauvegarde(String cheminFichierSauvegarde) throws IOException, NullPointerException, ClassNotFoundException
    {
        String ligne;
        System.out.println("Lecture dans le fichier de sauvegarde :");
        try (ObjectInputStream lire = new ObjectInputStream(new FileInputStream(cheminFichierSauvegarde)))
        {
            ligne = (String) lire.readObject();
        }
        System.out.println(ligne);
    }

    public static Album chargementAlbum(String cheminSource) throws IOException, NullPointerException
    {
        Album album = null;
        try (ObjectInputStream charger =new ObjectInputStream(new FileInputStream(cheminSource)))
        {
            try
            {
                album = (Album) charger.readObject();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        return album;
    }

    public static List<Album> chargementListeAlbum(String cheminSource) throws IOException, NullPointerException
    {
        List<Album> listeAlbum = null;
        try (ObjectInputStream charger =new ObjectInputStream(new FileInputStream(cheminSource)))
        {
            try
            {
                listeAlbum = (List<Album>) charger.readObject();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        return listeAlbum;
    }
}
