x=c(1,2,3)
y=c(1,2,3)

z=rbind(x,y)
w=cbind(x,y)

m=matrix(c(2:17),ncol=4)
m1=matrix(c(2:17),ncol=2,byrow=T)

x=c(1.7:10.7)
m=matrix(x,ncol=2)
m[1, ]
m[ ,2]

a=c(1.2:10.2)
b=c(rep(0,5),1:5)

i=matrix(c(2,4,7,8),ncol=2)
y=matrix(c(0,0,7,9),ncol=2)

u=1:5
r=rep(2.7,5)

t=c(1,5,3,98,41,648,135,1,53,1,58,2.3,6,54,5)
t[t<7 & 2<t]
t[t<3 | 5<=t]


matiere <- c("Anglais","Informatique","Biologie")
note <- c(12,19.5,14)
names(note) <- matiere
note

sort(note)
rev(sort(note))

read.table("table1.dat")


ech1<-runif(50,0,3)
avg<-0
sum<-0
for (pt in ech1) {
  sum<-sum+(pt*pt)
}
x1<-sum/50
y<-mean(ech1)
cla<-x1-(y*y)
cla

avg<-sum/50
avg

mean(ech1)
var(ech1)
sd(ech1)

# correction : S²
var(ech1) # varience en biais, S²n-1
sum(ech1^2)/50 - (mean(ech1))^2

hist?
  ?hist


hist(ech1)
hist(sqrt(islands),breaks = 12, col = "gray")


hist(sqrt(ech1),breaks = 12, col = "red")


ech2<-runif(5000,0,3)
hist(ech2,breaks=30) #histo de frequence
par(mfrow=c(1,2)) # pr afficher sur 1 col, 2 graphe
hist(ech2,breaks=30, proba=T, col = "red") # histo de densite

loiN<-rnorm(5000,0,1)
hist(loiN)
hist(loiN,breaks = 50, probability = T, col = "red")
dnorm(loiN)
hist(dnorm(loiN))
hist(dnorm(loiN), probability = T, col = "red")

help(dnorm)
x0<-seq(min(loiN),max(loiN),length.out = 100)
lines(x0,dnorm(x0,mean(loiN),sd(loiN)),col="green") #



# TODO
# hito sepal, petal pr versicolor et viginca : 4 graphes
# comparer avec courbe gaussienne 

# https://pbil.univ-lyon1.fr/R/pdf/bs01.pdf
hist(iris$Petal.Length[iris$Species == "versicolor"], main="lengh petal versicolor", breaks = seq(0,8,lenght=20), probability = T)

par(mfrow=c(1,4))
hist(iris$Petal.Length[iris$Species == "versicolor"], main="lengh petal versicolor", breaks = 20, probability = T , col = "red")
loiN<-iris$Petal.Length[iris$Species == "versicolor"]
x0<-seq(min(loiN),max(loiN),length.out = 100)
lines(x0,dnorm(x0,mean(loiN),sd(loiN)),col="black")

hist(iris$Sepal.Length[iris$Species == "versicolor"], main="lengh sepal versicolor", breaks = 20, probability = T , col = "green")
loiN<-iris$Sepal.Length[iris$Species == "versicolor"]
x0<-seq(min(loiN),max(loiN),length.out = 100)
lines(x0,dnorm(x0,mean(loiN),sd(loiN)),col="black")

# correction
x=iris[iris$Species == "versicolor",1] # on veut espece versicolor et on prend la colone 1
br0=seq(min(iris[,1]), max(iris[,1]), le=20 )
hist(x,br=br0,proba=T,main="versicolor col 1",col="blue")
x0=seq(min(x),max(x),length.out = 100)
line(x0, dnorm(x0, mean(x), sd(x)), col="red")


hist(iris$Petal.Length[iris$Species == "virginica"], main="lengh petal virginica", breaks = 10, probability = T , col = "yellow")
loiN<-iris$Petal.Length[iris$Species == "virginica"]
x0<-seq(min(loiN),max(loiN),length.out = 100)
lines(x0,dnorm(x0,mean(loiN),sd(loiN)),col="black")

hist(iris$Sepal.Length[iris$Species == "virginica"], main="lengh sepal virginica", breaks = 10, probability = T , col = "orange")
loiN<-iris$Sepal.Length[iris$Species == "virginica"]
x0<-seq(min(loiN),max(loiN),length.out = 100)
lines(x0,dnorm(x0,mean(loiN),sd(loiN)),col="black")




iris

par(mfrow=c(1,1))


# echantillon de poisson 5000 avec 4 param
loiPoisson<-rpois(5000,4)
# diagrame en baton de la repartition des effectifs
t<-table(loiPoisson) # table des effectif 
t
plot(t,ylim=c(0,990)) # diagrame en batton

#TODO
# echantillo de loi Binomiale n=100,p=0.25 de taille 500 simuler echantillon de loi de poisson de param 25 de taille 500 
# comparer les 2 distribution d effectif 
# refaire exo en variant n et p
par(mfrow=c(2,2))

x<-100
loiBinom<-rbinom(x,size=500,prob=0.25)
loiBinom
t<-table(loiBinom)
plot(t)

loiPoisson<-rpois(500,25)
loiPoisson
t<-table(loiPoisson)
plot(t)


x<-200
loiBinom<-rbinom(x,size=500,prob=0.5)
loiBinom
t<-table(loiBinom)
plot(t)

loiBinom<-rbinom(20000,size=100,prob=0.25)
loiBinom
t<-table(loiBinom)
plot(t)
loiN<-loiBinom
x0<-seq(min(loiN),max(loiN),length.out = 100)
lines(x0,dnorm(x0,mean(loiN),sd(loiN)),col="black")


#correction
par(mfrow=c(2,1))
x=rbinom(500,100,0.25)
y=rpois(500,25)
plot(table(x))
plot(table(y))
