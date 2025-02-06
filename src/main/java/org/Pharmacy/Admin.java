package org.Pharmacy;

public class Admin extends Utilisateur{
    public Admin(String identifiant, String motDePasse) {
        super(identifiant, motDePasse);
    }
    public void afficher_role(){
        System.out.println("role ; administrateur");
    }
}
