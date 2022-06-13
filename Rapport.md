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
    indice <- 0
    Tant que L != ancien et indice > nbrSommets faire
        ancien <- L
        Pour n un noeud de g
            Pour a un arc de n
                Si L(n) + L(a.cout) < L(a.destination)
                    L(a) <- L(n) + L(a.cout)
                    parent(a) <- n
            fpour
        fpour
        indice <- indice + 1
    ftantque
FIN

Lexique :
    i : entier, indice d'itération
    ancien : Ancienne valeur de L
    nbrSommets : Nombre de sommets du graphe
    indice : entier, indice d'itération
    n : Noeud, sommet du graphe
    a : Arc, arc du graphe
```