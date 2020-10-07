package facade;

import exceptions.*;
import modele.Discussion;
import modele.DiscussionImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFacadeMessagerie  {


    FacadeMessagerieOnLine facadeMessagerieOnLine;


    @Before
    public void quelquesDonneesPreinitialisees() throws PseudoDejaPrisException, MauvaisFormatDonneesException, PersonneDejaConnecteeException, OperationNonAuthoriseeException, IdentificationException {
        this.facadeMessagerieOnLine = FacadeMessagerieOnLine.creer();
        this.facadeMessagerieOnLine.inscription("yohan","boichut");
        this.facadeMessagerieOnLine.inscription("fred","moal");
        this.facadeMessagerieOnLine.inscription("matthieu","exbrayat");
        this.facadeMessagerieOnLine.connexion("yohan","boichut");
        DiscussionImpl.reinitID_GENERATOR();

    }


    @Test
    public void testInscription() throws PseudoDejaPrisException, MauvaisFormatDonneesException, OperationNonAuthoriseeException {
        this.facadeMessagerieOnLine.inscription("etudiant","etudiant");
        Assert.assertTrue(this.facadeMessagerieOnLine.getAllPseudosInscrits("yohan").size() == 4);
    }


    /**
     * Le pseudo demandé est déjà pris...
     * @throws PseudoDejaPrisException
     * @throws MauvaisFormatDonneesException
     * @throws OperationNonAuthoriseeException
     */
    @Test(expected = PseudoDejaPrisException.class)
    public void testInscriptionDejaPris() throws PseudoDejaPrisException, MauvaisFormatDonneesException, OperationNonAuthoriseeException {
        this.facadeMessagerieOnLine.inscription("yohan","etudiant");
        Assert.assertTrue(this.facadeMessagerieOnLine.getAllPseudosInscrits("yohan").size() == 4);
    }



    /**
     * Le pseudo est null...
     * @throws PseudoDejaPrisException
     * @throws MauvaisFormatDonneesException
     * @throws OperationNonAuthoriseeException
     */
    @Test(expected = MauvaisFormatDonneesException.class)
    public void testInscriptionPseudoNull() throws PseudoDejaPrisException, MauvaisFormatDonneesException, OperationNonAuthoriseeException {
        this.facadeMessagerieOnLine.inscription(null,"etudiant");
        Assert.assertTrue(this.facadeMessagerieOnLine.getAllPseudosInscrits("yohan").size() == 4);
    }


    /**
     * Le mot de passe est null...
     * @throws PseudoDejaPrisException
     * @throws MauvaisFormatDonneesException
     * @throws OperationNonAuthoriseeException
     */
    @Test(expected = MauvaisFormatDonneesException.class)
    public void testInscriptionMdpNull() throws PseudoDejaPrisException, MauvaisFormatDonneesException, OperationNonAuthoriseeException {
        this.facadeMessagerieOnLine.inscription("etudiant",null);
        Assert.assertTrue(this.facadeMessagerieOnLine.getAllPseudosInscrits("yohan").size() == 4);
    }


    /**
     * Le pseudo est vide...
     * @throws PseudoDejaPrisException
     * @throws MauvaisFormatDonneesException
     * @throws OperationNonAuthoriseeException
     */
    @Test(expected = MauvaisFormatDonneesException.class)
    public void testInscriptionPseudoVide() throws PseudoDejaPrisException, MauvaisFormatDonneesException, OperationNonAuthoriseeException {
        this.facadeMessagerieOnLine.inscription("","etudiant");
        Assert.assertTrue(this.facadeMessagerieOnLine.getAllPseudosInscrits("yohan").size() == 4);
    }




    /**
     * La désinscription de Fred se passe normalement...
     * @throws PseudoDejaPrisException
     * @throws MauvaisFormatDonneesException
     * @throws OperationNonAuthoriseeException
     */
    @Test
    public void testDesinscription() throws MauvaisFormatDonneesException, OperationNonAuthoriseeException {
        this.facadeMessagerieOnLine.desincription("fred","moal");
        Assert.assertTrue(this.facadeMessagerieOnLine.getAllPseudosInscrits("yohan").size() == 2);
    }



    /**
     * La désinscription de Fred se passe mal car le mot de passe n'est pas correct...
     * @throws OperationNonAuthoriseeException
     */
    @Test(expected = OperationNonAuthoriseeException.class)
    public void testDesinscriptionKO1() throws  MauvaisFormatDonneesException, OperationNonAuthoriseeException {
        this.facadeMessagerieOnLine.desincription("fred","breton");

    }




    /**
     * La désinscription de Fred se passe mal car les données ne sont pas cohérentes...
     * @throws OperationNonAuthoriseeException
     */
    @Test(expected = OperationNonAuthoriseeException.class)
    public void testDesinscriptionKO2() throws  OperationNonAuthoriseeException {
        this.facadeMessagerieOnLine.desincription("fred",null);

    }


    /**
     * La désinscription de Fred se passe mal car les données ne sont pas cohérentes...
     * @throws OperationNonAuthoriseeException
     */
    @Test(expected = OperationNonAuthoriseeException.class)
    public void testDesinscriptionKO3() throws  OperationNonAuthoriseeException {
        this.facadeMessagerieOnLine.desincription(null,"yohan");

    }

    /**
     * La connexion se passe bien.
     * @throws PersonneDejaConnecteeException
     * @throws OperationNonAuthoriseeException
     * @throws IdentificationException
     */


    @Test
    public void testConnexion() throws PersonneDejaConnecteeException, OperationNonAuthoriseeException, IdentificationException {
        this.facadeMessagerieOnLine.connexion("fred","moal");
        Assert.assertTrue(true);
    }


    /**
     * La connexion se passe mal car le pseudo est déjà connecté.
     * @throws PersonneDejaConnecteeException
     * @throws OperationNonAuthoriseeException
     * @throws IdentificationException
     */


    @Test(expected = PersonneDejaConnecteeException.class)
    public void testConnexionKO() throws PersonneDejaConnecteeException, OperationNonAuthoriseeException, IdentificationException {
        this.facadeMessagerieOnLine.connexion("yohan","boichut");
    }


    @Test
    public void testCreationDiscussion() throws OperationNonAuthoriseeException, DestinataireInexistantException {
        this.facadeMessagerieOnLine.creerDiscussion("yohan","fred");
        Assert.assertTrue(this.facadeMessagerieOnLine.getAllDiscussions("yohan").size() == 1);

    }


    @Test(expected = DestinataireInexistantException.class)
    public void testCreationDiscussionKO1() throws OperationNonAuthoriseeException, DestinataireInexistantException {
        this.facadeMessagerieOnLine.creerDiscussion("yohan","freda");

    }


    @Test(expected = OperationNonAuthoriseeException.class)
    public void testCreationDiscussionKO2() throws OperationNonAuthoriseeException, DestinataireInexistantException {
        this.facadeMessagerieOnLine.creerDiscussion("fred","yohan");

    }

    @Test
    public void testEnvoiMessage() throws OperationNonAuthoriseeException, DestinataireInexistantException, DiscussionNonTrouveeException {
        this.facadeMessagerieOnLine.creerDiscussion("yohan","fred");

        this.facadeMessagerieOnLine.envoyerMessage("yohan",0,"Pas si compliqué que ça d'envoyer un message...");
        Discussion discussion = this.facadeMessagerieOnLine.getDiscussionById("yohan",0);
        Assert.assertTrue(discussion.getMessages().size()==1);

    }



}
