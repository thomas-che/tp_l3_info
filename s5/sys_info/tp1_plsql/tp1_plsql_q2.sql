accept nomF prompt ' donnez le nom dun formateur'; 
declare 
nb number;
begin
select count(*) into nb from contrats where id_enseignant=(select id_enseignant from formateur where nom='&nomF');

DBMS_OUTPUT.put_line('');
DBMS_OUTPUT.put_line('###############');
DBMS_OUTPUT.put_line('');

if nb <= 0 then
    DBMS_OUTPUT.put_line('Aucun contract signe de la part de' || ' &nomF');
elsif nb = 1 then
    DBMS_OUTPUT.put_line('Un seul contract signe de' || ' &nomF');
else
    DBMS_OUTPUT.put_line('l enseignat' || ' &nomF' || ' a fait ' || nb || ' contrats');
end if;

DBMS_OUTPUT.put_line('');
DBMS_OUTPUT.put_line('###############');
DBMS_OUTPUT.put_line('');
end;
/