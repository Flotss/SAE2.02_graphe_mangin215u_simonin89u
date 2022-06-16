package Classe;

import laby.Labyrinthe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AdapterGrapheLabyrinthe implements Graphe {
    private final Labyrinthe laby;

    /**
     * Attribut : liste des noms des noeuds du graphe
     */
    private final List<String> ensNom;

    /**
     * Attribut : liste des noeuds du graphe
     */
    private final List<Noeud> ensNoeuds;

    public AdapterGrapheLabyrinthe(String chemin) throws IOException {
        this.laby = new Labyrinthe(chemin);
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();

        // on parcourt le tableau de murs
        for (int i = 0; i < laby.murs.length; i++) {
            for (int j = 0; j < laby.murs[i].length; j++) {
                // si il n y a pas de mur a la position actuelle on ajoute un arc
                if (!laby.murs[i][j]) {
                    ajouterArcs(this, laby, i, j);
                }
            }
        }
    }


    /**
     * methode qui permet d'ajouter les arcs dans le graphe
     *
     * @param g le graphe
     * @param x la position x
     * @param y la position y
     */
    public void ajouterArcs(AdapterGrapheLabyrinthe g, Labyrinthe laby, int x, int y) {
        // Ajout à tous les nœuds adjacents de l'emplacement actuel
        ajouterUnArc(g, laby, x, y, x + 1, y);
        ajouterUnArc(g, laby, x, y, x - 1, y);
        ajouterUnArc(g, laby, x, y, x, y + 1);
        ajouterUnArc(g, laby, x, y, x, y - 1);
    }

    /**
     * methode qui permet d'ajouter un arc dans le graphe
     *
     * @param g  le graphe
     * @param x  la position x
     * @param y  la position y
     * @param nx la position x de la destination
     * @param ny la position y de la destination
     */
    public void ajouterUnArc(AdapterGrapheLabyrinthe g, Labyrinthe laby, int x, int y, int nx, int ny) {
        try {
            // on verifie que la destination n'est pas un mur et on essaie d ajouter l arc
            if (!laby.murs[nx][(ny)]) {
                g.ajouterArc("\"" + x + "," + y + "\"", "\"" + nx + "," + ny + "\"", 1);
            }
        } catch (Exception ignored) {
        }
    }

    /**
     * Ajoute un arc au graphe
     *
     * @param depart      le nom du noeud de depart
     * @param destination le nom du noeud d'arrivee
     * @param valeur      le cout de l'arc
     */
    private void ajouterArc(String depart, String destination, int valeur) {
        if (!this.ensNom.contains(depart)) {
            this.ensNom.add(depart);
            this.ensNoeuds.add(new Noeud(depart));
        }
        if (!this.ensNom.contains(destination)) {
            this.ensNom.add(destination);
            this.ensNoeuds.add(new Noeud(destination));
        }
        this.ensNoeuds.get(this.ensNom.indexOf(depart)).ajouterArc(destination, valeur);
    }

    /**
     * Renvoie la liste des noeuds du graphe
     *
     * @return la liste de noeuds
     */
    @Override
    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    /**
     * Renvoie la liste des arcs partant d'un noeud
     *
     * @param n Nom du noeud
     * @return la liste des arcs partant du noeud
     */
    @Override
    public List<Arc> suivants(String n) {
        return this.ensNoeuds.get(this.ensNom.indexOf(n)).getAdj();
    }


    /**
     * Renvoie le format GraphViz du graphe
     *
     * @return Une chaine de caracteres representant le graphe en format GraphViz
     */
    @Override
    public String toGraphviz() {
        String res = "digraph {\n";
        for (String s : this.ensNom) {
            for (Arc a : this.suivants(s)) {
                res += s + " -> ";
                res += a.getDest() + " [label = " + (int) a.getCout() + "]\n";
            }
        }
        return res + "}";
    }


    /**
     * methode toString qui permet d afficher chaque noeud du graphe avec
     * ces arcs leur destination et leur cout
     *
     * @return le liste des noeuds et leurs arcs
     */
    public String toString() {
        String res = "";
        for (String s : this.ensNom) {
            res += s + " -> ";
            for (Arc a : this.suivants(s)) {
                res += a.getDest() + "(" + (int) a.getCout() + ") ";
            }
            res += "\n";
        }
        return res;
    }
}
