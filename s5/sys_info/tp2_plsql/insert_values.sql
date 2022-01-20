-- -----------------------------------------------------------------------------
--       TABLE : Utilisateur
-- -----------------------------------------------------------------------------
Insert Into Utilisateur(eMailUtilisateur) Values ('u1@');
Insert Into Utilisateur(eMailUtilisateur) Values ('u2@');
Insert Into Utilisateur(eMailUtilisateur) Values ('u3@');
Insert Into Utilisateur(eMailUtilisateur) Values ('u4@');
Insert Into Utilisateur(eMailUtilisateur) Values ('u5@');

-- -----------------------------------------------------------------------------
--       TABLE : Client
-- -----------------------------------------------------------------------------

Insert Into Client Values ('u1@','u1',NULL,NULL,NULL,'Centre','0123456789',9);
Insert Into Client Values ('u2@','u2',NULL,NULL,NULL,'Centre','1234567890',9);
Insert Into Client Values ('u3@','u3',NULL,NULL,NULL,'Centre','2345678901',9);
Insert Into Client Values ('u4@','u4',NULL,NULL,NULL,'Picardie','3456789012',9);
Insert Into Client Values ('u5@','u5',NULL,NULL,NULL,'PACA','4567890123',9);

-- -----------------------------------------------------------------------------
--       TABLE : Album
-- -----------------------------------------------------------------------------
Insert Into Album Values (11,'a11',SYSDATE,SYSDATE,'Public','u1@');
Insert Into Album Values (12,'a12',SYSDATE,SYSDATE,'Public','u1@');
Insert Into Album Values (21,'a21',SYSDATE,SYSDATE,'Privé','u2@');
Insert Into Album Values (22,'a22',SYSDATE,SYSDATE,'Privé','u2@');
Insert Into Album Values (23,'a23',SYSDATE,SYSDATE,'Public','u2@');
Insert Into Album Values (31,'a31',SYSDATE,SYSDATE,'Privé','u3@');
Insert Into Album Values (32,'a32',SYSDATE,SYSDATE,'Privé','u3@');
Insert Into Album Values (41,'a41',SYSDATE,SYSDATE,'Public','u4@');

-- -----------------------------------------------------------------------------
--       TABLE : Image
-- -----------------------------------------------------------------------------
Insert Into Image Values (11,1,'i11_1',2,NULL,to_date('13/03/2017', 'DD/MM/YYYY'));
Insert Into Image Values (11,2,'i11_2',2,NULL,SYSDATE);
Insert Into Image Values (12,1,'i12_1',2,NULL,SYSDATE);
Insert Into Image Values (12,2,'i12_2',2,NULL,SYSDATE);
Insert Into Image Values (23,1,'i23_1',2,NULL,SYSDATE);
Insert Into Image Values (23,2,'i23_2',2,NULL,SYSDATE);
Insert Into Image Values (31,1,'i31_1',2,NULL,SYSDATE);
Insert Into Image Values (41,1,'i41_1',2,NULL,SYSDATE);
Insert Into Image Values (41,2,'i41_2',2,NULL,SYSDATE);

/* Insert Into Image Values (11,3,'i11_3',2,NULL,SYSDATE); */

-- -----------------------------------------------------------------------------
--       TABLE : Laboratoire
-- -----------------------------------------------------------------------------
Insert Into Laboratoire Values ('l1','lab1',NULL,'l1@','0612345678');
Insert Into Laboratoire Values ('l2','lab2',NULL,'l2@','0623456789');
Insert Into Laboratoire Values ('l3','lab3',NULL,'l3@','0634567890');

-- -----------------------------------------------------------------------------
--       TABLE : TarifDegressif
-- -----------------------------------------------------------------------------
Insert Into TarifDegressif Values ('l1',10,19,10);
Insert Into TarifDegressif Values ('l1',20,29,20);
Insert Into TarifDegressif Values ('l1',30,39,30);
Insert Into TarifDegressif Values ('l1',40,1000,40);
Insert Into TarifDegressif Values ('l2',40,1000,50);

