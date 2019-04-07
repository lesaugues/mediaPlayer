/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import java.io.Serializable;

/**
 *
 * @author eloir
 */
public class Musique implements Serializable
{
    private String titre;
    private float duree;
    private String url;

    public Musique(String titre, float duree , String url)
    {
        setTitre(titre);
        setDuree(duree);
        setUrl(url);
    }

    private void setTitre(String titre){this.titre = titre;}
    private void setDuree(float duree){this.duree = duree;}
    private void setUrl(String url){this.url = url;}

    public String getTitre(){return this.titre;}
    public float getDuree(){return this.duree;}
    public String getUrl(){return this.url;}

    @Override
    public String toString(){return getTitre();}
}