accept nomF prompt ' donnez le nom dun formateur'; 
declare 
nb number;
begin
select count(*) into nb from contrats where id_enseignant=(select id_enseignant from formateur where nom='&nomF');
DBMS_OUTPUT.put_line('lenseignat' || ' &nomF' || ' a fait ' || nb || ' contrats');
end;
/