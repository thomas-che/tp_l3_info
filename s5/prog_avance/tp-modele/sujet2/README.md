
# TD 2 - Tic tac toe


Vous devez développer le modèle du jeu appelé « Tic Tac Toe » aussi connu sous
le nom du « Morpion ». Le principe est simple : sur une grille 3x3 les joueurs tenteront d'aligner
trois de leurs pions (verticalement, horizontalement ou en diagonale) en jouant alternativement.
Le premier parvenant à réussir à aligner trois de ses pions sera déclaré vainqueur. Cette application sera utilisée en monoposte par deux joueurs 
qui saisiront initialement leurs pseudos. 


## Use Cases

Le Use case classique
 
    * Vous arrivez sur un écran avec deux champs : le nom du créateur (le votre) et le nom de l'invité
    * Une fois la connexion validée vous arrivez sur le plateau du jeu et c'est à vous de jouer. 
    * Vous ne pourrez jouer le prochain coup que lorsque votre compagnon de jeu vous aura rejoint.
    * Votre compagnon est invité à jouer à son tour 
    * La partie se déroule jusqu'à la fin
    * Une fois la partie terminée, le résultat de la partie est affiché avant de quitter l'application
    
En partie, chaque joueur peut "ragequit" et ainsi donner la victoire à l'adversaire.




## Règles de gestion

* Les logins doivent au moins avoir une taille de 3 caractères.
* Les joueurs doivent avoir deux pseudos différents 
* Le joueur le premier saisi est toujours celui qui commence.
* On ne peut pas jouer en dehors des coordonnées du plateau ((x,y) avec x et y dans {0,1,2}). 


## Travail demandé
Vous devez développer le modèle de cette application qui aura pour vocation à être utilisée en monoposte. 
A l'aide d'un petit programme permettant de faire une partie. 