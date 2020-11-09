CREATE OR REPLACE TRIGGER AfterUpdateDrh
AFTER UPDATE OR INSERT OR DELETE ON drh
FOR EACH ROW
    --  mettra à jour les colonnes NBPERS ou NBFORM impactées par ces modifications
DECLARE
    
BEGIN
    
    IF DELETING THEN
        IF :OLD.emploi = 'FORMATEUR' THEN
            UPDATE Serv SET NBPERS=NBPERS-1, NBFORM=NBFORM-1 WHERE numServ= :OLD.numServ;
        ELSE
            UPDATE Serv SET NBPERS=NBPERS-1 WHERE numServ= :OLD.numServ;
        END IF;
       
    ELSIF INSERTING THEN
        IF :NEW.emploi = 'FORMATEUR' THEN
            UPDATE Serv SET NBPERS=NBPERS+1, NBFORM=NBFORM+1 WHERE numServ= :NEW.numServ;
        ELSE
            UPDATE Serv SET NBPERS=NBPERS+1 WHERE numServ= :NEW.numServ;
        END IF;
    ELSE
        IF :NEW.emploi = 'FORMATEUR' AND :OLD.emploi <> 'FORMATEUR' THEN
            UPDATE Serv SET NBFORM=NBFORM+1 WHERE numServ= :NEW.numServ;
        ELSIF :NEW.emploi <> 'FORMATEUR' AND :OLD.emploi = 'FORMATEUR' THEN
            UPDATE Serv SET NBFORM=NBFORM-1 WHERE numServ= :NEW.numServ;
       
        END IF;
    END IF;
END;
/


-- test
Update Drh Set emploi ='FORMATEUR',vac =300 Where mat =5712;
Delete From Drh Where mat =5708;
Insert Into Drh Values(5800,'MAURICE',5617,'CHEF',SYSDATE,12000,0,2);
Insert Into Drh Values(5900,'SERGE',5476,'FORMATEUR',SYSDATE,5000,1000,3);
select*from serv;
select*from drh;







-- info prof :

-- rappeler que le messqge table is mutating apparait pour les trigger for eqch row dès qu on essaye dans le corps du trigger a toucher 
-- a la table du trigger excpeté si c'est un before insert et que le insert declencheur n insert qu une seule ligne 
-- du coup on ne peut pas utiliser les fonctions nbformateur et nbemplye car elle accede a la table qui lance le trigger
-- du coup comme on peut faire  update serv set nbform=nbform+1  et de facon general des set x=x+y alors on peut s'en sortir sans ces fonctions