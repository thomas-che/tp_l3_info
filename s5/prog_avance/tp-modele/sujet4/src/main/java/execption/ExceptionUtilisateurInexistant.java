package execption;

public class ExceptionUtilisateurInexistant extends Throwable {
    public String getMessage(){
        return "utilisateur inexistant";
    }
}
