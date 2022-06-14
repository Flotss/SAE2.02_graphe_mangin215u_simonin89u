package Classe;

import java.util.List;

/**
 * Cette classe permet de manipuler un graphe
 */
public interface Graphe {
    /**
     * Renvoie la liste des noeuds du graphe
     * @return la liste de noeuds
     */
    public List<String> listeNoeuds();

    /**
     * Renvoie la liste des arcs partant d'un noeud
     * @param n Nom du noeud
     * @return la liste des arcs partant du noeud
     */
    public List<Arc> suivants(String n);
}