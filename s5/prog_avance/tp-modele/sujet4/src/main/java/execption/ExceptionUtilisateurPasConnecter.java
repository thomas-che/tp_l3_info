package execption;

public class ExceptionUtilisateurPasConnecter extends Throwable {
    public String getMessage(){
        return "utilisateur pas connecter";
    }
}
