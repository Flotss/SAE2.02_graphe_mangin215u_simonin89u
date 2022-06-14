package Main;

import Classe.BellmanFord;
import Classe.Dijkstra;
import Classe.GrapheListe;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainComparaisonParGraphe {
    public static void main(String[] args) throws IOException {
        //Créer un Document vide
        XSSFWorkbook wb = new XSSFWorkbook();
        //Créer une Feuille de calcul vide
        Sheet feuille = wb.createSheet("new sheet");
        //Créer une ligne
        Row row = feuille.createRow(0);
        //Créer une cellule
        Cell cell = row.createCell(1);
        // On écrit dans la cellule l'intitulé de la colonne ici Temps Classe.Dijkstra
        cell.setCellValue("Temps Classe.Dijkstra");

        // On écrit dans la cellule l'intitulé de la colonne ici Temps Bellman
        cell = row.createCell(2);
        cell.setCellValue("Temps Classe.BellmanFord");


        // On créer un répertoire contenant les fichiers des graphes
        File folder = new File("graphes");
        // Verification que c'est un répertoire
        if (!folder.isDirectory()){
            System.out.println("Le répertoire n'existe pas");
            System.exit(1);
        }



        System.out.println("Classe.Graphe de Djikstra");
        int nombreDeGraphe = folder.listFiles().length;
        int i = 0;
        // Tableau contenant les lignes de la feuille
        Row[] rows = new Row[nombreDeGraphe+1];
        for (File file : folder.listFiles()) {
            // Création de la ligne et de la cellule
            rows[i] = feuille.createRow(i+1);
            cell = rows[i].createCell(1);

            // Execution de l'algorithme de Djikstra
            // En prenant en compte le temps utilisé
            GrapheListe graphe = new GrapheListe(file.getPath());
            long tempsStart = System.nanoTime();
            Dijkstra.resoudre(graphe, "1");
            long tempsEnd = System.nanoTime();
            i++;

            // On écrit dans la cellule le temps de l'algorithme
            cell.setCellValue((int) (tempsEnd - tempsStart));

            // Logs
            if (i % 10 == 0) {
                System.out.println("Classe.Graphe " + i + "/" + nombreDeGraphe);
            }
        }

        System.out.println("Classe.Graphe de Classe.BellmanFord");
        i = 0;
        for (File file : folder.listFiles()) {
            // Création de la cellule
            cell = rows[i].createCell(2);

            // Execution de l'algorithme de Classe.BellmanFord
            // En prenant en compte le temps utilisé
            GrapheListe graphe = new GrapheListe(file.getPath());
            long tempsStart = System.nanoTime();
            BellmanFord.resoudre(graphe, "1");
            long tempsEnd = System.nanoTime();
            i++;

            // On écrit dans la cellule le temps de l'algorithme
            cell.setCellValue((int) (tempsEnd - tempsStart));

            // Logs
            if (i % 10 == 0) {
                System.out.println("Classe.Graphe " + i + "/" + nombreDeGraphe);
            }
        }

        i = 0;
        // On écrit le nom du fichier dans la cellule
        for (File file : folder.listFiles()) {
            cell = rows[i].createCell(0);
            cell.setCellValue(file.getName());
            i++;
        }

        // Création du fichier Excel
        // Pour pouvoir le lire dans Excel
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("tableau des response.xlsx");
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
