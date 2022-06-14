package laby;

import Classe.GrapheListe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";


    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public int[] deplacerPerso(int i, int j, String action) {
        // case courante
        int[] courante = {i, j};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante[0]][suivante[1]]) {
            // on met a jour personnage
            return suivante;
        }
        return courante;
    }

    /**
     * methode genererGraphe qui permet de generer un graphe avec un labyrinthe
     * @return le graphe
     */
    public GrapheListe genererGraphe() {
        // initialisation du graphe
        GrapheListe graphe = new GrapheListe();
        // on parcourt le tableau de murs
        for (int i = 0; i < murs.length; i++) {
            for (int j = 0; j < murs[i].length; j++) {
                // si il n y a pas de mur a la position actuelle on ajoute un arc
                if (!murs[i][j]) {
                    ajouterArcs(graphe, i, j, 1);
                }
            }
        }
        // retour du graphe
        return graphe;
    }

    /**
     * methode qui permet d'ajouter les arcs dans le graphe
     * @param g le graphe
     * @param x la position x
     * @param y la position y
     * @param valeur la valeur de l'arc
     */
    public void ajouterArcs(GrapheListe g, int x, int y, int valeur) {
        ajouterUnArc(g, x, y, x+1, y,valeur);
        ajouterUnArc(g, x, y, x-1, y,valeur);
        ajouterUnArc(g, x, y, x, y+1,valeur);
        ajouterUnArc(g, x, y, x, y-1,valeur);
    }

    /**
     * methode qui permet d'ajouter un arc dans le graphe
     * @param g le graphe
     * @param x la position x
     * @param y la position y
     * @param nx la position x de la destination
     * @param ny la position y de la destination
     * @param valeur la valeur de l'arc
     */
    public void ajouterUnArc (GrapheListe g, int x, int y, int nx, int ny , int valeur){
        try {
            // on verifie que la destination n'est pas un mur et on essaie d ajouter l arc
            if (!murs[x][(y)]) {
                g.ajouterArc("\"" + x + "," + y + "\"", "\"" + nx + "," + ny + "\"", valeur);
            }
        } catch (Exception ingored) {}
    }

    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     *
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }
}
