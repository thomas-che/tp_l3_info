-- correction
create or replace function ChoixLaboratoire (numCo IN varchar2) 
return Varchar2 
IS
    idLab Varchar2;
begin
    SELECT idLaboratoire INTO idLab From Laboratoire 
    WHERE MontantCommande(numCo, idLaboratoire) <= ALL (select MontantComande(numCo, idLaboratoire) from Laboratoire) ;
    
    Return idLab;
    
Exception
    When TOO_MANY_ROWS then
        return 'plusieur labo au meme prix min';
end;
/

SELECT ChoixLaboratoire ('cu1l1_1') from Dual;