package Main;

import Classe.BellmanFord;
import Classe.AdapterGrapheLabyrinthe;
import Classe.Graphe;
import Classe.Valeur;

import java.io.IOException;

public class MainGraphLabyrinthe {
    public static void main(String[] args) throws IOException {
        try{
            Graphe graphe = new AdapterGrapheLabyrinthe("labySimple/laby1.txt");
            System.out.println(graphe.toGraphviz());
            Valeur valeur = BellmanFord.resoudre(graphe, "\"1,1\"");
            System.out.println(valeur);
            System.out.println(valeur.calculerChemin("\"8,5\""));
        }catch (IOException e){
            System.out.println("Erreur lecture fichier");
        }

    }
}
