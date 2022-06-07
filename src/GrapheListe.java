import java.util.List;

public class GrapheListe implements Graphe{

    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    public void ajouterArc(String depart, String destination, double cout){
        throw new Error("TODO");
    }

    public List<String> listeNoeuds(){
        return this.ensNom;
    }

    public List<Arc> suivants(String n){
        throw new Error("TODO");
    }

}
