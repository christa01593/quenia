package model;


public class Billet {
    private int idbillet,num_du_billet;
    private String date_de_visite,visiteur;

    public Billet(int i, int t, int n, int p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Billet(int idbillet, int numero, int date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Billet(int idbillet, int numero, int date, String visiteur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdbillet() {
        return idbillet;
    }

    public void setIdbillet(int idbillet) {
        this.idbillet = idbillet;
    }

    public int getNum_du_billet() {
        return num_du_billet;
    }

    public void setNum_du_billet(int num_du_billet) {
        this.num_du_billet = num_du_billet;
    }

    public String getDate_de_visite() {
        return date_de_visite;
    }

    public void setDate_de_visite(String date_de_visite) {
        this.date_de_visite = date_de_visite;
    }

    public String getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(String visiteur) {
        this.visiteur = visiteur;
    }
    
   
   

    public Billet(int id, int tel, String nom, String prenom, String adresse, String nationalite) {
        this.idbillet = idbillet;
        this.num_du_billet = num_du_billet;
        this.date_de_visite = date_de_visite;
        this.visiteur = visiteur;
        
    }

    public Billet(){}

    public String getdate_de_visite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getnum_du_billet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
