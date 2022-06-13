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

        Cell cell = row.createCell(1);
        cell.setCellValue("Temps moyen de Dijkstra");

        cell = row.createCell(2);
        cell.setCellValue("Temps moyen de BellmanFord");


        File folder = new File("graphes");
        int nombreDeGraphe = folder.listFiles().length;
        int i = 0;


        System.out.println("Graphe de Djikstra");
        Row[] rows = new Row[nombreDeGraphe+1];
        for (File file : folder.listFiles()) {
            rows[i] = feuille.createRow(i+1);
            cell = rows[i].createCell(1);

            GrapheListe graphe = new GrapheListe(file.getPath());
            long tempsStart = System.nanoTime();
            Dijkstra.resoudre(graphe, "A");
            long tempsEnd = System.nanoTime();
            i++;
            cell.setCellValue((int) (tempsEnd - tempsStart));

            if (i % 10 == 0) {
                System.out.println("Graphe " + i + "/" + nombreDeGraphe);
            }
        }

        System.out.println("Graphe de BellmanFord");
        i = 0;
        for (File file : folder.listFiles()) {
            cell = rows[i].createCell(2);

            GrapheListe graphe = new GrapheListe(file.getPath());
            long tempsStart = System.nanoTime();
            BellmanFord.resoudre(graphe, "A");
            long tempsEnd = System.nanoTime();
            i++;
            cell.setCellValue((int) (tempsEnd - tempsStart));

            if (i % 10 == 0) {
                System.out.println("Graphe " + i + "/" + nombreDeGraphe);
            }
        }


        i = 0;
        for (File file : folder.listFiles()) {
            cell = rows[i].createCell(0);
            i++;
            cell.setCellValue(i);
        }

        //4. Sauvegarder le document
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
