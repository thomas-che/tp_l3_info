-- scrip sql qui permet de cree la bdd avec les 4 fic du prof

DROP TABLE Serv  CASCADE CONSTRAINTS;
DROP TABLE Drh   CASCADE CONSTRAINTS;
-- -----------------------------------------------------------------------------
--       TABLE : Serv
-- -----------------------------------------------------------------------------
CREATE TABLE Serv (
	numServ		numBER(2)    NOT NULL
	, nomServ	VARCHAR2(14)
	, lieu		VARCHAR2(8)  
	, CONSTRAINT PK_Serv PRIMARY KEY (numServ)  
);
-- -----------------------------------------------------------------------------
--       TABLE : Drh
-- -----------------------------------------------------------------------------
CREATE TABLE Drh ( 
	mat			numBER(4)    NOT NULL
	, nom		VARCHAR2(10)
	, matChef	numBER(4)
	, emploi	VARCHAR2(15)
	, dateEmb	DATE
	, sal		numBER(7,2)
	, vac		numBER(7,2)
	, numServ	numBER(2)  
	, CONSTRAINT PK_Drh PRIMARY KEY (mat)  
);



INSERT INTO Drh VALUES
	(5147,'BASILE',5344,'FORMATEUR',to_date('23/01/85','DD/MM/YY'),1300,190,1);
INSERT INTO Drh VALUES
	(5277,'GENEVIEVE',5476,'FORMATEUR',to_date('03/05/82','DD/MM/YY'),1400,300,3);
INSERT INTO Drh VALUES
	(5319,'RAYMOND',5476,'FORMATEUR',to_date('03/05/85','DD/MM/YY'),1250,850,3);
INSERT INTO Drh VALUES
	(5344,'LUCIEN',5617,'CHEF',to_date('23/07/82','DD/MM/YY'),2000,NULL,1);
INSERT INTO Drh VALUES
	(5432,'ALIX',5476,'FORMATEUR',to_date('08/02/81','DD/MM/YY'),800,100,3);
INSERT INTO Drh VALUES
	(5476,'GUILLAUME',5617,'CHEF',to_date('17/03/84','DD/MM/YY'),1850,NULL,3);
INSERT INTO Drh VALUES
	(5560,'PAULIN',5617,'CHEF',to_date('09/11/86','DD/MM/YY'),1550,NULL,4);
INSERT INTO Drh VALUES
	(5566,'TATIANA',5344,'FORMATEUR',to_date('09/12/80','DD/MM/YY'),1850,30,1);
INSERT INTO Drh VALUES
	(5617,'YVETTE',NULL,'PRESIDENT',to_date('01/04/80','DD/MM/YY'),3800,NULL,4);
INSERT INTO Drh VALUES
	(5622,'NINA',5476,'SECRETAIRE',to_date('28/11/81','DD/MM/YY'),900,NULL,3);
INSERT INTO Drh VALUES
	(5654,'RENE',5344,'FORMATEUR',to_date('02/09/81','DD/MM/YY'),700,190,1);
INSERT INTO Drh VALUES
	(5708,'MARCEL',5344,'FORMATEUR',to_date('22/05/87','DD/MM/YY'),600,550,1);
INSERT INTO Drh VALUES
	(5700,'ROSELINE',5344,'SECRETAIRE',to_date('20/11/83','DD/MM/YY'),1800,NULL,1);
INSERT INTO Drh VALUES
	(5712,'MARIUS',5566,'ADMINISTRATIF',to_date('17/09/82','DD/MM/YY'),800,NULL,4);


INSERT INTO Serv VALUES
	(1,'INFORMATIQUE','BAT 688');
INSERT INTO Serv VALUES
	(2,'PRODUCTIQUE','BAT 680');
INSERT INTO Serv VALUES
	(3,'ELECTRONIQUE','BAT 688');
INSERT INTO Serv VALUES
	(4,'ADMINISTRATION','BAT 607');


-- -----------------------------------------------------------------------------
--       CREATION DES REFERENCES DE TABLE
-- -----------------------------------------------------------------------------

ALTER TABLE Drh ADD (
      CONSTRAINT FK_Drh_Drh
           FOREIGN KEY (matChef)
               REFERENCES Drh (mat))   ;

ALTER TABLE Drh ADD (
      CONSTRAINT FK_Drh_Serv
          FOREIGN KEY (numServ)
                REFERENCES SERV (numServ))   ;
                
                
DESC Serv

SELECT * FROM Serv;

DESC Drh

SELECT * FROM Drh;

Select TABLE_NAME, substr(COLUMN_NAME,1,30), CONSTRAINT_NAME
From  USER_CONS_COLUMNS
Where CONSTRAINT_NAME NOT LIKE 'SYS%'
And   TABLE_NAME In ('SERV','DRH')
Order By 1, 2, 3;




SELECT * FROM Serv;
