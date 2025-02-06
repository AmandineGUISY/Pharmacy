package org.Pharmacy;

public class Employeetclient extends Utilisateur{
    public Employeetclient(String identifiant, String motDePasse) {
        super(identifiant, motDePasse);
    }
    public void afficher_role(){
        System.out.println("role ; employé ou client");
    }
}

