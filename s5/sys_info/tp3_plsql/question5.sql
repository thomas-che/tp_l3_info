create or replace function MasseSalariale (numService IN NUMBER) 
return number 
    -- prend en entrée un numéro du service et qui renvoie la masse salariale de ce service. Rendre0 si le service ne compte aucun salarié
IS
    masseSal number;
begin
-- nvl(sal,0) pr avoir 0 a la plase de null
    SELECT sum(nvl(sal,0)+nvl(vac,0)) INTO masseSal From drh WHERE numServ=numService; 
    return masseSal; -- return pas le 0
end;
/

SELECT MasseSalariale(1) From Dual;
SELECT MasseSalariale(2) From Dual;


ALTER TABLE Serv
DROP (
    BUDGET
);

ALTER TABLE Serv
ADD (
    BUDGET NUMBER(8)
);


DECLARE
	CURSOR C1 IS SELECT numserv FROM Serv FOR UPDATE of BUDGET;
BEGIN
	FOR ligne IN C1 LOOP
		UPDATE Serv SET BUDGET=MasseSalariale(ligne.numserv) WHERE CURRENT OF C1;
    END LOOP;
END;
/

SELECT * FROM Serv;


CREATE OR REPLACE TRIGGER AfterUpdateDrhBudjet
AFTER UPDATE OR INSERT OR DELETE ON drh
FOR EACH ROW
    --  Mettre  à  jour  automatiquement  cette  colonne  à  chaque  mouvement  de  salarié  (nouvelle embauche d’un salarié dans un service, débauche d’un salarié, promotion d’un salarié, etc.).
DECLARE
    
BEGIN
    IF DELETING THEN
        UPDATE Serv SET BUDGET=BUDGET-(nvl(:OLD.sal,0) + nvl(:OLD.vac,0)) WHERE numServ= :OLD.numServ;
    ELSIF INSERTING THEN
        UPDATE Serv SET BUDGET=BUDGET+(nvl(:NEW.sal,0) + nvl(:NEW.vac,0)) WHERE numServ= :NEW.numServ;
    ELSE
        -- prof rajout du if :new.sal <> :old.sal
        IF ( (nvl(:NEW.sal,0) <> nvl(:OLD.sal,0)) OR (nvl(:NEW.vac,0) <> nvl(:OLD.vac,0)) ) THEN
            UPDATE Serv SET BUDGET=BUDGET+(nvl(:NEW.sal,0) - nvl(:OLD.sal,0) + nvl(:NEW.vac,0) - nvl(:OLD.vac,0)) WHERE numServ= :NEW.numServ;
        END IF;
    END IF;
END;
/

-- test
Delete From Drh Where mat =5900;
Delete From Drh Where mat =5800;
Insert Into Drh Values(5708,'MARCEL',5344,'FORMATEUR',SYSDATE,600,550,1);
Update Drh Set emploi ='ADMINISTRATIF',vac = NULL Where mat =5712;
Select * from serv;





