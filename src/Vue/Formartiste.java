package vue;
import controller.Factory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.Artiste;


public class Formartiste extends JFrame implements ActionListener{
    JLabel lidart,lnom,lbiographie;
    JTextField tidart,tnom,tbiographie;
 
    JButton benr,bvis,binit,bdel,brech,bupd;
   
    ArrayList <Artiste> listeartiste= new ArrayList();
    JTable tbartiste;
    private final DefaultTableModel model;
    Artiste cl=new Artiste();
    Artiste art=null;
    
    public Formartiste(){
        lidart=new JLabel("ID");
        lidart.setBounds(10,30,100,30);
        this.getContentPane().add(lidart);
        
        tidart=new JTextField("");
        tidart.setBounds(120,30,100,30);
        this.getContentPane().add(tidart);
        
        brech=new JButton("Rechercher");
        brech.setBounds(230,30,100,30);
        brech.addActionListener(this);
        this.getContentPane().add(brech);
        
        lnom=new JLabel("Nom");
        lnom.setBounds(10,70,100,30);
        this.getContentPane().add(lnom);
        
        tnom=new JTextField("");
        tnom.setBounds(120,70,100,30);
        this.getContentPane().add(tnom);
        
        lbiographie=new JLabel("Biographie");
        lbiographie.setBounds(10,110,100,30);
        this.getContentPane().add(lbiographie);
        
        tbiographie=new JTextField("");
        tbiographie.setBounds(120,110,100,30);
        this.getContentPane().add(tbiographie);
        
        
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
        model.addColumn("Nom");
        model.addColumn("Biographie");
        
       this.getContentPane(). setLayout(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==benr){
            int numero = Integer.valueOf(tidart.getText());
            String nom = tnom.getText();
             String biographie = tbiographie.getText();
            
            
            art = new Artiste(numero,nom,biographie);
            Factory.setArtiste(art);
        }
        else{
            if(e.getSource()==bvis){
                afficher();
            }
            else{
                if(e.getSource()==binit){
                    initialiser();
                }
//                else{
//                    if(e.getSource()==listecategorie){
//            String sel = listecategorie.getSelectedItem().toString();
//            if(sel=="Salle"){
//                tprix.setText(String.valueOf(5000));
//            }
//            else{
//                if(sel=="Chambre"){
//                    tprix.setText(String.valueOf(20000));
//                }
//                else{
//                    if(sel=="VIP"){
//                        tprix.setText(String.valueOf(50000));
//                    }
//         ?
                else{
//                    Bouton rechercher
                    if(e.getSource()==brech){
                        int rech = Integer.valueOf(brech.getText());
                        art = Factory.getRechArtiste(rech);
                        if(art != null){
                            tidart.setText(String.valueOf(art.getIdart()));
                            tnom.setText(art.getNom());
                           tbiographie.setText(art.getBiographie());
                        }
                    }
                    else{
                            if(e.getSource()==bdel){
                                if(art != null){
                                  String msg = "Souhaitez-vous supprimer "+art.getIdart()+art.getNom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.DeleteArtiste(art);
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
        listeartiste = Factory.getArtiste();
        listeartiste.stream().forEach((c) -> {
            model.addRow(new Object[]{
                c.getIdart(),c.getNom(),c.getBiographie()});
        });
        JTable tableartiste = new JTable(model);
        JScrollPane p = new JScrollPane(tableartiste);
        p.setBounds(60,240,300,100);
        this.getContentPane().add(p);
    }
    public void initialiser(){
        tidart
                .setText("");
        tnom.setText("");
        tbiographie.setText("");
    }
}

