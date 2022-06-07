import java.util.List;

public class GrapheListe implements Graphe{

    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    public void ajouterArc(String depart, String destination, double cout){
        this.ensNoeuds.get(this.ensNom.indexOf(depart)).ajouterArc(destination, cout);
    }

    public List<String> listeNoeuds(){
        return this.ensNom;
    }

    public List<Arc> suivants(String n){
        return this.ensNoeuds.get(this.ensNom.indexOf(n)).getAdj();
    }

}
