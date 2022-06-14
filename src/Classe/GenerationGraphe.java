package Classe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * classe Generation Graphe qui permet de generer des graphes aleatoirements
 */
public class GenerationGraphe {
    public static void main(String[] args) throws IOException {
        // initialisation du scanner
        Scanner sc = new Scanner(System.in);

        // demande le nom du fichier a creer ou modifier pour y ajouter le graphe
        System.out.println("Indiquez le nom du graphe qui va etre genere : ");
        String nomGraphe = sc.nextLine();
        // demande le nombre de noeuds du graphe
        System.out.println("Indiquez le nombre de noeuds du graphe : ");
        int nbNoeud = sc.nextInt();
        // demande le nombre du noeud de depart du graphe
        System.out.println("Indiquez le debut du graphe : ");
        int debutGraphe =sc.nextInt();
        // demande le nombre du noeuds de fin du graphe
        System.out.println("Indiquez la fin du graphe : ");
        int finGraphe = sc.nextInt();

        // initialisation du FileWriter qui va creer ou ouvrir le fichier
        FileWriter fw = new FileWriter("graphesGenere/"+nomGraphe);

        // on ajoute un noeud vers chaque nombre du noeud de depart au noeud de fin du graphe
        for(int i = debutGraphe ; i < finGraphe ; i++){
            fw.write(i+"\t"+(i+1)+"\t"+(int)(Math.random()*100)+"\n");
        }
        // on ajoute un noeud vers chaque nombre du noeud de fin au noeud de depart du graphe
        for(int i = finGraphe ; i > debutGraphe ; i--){
            fw.write(i+"\t"+(i-1)+"\t"+(int)(Math.random()*100)+"\n");
        }
        // ajoute des noeuds aleatoire jusqu a obtenir le nombre de noeuds demande
        for(int i = (finGraphe-debutGraphe)*2 ; i < nbNoeud ; i++){
            int nb1 = (int)(Math.random()*finGraphe)+1;
            int nb2 = (int)(Math.random()*finGraphe)+1;
            while(nb1 == nb2){
                nb2 = (int)(Math.random()*finGraphe)+1;
            }
            fw.write(nb1+"\t"+nb2+"\t"+(int)(Math.random()*100)+"\n");
        }

        // fermeture du fichier
        fw.close();
    }
}
