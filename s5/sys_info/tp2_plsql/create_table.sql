-- (4)
DROP TABLE TirageImages CASCADE CONSTRAINTS;
DROP TABLE Notation CASCADE CONSTRAINTS;
-- (3)
DROP TABLE Tirage CASCADE CONSTRAINTS;
DROP TABLE Image CASCADE CONSTRAINTS;
-- (2)
DROP TABLE Commande CASCADE CONSTRAINTS;
DROP TABLE CarteBancaire CASCADE CONSTRAINTS;
DROP TABLE Album CASCADE CONSTRAINTS;
-- (1)
DROP TABLE TarifFormat CASCADE CONSTRAINTS;
DROP TABLE TarifDegressif CASCADE CONSTRAINTS;
DROP TABLE Client CASCADE CONSTRAINTS;
-- (0)
DROP TABLE Utilisateur CASCADE CONSTRAINTS;
DROP TABLE TypePapier CASCADE CONSTRAINTS;
DROP TABLE Laboratoire CASCADE CONSTRAINTS;
DROP TABLE FormatPapier CASCADE CONSTRAINTS;

-- (0)
CREATE TABLE FormatPapier (
    idFormat                    VARCHAR2(8) NOT NULL
    , libelleFormat             VARCHAR2(32)
    , largeur                   NUMBER(6,2)
    , hauteur                   NUMBER(6,2)
    , CONSTRAINT PK_FormatPapier PRIMARY KEY (idFormat)  
);

CREATE TABLE Laboratoire (
    idLaboratoire               VARCHAR2(8) NOT NULL
    , raisonSociale             VARCHAR2(32)
    , adressePostaleLabo        VARCHAR2(128)
    , eMailLabo                 VARCHAR2(64)
    , telLabo                   VARCHAR2(10)  
    , CONSTRAINT PK_Laboratoire PRIMARY KEY (idLaboratoire)  
);

CREATE TABLE TypePapier (
    idTypePapier                VARCHAR2(8) NOT NULL
    , libelleTypePapier         VARCHAR2(32)  
    , CONSTRAINT PK_TypePapier PRIMARY KEY (idTypePapier)  
);

CREATE TABLE Utilisateur (
    eMailUtilisateur            VARCHAR2(64)  NOT NULL
    , CONSTRAINT PK_Utilisateur PRIMARY KEY (eMailUtilisateur)  
);

-- (1)
CREATE TABLE Client (
    eMailUtilisateur            VARCHAR2(64)  NOT NULL
    , nomClient                 VARCHAR2(32)
    , login                     VARCHAR2(16)
    , motDePasse                VARCHAR2(16)
    , adressePostaleClient      VARCHAR2(128)
    , region                    VARCHAR2(32)
    , telClient                 VARCHAR2(10)
    , quota                     NUMBER(4)  
    , CONSTRAINT PK_Client PRIMARY KEY (eMailUtilisateur)
    , CONSTRAINT FK_Client_Utilisateur
        FOREIGN KEY (eMailUtilisateur)
        REFERENCES Utilisateur (eMailUtilisateur)
);

CREATE TABLE TarifDegressif (
    idLaboratoire               VARCHAR2(8) NOT NULL
    , quantiteMini              NUMBER(4)   NOT NULL
    , quantiteMaxi              NUMBER(4)   NOT NULL
    , reduction                 NUMBER(4,2)  
    , CONSTRAINT PK_TarifDegressif 
        PRIMARY KEY (quantiteMini, quantiteMaxi, idLaboratoire)  
    , CONSTRAINT FK_TarifDegressif_Laboratoire
        FOREIGN KEY (idLaboratoire)
        REFERENCES Laboratoire (idLaboratoire)
);

CREATE TABLE TarifFormat (
    idLaboratoire               VARCHAR2(8) NOT NULL
    , idFormat                  VARCHAR2(8) NOT NULL
    , idTypePapier              VARCHAR2(8) NOT NULL
    , prixUnitaire              NUMBER(4,2)  
    , CONSTRAINT PK_TarifFormat 
        PRIMARY KEY (idLaboratoire, idFormat, idTypePapier)
    , CONSTRAINT FK_TarifFormat_Laboratoire
        FOREIGN KEY (idLaboratoire)
        REFERENCES Laboratoire (idLaboratoire)
    , CONSTRAINT FK_TarifFormat_FormatPapier
        FOREIGN KEY (idFormat)
        REFERENCES FormatPapier (idFormat)
    , CONSTRAINT FK_TarifFormat_TypePapier
        FOREIGN KEY (idTypePapier)
        REFERENCES TypePapier (idTypePapier)
);

