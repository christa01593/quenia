package vue;
import controller.Factory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.Employes;


public class Formemp extends JFrame implements ActionListener{
    JLabel lidemp,lsalaire,lnom,lprenom,lposte,lmusee;
    JTextField tidemp,tsalaire,tnom,tprenom,tposte,tmusee;
   
    JButton enr,vis,init,del,rech,upd;
    
    ArrayList <Employes> listeEmployes= new ArrayList();
    JTable tbclient;
    private final DefaultTableModel model;
    Employes cl=new Employes();
    Employes clnt=null;
    
    public Formemp(){
        lidemp=new JLabel("ID");
        lidemp.setBounds(10,30,100,30);
        this.getContentPane().add(lidemp);
        
        tidemp=new JTextField("");
        tidemp.setBounds(120,30,100,30);
        this.getContentPane().add(tidemp);
        
        rech=new JButton("Rechercher");
        rech.setBounds(230,30,100,30);
        rech.addActionListener(this);
        this.getContentPane().add(rech);
        
        lnom=new JLabel("Nom");
        lnom.setBounds(10,70,100,30);
        this.getContentPane().add(lnom);
        
        tnom=new JTextField("");
        tnom.setBounds(120,70,100,30);
        this.getContentPane().add(tnom);
        
        lprenom=new JLabel("Prenom");
        lprenom.setBounds(10,110,100,30);
        this.getContentPane().add(lprenom);
        
        tprenom=new JTextField("");
        tprenom.setBounds(120,110,100,30);
        this.getContentPane().add(tprenom);
        
        lsalaire=new JLabel("Salaire");
        lsalaire.setBounds(10,150,100,30);
        this.getContentPane().add(lsalaire);
        
        tsalaire=new JTextField("");
        tsalaire.setBounds(120,150,100,30);
        this.getContentPane().add(tsalaire);
        
        lposte=new JLabel("Poste");
        lposte.setBounds(10,190,100,30);
        this.getContentPane().add(lposte);
        
        tposte=new JTextField("");
        tposte.setBounds(120,190,100,30);
        this.getContentPane().add(tposte);
        
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
        model.addColumn("Nom");
        model.addColumn("Prenom");
        model.addColumn("Salaire");
        model.addColumn("Poste");
        model.addColumn("Musee");
        
        this.getContentPane().setLayout(null);
    }
    
    public void effacer(){
        tidemp.setText("");
        tnom.setText("");
        tsalaire.setText("");
        tprenom.setText("");
        tposte.setText("");
         tmusee.setText("");
    }
    
    public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        listeEmployes= Factory.getEmployes();
        for(Employes c:listeEmployes){
            model.addRow(new Object[]{
                    c.getIdemp(),c.getNom(),c.getPrenom(),c.getSalaire(),c.getPoste(),c.getMusee()}
            );
        }
         
        tbclient=new JTable(model);
    JScrollPane p=new JScrollPane(tbclient);
    p.setBounds(60,310,300,100);
    this.getContentPane().add(p);
    }
    
    public void recuupemp(Employes c){
        //tnum.setText(cr.getNum());
        tidemp.setText(String.valueOf(c.getIdemp()));
        tnom.setText(c.getNom());
        tprenom.setText(c.getPrenom());
        tposte.setText(c.getPoste());
        tsalaire.setText(String.valueOf(c.getSalaire()));
        tmusee.setText(c.getMusee());
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==enr){
            int i=Integer.valueOf(tidemp.getText());
            String  n=tnom.getText();
            String p=tprenom.getText();
            String a=tposte.getText();
            int t=Integer.valueOf(tsalaire.getText());
             String m=tmusee.getText();
             
            cl=new Employes(i,t,n,p,a,m);
            Factory.insererEmployes(clnt);
        }else if(e.getSource()==vis){
            afficher();
        }else if(e.getSource()==init){
            effacer();
        }else if(e.getSource()==del){
            if(clnt !=null){
                String msg="Voulez-vous reelement supprimer "+clnt.getNom()+" de la liste des employes";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    Factory.DeleteEmployes(clnt);
                    afficher();
                    effacer();
                }
            }
        }else if(e.getSource()==rech){
            int ct=Integer.valueOf(tidemp.getText());
            clnt=Factory.getEmployesid(ct);
            if(clnt!=null){
                recuupemp(clnt);
            }
        }else if(e.getSource()==upd){
            int idd=Integer.valueOf(tidemp.getText());
            String nm=tnom.getText();
            String prn=tprenom.getText();
            String adr=tposte.getText();
            int tp=Integer.valueOf(tsalaire.getText());
            String ad =tmusee.getText();
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
             //   controller.Factory.ModifyEmployesID(idd,tp,nm,prn,adr,);
                afficher();
            }
        }
    }
}
