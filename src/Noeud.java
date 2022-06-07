import java.util.ArrayList;
import java.util.List;

/**
 * classe Noeud qui represente un noeud du graphe
 */
public class Noeud {

    /**
     * attributs de la classe Noeud
     * nom qui représente le nom du noeud
     * une liste d arc qui represente les arcs qui partent du noeud vers ses successeurs
     */
    private String nom;
    private List<Arc> adj;

    /**
     * constructeur de la classe Noeud
     * qui initialise le nom du Noeud et une liste d arc vide
     * @param nom le nom du Noeud
     */
    public Noeud(String nom){
        this.nom = nom;
        this.adj = new ArrayList<>();
    }

    /**
     * methode qui retourne si le Noeud en parametre est le meme que le Noeud courant
     * @param o le Noeud a comparer
     * @return si oui ou non le nom est le meme
     */
    public boolean equals(Object o){
        return this.nom.equals(((Noeud)o).nom);
    }

    /**
     * methode ajouterArc qui permet d ajouter un arc au Noeud dans la liste d Arc
     * @param destination la destination de l Arc
     * @param cout le cout de l Arc
     */
    public void ajouterArc(String destination, double cout){
        this.adj.add(new Arc(destination, cout));
    }

    /**
     * methode qui retourne les arcs partant du Noeud
     * @return la liste d Arc
     */
    public List<Arc> getAdj(){
        return this.adj;
    }

}
