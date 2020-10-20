drop table formateur cascade constraints;
drop table competence cascade constraints;
drop table contrats cascade constraints;
drop table formation cascade constraints;
drop table  enseignantSanscontrat cascade constraints; 
create table Formateur 
    (id_Enseignant number(4) primary key 
    , nom varchar2(32)
    , prénom varchar2(32)
    , salaire number(4)
    , date_naiss date
    );
    
create table Competence
    (id_Enseignant number(4) references Formateur 
    , matiere varchar2(32)
    , constraint pk_competence primary key (id_Enseignant,matiere)
    ); 

create table Contrats
    (id_Enseignant number(4) references Formateur
    , societe varchar2(32)
    , constraint pk_contrat primary key (id_Enseignant,societe) 
    );
create table Formation 
    (societe varchar2(32)
    ,matiere varchar2(32)
    , constraint pk_formation primary key (societe,matiere)
    );
    
create table enseignantSanscontrat
    (id_enseignant number(4) primary key
    );
    
insert into formateur values (1,'n1' , 'p1', 1000, to_date('1980/01/01','YYYY/MM/DD'));    
insert into formateur values (2,'n2' , 'p2', 1200, to_date('1980/01/01','YYYY/MM/DD'));   
insert into formateur values (3,'n3' , 'p3', 1300, to_date('1980/01/01','YYYY/MM/DD'));   
insert into formateur values (4,'n4' , 'p4', 1400, to_date('1980/01/01','YYYY/MM/DD'));   

insert into contrats values (1,'IBM');
insert into contrats values (2,'IBM');
insert into contrats values (2,'SUN');
insert into contrats values (3,'IBM');


insert into competence values (1,'oracle');
insert into competence values (2,'oracle');
insert into competence values (3,'oracle');
insert into competence values (3,'java');

accept x1 prompt ' donner une soc x1' ;
accept x2 prompt ' donner une soc x2';
declare 
 cursor cs1(x varchar2, y varchar2, z varchar2)  is select nom from formateur where id_enseignant in
 (select id_enseignant from contrats where societe=x and id_enseignant in 
 (select id_enseignant from competence where matiere=y 
 minus (select id_enseignant from competence where matiere=z)));

cptx1 number:=0;
cptx2 number:=0;
begin
DBMS_OUTPUT.put_line('liste des enseignants qui ont signe avec ' || '&x1');
for Ens1 in cs1('&x1','oracle','java') loop
    DBMS_OUTPUT.put_line(Ens1.nom);
    cptx1:=cptx1+1;
end loop;

DBMS_OUTPUT.put_line('liste des enseignants qui ont signe avec ' || '&x2');
for Ens2 in cs1('&x2','oracle','java') loop
    DBMS_OUTPUT.put_line(Ens2.nom);
    cptx2:=cptx2+1;
end loop;

if (cptx2>cptx1) then DBMS_OUTPUT.put_line('cest '|| '&x2' || ' qui a plus de contrats que ' || '&x1');
elsif (cptx2<cptx1) then DBMS_OUTPUT.put_line('cest '|| '&x1' || ' qui a plus de contrats que ' || '&x2');
else DBMS_OUTPUT.put_line('&x2' || ' a autant de contrats que ' || '&x1');
end if;
end;
/

