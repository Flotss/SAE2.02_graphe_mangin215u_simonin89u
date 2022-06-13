//Entrees :
//        G un graphe oriente avec une ponderation (poids) positive des arcs
//        A un sommet (depart) de G
//        Debut
//        Q <- {} // utilisation d’une liste de noeuds a traiter
//        Pour chaque sommet v de G faire
//          v.distance <- Infini
//          v.parent <- Indefini
//          Q <- Q U {v} // ajouter le sommet v `a la liste Q
//        Fin Pour
//        A.distance <- 0
//        Tant que Q est un ensemble non vide faire
//        u <- un sommet de Q telle que u.distance est minimale
//        Q <- Q \ {u} // enlever le sommet u de la liste Q
//        Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
//        D <- u.distance + poids(u,v)
//        Si D < v.distance
//        Alors v.distance <- D
//        v.parent <- u
//        Fin Si
//        Fin Pour
//        Fin Tant que
//        Fin

import java.util.ArrayList;
import java.util.List;

/**
 * classe Dijkstra qui permet de calculer le plus court chemin entre deux sommets
 * avec la methode de Dijkstra
 */
public class Dijkstra {
    /**
     * methode qui calcule le plus court chemin entre tous les sommets
     * @param g le graphe
     * @param depart le sommet de depart
     * @return un objet Valeur qui contient les plus courts chemins et leur cout entre chaque sommet
     */
    public static Valeur resoudre(Graphe g, String depart) {
        // initialisation de la liste de noeud qu il reste a traiter
        List<Noeud> Q = new ArrayList<>();
        // initialisation de l'objet Valeur
        Valeur val = new Valeur();

        // initialisation toutes les valeurs a +l infini et leur parent a null et on les ajoute a la liste de noeud qu il reste a traiter
        for (String v : g.listeNoeuds()) {
            val.setValeur(v, Double.MAX_VALUE);
            val.setParent(v, null);
            Q.add(new Noeud(v));
        }
        // on initialise la valeur du noeud de depart a 0
        val.setValeur(depart, 0);

        int indice = 0;
        // tant que la liste de noeud qu il reste a traiter n'est pas vide on continue
        while (!Q.isEmpty()) {
            // on cherche la valeur la plus petite et on la retire de la liste de noeud qu il reste a traiter
            Noeud u = null;
            for (Noeud n : Q) {
                if (u == null || val.getValeur(n.getNom()) < val.getValeur(u.getNom())) {
                    u = n;
                }
            }
            Q.remove(u);

            // on parcourt tous les noeuds qu il reste a traiter
            for (Noeud v : Q) {
                // on parcourt tous les arcs successeur du noeud en cours
                List<Arc> arcs = g.suivants(u.getNom());
                for (Arc a : arcs) {
                    // on vérifie qu'il existe un arc entre le noeud en cours et le noeud à traiter
                    if (a.getDest().equalsIgnoreCase(v.getNom())) {
                        // on calcule la valeur du noeud a traiter
                        double D = val.getValeur(u.getNom()) + a.getCout();
                        // Si la valeur du noeud a traiter est plus petite que le noeud en cours
                        // Alors on met a jour la valeur du noeud en cours
                        if (D < val.getValeur(v.getNom())) {
                            val.setValeur(v.getNom(), D);
                            val.setParent(v.getNom(), u.getNom());
                        }
                    }
                }
            }
        }
        // retour des chemins les plus courts et de leur cout
        return val;
    }

}

