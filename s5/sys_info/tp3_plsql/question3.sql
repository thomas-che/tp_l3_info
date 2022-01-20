SELECT * FROM serv;

ALTER TABLE Serv
DROP (
    NBPERS,
    NBFORM
);

ALTER TABLE Serv
ADD (
    NBPERS NUMBER(4),
    NBFORM NUMBER(4)
);


DECLARE
	CURSOR C IS SELECT * FROM Serv FOR UPDATE of NBPERS, NBFORM;
BEGIN
	FOR ligne IN C LOOP
		UPDATE Serv SET NBPERS=NbEmploye(ligne.numServ), NBFORM=NbFormateur(ligne.numServ) WHERE CURRENT OF C;
    END LOOP;
END;
/


SELECT * FROM Serv;



