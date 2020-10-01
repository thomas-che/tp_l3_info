package modele.exceptions;

public class DossierDejaExistantException extends Exception {
    private String nomDossierProblematique;

    public DossierDejaExistantException(String dossier) {
        super();
        this.nomDossierProblematique = dossier;
    }

    public String getNomDossierProblematique() {
        return nomDossierProblematique;
    }
}
