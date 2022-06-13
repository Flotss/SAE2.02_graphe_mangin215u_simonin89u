/**
 * classe BellmanFord qui permet de calculer le plus court chemin
 * entre deux noeuds avec la methode du point fixe
 */
public class BellmanFord {

    /**
     * methode static resoudre qui permet de calculer le plus court chemin entre chaque noeud
     * @param g graphe dans lequel on cherche le plus court chemin
     * @param depart noeud de depart
     * @return un objet Valeur qui contient les plus courts chemins et leur cout entre chaque noeud
     */
    public static Valeur resoudre(Graphe g, String depart){
        // initialisation de l'objet Valeur
        Valeur val = new Valeur();
        // initialise toutes les valeurs a + l infini et leur parent a null
        for (String n : g.listeNoeuds()){
            val.setValeur(n, Double.MAX_VALUE);
            val.setParent(n, null);
        }
        // initialise un objet Valeur avec les valeurs de val
        Valeur ancien = new Valeur(val);
        // on assigne la valeur du noeud de depart a 0
        val.setValeur(depart, 0);

        int pointFixe = val.valeur.size();
        int indice =0;
        // tant que val et ancien ne sont pas egaux et que le nombre d iteration est inferieur a la taille du graphe on continue
        while (!val.equals(ancien) && pointFixe > indice){
            // Ancien est assigne a val
            ancien = new Valeur(val);
            // On parcourt tous les noeuds du graphe
            for (String n : g.listeNoeuds()){
                // On parcourt tous les arcs de chaque noeuds
                for (Arc a : g.suivants(n)){
                    if (val.getValeur(n) + a.getCout() < val.getValeur(a.getDest())){
                        val.setValeur(a.getDest(), val.getValeur(n) + a.getCout());
                        val.setParent(a.getDest(), n);
                    }
                }
            }
            indice++;
        }
        // retour de l objet Valeur
        return val;
    }
}
