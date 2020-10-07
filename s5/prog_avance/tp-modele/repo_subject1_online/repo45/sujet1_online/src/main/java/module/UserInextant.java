package module;

public class UserInextant extends Exception {
    private String nomUser;
    public UserInextant(String nomUser) {
        super();
        this.nomUser=nomUser;
    }
    public String getMessage(){
        return "User enter : "+this.nomUser+" est inconnu...";
    }
}
