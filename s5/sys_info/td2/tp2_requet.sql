-- requete sql

-- q1
SELECT nom FROM Formateur 
    NATURAL JOIN
    (SELECT * FROM  (
                    SELECT id_Enseigant FROM Competence WHERE matiere='oracle'
                        MINUS
                    (SELECT id_Enseigant FROM Competence WHERE matiere='java')
                    )
    )   
;


-- q2
SELECT AVG(TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(date_naiss,'YYYY')) FROM Formateur;

CREATE OR REPLACE View Ens (id_Enseigant, age) AS
    (SELECT id_Enseigant,TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(date_naiss,'YYYY')  FROM Formateur);

SELECT avg(age) from Ens;

-- q3

SELECT nom, prenom FROM Formateur
    Natural Join
(Select * FROM Ens WHERE age=(Select min(age) from Ens));


-- q4
SELECT nom, prenom FROM Formateur
NATURAL JOIN 
Contracts
Natural join (
SELECT societe From Formation
    Minus
(SELECT societe FROM Formation Where matiere='oracle')
);

-- q5

SELECT nom, prenom FROM Formateur 
    NATURAL JOIN
    (
       SELECT id_Enseigant FROM Competence Group BY id_Enseigant Having count(*)>=3
    )
;


-- q6

Select T1.id_Enseigant, T2.id_Enseigant From (
(SELECT id_Enseigant, matiere FROM Competence )T1
Join 
(SELECT id_Enseigant, matiere FROM Competence ) T2
ON T1.id_Enseigant < T2.id_Enseigant AND T1.matiere = T2.matiere
); 


-- q7

Select matiere, COUNT(*) From Competence GROUP BY matiere;


-- q8

SELECT matiere FROM Formation;



-- q9

SELECT matiere From Competence Minus (SELECT matiere FROM Formation);



-- q10

Select * From 
(
    Select matiere, COUNT(*) nb From Formation GROUP BY matiere
)
 WHERE nb=
        (Select COUNT(DISTINCT societe) From Formation)
;

-- q11


Select matiere From Formation WHERE societe='ibm'
MINUS
Select matiere From Formation Where societe<>'ibm';


--q12

SELECT matiere From Competence Minus (SELECT matiere FROM Formation)
OR (
Select matiere From Formation WHERE societe='ibm'
MINUS
Select matiere From Formation Where societe<>'ibm');
