
CREATE OR REPLACE TRIGGER BeforeUpdateVacation
BEFORE UPDATE OR INSERT ON drh
FOR EACH ROW
    -- Seuls les formateurs ont droit à une vacation
DECLARE
    
BEGIN
    IF (:NEW.emploi = 'FORMATEUR' AND :NEW.vac IS NULL) THEN
            raise_application_error(-20001,'Un formateur a droit à une vacation !');
    ELSIF (:OLD.emploi = 'FORMATEUR' AND :NEW.vac IS NOT NULL) THEN
        raise_application_error(-20002,'Un non formateur n a pas droit à une vacation !');
    END IF;
END;
/




-- test
Update Drh Set emploi = 'FORMATEUR' Where mat =5712;
Update Drh Set emploi = 'ADMINISTRATIF' Where mat =5708;
