create or replace function NbEmploye (numService IN NUMBER) 
return number 
    -- prend en entrée un  numéro du service et qui renvoie le nombre (il peut être égal à 0) d’employés dans ce service
IS
    nbEmploye number;
begin
    SELECT count(*) INTO nbEmploye From drh WHERE numServ=numService;
    
    return nbEmploye;
end;
/


create or replace function NbFormateur (numService IN NUMBER) 
return number 
    -- prend en entrée un numéro du service et qui renvoie le nombre (il peut être égal à 0) de formateur dans ceservice
IS
    nbFormateur number;
begin
    SELECT count(*) INTO nbFormateur From drh WHERE numServ=numService AND emploi='FORMATEUR';
    
    return nbFormateur;
end;
/


SELECT NbEmploye(1) FROM Dual;

SELECT NbFormateur(1) FROM Dual;
SELECT NbFormateur(4) FROM Dual;