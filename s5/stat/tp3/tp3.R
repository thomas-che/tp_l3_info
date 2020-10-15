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

tab_sal_h=table(cut(sal_h,breaks = bk))
tab_sal_h

par(mrfrow=c(1,2))
hist(sal_h,freq = T, breaks = bk)
hist(sal_h,probability = T, breaks = bk)

y=c(0,cumsum(tab_sal_h)/42500)
plot(bk,y,type='l') # ligne briser des frequence cumuler
quantile(sal_h,c(0.25,0.5,0.75)) # pr avoir les quartille du sal





