package vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Formprincipal extends JFrame implements ActionListener{
    JMenuBar ba;
    JMenu md,mt,mf;
    JMenuItem imus,iexp,iemp,ivis,iart,ibil,iqu;
    public Formprincipal(){
        ba=new JMenuBar();
        
        md=new JMenu("Données de base");
        mt=new JMenu("Traitement");
        mf=new JMenu("Fichier");
        
        imus=new JMenuItem("Musee");
        imus.addActionListener(this);
        iexp=new JMenuItem("Exposition");
        iexp.addActionListener(this);
        iart=new JMenuItem("Artiste");
        iart.addActionListener(this);
        
        iemp=new JMenuItem("Employe");
        iemp.addActionListener(this);
         ivis=new JMenuItem("Visiteur");
        ivis.addActionListener(this);
        ibil=new JMenuItem("Billet");
        ibil.addActionListener(this);
        iqu=new JMenuItem("Quiter");
        iqu.addActionListener(this);
        
        ba.add(md);
        ba.add(mt);
        ba.add(mf);
        
        md.add(imus);
        md.add(iexp);
        md.add(iart);
        md.add(iemp);
        md.add(ivis);
        md.add(ibil);
        mf.add(iqu);
        
        this.getContentPane().add(ba);
        ba.setBounds(10,10,400,40);
        
        this.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==iart){
            Formartiste C=new Formartiste();
            C.setSize(800,800);
            C.setTitle("Formulaire des artistes");
            C.setVisible(true);
        }else if(e.getSource()==ibil){
            Formbillet M=new Formbillet();
            M.setSize(800,800);
            M.setTitle("Formulaire des billets");
            M.setVisible(true);
        }else if(e.getSource()==iemp){
            Formemp R=new Formemp();
            R.setSize(800,800);
            R.setTitle("Formulaire des employes");
            R.setVisible(true);
        }else if(e.getSource()==iexp){
            Formexp T=new Formexp();
            T.setSize(800,800);
            T.setTitle("Formulaire des expositions");
            T.setVisible(true);
        } else if(e.getSource()==imus){
            Formmusee T=new Formmusee();
            T.setSize(800,800);
            T.setTitle("Formulaire du musee");
            T.setVisible(true);
        }  else if(e.getSource()==ivis){
            Formvisiteur T=new Formvisiteur();
            T.setSize(800,800);
            T.setTitle("Formulaire des visiteurs");
            T.setVisible(true);
        }else if(e.getSource()==iqu){
            dispose();
        }
    }
}
