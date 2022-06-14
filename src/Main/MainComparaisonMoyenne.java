package Main;

import Classe.BellmanFord;
import Classe.Dijkstra;
import Classe.GrapheListe;

import java.io.File;
import java.io.IOException;

/**
 * classe qui permet de comparer le moyenne de temps par graphe pour les deux methodes
 */
public class MainComparaisonMoyenne {
    public static void main(String[] args) throws IOException {
        // initialisation des moyennes
        long moyenneTempsDjikstra = 0;
        long moyenneTempsBellman = 0;

        // initialisation du dossier et du nombre de fichier
        File folder = new File("graphesGenere");
        int nombreDeGraphe = folder.listFiles().length;

        // on parcourt le dossier et on calcule le chemins minimal pour chaque graphe avecc la methode de Djikstra
        int i = 0;
        for (File file : folder.listFiles()) {
            GrapheListe graphe = new GrapheListe(file.getPath());
            long tempsStart = System.nanoTime();
            Dijkstra.resoudre(graphe, "1");
            long tempsEnd = System.nanoTime();
            moyenneTempsDjikstra += (tempsEnd - tempsStart);
            i++;
            System.out.println("Graphe " + i + "/" + nombreDeGraphe);
        }
        moyenneTempsDjikstra /= nombreDeGraphe;

        // on parcourt le dossier et on calcule le chemins minimal pour chaque graphe avecc la methode de BellmanFord
        i = 0;
        for (File file : folder.listFiles()) {
            GrapheListe graphe = new GrapheListe(file.getPath());
            long tempsStart = System.nanoTime();
            BellmanFord.resoudre(graphe, "1");
            long tempsEnd = System.nanoTime();
            moyenneTempsBellman += (tempsEnd - tempsStart);
            i++;
            System.out.println("Graphe " + i + "/" + nombreDeGraphe);
        }
        moyenneTempsBellman /= nombreDeGraphe;

        // on affiche les resultats
        System.out.println("Temps moyen de Dijkstra : " + moyenneTempsDjikstra);
        System.out.println("Temps moyen de Bellman : " + moyenneTempsBellman);

    }
}
