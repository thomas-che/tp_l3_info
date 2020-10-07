
###############################
#                             #
#           EX 1              #
#                             #
###############################

# 1)
nb_e<-c(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6 )
nb_e

# 2)
t_nb_e<-table(nb_e)
t_nb_e
plot(t_nb_e) # mode = 1

help (range)
(r.x <- range(t_nb_e) ) # donne les modaliter min-max : 4 58

summary(nb_e) # resume plein de donner sur le vecteur

#x <- nb_e
#range(x)
#range(x, na.rm = TRUE)
#range(x, finite = TRUE)


#3)
t_fc<-t_nb_e/length(nb_e)
t_fc
t_fc_cum<-cumsum(t_fc)
plot(t_fc_cum)
plot(t_fc_cum,type="s")


# corrr

# courbe des frequences cumulee = fonction repartition empirique
help(ecdf) 
c=ecdf(nb_e)
plot(c)


#4)
boxplot(nb_e)
boxplot.stats(nb_e)

#5)
mean(nb_e) # calc = 1.735
var(nb_e)
sd(nb_e)

###############################
#                             #
#           EX 2              #
#                             #
###############################

#1)
etu<-c(rep(19,1),rep(20,3),rep(21,9),rep(22,5),rep(23,2))
etu

#2)


###############################
#                             #
#           EX 3              #
#                             #
###############################

install.packages("/home/thomas/Documents/tp_l3_info/s5/stat/tp3/lycee_1.0.zip")
# charger le fichier en tant que data dans Rstudio
load("/home/thomas/.cache/.fr-2AJteU/robinet.rda")
help(lycee)
#lycee<- ...

#1)
guichet
file<-guichet$queue
summary(file)

#2)

boxplot(file)
boxplot.stats(file)
var(file)
sd(file)


#3)

t_file<-table(file)
plot(t_file/length(file))

fn_repatition_empirique<-ecdf(file)
plot(fn_repatition_empirique)


#4)








