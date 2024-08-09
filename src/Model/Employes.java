package model;


public class Employes {
    private int idemp ,salaire;
    private String nom,prenom,poste,musee;
    public String getSalaire;

    public int getIdemp() {
        return idemp;
    }

    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getMusee() {
        return musee;
    }

    public void setMusee(String musee) {
        this.musee = musee;
    }

    

    public Employes(int idemp , int salaire, String nom, String prenom, String poste, String musee) {
        this.idemp = idemp;
        this.salaire = salaire;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.musee = musee;
    }
    
    public Employes(){}
}
