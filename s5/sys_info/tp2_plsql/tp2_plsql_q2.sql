create or replace function NbImage (email IN varchar2) return number as
    nb number;
begin
    Select count(*) into nb from Image 
        Natural JOIN
    (select idalbum from Album where eMailClient=email);
    return(nb);
end;
/

select NbImage('u1@') from dual;