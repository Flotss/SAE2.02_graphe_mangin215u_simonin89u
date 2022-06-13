import java.io.IOException;

public class MainDijkstra {
    public static void main(String[] args) throws IOException {
        // lecture des graphes `a partir de fichiers texte
        GrapheListe graphe = new GrapheListe("graphe_exemple1.txt");

        // affichage du graphe
        System.out.println(graphe);


    }
}
