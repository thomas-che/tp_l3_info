create or replace function NbEmploye (numService IN NUMBER) 
return number 
    -- prend en entr�e un  num�ro du service et qui renvoie le nombre (il peut �tre �gal � 0) d�employ�s dans ce service
IS
    nbEmploye number;
begin
    SELECT count(*) INTO nbEmploye From drh WHERE numServ=numService;
    
    return nbEmploye;
end;
/


create or replace function NbFormateur (numService IN NUMBER) 
return number 
    -- prend en entr�e un num�ro du service et qui renvoie le nombre (il peut �tre �gal � 0) de formateur dans ceservice
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