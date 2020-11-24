# exo ANOVA page 2

# Varible "ventes" = variable a explique ; "depences" = var explicative

ventes=c(25,30,35,45,65)
depences=c(5,6,9,12,18)

plot(depences,ventes)
# les pt sont bien aligner, il semble avoir une depenedance entre vente et depence



###############################
#                             #
#        EX 1  tp4            #
#                             #
###############################

#1) avant tout calc on s'interesse aux nuage de pt

age=c(5,4,6,5,5,5,6,6,7,7)
km=c(92,64,124,97,79,76,93,63,111,143)
prix=c(7.8,9.5,6.4,7.5,8.1,9,6.1,9.7,6.4,4.4)

par(mfrow=c(1,2))
plot(age,prix)
plot(km,prix)

#2) calc coef de corelation
# plus c'est proche de 1 plus c'est coreler
cor(age,prix) # tres corele negativement 
cor(km,prix)

#3)a) regresion lineaire : lm

reg1=lm(prix~km)
reg1 
coefficients(reg1)# intercept = ^b(=13.23856)(=ordoner a l'origine) et la valeur explicative (ici km) donne â(=-0.06103)(=coef pente) 

#3)b)

par(mfrow=c(1,1))
plot(prix~km)
abline(reg1,lty=1,col='blue',lwd=1)

#3)c) on veut verifier que le pt central (mean(x), mean(y)) est dur la droite
abline(v=mean(km))
abline(h=mean(prix))

x=mean(km)
y=mean(prix)
13.23855594 -0.06102501*x # on cherche a retrouver y
y # le pt centarl est bien sur la droite

# qualiter de la regresion on regade R^2
summary(reg1)
# on toruve le R^2 par "Adjusted R-squared:  0.8619 " cela signifi que la regresion explique 86% de la variation

# on predit qu'une voiture selon la reg1 et qui aura 150 000km aura un prix de 4 084e
predict(reg1,data.frame(km=150)) 




###############################
#                             #
#        EX 2  tp4            #
#                             #
###############################

annee=c(0,1,2,3,4,5,6) # var explicative
achat=c(75,260,820,1650,2300,4000,5300) # var a expliquer

plot(annee,achat)
# certain pt alignée, courbe semble etre une parabole

cor(annee,achat) # coef tres proche de 1

reg_annee_achat=lm(achat~annee)
reg_annee_achat

abline(reg_annee_achat,lty=1,col='blue',lwd=1)

summary(reg_annee_achat) # coef R^2 = 0.92 est bon

abline(v=mean(annee))
abline(h=mean(achat))

predict(reg_annee_achat,data.frame(annee=7)) 

# remarque prof :
reg_annee_achat$residuals
# valeur des residue pr chaque pt eleve ca qui permet de questionner la pertinence du model lineaire (donc plus un model y=x^2)


