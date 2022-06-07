import java.util.List;

public class Noeud {

    private String nom;
    private List<Arc> adj;

    public Noeud(String nom){
        this.nom = nom;
        this.adj = new List<Arc>();
    }

    public boolean equals(Object o){
        return this.nom.equals(((Noeud)o).nom);
    }

    public void ajouterArc(String destination, double cout){
        this.adj.add(new Arc(destination, cout));
    }

}
