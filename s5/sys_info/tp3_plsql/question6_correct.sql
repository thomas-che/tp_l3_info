-- correction du prof
-- pas le tps de finir


create or replace trigger question6a before update of emploi on drh 

 for each row

 begin
 
if (:new.emploi='FORMATEUR' and :new.vac is null) then 

   raise_application_error(-20200,'un formateur a droit a des vac !');

 end if;  
 
if (:new.emploi!='FORMATEUR' and :new.vac is not null) then

   raise_application_error(-20201,'seul les formateurs ont droit à des vac ! ');

 end if; 
 
end;

 /
 


 create or replace trigger question6b before insert or update of mat,matchef on drh 

 for each row

 begin
 
if (:new.mat=:new.matchef) then 

   raise_application_error(-20200,'Un salarié ne doit pas être son propre chef !');

 end if;  
 
end;

 /
 


 create or replace trigger question6c before update of dateemb on drh 

 for each row

 begin
 
if (:new.dateemb!=:old.dateemb) then 

   raise_application_error(-20200,'La date d embauche d un salarié est non modifiable !');

 end if;  
 
end;

 /
 
-- Attention au null dans les vac donc obligé de passer par les nvl

 create or replace trigger question6d before update of sal,vac  on drh 

 for each row

 begin
 
if (:new.sal+nvl(:new.vac,0)<:old.sal+nvl(:old.vac,0)) then 

   raise_application_error(-20200,'Le salaire d un employé ne doit jamais diminuer');

 end if;  
 
end;

 /