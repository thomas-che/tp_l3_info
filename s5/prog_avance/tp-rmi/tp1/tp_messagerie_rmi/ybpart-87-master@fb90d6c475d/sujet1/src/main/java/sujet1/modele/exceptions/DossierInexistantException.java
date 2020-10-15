package sujet1.modele.exceptions;

public class DossierInexistantException extends Exception {
    private String nomDossierProblematique;

    public DossierInexistantException(String dossier) {
        super();
        this.nomDossierProblematique = dossier;
    }

    public String getNomDossierProblematique() {
        return nomDossierProblematique;
    }
}
