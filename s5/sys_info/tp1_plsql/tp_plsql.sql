-- drop table

DROP TABLE Formation ;
DROP TABLE Contracts ;
DROP TABLE Competence ;
DROP TABLE Formateur ;

-- creat table

CREATE TABLE Formateur (
    id_Enseigant                NUMBER(8) NOT NULL
    , nom                       VARCHAR2(32) NOT NULL
    , prenom                    VARCHAR2(32) NOT NULL
    , date_naiss                DATE NOT NULL
    , CONSTRAINT PK_Formateur PRIMARY KEY (id_Enseigant)  
);

CREATE TABLE Competence (
    id_Enseigant                NUMBER(8) NOT NULL
    , matiere                   VARCHAR2(64) NOT NULL
    , CONSTRAINT PK_Competence PRIMARY KEY (id_Enseigant,matiere)
    --, CONSTRAINT FK_Competence_Formateur FOREIGN KEY (id_Enseigant) REFERENCES Formateur (id_Enseigant)
    --, CONSTRAINT FK_Competence_Formation FOREIGN KEY (matiere) REFERENCES Formation (matiere)
);

CREATE TABLE Contracts (
    id_Enseigant                NUMBER(8) NOT NULL
    , societe                   VARCHAR2(64) NOT NULL
    , CONSTRAINT PK_Contracts PRIMARY KEY (id_Enseigant,societe)
    --, CONSTRAINT FK_Contracts_Formateur FOREIGN KEY (id_Enseigant) REFERENCES Formateur (id_Enseigant)
    --, CONSTRAINT FK_Contracts_Foration FOREIGN KEY (societe) REFERENCES Formation (societe)
);

CREATE TABLE Formation (
    societe                VARCHAR2(64) NOT NULL
    , matiere              VARCHAR2(64) NOT NULL
    , CONSTRAINT PK_Formation PRIMARY KEY (societe,matiere)
    --, CONSTRAINT FK_Formation_Competence FOREIGN KEY (matiere) REFERENCES Competence (matiere)
    --, CONSTRAINT FK_Formation_Contracts FOREIGN KEY (societe) REFERENCES Contracts (societe)
);



-- inster value table

Insert Into Formateur(id_Enseigant,nom,prenom,date_naiss) Values ('1','DUPONT','Michel',to_date('01/05/1991', 'DD/MM/YYYY'));
Insert Into Formateur(id_Enseigant,nom,prenom,date_naiss) Values ('2','JACK','Thomas',to_date('25/05/1988', 'DD/MM/YYYY'));
Insert Into Formateur(id_Enseigant,nom,prenom,date_naiss) Values ('3','JEAN','Romain',to_date('12/11/1956', 'DD/MM/YYYY'));

Insert Into Competence(id_Enseigant,matiere) Values ('1','oracle');
Insert Into Competence(id_Enseigant,matiere) Values ('1','java');
Insert Into Competence(id_Enseigant,matiere) Values ('2','oracle');
Insert Into Competence(id_Enseigant,matiere) Values ('2','c++');
Insert Into Competence(id_Enseigant,matiere) Values ('2','python');
Insert Into Competence(id_Enseigant,matiere) Values ('3','java');
Insert Into Competence(id_Enseigant,matiere) Values ('3','php');

Insert Into Contracts(id_Enseigant,societe) Values ('1','ibm');
Insert Into Contracts(id_Enseigant,societe) Values ('1','ca');
Insert Into Contracts(id_Enseigant,societe) Values ('2','ibm');
Insert Into Contracts(id_Enseigant,societe) Values ('2','sopra');
Insert Into Contracts(id_Enseigant,societe) Values ('2','ca');
Insert Into Contracts(id_Enseigant,societe) Values ('3','sopra');
Insert Into Contracts(id_Enseigant,societe) Values ('3','apple');

Insert Into Formation(societe,matiere) Values ('ibm','oracle');
Insert Into Formation(societe,matiere) Values ('ibm','php');
Insert Into Formation(societe,matiere) Values ('sopra','java');
Insert Into Formation(societe,matiere) Values ('sopra','php');
Insert Into Formation(societe,matiere) Values ('ca','php');
Insert Into Formation(societe,matiere) Values ('ca','python');




