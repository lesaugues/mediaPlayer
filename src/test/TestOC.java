package test;

import java.io.IOException;
import java.util.List;

import modeles.Album;
import services.Chargement;
import services.Sauvegarde;

public class TestOC
{
    public static void testChargement() throws IOException, ClassNotFoundException
    {
        Chargement.chargementFichierSauvegarde("src/data/donnees.don");
    }

    public static void testSauvegarde() throws IOException, ClassNotFoundException
    {
        Sauvegarde.saisieEtSauvegardeDansFichier("src/data/donnees.don");
    }


    public static void testSauvegardeAlbum() throws IOException, ClassNotFoundException
    {
        Album album = TestMusique.getAlbum();
        System.out.println("Album créé:\n" + album);
        Sauvegarde.sauvegardeAlbum("src/data/albumSauvegarde.don",album);
        System.out.println("Album sauvegardé.");
    }

    public static void testChargementAlbum() throws IOException, ClassNotFoundException
    {
        System.out.println("Chargement de l'album sauvegardé:");
        Album album = Chargement.chargementAlbum("src/data/albumSauvegarde.don");
        System.out.println(album);
    }

    public static void testSauvegardeListeAlbum() throws IOException, ClassNotFoundException
    {
        List<Album> listeAlbum = TestMusique.getMediatheque();
        System.out.println("Liste d'albums créée:\n" + listeAlbum);
        Sauvegarde.sauvegardeListeAlbum("src/data/listeAlbumSauvegarde.don",listeAlbum);
        System.out.println("Liste albums sauvegardée.");
    }

    public static void testChargementListeAlbum() throws IOException, ClassNotFoundException
    {
        System.out.println("Chargement de la liste d'albums sauvegardée:");
        List<Album> listeAlbum = Chargement.chargementListeAlbum("src/data/listeAlbumSauvegarde.don");
        System.out.println(listeAlbum);
    }









    public static void test() throws IOException, ClassNotFoundException
    {
        testSauvegarde();
        testChargement();
    }

    public static void testAlbum() throws IOException, ClassNotFoundException
    {
        testSauvegardeAlbum();
        testChargementAlbum();
    }

    public static void testListeAlbum() throws IOException, ClassNotFoundException
    {
        testSauvegardeListeAlbum();
        testChargementListeAlbum();
    }

}
