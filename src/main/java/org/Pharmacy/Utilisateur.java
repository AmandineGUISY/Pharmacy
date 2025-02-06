package org.Pharmacy;

abstract class Utilisateur {
    protected String identifiant;
    protected String motDePasse;

    public Utilisateur(String identifiant, String motDePasse) {
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
    }
    public String getIdentifiant() {
        return identifiant;
    }
    public Boolean verifier_mot_de_passe(String motDePasse) {
        return this.motDePasse.equals(motDePasse);
    }
    public abstract void afficher_role();

    public String connexion(String identifiant, String motDePasse) {
        Utilisateur[] utilisateurs = {
                new Admin("admin" , "mdp"),
                new Admin("admin2" , "mdp2"),
                new Employeetclient("employe" , "mdp3")
        };
        for (Utilisateur utilisateur :utilisateurs){
            if (utilisateur.getIdentifiant().equals(identifiant) && utilisateur.verifier_mot_de_passe(motDePasse)) {
                return "vous êtes connecté";
            }
        }
        return "Erreur de connexion";
    }
}
