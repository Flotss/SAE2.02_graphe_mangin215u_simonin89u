package Classe;

import java.util.ArrayList;
import java.util.List;

/**
 * classe Classe.Noeud qui represente un noeud du graphe
 */
public class Noeud {

    /**
     * attributs de la classe Classe.Noeud
     * nom qui représente le nom du noeud
     * une liste d arc qui represente les arcs qui partent du noeud vers ses successeurs
     */
    private String nom;
    private List<Arc> adj;

    /**
     * constructeur de la classe Classe.Noeud
     * qui initialise le nom du Classe.Noeud et une liste d arc vide
     * @param nom le nom du Classe.Noeud
     */
    public Noeud(String nom){
        this.nom = nom;
        this.adj = new ArrayList<>();
    }

    /**
     * methode qui retourne si le Classe.Noeud en parametre est le meme que le Classe.Noeud courant
     * @param o le Classe.Noeud a comparer
     * @return si oui ou non le nom est le meme
     */
    public boolean equals(Object o){
        return this.nom.equals(((Noeud)o).nom);
    }

    /**
     * methode ajouterArc qui permet d ajouter un arc au Classe.Noeud dans la liste d Classe.Arc
     * @param destination la destination de l Classe.Arc
     * @param cout le cout de l Classe.Arc
     */
    public void ajouterArc(String destination, double cout){
        this.adj.add(new Arc(destination, cout));
    }

    /**
     * methode qui retourne les arcs partant du Classe.Noeud
     * @return la liste d Classe.Arc
     */
    public List<Arc> getAdj(){
        return this.adj;
    }

    /**
     * methode qui retourne le nom du noeud
     * @return le nom du noeud
     */
    public String getNom() {
        return nom;
    }
}
