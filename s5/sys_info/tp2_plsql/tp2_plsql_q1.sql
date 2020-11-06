create or replace function NbImage (email IN varchar2) return number as
    nb number;
begin
    --Select count(*) into nb from Image 
    --    Natural JOIN
    --(select idalbum from Album where eMailClient=email);
    
    -- requete optimiser correction
    Select count(*) into nb from 
        (select * from Album where eMailClient=email) 
            NATURAL JOIN 
        Image;

    
    
    return(nb);
end;
/

select NbImage('u1@') from dual;