-- (2)
CREATE TABLE Album (
    idAlbum                     NUMBER(4)   NOT NULL
    , titreAlbum                VARCHAR2(32)
    , dateCreation              DATE
    , dateDerniereModification  DATE
    , visibilite                VARCHAR2(32)
        CHECK (visibilite IN ('Public', 'Privé'))
    , eMailClient               VARCHAR2(64) NOT NULL
    , CONSTRAINT PK_Album PRIMARY KEY (idAlbum)  
    , CONSTRAINT FK_Album_Client
        FOREIGN KEY (eMailClient)
        REFERENCES Client (eMailUtilisateur)
);

CREATE TABLE CarteBancaire (
    numCarteBancaire            VARCHAR2(16)  NOT NULL
    , dateLimiteValidite        DATE
    , codeControle              NUMBER(3)
    , typeCarteBancaire         VARCHAR2(32)
    , eMailClient               VARCHAR2(64)  NOT NULL
    , CONSTRAINT PK_CarteBancaire PRIMARY KEY (numCarteBancaire)  
    , CONSTRAINT FK_CarteBancaire_Client
        FOREIGN KEY (eMailClient)
        REFERENCES Client (eMailUtilisateur)
);

CREATE TABLE Commande (
    numCommande                 VARCHAR2(8)  NOT NULL
    , dateCommande              DATE
    , adresseLivraison          VARCHAR2(128)
    , etatCommande              VARCHAR2(32)
        CHECK (etatCommande IN ('Attente Paiement'
        , 'Attente Impression', 'Attente Accusé réception', 'Livrée'))
    , eMailClient               VARCHAR2(64)  NOT NULL
    , idLaboratoire             VARCHAR2(8)  NOT NULL
    , CONSTRAINT PK_Commande PRIMARY KEY (numCommande)  
    , CONSTRAINT FK_Commande_Laboratoire
        FOREIGN KEY (idLaboratoire)
        REFERENCES Laboratoire (idLaboratoire)
    , CONSTRAINT FK_Commande_Client
        FOREIGN KEY (eMailClient)
        REFERENCES Client (eMailUtilisateur)
);

-- (3)
CREATE TABLE Image (
    idAlbum                     NUMBER(4)  NOT NULL
    , numImage                  NUMBER(4)  NOT NULL
    , titreImage                VARCHAR2(32)
    , taille                    NUMBER(4)
    , annotation                VARCHAR2(64)
    , dateTelechargement        DATE  
    , CONSTRAINT PK_Image PRIMARY KEY (idAlbum, numImage)
    , CONSTRAINT FK_Image_Album
        FOREIGN KEY (idAlbum)
        REFERENCES Album (idAlbum)
);

CREATE TABLE Tirage (
    numCommande                 VARCHAR2(8) NOT NULL
    , numTirage                 NUMBER(4)   NOT NULL
    , idFormat                  VARCHAR2(8) NOT NULL
    , idTypePapier              VARCHAR2(8)  NOT NULL
    , CONSTRAINT PK_Tirage PRIMARY KEY (numCommande, numTirage)
    , CONSTRAINT FK_Tirage_Commande
        FOREIGN KEY (numCommande)
        REFERENCES Commande (numCommande)
    , CONSTRAINT FK_Tirage_FormatPapier
        FOREIGN KEY (idFormat)
        REFERENCES FormatPapier (idFormat)
    , CONSTRAINT FK_Tirage_TypePapier
        FOREIGN KEY (idTypePapier)
        REFERENCES TypePapier (idTypePapier)
);

-- (4)
CREATE TABLE Notation (
    eMailUtilisateur            VARCHAR2(64)  NOT NULL
    , idAlbum                   NUMBER(4)     NOT NULL
    , numImage                  NUMBER(4)     NOT NULL
    , note                      NUMBER(2)
    , commentaire               VARCHAR2(64)
    , dateNotation              DATE  
    , CONSTRAINT PK_Notation PRIMARY KEY (eMailUtilisateur, idAlbum, numImage)
    , CONSTRAINT FK_Notation_Image
        FOREIGN KEY (idAlbum, numImage)
        REFERENCES Image (idAlbum, numImage)
    , CONSTRAINT FK_Notation_Utilisateur
        FOREIGN KEY (eMailUtilisateur)
        REFERENCES Utilisateur (eMailUtilisateur)
);

CREATE TABLE TirageImages (
    numCommande                   VARCHAR2(8) NOT NULL
    , numTirage                   NUMBER(4)   NOT NULL
    , idAlbum                     NUMBER(4)   NOT NULL
    , numImage                    NUMBER(4)   NOT NULL
    , quantite                    NUMBER(4)  
    , CONSTRAINT PK_TirageImages 
        PRIMARY KEY (numCommande, numTirage, idAlbum, numImage)
    , CONSTRAINT FK_TirageImages_Image
        FOREIGN KEY (idAlbum, numImage)
        REFERENCES Image (idAlbum, numImage)
    , CONSTRAINT FK_TirageImages_Tirage
        FOREIGN KEY (numCommande, numTirage)
        REFERENCES Tirage (numCommande, numTirage)
);
