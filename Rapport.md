## Rapport de la SAE S2.02
#### Question 13 : Algorithme du point fixe

```pseudocode
fonction pointFixe(g InOut : Graphe, depart : Noeud)
    DEBUT
    L(depart) <- 0
    Pour i allant de 1 à taille de g
        L(i) <- +infini
    fpour
    
    ancien <- L
    Tant que ancien != L faire
        Pour i allant de 1 à taille de g
            Si L(i) > L(i) + cout
                L(i) <- L(i-1) + cout
```