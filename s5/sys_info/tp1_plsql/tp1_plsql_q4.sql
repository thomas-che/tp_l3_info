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


declare
    cursor cx is select * from formateur;
    cursor cx2(monF  formateur.id_enseignant%type) is select societe from contrats where id_enseignant=monF ;
    nb number := 0;
    str varchar(32) := ' ';
begin
    for es in cx loop
        nb :=0;
        str := '';
        
        for soc in cx2(es.id_enseignant) loop
            nb := nb +1;
            if nb = 1 then
                str := soc.societe;
            else
                str := str || '-' || soc.societe;
            end if;
        end loop;
        if nb = 0 then
            DBMS_OUTPUT.put_line('Le formateur ' || es.nom || ' a signe 0 contact');
            insert into enseignantSanscontrat values(es.id_enseignant);
        elsif nb = 1 then
           DBMS_OUTPUT.put_line('Le formateur ' || es.nom || ' a signe 1 contact avec ' || str);
        else
            DBMS_OUTPUT.put_line('Le formateur ' || es.nom || ' a signe des contacts avec ' || nb || ' qui sont : ' || str);
        end if;
    end loop;
    
end;
/

select * from enseignantsanscontrat;


