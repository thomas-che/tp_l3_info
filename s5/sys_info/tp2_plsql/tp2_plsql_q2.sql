create or replace function Occupe (email IN varchar2) return number as
    nb number;
begin
    -- nvl permet si pas de valeur on met un 0 par default 
    Select NVL(sum(taille),0) into nb from Image 
        Natural JOIN
    (select idalbum from Album where eMailClient=email);
    return(nb);
end;
/

select Occupe('u1@') from dual;