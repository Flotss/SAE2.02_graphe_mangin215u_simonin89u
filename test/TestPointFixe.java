import Classe.BellmanFord;
import Classe.GrapheListe;
import Classe.Valeur;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * classe de test
 */
public class TestPointFixe {

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
        assertEquals(0,  res.getValeur("A"), "La distance vers A devrait etre 0");
        assertEquals(12, res.getValeur("B"), "La distance vers B devrait etre 12");
        assertEquals(76, res.getValeur("C"), "La distance vers C devrait etre 76");
        assertEquals(66, res.getValeur("D"), "La distance vers D devrait etre 66");
        assertEquals(23, res.getValeur("E"), "La distance vers E devrait etre 23");
    }


    /**
     * test la methode du point fixe sur le graphe
     * @throws IOException en cas d'erreur de lecture du fichier
     */
    @Test
    public void testMethodeDuPointFixe2() throws IOException {
        // initialisation du graphe
        GrapheListe figure2 = new GrapheListe("graphes/graphe_exemple1.txt");
        Valeur res = BellmanFord.resoudre(figure2, "E");
        // verifications
        assertEquals(72, res.getValeur("A"), "La distance vers A devrait etre 0");
        assertEquals(66, res.getValeur("B"), "La distance vers B devrait etre 12");
        assertEquals(53, res.getValeur("C"), "La distance vers C devrait etre 76");
        assertEquals(43, res.getValeur("D"), "La distance vers D devrait etre 66");
        assertEquals(0,  res.getValeur("E"), "La distance vers E devrait etre 23");
    }



    /**
     * Test calculerCheminPointFixe
     * @throws IOException en cas d'erreur de lecture du fichier
     */
    @Test
    public void testCalculerCheminPointFixe() throws IOException {
        // initialisation du graphe
        GrapheListe figure2 = new GrapheListe("graphes/graphe_exemple1.txt");
        Valeur res = BellmanFord.resoudre(figure2, "E");
        // verifications
        ArrayList<String> resAttendu = new ArrayList<>();
        resAttendu.add("E");
        resAttendu.add("D");
        resAttendu.add("C");
        resAttendu.add("A");
        assertEquals(resAttendu, res.calculerChemin("A"), "Le chemin vers A devrait etre [E, D, C, A]");

        resAttendu.remove("A");
        resAttendu.remove("C");
        resAttendu.add("B");
        assertEquals(resAttendu, res.calculerChemin("B"), "Le chemin vers B devrait etre [E, D, C, B, A]");
    }

}
