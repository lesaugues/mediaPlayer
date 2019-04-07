package services;

import modeles.Album;

import java.io.*;
import java.util.List;

public class Sauvegarde
{
    public static void saisieEtSauvegardeDansFichier(String cheminFichierSauvegarde) throws IOException
    {
        InputStreamReader fluxEntree = new InputStreamReader(System.in);
        BufferedReader lecteur = new BufferedReader(fluxEntree);
        try(ObjectOutputStream transfert = new ObjectOutputStream(new FileOutputStream(cheminFichierSauvegarde)))
        {
            System.out.println("Saisir un truc au clavier :");
            String lu = lecteur.readLine();
            System.out.println("Vous avez écrit : " + lu);
            transfert.writeObject(lu);
            System.out.println("Sauvegarde effectuée.");
        }
    }

    public static void sauvegardeAlbum(String cheminCible, Album album) throws FileNotFoundException, IOException, NullPointerException
    {
        try (ObjectOutputStream sauver =new ObjectOutputStream(new FileOutputStream(cheminCible)))
        {
            sauver.writeObject(album);
        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
    }

    public static void sauvegardeListeAlbum(String cheminCible, List<Album> listeAlbum) throws FileNotFoundException, IOException, NullPointerException
    {
        try (ObjectOutputStream sauver =new ObjectOutputStream(new FileOutputStream(cheminCible)))
        {
            sauver.writeObject(listeAlbum);
        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
    }
}
