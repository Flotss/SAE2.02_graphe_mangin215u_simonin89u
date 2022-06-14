package Main;

import laby.Labyrinthe;

import java.io.IOException;

public class MainLabyrinthe {
    public static void main(String[] args) throws IOException {
        Labyrinthe lab = new Labyrinthe("labySimple/laby0.txt");
        System.out.println(lab.genererGraphe());
    }
}
