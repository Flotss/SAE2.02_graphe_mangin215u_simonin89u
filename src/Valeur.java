import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

/**
 * Classe fournie, permet de stocker des valeurs associées au noeud et des parents
 * - un noeud est represente par un String (son nom)
 * - on accede avec des get (getValeur et getParent)
 * - on modifie avec des set (setValeur et setParent)
 */
public class Valeur {

    /**
     * attributs pour stocker les informations (type Table = Dictionnaire)
     * dans le programme de 2 annee.
     */
    Map<String, Double> valeur;
    Map<String, String> parent;

    /**
     * constructeur vide (initialise la possibilité de stocker des valeurs)
     */
    public Valeur() {
        this.valeur = new TreeMap<>();
        this.parent = new TreeMap<>();
    }

    /**
     * constructeur qui prend en parametre un objet de type Valeur
     * pour copier les valeurs et les parents
     * @param a un objet de type Valeur
     */
    public Valeur(Valeur a){
        this.valeur = new TreeMap<>();
        this.parent = new TreeMap<>();
        for(String s : a.valeur.keySet()){
            this.valeur.put(s, a.valeur.get(s));
            this.parent.put(s, a.parent.get(s));
        }
    }

    /**
     * renvoie la list des noeuds du chemin allant vers un noeud
     * @param destination le noeud d'arrivee
     * @return la liste des noeuds du chemin
     */
    public List<String> calculerChemin(String destination){
        List<String> chemin = new ArrayList<>();
        String s = destination;
        while(s != null){
            chemin.add(s);
            s = this.parent.get(s);
        }
        // reverse chemin
        for (int i = 0; i < chemin.size() / 2; i++) {
            String tmp = chemin.get(i);
            chemin.set(i, chemin.get(chemin.size() - i - 1));
            chemin.set(chemin.size() - i - 1, tmp);
        }
        return chemin;
    }

    /**
     * permet d'associer une valeur a un nom de noeud (ici L(X))
     *
     * @param nom    le nom du noeud
     * @param valeur la valeur associée
     */
    public void setValeur(String nom, double valeur) {
        // modifie valeur
        this.valeur.put(nom, valeur);
    }

    /**
     * * permet d'associer un parent a un nom de noeud (ici parent(X))
     *
     * @param nom    nom du noeud
     * @param parent nom du noeud parent associe
     */
    public void setParent(String nom, String parent) {
        this.parent.put(nom, parent);
    }

    /**
     * accede au parent stocke associe au noeud nom passe en parametre
     *
     * @param nom nom du noeud
     * @return le nom du noeud parent
     */
    public String getParent(String nom) {
        return this.parent.get(nom);
    }


    /**
     * accede a la valeur associee au noeud nom passe en parametre
     *
     * @param nom nom du noeud
     * @return la valeur stockee
     */
    public double getValeur(String nom) {
        return this.valeur.get(nom);
    }

    /**
     * retourne une chaine qui affiche le contenu
     * - par noeud stocke
     * - a chaque noeud, affiche la valeur puis le noeud parent
     *
     * @return descriptif du noeud
     */
    public String toString() {
        String res = "";
        // pour chaque noeud
        for (String s : this.valeur.keySet()) {
            // ajoute la valeur et le noeud parent
            Double valeurNoeud = valeur.get(s);
            String noeudParent = parent.get(s);
            res += s + " ->  V:" + valeurNoeud + " p:" + noeudParent + "\n";
        }
        return res;

    }

    /**
     * Retourne si deux valeurs sont égales
     * @param val valeur a comparer
     * @return si oui ou non les valeurs sont eagles
     */
    public boolean equals(Valeur val){
        return this.valeur.values().stream().allMatch(v -> val.valeur.values().contains(v));
    }

}
