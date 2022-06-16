import Classe.AdapterGrapheLabyrinthe;
import Classe.Arc;
import Classe.Graphe;
import laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdapterGrapheLabyrinthe {

    /**
     * Test du constructeur de AdapterGrapheLabyrinthe
     * @throws IOException Erreur lors de la lecture du fichier
     */
    @Test
    public void testAdaptaterConstruction() throws IOException {
        // initialisation du graphe
        Graphe g = new AdapterGrapheLabyrinthe("labySimple/laby1.txt");
        // verifications
        assertEquals(g.listeNoeuds().size(), 34, "il devrait y avoir 34 noeuds");
    }

    /**
     * Test que tous les noeuds sont corrects
     * @throws IOException Erreur lors de la lecture du fichier
     */
    @Test
    public void testNoeudCorrect() throws IOException {
        // initialisation du graphe
        Graphe g = new AdapterGrapheLabyrinthe("labySimple/laby0.txt");
        // verifications
        assertEquals(g.listeNoeuds().size(), 15, "il devrait y avoir 15 noeuds");

        // Verification de tous les noeuds
        for (int y = 1; y < 4; y++) {
            for (int x = 1; x <6; x++){
                assertEquals("\""+x+","+y+"\"", g.listeNoeuds().get(g.listeNoeuds().indexOf("\""+x+","+y+"\"")), "le nom du noeud doit etre \""+x+","+x+"\"");
            }
        }
    }

    /**
     * Test que tous les arcs sont corrects
     * @throws IOException Erreur lors de la lecture du fichier
     */
    @Test
    public void testArcCorrect() throws IOException {
        // initialisation du graphe
        Graphe g = new AdapterGrapheLabyrinthe("labySimple/laby0.txt");

        // Données pour les tests
        List<Arc> res1 =  g.suivants("\"1,1\"");
        List<Arc> res2 =  g.suivants("\"2,2\"");
        List<Arc> res3 =  g.suivants("\"3,3\"");

        // Verification des arcs
        assertEquals(2, res1.size(), "il devrait y avoir 2 arcs");
        assertEquals(4, res2.size(), "il devrait y avoir 4 arcs");
        assertEquals(3, res3.size(), "il devrait y avoir 3 arcs");

        // Verification des arcs
        assertEquals("\"2,1\"", res1.get(0).getDest(), "le noeud destination doit etre \"2,1\"");
        assertEquals("\"1,2\"", res1.get(1).getDest(), "le noeud destination doit etre \"2,1\"");

        assertEquals("\"3,2\"", res2.get(0).getDest(), "le noeud destination doit etre \"3,1\"");
        assertEquals("\"1,2\"", res2.get(1).getDest(), "le noeud destination doit etre \"2,2\"");
        assertEquals("\"2,3\"", res2.get(2).getDest(), "le noeud destination doit etre \"1,3\"");
        assertEquals("\"2,1\"", res2.get(3).getDest(), "le noeud destination doit etre \"3,2\"");

        assertEquals("\"4,3\"", res3.get(0).getDest(), "le noeud destination doit etre \"3,2\"");
        assertEquals("\"2,3\"", res3.get(1).getDest(), "le noeud destination doit etre \"3,3\"");
        assertEquals("\"3,2\"", res3.get(2).getDest(), "le noeud destination doit etre \"3,1\"");
    }


    /**
     * Test que le graphe est le même que celui du labyrinthe
     * @throws IOException Erreur lors de la lecture du fichier
     */
    @Test
    public void testGraphviz() throws IOException {
        // initialisation du graphe
        Graphe g = new AdapterGrapheLabyrinthe("labySimple/laby1.txt");
        Labyrinthe l = new Labyrinthe("labySimple/laby1.txt");

        // verifications
        assertEquals(l.genererGraphe().toGraphviz(), g.toGraphviz(), "le graphe doit etre identique");

    }
}
