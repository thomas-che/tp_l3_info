plsql4_ex2_tp_verouillage

t1: 
	create table t(a number);
    	insert into t values (0); 
l1	Grant all on t to system;
l2	insert into t values (-1);

t2:
l3	lock table system.t in exclusive mode nowait; # on peut pas car la table t est deja bloqué en RX par t1,l2
l4	lock table system.t in row share mode; # block en RS
l5	insert into systme.t values(-2); # pas de pb pour inserer
l6	update system.t set a=3 where a=0;

t1:
l7	update system.t set a=4 where a=0;

t2:
l8	commit; # u2: 3 -2 ; u1: 3 -1 -2

t1:
l9	commit; # u1: -1 -2 3 ; u2: -1 -2 3
l10	select * from t where a=-1 for update; # reserve du coter t1 la ligne a=-1 pour faire un maj

t2:
l11	update system.t set a=3 where a=-1; # en attente car la ligne est bloqué par t1

t1:
l12	update system.t set a=0 where a=-1;
l13	commit; # u1: 3 0 -2; u2: 3 0 -2

t2:
l14	commit; # inutile sur la table, juste utile pour recommencer une nouvelle transaction
l15	lock table system.t in share mode;

t1:
l16	lock table system.t in exclusive mode nowait; # erreu 54, bloqué car resource deja ocupé 
l17	update system.t set a=-1 where a=-2; # t1 bloqué en attente

t2:
l18	update system.t set a=2 where a=-2;
l19	commit; # u2: 3 0 2 ; u1: 3 0 -2

t1:
l20	commit; # u1: 3 0 2 ; u2: 3 0 2

t2:
l21	lock table system.t in share row exclusive mode;

t1:
l22	lock table system.t in row share mode nowait; # sa marche
l23	insert into system.t values(5); # mais en attente car u2 est en exclusive donc pas autorisé aux modifs

t2:
l24	delete from system.t; # pas de pb
l25	commit; # u2: null ; u1: 5

t1:
l26	rollback; # fini en anulant 

t2:
l27	lock table system.t in share mode;
l28	insert into system.t values(-1);

t1:
l29	drop table t; # erreur 54

t2:
l30	alter table system.t add (b number); # u2: a: -1; b: vide ; u1 a: -1; b: vide
l31 	alter table system.t add ( constraint pk_t_a primary key (a) );

t1:
l32	drop table t; 

t2:
l33	drop table system.t; # ne fonctionne pas car deja supprimer la table en t1, commit implicite 


















