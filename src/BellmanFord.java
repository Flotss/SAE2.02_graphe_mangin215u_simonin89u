public class BellmanFord {
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