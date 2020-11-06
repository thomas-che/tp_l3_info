-- correction

create or replace function ReductionCommande (numCo IN varchar2, idLabo IN varchar2) 
return number 
IS
    qteT number;
    existe number;
    reduc number;
begin
    SELECT sum(quantite) INTO qteT From TirageImages WHERE numCommande=numCo;
    
    select count(*) into existe
    From tarifdegressif
    Where idLaboratoire = idLabo
    AND qteT BETWEEN quantiteMini and quantiteMaxi;
    
    -- pb on relance la requete, le mieux de faire cursor parameter
    if existe = 0 then
        return 0;
    else
        select reduction into reduc
        From tarifdegressif
        Where idLaboratoire = idLabo
        AND qteT BETWEEN quantiteMini and quantiteMaxi;
    
        RETURN reduc;
    end if;
end;
/


-- moi

create or replace function ReductionCommande2 (numCo IN varchar2, idLabo IN varchar2) 
return number 
as
    nbImage number;
    redrc DECIMAL;
    idAlb varchar2;
begin
    SELECT idAlbum INTO idAlb From TirageImages WHERE numCommande='numCo';
    
    Select count(*) into nbImage from 
        (select * from Album where idAlbum=idAlb) 
            NATURAL JOIN 
        Image;
    
    select reduction into redrc FROM TarifDegressif where idlaboratoire=idLabo AND nbImage <= quantiteMaxi AND quantiteMini <= nbImage;
    
    return(redrc);
end;
/


--SELECT reduction FROM tarifdegressif where 22 < quantiteMaxi AND quantiteMini < 22;
--select reduction FROM TarifDegressif where idlaboratoire = '11' AND 22 < quantiteMaxi AND quantiteMini < 22;