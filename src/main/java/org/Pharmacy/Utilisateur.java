package org.Pharmacy;

import java.util.ArrayList;

abstract class Utilisateur {
    protected String identifiant;
    protected String motDePasse;
    protected String role;
    private static final ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

    static {
        utilisateurs.add(new Admin("adminorigin", "1", "admin"));
    }

    public Utilisateur(String identifiant, String motDePasse, String role) {
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.role = role; // Correction ici
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getRole() {
        return role;
    }

    public Boolean verifierMotDePasse(String motDePasse) {
        return this.motDePasse.equals(motDePasse);
    }

    public void addEmployeEtClient(Employeetclient user, String identifiant, String motDePasse) {
        Utilisateur admin = connexion(identifiant, motDePasse);
        if (admin != null && "admin".equals(admin.getRole())) {  // Sécurisé pour éviter NullPointerException
            utilisateurs.add(user);
        } else {
            System.out.println("wrong login");
        }
    }

    public void addAdmin(Admin user, String identifiant, String motDePasse) {
        Utilisateur admin = connexion(identifiant, motDePasse);
        if (admin != null && "admin".equals(admin.getRole())) {  // Sécurisé aussi
            utilisateurs.add(user);
        } else {
            System.out.println("wrong login");
        }
    }

    public void supprimerUtilisateur(String identifiant, String adminIdentifiant, String adminMotDePasse) {
        Utilisateur admin = connexion(adminIdentifiant, adminMotDePasse);
        if (admin != null && "admin".equals(admin.getRole())) {
            utilisateurs.removeIf(utilisateur -> utilisateur.getIdentifiant().equals(identifiant));
            System.out.println("Utilisateur supprimé : " + identifiant);
        } else {
            System.out.println("Permission refusée : seul un admin peut supprimer un utilisateur.");
        }
    }


    public abstract void afficherRole();

    public Utilisateur connexion(String identifiant, String motDePasse) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getIdentifiant().equals(identifiant) && utilisateur.verifierMotDePasse(motDePasse)) {
                return utilisateur;
            }
        }
        return null;
    }
}
