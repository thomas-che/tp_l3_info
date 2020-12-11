# construir echantillon 5000, loi unif [-1,1]
x=runif(5000,-1,1)
# ilustrer par un graphe la convergence de la moyenne empirique et theorique
y=0
z=0
for(i in 1:5000)
{
  y[i+1]=y[i]+x[i+1]; z[i]=y[i]/i
}
plot(z,type='l')
abline(h=0,col='red')

# convergence de la variance, on suppose que la moyene=0
t=0
u=0
for(i in 1:5000)
{
  t[i+1]=t[i]+x[i+1]^2;u[i]=t[i]/i
}
plot(u,type='l')
abline(h=1/3,col='blue')

# si m est inconnue, on remplace par \bar x_5000 = mean(x)
v=0
w=0
for(i in 1:5000)
{
  v[i+1]=v[i]+(x[i+1]-mean(x))^2;w[i]=v[i]/i
}
plot(w,type='l')
abline(h=1/3,col='blue')

# illustration de la convergence de l'chantillon de la moyenne empirique
n=1000
m=10000
u=rexp(n*m,1) # random exponentiel
x=matrix(u,nrow=n,ncol=m)
z=sqrt(n)*(colSums(x)/n-1) #vecteur dont chaque coordone est la racine(n)(\bar x_n-1)
par(mfrow=c(1,2))
hist(u, freq = F, main=" loi de x")
hist(z, freq = F, main="loi de la moyenne empirique")
a=seq(min(range(z)),max(range(z)),by=0.01)
lines(a,dnorm(a),col="red")

# quantile de la loi normal qnorm(valeur proba, moyenne, variance)
qnorm(0.95,0,1)
# proba d'etre inferieur a une valeur pnorm(valeur,moyenne,variance)
pnorm(0, 0,1)




