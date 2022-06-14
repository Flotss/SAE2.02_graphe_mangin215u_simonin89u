package Main;

import java.io.File;
import java.io.IOException;

public class MainComparaisonMoyenne {
    public static void main(String[] args) throws IOException {
        // Faire une moyenne de temps de tout les graphes
        long moyenneTempsDjikstra = 0;
        long moyenneTempsBellman = 0;

        File folder = new File("graphes");
        int nombreDeGraphe = folder.listFiles().length;
        int i = 0;
        for (File file : folder.listFiles()) {
            GrapheListe graphe = new GrapheListe(file.getPath());
            long tempsStart = System.nanoTime();
            Dijkstra.resoudre(graphe, "A");
            long tempsEnd = System.nanoTime();
            moyenneTempsDjikstra += (tempsEnd - tempsStart);
            i++;
            System.out.println("Classe.Graphe " + i + "/" + nombreDeGraphe);
        }
        moyenneTempsDjikstra /= nombreDeGraphe;

        i = 0;
        for (File file : folder.listFiles()) {
            GrapheListe graphe = new GrapheListe(file.getPath());
            long tempsStart = System.nanoTime();
            BellmanFord.resoudre(graphe, "A");
            long tempsEnd = System.nanoTime();
            moyenneTempsBellman += (tempsEnd - tempsStart);
            i++;
            System.out.println("Classe.Graphe " + i + "/" + nombreDeGraphe);
        }
        moyenneTempsBellman /= nombreDeGraphe;

        System.out.println("Temps moyen de Classe.Dijkstra : " + moyenneTempsDjikstra);
        System.out.println("Temps moyen de Bellman : " + moyenneTempsBellman);

    }
}
