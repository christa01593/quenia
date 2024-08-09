package model;


public class Exposition {
    private int idexposition ,date_du_debut,date_de_fin;
    private String titre,description,musee;

    public Exposition(int i, int t, String n, String p, String a, int na) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdexposition() {
        return idexposition;
    }

    public void setIdexposition(int idexposition) {
        this.idexposition = idexposition;
    }

    public int getDate_du_debut() {
        return date_du_debut;
    }

    public void setDate_du_debut(int date_du_debut) {
        this.date_du_debut = date_du_debut;
    }

    public int getDate_de_fin() {
        return date_de_fin;
    }

    public void setDate_de_fin(int date_de_fin) {
        this.date_de_fin = date_de_fin;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusee() {
        return musee;
    }

    public void setMusee(String musee) {
        this.musee = musee;
    }
    

    public Exposition(int idexposition, int date_du_debut, int date_de_fin, String prenom, String adresse, String nationalite) {
        this.idexposition = idexposition;
        this.date_du_debut = date_du_debut  ; 
        this.date_de_fin = date_de_fin;
        this.titre = titre;
        this. description= description;
        this.  musee=musee;
    }
    
    public Exposition(){}

    public String geTitre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
