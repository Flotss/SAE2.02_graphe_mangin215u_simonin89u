## Rapport de la SAE S2.02
#### Question 13 : Algorithme du point fixe

```pseudocode
fonction pointFixe(g InOut : Graphe, depart : Noeud)
 DEBUT
    L(depart) <- 0
    Pour i allant de 1 à taille de g
        L(i) <- +infini
        parent(i) <- indéfini
    fpour
    
    ancien <- L
    nbrSommets <- taille de g
    i <- 0
    Tant que L != ancien et i > nbrSommets faire
        ancien <- L
        Pour n un noeud de g
            Pour a un arc de n
                Si L(n) + L(a.cout) < L(a.destination)
                    L(a) <- L(n) + L(a.cout)
                    parent(a) <- n
            fpour
        fpour
        i <- i + 1
    ftantque
FIN
```