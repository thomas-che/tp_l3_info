-- q1
set serveroutput on

accept nom_es prompt 'entez le nom du prof : ';

DECLARE
    num_contact NUMBER;
    
BEGIN

Select nb into num_contact From 
 (Select id_Enseigant, COUNT(*) nb From Contracts GROUP BY id_Enseigant)
    NATURAL JOIN
 (SELECT * from Contracts WHERE id_Enseigant= (SELECT id_Enseigant From Formateur WHERE prenom='&nom_es'))
;

DBMS_OUTPUT.PUT('hello');
DBMS_OUTPUT.PUT_LINE('hello');
dbms_output.put_line('hello');
dbms.output.put.line('le formateur ' || '&nom_es' || ' a signe des contrats avec ' || num_contact || ' societes');

END;
/


--Select id_Enseigant,nb From  
--( 
--    Select id_Enseigant, COUNT(*) nb From Contracts GROUP BY id_Enseigant 
--) 
-- WHERE id_Enseigant= (SELECT id_Enseigant From Formateur WHERE prenom='Thomas') 

