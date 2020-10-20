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


accept nomF prompt ' donnez le nom dun formateur'; 
declare 
cursor cs is select societe from contrats where id_enseignant=(select id_enseignant from formateur where nom='&nomF');
nb number:=0;
liste varchar(32);
begin
liste := '';
for Soc in cs loop 
   nb:=nb+1;
   if nb=1 then 
    liste:=Soc.societe; 
   else 
    liste:=liste || '-' || Soc.societe ; 
    
   end if; 
end loop;
if nb=0 then 
    DBMS_OUTPUT.put_line('aucun contrat pour lenseignat' || ' &nomF');
elsif nb=1 then  
    DBMS_OUTPUT.put_line('lenseignat' || ' &nomF' || ' a fait 1 contrat avec ' || liste);
else    
    DBMS_OUTPUT.put_line('lenseignat' || ' &nomF' || ' a fait ' || nb || ' contrats avec : ' || liste);
end if;
end;
/