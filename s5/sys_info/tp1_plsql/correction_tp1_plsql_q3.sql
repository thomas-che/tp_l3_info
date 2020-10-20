drop table formateur cascade constraints;
drop table competence cascade constraints;
drop table contrats cascade constraints;
drop table formation cascade constraints;

create table Formateur 
    (id_Enseignant number(4) primary key 
    , nom varchar2(32)
    , prénom varchar2(32)
    , date_naiss date
    );
    
create table Competence
    (id_Enseignant number(4) primary key references Formateur 
    , matiere varchar2(32)
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
    
insert into formateur values (1,'n1' , 'p1', to_date('1980/01/01','YYYY/MM/DD'));    
insert into formateur values (2,'n2' , 'p2', to_date('1980/01/01','YYYY/MM/DD'));   
insert into contrats values (1,'IBM');
insert into contrats values (2,'IBM');
insert into contrats values (2,'SUN');



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