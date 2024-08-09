package vue;
import controller.Factory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.Exposition;


public class Formexp extends JFrame implements ActionListener{
    JLabel lidexposition,ldate_du_debut,ldate_de_fin,ltitre,ldescription,lmusee;
    JTextField tdexposition,tdate_du_debut,tdate_de_fin,ttitre,tdescription,tmusee;
 
    JButton enr,vis,init,del,rech,upd;
    
    ArrayList <Exposition> listeClient= new ArrayList();
    JTable tbclient;
    private final DefaultTableModel model;
    Exposition cl=new Exposition();
    Exposition clnt=null;
    
    public Formexp(){
        lidexposition=new JLabel("ID");
        lidexposition.setBounds(10,30,100,30);
        this.getContentPane().add(lidexposition);
        
        tdexposition=new JTextField("");
        tdexposition.setBounds(120,30,100,30);
        this.getContentPane().add(tdexposition);
        
        rech=new JButton("Rechercher");
        rech.setBounds(230,30,100,30);
        rech.addActionListener(this);
        this.getContentPane().add(rech);
        
        ldate_du_debut=new JLabel("Date_du_debut");
        ldate_du_debut.setBounds(10,70,100,30);
        this.getContentPane().add(ldate_du_debut);
        
        tdate_du_debut=new JTextField("");
        tdate_du_debut.setBounds(120,70,100,30);
        this.getContentPane().add(tdate_du_debut);
        
        ldate_de_fin=new JLabel("Date_de_fin");
        ldate_de_fin.setBounds(10,110,100,30);
        this.getContentPane().add(ldate_de_fin);
        
        tdate_de_fin=new JTextField("");
        tdate_de_fin.setBounds(120,110,100,30);
        this.getContentPane().add(tdate_de_fin);
        
        ltitre=new JLabel("Titre");
        ltitre.setBounds(10,150,100,30);
        this.getContentPane().add(ltitre);
        
        ttitre=new JTextField("");
        ttitre.setBounds(120,150,100,30);
        this.getContentPane().add(ttitre);
        
        ldescription=new JLabel("Description");
        ldescription.setBounds(10,190,100,30);
        this.getContentPane().add(ldescription);
        
        tdescription=new JTextField("");
        tdescription.setBounds(120,190,100,30);
        this.getContentPane().add(tdescription);
        
        lmusee=new JLabel("Musee");
        lmusee.setBounds(10,230,100,30);
        this.getContentPane().add(lmusee);
        
            
        tmusee=new JTextField("");
        tmusee.setBounds(120,190,100,30);
        this.getContentPane().add(tmusee);
        
        enr=new JButton("Enregistrer");
        enr.setBounds(10,270,100,30);
        enr.addActionListener(this);
        this.getContentPane().add(enr);
        
        vis=new JButton("Visualiser");
        vis.setBounds(120,270,100,30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init=new JButton("Initialiser");
        init.setBounds(230,270,100,30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del=new JButton("Supprimer");
        del.setBounds(340,270,100,30);
        del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd=new JButton("Modifier");
        upd.setBounds(450,270,100,30);
        upd.addActionListener(this);
        this.getContentPane().add(upd);
        
        model=new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("");
        model.addColumn("Date_de_fin");
        model.addColumn("Titre");
        model.addColumn("Description");
        model.addColumn("Musee");
        
        this.setLayout(null);
    }
    
    public void effacer(){
        tdexposition.setText("");
        tdate_du_debut.setText("");
        tdate_de_fin.setText("");
        ttitre.setText("");
        tdescription.setText("");
         tmusee.setText("");
    }
    
    
    public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        listeClient= Factory.getExposition();
        for(Exposition c:listeClient){
            model.addRow(new Object[]{
                    c.getIdexposition(),c.getDate_du_debut(),c.getDate_de_fin(),c.getTitre(),c.getDescription(),c.getMusee()}
            );
        }
         
        tbclient=new JTable(model);
    JScrollPane p=new JScrollPane(tbclient);
    p.setBounds(60,310,300,100);
    this.getContentPane().add(p);
    }
    
    public void recupInfo(Exposition c){
        //tnum.setText(cr.getNum());
        tdexposition.setText(String.valueOf(c.getIdexposition()));
         tdate_du_debut.setText(String.valueOf(c.getDate_du_debut()));
         tdate_de_fin.setText(String.valueOf(c.getDate_de_fin()));
        ttitre.setText(c.getTitre());
        tdescription.setText(c.getDescription());      
        tmusee.setText(c.getMusee());
        
    }
    
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==enr){
            int i=Integer.valueOf(tdexposition.getText());
            int t=Integer.valueOf(tdate_du_debut.getText());
                    int na=Integer.valueOf(tdate_de_fin.getText());
            String  n=ttitre.getText();
            String p=tdescription.getText();
            String a=tmusee.getText();
            cl=new Exposition (i,t,n,p,a,na);
            Factory.insererExposition(cl);
        }else if(e.getSource()==vis){
            afficher();
        }else if(e.getSource()==init){
            effacer();
        }else if(e.getSource()==del){
            if(clnt !=null){
                String msg="Voulez-vous reelement supprimer "+clnt.getTitre()+" de la liste des expositions";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    Factory.DeleteExposition(clnt);
                    afficher();
                    effacer();
                }
            }
        }else if(e.getSource()==rech){
            int ct=Integer.valueOf(tdexposition.getText());
            String c = null;
            clnt=Factory.getExpositionid(c);
            if(clnt!=null){
                recupInfo(clnt);
            }
        }else if(e.getSource()==upd){
            int idd=Integer.valueOf(tdexposition.getText());
             int id=Integer.valueOf(tdate_du_debut.getText());
              int idi=Integer.valueOf(tdate_de_fin.getText());
            String nm=ttitre.getText();
            String prn=tdescription.getText();
            String adr=tmusee.getText();
      
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                controller.Factory.ModifyExpositionID(idd,id,nm,prn,adr,idi);
                afficher();
            }
        }
    }
}
