###############################
#                             #
#        EX 1  tp5            #
#                             #
###############################

#1) population = 34etu de science ; caratere etudie = genre et possede vehicule, variable qualitatives

#2)
genre=c(rep("H",2),rep("F",3),"H",rep("F",3),rep("H",2),"F","H",rep("F",2),rep("H",2),rep("H",2),rep("F",5),"H",rep("F",2),"H",rep("F",3),"H",rep("F",2))
vehicule=c(rep("V",2),rep("NV",7),"V","NV","V",rep("NV",6),"V","NV","V","NV","V","NV","V",rep("NV",2),"V",rep("NV",3),"V","NV","V")
enquete=data.frame(genre,vehicule)
enquete

#3)
table_enquete=table(enquete$vehicule,enquete$genre)
table_enquete

#4)
barplot(table_enquete, main="possede vehicule selon genre",xlab="genre",col=c("grey","blue"),legend=rownames(table_enquete))

#5)
# on fait le test du chi-2 (qi2)
chisq.test(table_enquete)
# Si p-value < 0.05 alors on rejet le test, ici p-value=0.08 donc on ne rejet pas l'hypothese H0, les var sont indep


###############################
#                             #
#        EX 2  tp5            #
#                             #
###############################

#install.packages("ade4")
library(ade4)
data(banque)
banque
# toute les var sont qualitative

# on etudit : csp/cableue et age/eparlog
enq1=data.frame(banque$csp,banque$cableue)
enq1
table_enq1=table(enq1)
mosaicplot(table_enq1,col=c("blue","red"))
barplot(table_enq1(k,), main="possede un carte bleu selon csp",legend=rownames(table_enq1)) 

# avoir 9 graphe en fonctio de csp categorie socio profesionel
par(mfrow=c(3,3))
for (k in 1:9) {
  barplot(table_enq1[k,],main=row.names(table_enq1)[k] )  
}

chisq.test(table_enq1)
# p-value = 7.529e-06 donc on rejette l'hypo car p-value est tres fable, donc csp/cableue n'est pas indep

# age/eparlog
enq2=data.frame(banque$age,banque$eparlog)
table_enq2=table(enq2)
par(mfrow=c(1,1))
mosaicplot(table_enq2,col=c("blue","red","yellow"))

barplot(table_enq2,legend=rownames(table_enq2))

chisq.test(table_enq2)
# on ne rejette pas H0, les var sont donc indep 




