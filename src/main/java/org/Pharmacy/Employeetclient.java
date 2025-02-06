package org.Pharmacy;

public class Employeetclient extends Utilisateur implements Role{
    public Employeetclient(String identifiant, String motDePasse, String role) {
        super(identifiant, motDePasse, role);
    }

    public void afficherRole() {
        System.out.println("Rôle : Employé ou Client");
    }
}
