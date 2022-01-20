-- correction
create or replace function MontantCommande (numCo IN varchar2, idLabo IN varchar2) 
return number 
IS
    tarifCom number;
    reduc number;
begin
    -- requete pas opti, diretc prendre dans chaque table quand le idComande est le bon
    SELECT sum(quantite * prixUnitaire) INTO tarifCom From TirageImages 
    Natural join Tirage Natural join TarifFormat
    WHERE numCommande=numCo AND idLaboratoire = idLabo;
    
    reduc := ReductionCommande (numCo, idLabo);
    return tarifCom*(1 - reduc/100);
end;
/


select MontantCommande('cu1l1_1','l1') from dual;

--select * from client where substr(region,1,3)='Cen';
-- select * from client where region LIKE 'Cen%';