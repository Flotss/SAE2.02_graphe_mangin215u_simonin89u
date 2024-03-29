package Main;

import Classe.BellmanFord;
import Classe.GrapheListe;
import Classe.Valeur;

import java.io.IOException;

/**
 * class Principale du projet
 */
public class Main {
    public static void main(String[] args) throws IOException {

        // PARTIE 1
        // Creation d'un graphe pour representer la figure 1 du sujet
        GrapheListe figure1 = new GrapheListe();

        // Ajout des arcs du graphe 1
        figure1.ajouterArc("A", "B", 12);
        figure1.ajouterArc("C", "A", 19);
        figure1.ajouterArc("A", "D", 87);
        figure1.ajouterArc("E", "D", 43);
        figure1.ajouterArc("D", "B", 23);
        figure1.ajouterArc("D", "C", 10);
        figure1.ajouterArc("B", "E", 11);

        // Affichage du graphe 1
        System.out.println(figure1);

        // PARTIE 2
        // Creation du graphe avec un fichier
        GrapheListe figure2 = new GrapheListe("graphes/graphe_exemple1.txt");

        // Resultat du point fixe
        Valeur res = BellmanFord.resoudre(figure2, "A");
        System.out.println(res);

        // resultat du chemin du point fixe
        System.out.println(res.calculerChemin("C"));

        // affichages graphes genere numero 1
        GrapheListe figure3 = new GrapheListe("graphesGenere/graphe4");
        System.out.println(figure3);
        System.out.println(figure3.toGraphviz());
    }
}
