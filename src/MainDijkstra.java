import java.io.IOException;
import java.util.Scanner;

public class MainDijkstra {
    public static void main(String[] args) throws IOException {
        // lecture des graphes `a partir de fichiers texte
        GrapheListe graphe = new GrapheListe("graphes/graphe_exemple1.txt");

        // affichage du graphe
        System.out.println(graphe);

        // lecture du noeud de depart
        Scanner sc = new Scanner(System.in);
        System.out.println("Indiquez un noeud de depart : ");
        String depart = sc.nextLine();
        // calcul des chemins les plus courts depuis le noeud de depart
        Valeur res = Dijkstra.resoudre(graphe, depart);
        // affichage des chemins les plus courts
        System.out.println(res);

        // lecture du noeud d'arrivee
        System.out.println("Indiquez un noeud d'arrivee : ");
        String arrivee = sc.nextLine();
        // affichage des chemins
        System.out.println(res.calculerChemin(arrivee));


    }
}
