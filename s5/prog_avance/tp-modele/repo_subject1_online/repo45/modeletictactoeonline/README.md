
# TD 3 - Tic tac toe on line


Vous devez développer le modèle du jeu appelé « Tic Tac Toe » aussi connu sous
le nom du « Morpion ». Le principe est simple : sur une grille 3x3 les joueurs tenteront d'aligner
trois de leurs pions (verticalement, horizontalement ou en diagonale) en jouant alternativement.
Le premier parvenant à réussir à aligner trois de ses pions sera déclaré vainqueur. Le but de cette application est d'être utilisé on line.


## Use Cases

Le Use case classique
 
    * Vous lancez l'application et vous arrivez sur un menu (2 liens)
        + Nouvelle partie
        + Rejoindre une partie
    * Vous demandez la création d'une nouvelle partie
    * Vous arrivez sur un écran avec deux champs : le nom du créateur (le votre) et le nom de l'invité
    * Une fois la connexion validée vous arrivez sur le plateau du jeu et c'est à vous de jouer. 
    * Vous ne pourrez jouer le prochain coup que lorsque votre compagnon de jeu vous aura rejoint.
    * Votre compagnon lance l'application et arrive sur le même menu.
    * Il demande à rejoindre une partie.
    * Il arrive sur une page lui demandant son nom.
    * Il entre son nom puis valide. 
    * Le plateau de jeu s'affiche et il peut participer à la partie.
    * La partie se déroule jusqu'à la fin
    * Une fois la partie terminée, le résultat de la partie est affiché et un lien est affiché pour 
    se déconnecter de l'application.
    * Une fois cliqué sur le lien, l'individu est déconnecté.
    
En partie, chaque joueur peut "ragequit" et ainsi donner la victoire à l'adversaire.




## Règles de gestion

* Les logins doivent au moins avoir une taille de 3 caractères.
* Un login ne peut créer ou rejoindre une partie si le même login existe déjà dans les membres connectés.
* Pour rejoindre une partie avec un pseudo, il faut avoir été invité à une partie (quelqu'un a créé une partie et a désigné 
votre pseudo) en tant que second joueur.
* On ne peut pas jouer quand ce n'est pas notre tour. 
* Le joueur qui a créé la partie est toujours celui qui commence.
* On ne peut pas jouer en dehors des coordonnées du plateau ((x,y) avec x et y dans {0,1,2}). 


## Travail demandé
Vous devez développer le modèle de cette application qui aura pour vocation à être utilisé on-line. 
Vous devrez aussi valider votre modèle à l'aide de tests unitaires comme présenté en cours. 