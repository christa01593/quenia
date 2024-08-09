package model;


public class Artiste {
    private int idart;
    private String nom,biographie;

    public int getIdart() {
        return idart;
    }

    public void setIdart(int idart) {
        this.idart = idart;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    

   
     
   
   

    public Artiste(int idart, String nom, String biographie) {
        this.idart = idart;
        this.biographie = biographie;
        this.nom = nom; 
  
        
    }

    public Artiste(){}
}
