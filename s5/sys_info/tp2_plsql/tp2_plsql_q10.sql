-- correction
create or replace function PertinenceImage (idAlb IN NUMBER, numImg IN NUMBER) 
return NUMBER
IS
    nb NUMBER;
    pertinence NUMBER;
begin
    -- pas opti car on fait 2 fois la requete
    SELECT Count(*) INTO nb FROM Notation
    Where idAlbum=idAlb and numImage=numImg;
    
    If nb = 0 then
        return -1;
    else
        Select round(avg(note)*sqrt(nb),2) into pertinence From Notation
        Where idAlbum=idAlb and numImage=numImg;
        
        return pertinence;
    end if;
end;
/