-- -----------------------------------------------------------------------------
--       TABLE : Commande
-- -----------------------------------------------------------------------------
Insert Into Commande Values ('cu1l1_1',SYSDATE,NULL,'Attente Impression','u1@','l1');
Insert Into Commande Values ('cu2l2_1',SYSDATE,NULL,'Attente Impression','u2@','l2');
Insert Into Commande Values ('cu4l3_1',SYSDATE,NULL,'Attente Impression','u4@','l3');

/*
Insert Into Commande Values ('cu1l3_1',to_date('01/05/2013', 'DD/MM/YYYY'),NULL,'Attente Impression','u1@','l3');
Insert Into Commande Values ('cu2l3_1',to_date('10/05/2013', 'DD/MM/YYYY'),NULL,'Attente Impression','u2@','l3');
Insert Into Commande Values ('cu3l3_1',to_date('20/05/2013', 'DD/MM/YYYY'),NULL,'Attente Impression','u3@','l3');
*/

-- -----------------------------------------------------------------------------
--       TABLE : FormatPapier
-- -----------------------------------------------------------------------------
Insert Into FormatPapier Values ('A4','Normal',21,29.7);
Insert Into FormatPapier Values ('A3','Large',29.7,42);

-- -----------------------------------------------------------------------------
--       TABLE : TypePapier
-- -----------------------------------------------------------------------------
Insert Into TypePapier Values ('PPB','Papier Photo Brillant');
Insert Into TypePapier Values ('PPS','Papier Photo Satiné');

-- -----------------------------------------------------------------------------
--       TABLE : TarifFormat
-- -----------------------------------------------------------------------------
Insert Into TarifFormat Values ('l1','A4','PPB',0.7);
Insert Into TarifFormat Values ('l1','A4','PPS',0.8);
Insert Into TarifFormat Values ('l1','A3','PPB',1.0);
Insert Into TarifFormat Values ('l1','A3','PPS',1.1);
Insert Into TarifFormat Values ('l2','A4','PPB',0.7);
Insert Into TarifFormat Values ('l2','A4','PPS',0.8);
Insert Into TarifFormat Values ('l2','A3','PPB',0.9);
Insert Into TarifFormat Values ('l2','A3','PPS',1.0);
Insert Into TarifFormat Values ('l3','A4','PPB',0.7);
Insert Into TarifFormat Values ('l3','A4','PPS',0.8);
Insert Into TarifFormat Values ('l3','A3','PPB',0.9);
Insert Into TarifFormat Values ('l3','A3','PPS',1.0);

-- -----------------------------------------------------------------------------
--       TABLE : Tirage
-- -----------------------------------------------------------------------------
Insert Into Tirage Values ('cu1l1_1',1,'A4','PPB');
Insert Into Tirage Values ('cu1l1_1',2,'A3','PPB');
Insert Into Tirage Values ('cu2l2_1',1,'A4','PPS');
Insert Into Tirage Values ('cu2l2_1',2,'A3','PPS');
Insert Into Tirage Values ('cu4l3_1',1,'A3','PPS');

-- -----------------------------------------------------------------------------
--       TABLE : TirageImages
-- -----------------------------------------------------------------------------
Insert Into TirageImages Values ('cu1l1_1',1,11,1,20);
Insert Into TirageImages Values ('cu1l1_1',2,11,2,20);
Insert Into TirageImages Values ('cu2l2_1',1,23,1,20);
Insert Into TirageImages Values ('cu2l2_1',2,23,2,30);
Insert Into TirageImages Values ('cu4l3_1',1,41,1,5);

-- -----------------------------------------------------------------------------
--       TABLE : Notation
-- -----------------------------------------------------------------------------
Insert Into Notation Values ('u1@',11,1,18, NULL,SYSDATE);
Insert Into Notation Values ('u2@',11,1,17, NULL,SYSDATE);
Insert Into Notation Values ('u3@',11,1,5, NULL,SYSDATE);
Insert Into Notation Values ('u1@',11,2,7, NULL,SYSDATE);
Insert Into Notation Values ('u2@',11,2,4, NULL,SYSDATE);
Insert Into Notation Values ('u1@',12,1,6, NULL,SYSDATE);
Insert Into Notation Values ('u1@',12,2,5, NULL,SYSDATE);

-- -----------------------------------------------------------------------------
--       TABLE : CarteBancaire
-- -----------------------------------------------------------------------------
