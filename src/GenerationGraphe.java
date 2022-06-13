import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GenerationGraphe {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indiquez le nom du graphe qui va etre genere : ");
        String nomGraphe = sc.nextLine();
        System.out.println("Indiquez le nombre de noeuds du graphe : ");
        int nbNoeud = sc.nextInt();
        System.out.println("Indiquez le debut du graphe : ");
        int debutGraphe =sc.nextInt();
        System.out.println("Indiquez la fin du graphe : ");
        int finGraphe = sc.nextInt();

        FileWriter fw = new FileWriter("graphesGenere/"+nomGraphe);
//
//        for(int i = 0 ; i < nbNoeud ; i++){
//            fw.write((int)(Math.random()*i/2)+"\t"+(int)(Math.random()*i/2)+"\t"+(int)(Math.random()*101)+"\n");
//        }

        for(int i = debutGraphe ; i < finGraphe ; i++){
            fw.write(i+"\t"+(i+1)+"\t"+(int)(Math.random()*100)+"\n");
        }
        for(int i = finGraphe ; i > debutGraphe ; i--){
            fw.write(i+"\t"+(i-1)+"\t"+(int)(Math.random()*100)+"\n");
        }
        for(int i = (finGraphe-debutGraphe)*2 ; i < nbNoeud ; i++){
            int nb1 = (int)(Math.random()*finGraphe)+1;
            int nb2 = (int)(Math.random()*finGraphe)+1;
            while(nb1 == nb2){
                nb2 = (int)(Math.random()*finGraphe)+1;
            }
            fw.write(nb1+"\t"+nb2+"\t"+(int)(Math.random()*100)+"\n");
        }







        int nbLigne = (finGraphe - debutGraphe) * 2;
//        for(int i = nbLigne ; i < nbNoeud ; i++){
//            fw.write(i+"\t"+(int)(Math.random()*finGraphe+1)+"\t"+(int)(Math.random()*100)+"\n");
//        }

        fw.close();
    }
}
