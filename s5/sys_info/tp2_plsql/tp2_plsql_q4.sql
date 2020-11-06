-- correction

CREATE OR REPLACE TRIGGER BeforeAddImage
BEFORE INSERT ON Image
FOR EACH ROW
DECLARE
    libre client.espacestockagedispo%TYPE;
BEGIN
-- on controle que la taille de l'emplacement libre de l'espace de stockage es > a la taille de l'image
    SELECT espaceStockageDispo INTO libre FROM 
        (SELECT * FROM Album WHERE idAlbum=:NEW.idAlbum)
            JOIN
        Client
            ON EmailUtilisateur=eMailClient; 
    
    IF libre < :NEW.taille THEN
        raise_application_error(-20001,'error ajout image, espace dtockahge depaser');
    END IF;
END;
/

-- test erreur
INSERT INTO Image VALUES (11,3,'i11_3',2,NULL,SYSDATE);