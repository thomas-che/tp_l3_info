# exo 1
#install.packages("questionr")
library(questionr)
data(hdv2003)
summary(hdv2003)

d=hdv2003[,c(7,20)] # on prend tout les ligne mais que les colones 7 et 20
d=na.exclude(d) # on exclu les ligne ou il y a des na

# decrir repartition de la var 20 (var 2 pour d) suivant les categorie de la car 7 (var 1 par d)
summary(d[,2])
summary(d[d$qualif=='Ouvrier specialise',2])

boxplot(d[,2])
boxplot.stats(d[,2])

# tracer les boxplot des heures de tv en fonction des categories de qualification, renommer ces categories
d$qualif.bis[d$qualif=="Ouvrier specialise"]="O.S" # renome la colonne Ouvrier specialise par O.S
#... renome les autre col
#plot(d[,2]~d[,1])

boxplot(d[,2]~d$qualif.bis)
# 4 distribution identique : emply, inter, ouvrier qualif, techinisien
# ouvrier spe regarde + la tv, median=3eme quartile des ouvrier qualif
# donc la qualification est lier au nb d'heure devant la tv

annova(lm(d[,2]~d$qualif.bis))
# on rejet H0, pas la meme distrib, donc h de tv ne depend pas de la qualif




# exo 2 
# generer echantilon taille = 5000 de variable sur [-1;1], utiliser la loi des grands nb

x=runif(5000,-1,1)
sum(x)/5000

# graphe montre convergence de xn_bar vers la moyenne de x

# faire un graphe de la distrib des moyenne empirique 











