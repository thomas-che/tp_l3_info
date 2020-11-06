
-- correction

CREATE OR REPLACE TRIGGER AfterAddImage
AFTER INSERT ON Image
FOR EACH ROW
DECLARE
    emailU album.emailclient%TYPE; 
BEGIN
    SELECT eMailClient INTO emailU FROM Album WHERE idAlbum=:NEW.idAlbum;
    
    -- pas bessoin de recalculer le tout
    UPDATE Client
    SET nombreImage = nombreImage + 1
        , espaceStockageDispo = espaceStockageDispo - :NEW.taille
    WHERE eMailUtilisateur = emailU;
END;
/

INSERT INTO Image VALUES (41,3,'i41_3',2,NULL,SYSDATE);
