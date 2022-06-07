/**
 * class Principale du projet
 */
public class Main {
    public static void main(String[] args) {

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

    }
}
