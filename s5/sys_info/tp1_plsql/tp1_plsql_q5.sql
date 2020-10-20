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


select * from formateur;

declare
    Cursor cx is select * from formateur for update of salaire;
    tt number;
    nb number;
begin
    for ligne in cx loop
        select count(*) into nb from contracts where id_enseigant = ligne.id_enseignant;
        if nb >= 30 then
            tt := ligne.salaire + ligne.salaire * 0.3;
        elsif nb >= 20 then
            tt := ligne.salaire + ligne.salaire * 0.2;
        elsif nb >= 10 then
            tt := ligne.salaire + ligne.salaire * 0.1;
        elsif nb = 0 then
            tt := ligne.salaire - ligne.salaire * 0.1;
        else 
            tt := ligne.salaire;
        end if;
        update formateur set salaire=tt where current of cx;
    end loop;
end;
/

select * from formateur;


























