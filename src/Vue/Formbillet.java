package vue;
import controller.Factory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.Artiste;
import model.Billet;


public class Formbillet extends JFrame implements ActionListener{
    JLabel lidbillet,lnum_du_billet,ldate_de_visite,lvisiteur;
    JTextField tidbillet,tnum_du_billet,tdate_de_visite,tvisiteur;
    
    JButton benr,bvis,binit,bdel,brech,bupd;
    
    ArrayList <Billet> listeBillet= new ArrayList();
    JTable tbbillet;
    private final DefaultTableModel model;
    Billet cl=new Billet();
    Billet bil =null;
    
    public Formbillet(){
        lidbillet=new JLabel("ID");
        lidbillet.setBounds(10,30,100,30);
        this.getContentPane().add(lidbillet);
        
        tidbillet=new JTextField("");
        tidbillet.setBounds(120,30,100,30);
        this.getContentPane().add(tidbillet);
        
        brech.setBounds(230,30,100,30);
        brech.addActionListener(this);
        this.getContentPane().add(brech);
        
        lnum_du_billet=new JLabel("num_du_billet");
        lnum_du_billet.setBounds(10,70,100,30);
        this.getContentPane().add(lnum_du_billet);
        
        tnum_du_billet=new JTextField("");
        tnum_du_billet.setBounds(120,70,100,30);
        this.getContentPane().add(tnum_du_billet);
        
        ldate_de_visite=new JLabel("date_de_visite");
        ldate_de_visite.setBounds(10,110,100,30);
        this.getContentPane().add(ldate_de_visite);
        
        tdate_de_visite=new JTextField("");
        tdate_de_visite.setBounds(120,110,100,30);
        this.getContentPane().add(tdate_de_visite);
        
        lvisiteur=new JLabel("Visiteur");
        lvisiteur.setBounds(10,150,100,30);
        this.getContentPane().add(lvisiteur);
        
        tvisiteur=new JTextField("");
        tvisiteur.setBounds(120,150,100,30);
        this.getContentPane().add(tvisiteur);
        
        
        benr=new JButton("Enregistrer");
        benr.setBounds(10,270,100,30);
        benr.addActionListener(this);
        this.getContentPane().add(benr);
        
        bvis=new JButton("Visualiser");
        bvis.setBounds(120,270,100,30);
        bvis.addActionListener(this);
        this.getContentPane().add(bvis);
        
        binit=new JButton("Initialiser");
        binit.setBounds(230,270,100,30);
        binit.addActionListener(this);
        this.getContentPane().add(binit);
        
        bdel=new JButton("Supprimer");
        bdel.setBounds(340,270,100,30);
        bdel.addActionListener(this);
        this.getContentPane().add(bdel);
        
        bupd=new JButton("Modifier");
        bupd.setBounds(450,270,100,30);
        bupd.addActionListener(this);
        this.getContentPane().add(bupd);
        
        model=new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("num_du_billet");
        model.addColumn("date_de_visite");
        model.addColumn("Visiteur");
      
    this.getContentPane(). setLayout(null);
    }
   public void actionPerformed(ActionEvent e){
       if(e.getSource()==benr){
            int idbillet = Integer.valueOf(tidbillet.getText());
             int numero = Integer.valueOf(tnum_du_billet.getText());
              int date = Integer.valueOf(tdate_de_visite.getText());
            String visiteur = tvisiteur.getText();
           
            bil = new Billet(idbillet,numero,date,visiteur);
            Factory.setBillet(bil);
        }
        else{
            if(e.getSource()==bvis){
                afficher();
            }
            else{
                if(e.getSource()==binit){
                    initialiser();
                }
////                else{
////                    if(e.getSource()==listecategorie){
////            String sel = listecategorie.getSelectedItem().toString();
////            if(sel=="Salle"){
////                tprix.setText(String.valueOf(5000));
////            }
////            else{
////                if(sel=="Chambre"){
////                    tprix.setText(String.valueOf(20000));
////                }
////                else{
////                    if(sel=="VIP"){
////                        tprix.setText(String.valueOf(50000));
////                    }
//                }
//            }
//                }
                else{
//                    Bouton rechercher
                     if(e.getSource()==brech){
                        int rech = Integer.valueOf(brech.getText());
                      //  bil = Factory.getRechArtiste(rech);
                        if(bil != null){
                            tidbillet.setText(String.valueOf(bil.getIdbillet()));
                               tnum_du_billet.setText(String.valueOf(bil.getNum_du_billet()));
                                tdate_de_visite.setText(String.valueOf(bil.getDate_de_visite()));
                           tvisiteur.setText(bil.getVisiteur());
                        }
                    }
                    else{
                            if(e.getSource()==bdel){
                                if(bil != null){
                                  String msg = "Souhaitez-vous supprimer "+bil.getIdbillet()+bil.getNum_du_billet();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.DeleteBillet(bil);
                                        afficher();
                                        initialiser();
                                  }
                                }
                            }
                        }
                    }
                }
            }
        }

     public void afficher(){
        model.setRowCount(0);
        ArrayList<Artiste> listebillet = Factory.getArtiste();
        listebillet.stream().forEach((c) -> {
            model.addRow(new Object[]{
                c.getIdart(),c.getNom(),c.getBiographie()});
        });
        JTable tableartiste = new JTable(model);
        JScrollPane p = new JScrollPane(tableartiste);
        p.setBounds(60,240,300,100);
        this.getContentPane().add(p);
    }
    public void initialiser(){
        tidbillet .setText("");
        tnum_du_billet.setText("");
        tdate_de_visite.setText("");
        tvisiteur.setText("");
    }
}

