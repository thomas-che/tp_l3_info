create or replace function Occupe (email IN varchar2) return number as
    nb number;
begin
    Select sum(taille) into nb from Image 
        Natural JOIN
    (select idalbum from Album where eMailClient=email);
    return(nb);
end;
/

select Occupe('u1@') from dual;