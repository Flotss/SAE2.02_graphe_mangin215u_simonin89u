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
     * test le constructeur sans parametre de la classe GrapheListe
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
        assertEquals("B", figure1.suivants("A").get(0).getDest(), "le noeud B doit etre le suivant de A");
        assertEquals("D", figure1.suivants("A").get(1).getDest(), "le noeud D doit etre le suivant de A");
        assertEquals("E", figure1.suivants("B").get(0).getDest(), "le noeud E doit etre le suivant de B");
        assertEquals("A", figure1.suivants("C").get(0).getDest(), "le noeud A doit etre le suivant de C");
        assertEquals("B", figure1.suivants("D").get(0).getDest(), "le noeud B doit etre le suivant de D");
        assertEquals("C", figure1.suivants("D").get(1).getDest(), "le noeud C doit etre le suivant de D");
        assertEquals("D", figure1.suivants("E").get(0).getDest(), "le noeud D doit etre le suivant de E");
        assertEquals(12 , figure1.suivants("A").get(0).getCout(), "le cout de l'arc doit etre 12");
        assertEquals(87 , figure1.suivants("A").get(1).getCout(), "le cout de l'arc doit etre 87");
        assertEquals(11 , figure1.suivants("B").get(0).getCout(), "le cout de l'arc doit etre 11");
        assertEquals(19 , figure1.suivants("C").get(0).getCout(), "le cout de l'arc doit etre 19");
        assertEquals(23 , figure1.suivants("D").get(0).getCout(), "le cout de l'arc doit etre 23");
        assertEquals(10 , figure1.suivants("D").get(1).getCout(), "le cout de l'arc doit etre 10");
        assertEquals(43 , figure1.suivants("E").get(0).getCout(), "le cout de l'arc doit etre 43");
    }


}
