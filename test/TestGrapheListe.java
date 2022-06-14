import Classe.BellmanFord;
import Classe.Dijkstra;
import Classe.GrapheListe;
import Classe.Valeur;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * classe de test
 */
public class TestGrapheListe {

    /**
     * test le constructeur sans parametre de la classe Classe.GrapheListe
     * avec la figure1 du sujet
     */
    @Test
    public void testFigure1InitialisationALaMain(){
        // initialisation du graphe
        GrapheListe figure1 = new GrapheListe();
        // ajout des arcs dans le graphe
        figure1.ajouterArc("A", "B", 12);
        figure1.ajouterArc("C", "A", 19);
        figure1.ajouterArc("A", "D", 87);
        figure1.ajouterArc("E", "D", 43);
        figure1.ajouterArc("D", "B", 23);
        figure1.ajouterArc("D", "C", 10);
        figure1.ajouterArc("B", "E", 11);
        // verifications
        assertEquals(figure1.listeNoeuds().size(), 5, "il devrait y avoir 5 noeuds");
        assertEquals(figure1.suivants("A").get(0).getDest(), "B");
        assertEquals(figure1.suivants("A").get(0).getCout(), 12);
        assertEquals(figure1.suivants("A").get(1).getDest(), "D");
        assertEquals(figure1.suivants("A").get(1).getCout(), 87);
        assertEquals(figure1.suivants("B").get(0).getDest(), "E");
        assertEquals(figure1.suivants("B").get(0).getCout(), 11);
        assertEquals(figure1.suivants("C").get(0).getDest(), "A");
        assertEquals(figure1.suivants("C").get(0).getCout(), 19);
        assertEquals(figure1.suivants("D").get(0).getDest(), "B");
        assertEquals(figure1.suivants("D").get(0).getCout(), 23);
        assertEquals(figure1.suivants("D").get(1).getDest(), "C");
        assertEquals(figure1.suivants("D").get(1).getCout(), 10);
        assertEquals(figure1.suivants("E").get(0).getDest(), "D");
        assertEquals(figure1.suivants("E").get(0).getCout(), 43);
    }

    /**
     * test la methode du point fixe sur le graphe
     * avec la figure1 du sujet
     */
    @Test
    public void testMethodeDuPointFixe() throws IOException {
        // initialisation du graphe
        GrapheListe figure2 = new GrapheListe("graphes/graphe_exemple1.txt");
        Valeur res = BellmanFord.resoudre(figure2, "A");
        // verifications
        assertEquals(0, res.valeur.get("A"), "La distance vers A devrait etre 0");
        assertEquals(12, res.valeur.get("B"), "La distance vers B devrait etre 12");
        assertEquals(76, res.valeur.get("C"), "La distance vers C devrait etre 76");
        assertEquals(66, res.valeur.get("D"), "La distance vers D devrait etre 66");
        assertEquals(23, res.valeur.get("E"), "La distance vers E devrait etre 23");
    }

    /**
     * test la methode du point fixe sur le graphe
     * @throws IOException
     */
    @Test
    public void testMethodeDuPointFixe2() throws IOException {
        // initialisation du graphe
        GrapheListe figure2 = new GrapheListe("graphes/graphe_exemple1.txt");
        Valeur res = BellmanFord.resoudre(figure2, "E");
        // verifications
        assertEquals(72, res.valeur.get("A"), "La distance vers A devrait etre 0");
        assertEquals(66, res.valeur.get("B"), "La distance vers B devrait etre 12");
        assertEquals(53, res.valeur.get("C"), "La distance vers C devrait etre 76");
        assertEquals(43, res.valeur.get("D"), "La distance vers D devrait etre 66");
        assertEquals(0, res.valeur.get("E"), "La distance vers E devrait etre 23");
    }

    /**
     * test la methode de Dijkstra sur le graphe
     * @throws IOException
     */
    @Test
    public void testMethodeDijkstra() throws IOException {
        // initialisation du graphe
        GrapheListe figure2 = new GrapheListe("graphes/graphe_exemple1.txt");
        Valeur res = Dijkstra.resoudre(figure2, "A");
        // verifications
        assertEquals(0, res.valeur.get("A"), "La distance vers A devrait etre 0");
        assertEquals(12, res.valeur.get("B"), "La distance vers B devrait etre 12");
        assertEquals(76, res.valeur.get("C"), "La distance vers C devrait etre 76");
        assertEquals(66, res.valeur.get("D"), "La distance vers D devrait etre 66");
        assertEquals(23, res.valeur.get("E"), "La distance vers E devrait etre 23");
    }

}
