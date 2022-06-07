/**
 * Classe Arc qui represente un arc d'un graphe partant d'un noeud
 */
public class Arc {
    /**
     * La destination de l'arc (le noeud d'arrivee)
     */
    private final String dest;

    /**
     * Le poids de l'arc (cout de l'arc)
     */
    private final double cout;

    /**
     * Le constructeur de l'arc
     * @param nom La destination de l'arc
     * @param cout Le cout de l'arc
     */
    public Arc(String nom, double cout) {
      this.dest = nom;
      this.cout = cout;
    }

    /**
     * getter de la destination de l'arc
     * @return
     */
    public String getDest() {
      return dest;
    }

    public double getCout() {
      return cout;
    }
}
