package module;

import java.util.Objects;

public class User {
    private String nom;
    private boolean connect;
    private Facade facadeFileSys;

    public User(String nom) {
        this.nom = nom;
        this.connect = true;
        this.facadeFileSys = new Facade();
    }

    public Facade getFacadeFileSys() {
        return facadeFileSys;
    }

    public String getNom() {
        return nom;
    }

    public boolean isConnect() {
        return connect;
    }

    public void deconection() {
        connect = false;
    }

    public void connection() {
        connect = true;
    }
/*
    public void supprimer() {
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (Objects.equals(nom, user.nom)) return true;
        return connect == user.connect &&
                Objects.equals(nom, user.nom) &&
                Objects.equals(facadeFileSys, user.facadeFileSys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, connect, facadeFileSys);
    }
}
