import java.util.ArrayList;
import java.util.List;

/**
 * La classe GraphListe permet de representer les donnees associees a un graphe
 */
public class GrapheListe implements Graphe{

    /**
     * Attribut : liste des noms des noeuds du graphe
     */
    private List<String> ensNom;

    /**
     * Attribut : liste des noeuds du graphe
     */
    private List<Noeud> ensNoeuds;

    /**
     * Constructeur de la classe GraphListe
     */
    public GrapheListe(){
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();
    }

    /**
     * Ajoute un arc au graphe
     * @param depart le nom du noeud de depart
     * @param destination le nom du noeud d'arrivee
     * @param cout le cout de l'arc
     */
    public void ajouterArc(String depart, String destination, double cout){
        if (!this.ensNom.contains(depart)){
            this.ensNom.add(depart);
            this.ensNoeuds.add(new Noeud(depart));
        }
        if (!this.ensNom.contains(destination)){
            this.ensNom.add(destination);
            this.ensNoeuds.add(new Noeud(destination));
        }
        this.ensNoeuds.get(this.ensNom.indexOf(depart)).ajouterArc(destination, cout);
    }

    /**
     * Renvoie la liste des noeuds du graphe
     * @return la liste des noeuds
     */
    public List<String> listeNoeuds(){
        return this.ensNom;
    }

    /**
     * Renvoie la liste des arcs partant d'un noeud
     * @param n Nom du noeud
     * @return la liste des arcs partant du noeud
     */
    public List<Arc> suivants(String n){
        return this.ensNoeuds.get(this.ensNom.indexOf(n)).getAdj();
    }

}
