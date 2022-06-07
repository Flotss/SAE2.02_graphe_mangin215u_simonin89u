import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
