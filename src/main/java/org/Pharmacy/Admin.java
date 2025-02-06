package org.Pharmacy;

public class Admin extends Utilisateur implements Role{
    public Admin(String identifiant, String motDePasse, String role) {
        super(identifiant, motDePasse, role);
    }

    public void afficherRole() {
        System.out.println("Rôle : Administrateur");
    }
}
