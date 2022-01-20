-- correction
CREATE OR REPLACE TRIGGER AvantAjoutTarifDegressif
BEFORE INSERT
ON TarifDegressif
FOR EACH ROW
DECLARE
    pb NUMBER
BEGIN
    -- controle de la forchette disjointe des autres forchettes
    SELECT Count(*) INTO pb 
    FROM TarifDegressif 
    WHERE idLaboratoire =:NEW.idLaboratoire
        AND NOT
        ( :NEW.quantiteMaxi < quantiteMini
          OR :NEW.quantiteMini > quantiteMaxi);
    IF pb <> 0 THEN
        -- new forchette chevauchement
        raise_application_error(-20002,'PB chevauchement');
    END IF;
END;
/

SELECT * FROM tarifdegressif;
INSERT INTO tarifdegressif VALUES ('12',1001,2000,51);
SELECT * FROM tarifdegressif;
INSERT INTO tarifdegressif VALUES ('12',0,30,10);