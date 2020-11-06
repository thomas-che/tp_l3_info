ALTER TABLE Client
ADD (
    nombreImage NUMBER(4),
    espaceStockageDispo NUMBER(4)
);

SELECT eMailUtilisateur,nombreImage,espaceStockageDispo FROM Client;

-- corretion pas besoin d'un cursor, on pas specifier le where ducoup il fait pr toute les lignes de Client
UPDATE Client
    SET nombreImage = NbAlbumPublic(eMailUtilisateur)
        , espaceStockageDispo = quota - Occupe(eMailUtilisateur);


SELECT eMailUtilisateur,nombreImage,espaceStockageDispo FROM Client;