package controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.sql.*;
import model.*;


public class Factory {
    private static Connection conn=null;
    private static Statement stm;
    private static PreparedStatement pstmet=null;
    private static ResultSet rs=null;
    
    public static void insererArtiste(Artiste a){
        try{
            conn=getConnection();
            pstmet=conn.prepareStatement("insert into gestion_musee.artiste(idart,nom,biographie) values(?,?,?,?,?,?)");
            pstmet.setInt(1,a.getIdart());
            pstmet.setString(2,a.getNom());
            pstmet.setString(3,a.getBiographie());
            
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    public static void insererBillet(Billet b){
        try{
            conn=getConnection();
            pstmet=conn.prepareStatement("insert into gestion_musee.billet(	idbillet,num_du_billet,date_de_visite,visiteur) values(?,?,?,?,?)");
            pstmet.setInt(1,b.getIdbillet());
            pstmet.setInt(2,b.getNum_du_billet());
            pstmet.setString(3,b.getDate_de_visite());
            pstmet.setString(4,b.getVisiteur());
           
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
     
    public static void insererEmployes(Employes em){
        try{
            conn=getConnection();
            pstmet=conn.prepareStatement("insert into gestion_musee.Employes(idemp,salaire,nom,prenom,poste,musee) values(?,?,?,?,?,?,?)");
            pstmet.setInt(1,em.getIdemp());
           pstmet.setFloat(2,em.getSalaire());
            pstmet.setString(3,em.getNom());
            pstmet.setString(4,em.getPrenom());
            pstmet.setString(5,em.getPoste());
            pstmet.setString(6,em.getMusee());
           
            pstmet.executeUpdate();
            conn.close();
        }
         catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    public static void insererExposition(Exposition ex){
       try{   

            conn=getConnection();
            pstmet=conn.prepareStatement("insert into gestion_musee.Exposition(idexposition,date_du_debut,date_de_fin,titre,description,musee) values(?,?,?,?,?)");
            pstmet.setInt(1,ex.getIdexposition());
            pstmet.setInt(2,ex.getDate_du_debut());
            pstmet.setInt(3,ex.getDate_de_fin());
            pstmet.setString(4,ex.geTitre());
            pstmet.setString(5,ex.getDescription());
          pstmet.setString(6,ex.getMusee());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
       public static void insererMusee(Musee m){
        try{
   
            conn=getConnection();
            
            pstmet=conn.prepareStatement("insert into gestion_musee.musee(idmusee,telephone,nom,adresse,ville,pays) values(?,?,?,?,?,?)");
            pstmet.setInt(1,m.getIdmusee());
            pstmet.setInt(2,m.getTelephone());
            pstmet.setString(3,m.getNom());
            pstmet.setString(4,m.getAdresse());
              pstmet.setString(5,m.getVille());
            pstmet.setString(6,m.getPays());
             
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    public static void insererVisiteur(Visiteur v){
        try{
           

            conn=getConnection();
            pstmet=conn.prepareStatement("insert into gestion_musee.visiteur(	idvisiteur,nom,prenom,email) values(?,?,?,?,?)");
            pstmet.setInt(1,v.getIdvisiteur());
            pstmet.setString(2,v.getNom());
            pstmet.setString(3,v.getPrenom());
            pstmet.setString(4,v.getEmail());
           
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    public static ArrayList<Artiste> getArtiste(){
        ArrayList<Artiste> lic=new ArrayList();
        Artiste a=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.artiste");
            while(rs.next()){
                a=new Artiste();
                a.setIdart(rs.getInt("idartiste"));
                a.setNom(rs.getString("nom"));
                a.setBiographie(rs.getString("biographie"));
                
                lic.add(a);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    }
    
    public static ArrayList<Billet> getBillet(){
        ArrayList<Billet> lic=new ArrayList();
        Billet b=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.billet");
            while(rs.next()){
                b=new Billet();
                b.setIdbillet(rs.getInt("idbill"));
                b.setNum_du_billet(rs.getInt("num_du_billet"));
                b.setDate_de_visite(rs.getString("date_de_visite"));
                 b.setVisiteur(rs.getString("visiteur"));
            
                lic.add(b);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
         
           
            
        }return lic;
    }
    
    public static ArrayList<Employes> getEmployes(){
        ArrayList<Employes> lic=new ArrayList();
        Employes em=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.employes");
            while(rs.next()){
                em=new Employes();
                em.setIdemp(rs.getInt("idemp"));
                em.setNom(rs.getString("nom"));
                em.setPrenom(rs.getString("prenom"));
                em.setPoste(rs.getString("poste"));
                em.setMusee(rs.getString("musee"));
            
                em.setSalaire(rs.getInt("salaire"));
                lic.add(em);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    }
    
           
    
    public static ArrayList<Exposition> getExposition(){
        ArrayList<Exposition> lic=new ArrayList();
        Exposition ex=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.exposition");
            while(rs.next()){
                ex=new Exposition();
                ex.setIdexposition(rs.getInt("idexposition"));
                ex.setDate_du_debut(rs.getInt("date_du_debut"));
                ex.setDate_de_fin(rs.getInt("date_de_fin"));
                ex.setTitre(rs.getString("titre"));
                ex.setDescription(rs.getString("description"));
                ex.setMusee(rs.getString("musee"));
             
               
                lic.add(ex);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    }
    
    
    public static ArrayList<Musee> getMusee(){
        ArrayList<Musee> lic=new ArrayList();
        Musee m=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.Musee");
            while(rs.next()){
                m=new Musee();
                m.setIdmusee(rs.getInt("idmusee"));
                m.setNom(rs.getString("nom"));
                m.setAdresse(rs.getString("adresse"));
                m.setTelephone(rs.getInt("telephone"));
                m.setVille(rs.getString("ville"));
                m.setPays(rs.getString("pays"));
            
               
                lic.add(m);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    }
    
       
             
    
    public static ArrayList<Visiteur> getVisiteur(){
        ArrayList<Visiteur> lic=new ArrayList();
        Visiteur v=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.visiteur");
            while(rs.next()){
                v=new Visiteur();
                v.setIdvisiteur(rs.getInt("idvisiteur"));
                v.setNom(rs.getString("nom"));
                v.setPrenom(rs.getString("prenom"));
                v.setEmail(rs.getString("email"));
             
               
                lic.add(v);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    }
    
    
    public static Artiste getArtisteId(int a){
        Artiste ar= null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.artiste where idart='"+a+"'");
            if(rs.next()){
                ar=new Artiste();
                ar.setIdart(rs.getInt("idartiste"));
                ar.setNom(rs.getString("nom"));
                ar.setBiographie(rs.getString("biographie"));
             
            }
            conn.close();
            stm.close();
            return ar;
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
    
                
    public static Billet getBilletid(int b){
        Billet bi=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.billet where ibillet='"+b+"'");
            if(rs.next()){
                bi=new Billet();
               bi.setIdbillet(rs.getInt("idbill"));
                bi.setNum_du_billet(rs.getInt("num_du_billet"));
                bi.setDate_de_visite(rs.getString("date_de_visite"));
                 bi.setVisiteur(rs.getString("visiteur"));            }
            conn.close();
            stm.close();
            return bi;
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
    
    
    public static Employes getEmployesid(int em){
        Employes emp=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.employes where idemp='"+em+"'");
            if(rs.next()){
                emp=new Employes();
                 emp=new Employes();
                emp.setIdemp(rs.getInt("idemp"));
                emp.setNom(rs.getString("nom"));
                emp.setPrenom(rs.getString("prenom"));
                emp.setPoste(rs.getString("poste"));
                emp.setMusee(rs.getString("musee"));
                emp.setSalaire(rs.getInt("salaire"));
            }
            conn.close();
            stm.close();
            return emp;
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
    
    public static Exposition getExpositionid(String exp){
        Exposition expo=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.exposition where idexposition='"+exp+"'");
            if(rs.next()){
               expo=new Exposition();
                expo.setIdexposition(rs.getInt("idexposition"));
                expo.setDate_du_debut(rs.getInt("date_du_debut"));
                expo.setDate_de_fin(rs.getInt("date_de_fin"));
                expo.setTitre(rs.getString("titre"));
                expo.setDescription(rs.getString("description"));
                expo.setMusee(rs.getString("musee"));
             
            }
            conn.close();
            stm.close();
            return expo;
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
    
    public static Musee getMuseeId(int mu){
        Musee mus=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.musee where idemp='"+mu+"'");
            if(rs.next()){
               mus=new Musee();
                mus.setIdmusee(rs.getInt("idmusee"));
                mus.setNom(rs.getString("nom"));
                mus.setAdresse(rs.getString("adresse"));
                mus.setTelephone(rs.getInt("telephone"));
                mus.setVille(rs.getString("ville"));
                mus.setPays(rs.getString("pays"));
            }
            conn.close();
            stm.close();
            return mus;
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
    
    public static Visiteur getVisiteurId(String vi){
        Visiteur vis=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion_musee.visiteur where idvisiteur='"+vi+"'");
            if(rs.next()){
               vis=new Visiteur();
             vis.setIdvisiteur(rs.getInt("idvisiteur"));
                vis.setNom(rs.getString("nom"));
                vis.setPrenom(rs.getString("prenom"));
                vis.setEmail(rs.getString("email"));
             
            }
            conn.close();
            stm.close();
            return vis;
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
    
    
    public static void DeleteArtiste(Artiste ai){
        Artiste ar=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from gestion_musee.artiste where idClient='"+ai.getIdart()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }
    
    public static void DeleteBillet(Billet ai){
        Billet bil=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re="delete from gestion_musee.billet where idbillet='"+ai.getIdbillet()+"'";
            stm.executeUpdate(re);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }
    
    public static void DeleteEmployes(Employes t){
        Employes tec=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from gestion_musee.employes where idemp='"+t.getIdemp()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }
    
    public static void DeleteExposition(Exposition r){
        Exposition rep=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from gestion_musee.exposition where idexposition='"+r.getIdexposition()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }
    
    
    
    public static void DeleteMusee(Musee h){
        Musee mus=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from gestion_musee.musee where idmusee='"+h.getIdmusee()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }
    
    public static void DeleteVisiteur(Visiteur r){
        Visiteur rep=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from gestion_musee.visiteur where idvisiteur='"+r.getIdvisiteur()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }
    public static void ModifyArtisteID(int id, String nom, String biographie){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update gestion_musee.artiste set nom='"+nom+"',biographie='"+biographie+"' where idart='"+id+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    }
    
    public static void ModifyBilletID(int idbillet, int num_du_billet, String visiteur,int date_de_visite){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update gestion_musee.billet set num_du_billet='"+num_du_billet+"',visiteur='"+visiteur+"',date_de_visite='"+date_de_visite+"' where idbillet='"+idbillet+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    }
    
    public static void ModifyEmployesID(int idemp, String nom, String prenom, String poste, String musee, int salaire){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update gestion_musee.employes set nom='"+nom+"',prenom='"+prenom+"',poste='"+poste+"',musee='"+musee+"',salaire='"+salaire+"' where idemp='"+idemp+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    }
    
    public static void ModifyExpositionID(int idexposition, int date_du_debut, int date_de_fin, String titre, String description,String musee){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update gestion_musee.exposition set date_du_debut='"+date_du_debut+"',date_de_fin='"+date_de_fin+"',titre='"+titre+"',description='"+description+"',musee='"+musee+"' where idexposition='"+idexposition+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    }
    
    
     
    public static void ModifyMuseeID(int idmusee, String nom, String adresse, String ville, int telephone, String pays){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update gestion_musee.musee set nom='"+nom+"',adresse='"+adresse+"',ville='"+ville+"',pays='"+pays+"',telephone='"+telephone+"' where idmusee='"+idmusee+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    }
    
    public static void ModifyVisiteurID(int idvisiteur, String nom, String prenom, String email){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update gestion_musee.visiteur set nom='"+nom+"',prenom='"+prenom+"',email='"+email+"'  where idvisiteur='"+idvisiteur+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    }
    
    
    
    public static Connection getConnection(){
        String serveur="localhost";
        int port=3306;
        String database="gestion_musee";
        String username="root";
        String password="";
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url="jdbc:mysql://"+serveur+":"+port+"/"+database;
            conn=DriverManager.getConnection(url,username,password);
            System.out.println("connected");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void setArtiste(Artiste art) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void setBillet(Billet bil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Artiste getRechArtiste(int rech) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void ModifyExpositionID(int idd, int id, String nm, String prn, String adr, int idi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
