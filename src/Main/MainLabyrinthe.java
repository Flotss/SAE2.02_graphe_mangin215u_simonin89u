package Main;

import Classe.BellmanFord;
import Classe.GrapheListe;
import Classe.Valeur;
import laby.Labyrinthe;
import java.io.IOException;
import java.util.List;

public class MainLabyrinthe {
    public static void main(String[] args) throws IOException {
        // Création du labyrinthe
        Labyrinthe lab = new Labyrinthe("labySimple/laby1.txt");

        // Génération du graphe
        GrapheListe g = lab.genererGraphe();

        // Affichage du graphe et de son Graphviz
        System.out.println(g);
        System.out.println(g.toGraphviz());

        // Résolution du graphe BellmanFord
        // Affichage du résultat
        Valeur v = BellmanFord.resoudre(g, "\"1,1\"");
        System.out.println(v);

        // Calcul du chemin pour aller vers 8,1
        List<String> chemin = v.calculerChemin("\"8,1\"");
        System.out.println(chemin);
    }
}
