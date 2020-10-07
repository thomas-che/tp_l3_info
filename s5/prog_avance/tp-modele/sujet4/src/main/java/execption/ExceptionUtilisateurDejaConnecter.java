package execption;

public class ExceptionUtilisateurDejaConnecter extends Throwable {
    public String getMessage(){
        return "utilisateur deja connecter";
    }
}
