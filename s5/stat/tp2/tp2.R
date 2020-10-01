class=read.table("/home/thomas/Documents/tp_l3_info/s5/stat/tp2/class.data.txt", header = T)
class # valeur qualitative

vec_sexe<-class$sexe # ou on peut faire : attach(class) et apres on aura deja des vect juste avec sexe
vec_sexe

vec_dep<-class$departement
vec_dep

vec_seri<-class$serie
vec_seri

par(mfrow=c(1,3))
t_sexe<-table(vec_sexe)
barplot(t_sexe/150,col = "blue") # diagrame en baton
t_dep<-table(vec_dep)
pie(t_dep/150) # pr avoir un cammenbert
t_seri<-table(vec_seri)
plot(t_seri/150) 


# test perso
plot(table(class$sexe[class$serie == "S"]))
table(class$sexe[class$serie == "S"])



# bande de donner de R ; iris, ....
library(MASS) 
caith # pas use
quine
help (quine)

# diagrame fc pr age
vec_age<-quine$Age
t_age<-table(vec_age)
barplot(t_age/146,col = "blue") 


# boite moustache nb jour abs
vec_day<-quine$Days
boxplot(vec_day)# pr avoir une boite a moustache, directemnt le vecteur


boxplot.stats(vec_day) # affiche plein de donner sur la boite ; $conf interval de confiance

help(boxplot)

# boite moustache nb jour abs en fc de lage
boxplot(vec_day~vec_age)


# boite a moustache age=F1 et days abs 
#quine$Days[quine$Age == "F1"]
boxplot(vec_day[vec_age == "F1"])





