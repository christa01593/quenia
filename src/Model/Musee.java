package model;


public class Musee {
    private int idmusee,telephone;
    private String nom,adresse,ville,pays;

    public int getIdmusee() {
        return idmusee;
    }

    public void setIdmusee(int idmusee) {
        this.idmusee = idmusee;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

  
    
    public Musee(int idmusee, int telephone, String nom, String adresse,String pays, String ville) {
        this.idmusee = idmusee;
        this.telephone = telephone;
        this.nom = nom;
       
        this.pays = pays;
        this.ville = ville;
    }
    
    public Musee(){}
}
