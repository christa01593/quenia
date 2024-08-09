package model;


public class Visiteur {
    private int idvisiteur;
    private String nom,prenom,email;

    public int getIdvisiteur() {
        return idvisiteur;
    }

    public void setIdvisiteur(int idvisiteur) {
        this.idvisiteur = idvisiteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public Visiteur(int idvisiteur, String nom, String prenom, String email) {
    
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
       
    }
    
    public Visiteur(){}
}
