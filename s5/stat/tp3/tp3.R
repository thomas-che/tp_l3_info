###############################
#                             #
#           EX 1              #
#                             #
###############################

# 1)
vec_1<-rnorm(150,0,1)
vec_1

# 2)
tab_vec_1<-table(vec_1)
plot(tab_vec_1)

# 3)
mean(vec_1)
sd(vec_1)
summary(vec_1)

hist(vec_1, main="",breaks = 50, probability = T, col = "red")
x0<-seq(min(vec_1),max(vec_1),length.out = 100)
lines(x0,dnorm(x0,mean(vec_1),sd(vec_1)),col="green")

# correction
x0<-seq(-4,4,by=0.01)
plot(x0,dnorm(x0,mean(vec_1),sd(vec_1)),type='l')
lines(x0,dnorm(x0,0,1),col="green")


###############################
#                             #
#           EX 2              #
#                             #
###############################

#1) homme et femme 42500 ouvriers 

# population = ouvrier groupe industriel
# card(pop) = 42500
# character observer = salaire annuel en k€
# x = var quantitative considerer comme continue

# 2)
# reproduire echantillon donne brut (x1,x2,...,x42500)
# on va considerer que dans chaque classe la repartition des donnes est uniforme

sal_h<-c( runif(3145,2.5,5), runif(2465,5,6), runif(4675,6,7), runif(11220,7,8.5), runif(9180,8.5,10), runif(8160,10,12), runif(3655,12,14) )
sal_h
bk<-c(2.5,5,6,7,8.5,10,12,14)
rm(c)
tab_sal_h=table(cut(sal_h,breaks = bk))
tab_sal_h

par(mrfrow=c(1,2))
hist(sal_h,freq = T, breaks = bk)
hist(sal_h,probability = T, breaks = bk)

y=c(0,cumsum(tab_sal_h)/42500)
plot(bk,y,type='l') # ligne briser des frequence cumuler
quantile(sal_h,c(0.25,0.5,0.75)) # pr avoir les quartille du sal


###############################
#                             #
#           EX 3              #
#                             #
###############################

robinet
#1)
summary(robinet)

#2)
boxplot(robinet)

t_fc_cum<-cumsum(table(robinet$consommation)/length(robinet$consommation))
plot(t_fc_cum)

# autre possibiliter : 
# trier le robinet par ordre croissant, et chaque observation/lenght(tab)
plot(sort(robinet$consommation),(1:length(robinet$consommation))/length(robinet$consommation),type='l')


#3)
par(mfrow=c(1,2))

hist(robinet$consommation)

hist(robinet$consommation, proba = T)

hist(robinet$consommation, breaks = 5)
hist(robinet$consommation, nsclass = 5)

bk2<-c(0,50,100,200,350,550,800,1100,1450,3000)
hist(robinet$consommation, freq = T , breaks = bk2)


#4)
x0<-seq(min(robinet$consommation),max(robinet$consommation))
lines(x0,exp(1/mean(robinet$consommation)))



