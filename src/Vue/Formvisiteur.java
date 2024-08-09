package vue;
import controller.Factory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.Client;


public class FormClient extends JFrame implements ActionListener{
    JLabel lid,lnom,lpre,ladr,ltel,lnat;
    JTextField tid,tnom,tpre,tadr,ttel;
    JComboBox tnat;
    JButton enr,vis,init,del,rech,upd;
    String[] pays={"Burundi","Rwanda","Tanzanie","RDC","Kenya","Soudan du sud","Ouganda"};
    ArrayList <Client> listeClient= new ArrayList();
    JTable tbclient;
    private final DefaultTableModel model;
    Client cl=new Client();
    Client clnt=null;
    
    public FormClient(){
        lid=new JLabel("ID");
        lid.setBounds(10,30,100,30);
        this.getContentPane().add(lid);
        
        tid=new JTextField("");
        tid.setBounds(120,30,100,30);
        this.getContentPane().add(tid);
        
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
        
        lpre=new JLabel("Prenom");
        lpre.setBounds(10,110,100,30);
        this.getContentPane().add(lpre);
        
        tpre=new JTextField("");
        tpre.setBounds(120,110,100,30);
        this.getContentPane().add(tpre);
        
        ladr=new JLabel("Adresse");
        ladr.setBounds(10,150,100,30);
        this.getContentPane().add(ladr);
        
        tadr=new JTextField("");
        tadr.setBounds(120,150,100,30);
        this.getContentPane().add(tadr);
        
        ltel=new JLabel("Telephone");
        ltel.setBounds(10,190,100,30);
        this.getContentPane().add(ltel);
        
        ttel=new JTextField("");
        ttel.setBounds(120,190,100,30);
        this.getContentPane().add(ttel);
        
        lnat=new JLabel("Nationalité");
        lnat.setBounds(10,230,100,30);
        this.getContentPane().add(lnat);
        
        tnat=new JComboBox(pays);
        tnat.setBounds(120,230,100,30);
        this.getContentPane().add(tnat);
        
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
        model.addColumn("Adresse");
        model.addColumn("Telephone");
        model.addColumn("Nationalité");
        
        this.setLayout(null);
    }
    
    public void effacer(){
        tid.setText("");
        tnom.setText("");
        tpre.setText("");
        tadr.setText("");
        ttel.setText("");
    }
    
    public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        listeClient= Factory.getclient();
        for(Client c:listeClient){
            model.addRow(new Object[]{
                    c.getId(),c.getNom(),c.getPrenom(),c.getAdresse(),c.getTel(),c.getNationalite()}
            );
        }
         
        tbclient=new JTable(model);
    JScrollPane p=new JScrollPane(tbclient);
    p.setBounds(60,310,300,100);
    this.getContentPane().add(p);
    }
    
    public void recupInfo(Client c){
        //tnum.setText(cr.getNum());
        tid.setText(String.valueOf(c.getId()));
        tnom.setText(c.getNom());
        tpre.setText(c.getPrenom());
        tadr.setText(c.getAdresse());
        ttel.setText(String.valueOf(c.getTel()));
        tnat.setSelectedItem(c.getNationalite());
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==enr){
            int i=Integer.valueOf(tid.getText());
            String  n=tnom.getText();
            String p=tpre.getText();
            String a=tadr.getText();
            int t=Integer.valueOf(ttel.getText());
            String na=String.valueOf(tnat.getSelectedItem());
            cl=new Client(i,t,n,p,a,na);
            Factory.insererClient(cl);
        }else if(e.getSource()==vis){
            afficher();
        }else if(e.getSource()==init){
            effacer();
        }else if(e.getSource()==del){
            if(clnt !=null){
                String msg="Voulez-vous reelement supprimer "+clnt.getNom()+" de la liste des clients";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    Factory.DeleteClient(clnt);
                    afficher();
                    effacer();
                }
            }
        }else if(e.getSource()==rech){
            int ct=Integer.valueOf(tid.getText());
            clnt=Factory.getClientID(ct);
            if(clnt!=null){
                recupInfo(clnt);
            }
        }else if(e.getSource()==upd){
            int idd=Integer.valueOf(tid.getText());
            String nm=tnom.getText();
            String prn=tpre.getText();
            String adr=tadr.getText();
            int tp=Integer.valueOf(ttel.getText());
            String nat=String.valueOf(tnat.getSelectedItem());
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                controller.Factory.ModifyClientID(idd,tp,nm,prn,adr,nat);
                afficher();
            }
        }
    }
}
