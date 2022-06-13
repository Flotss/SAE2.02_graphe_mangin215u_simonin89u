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
        Valeur val = new Valeur();
        for (String n : g.listeNoeuds()){
            val.setValeur(n, Double.MAX_VALUE);
            val.setParent(n, null);
        }

        Valeur ancien = new Valeur(val);
        val.setValeur(depart, 0);

        int pointFixe = val.valeur.size();
        int i =0;
        while (!val.equals(ancien) && pointFixe > i){
            // Ancien devient val
            ancien = new Valeur(val);

            for (String n : g.listeNoeuds()){
                for (Arc a : g.suivants(n)){
                    if (val.getValeur(n) + a.getCout() < val.getValeur(a.getDest())){
                        val.setValeur(a.getDest(), val.getValeur(n) + a.getCout());
                        val.setParent(a.getDest(), n);
                    }
                }
            }
            i++;
        }

        return val;
    }
}
