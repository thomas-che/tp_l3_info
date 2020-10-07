# TD 4


## Contexte 


Vous devez développer un modèle pour que des utilisateurs puissent échanger des messages privés sur 
une plateforme à laquelle ils se seraient inscrits.
Le but est de pouvoir envoyer un message à n'importe qui à partir du moment où cet individu est également 
inscrit à la plateforme. Pour pouvoir échanger des messages avec un individu, il faut déjà initier une discussion avec lui. 
Au sein de cette discussion, nous retrouverons tous les messages échangés entre les deux individus concernés. 
Une discussion ne concerne que deux utilisateurs.


## Spécification

Un utilisateur devra
 
    * Pouvoir s'inscrire à la plateforme avec un pseudo non nul et non existant dans la plateforme
    * Pouvoir se désinscrire de la plateforme
    * Pouvoir se connecter à la plateforme s'il n'est pas déjà connecté
    * Pouvoir se déconnecter de la plateforme 
    * Pouvoir consulter toutes les discussions qu'il a depuis son inscription (titre, expéditeur et date) uniquement 
      s'il est connecté
    * Pouvoir consulter n'importe quelle discussion uniquement s'il est connecté
    * Pouvoir envoyer un message dans une discussion uniquement s'il est connecté
    * Créer une discussion avec un individu inscrit
    * Pouvoir consulter la liste des individus inscrits
    

Un message consulté sera alors un message lu. 


## Travail demandé
Développez le modèle destiné à cette application en ligne en prenant bien en compte le contexte dans lequel cette application sera déployée.