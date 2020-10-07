package execption;

public class ExceptionUtilisateurDejaExistant extends Exception {
    public String getMessage(){
        return "Nom d'utilisateur deja existant";
    }
}
