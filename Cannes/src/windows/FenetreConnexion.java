/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import gestion_VIP.Personne;
import gestion_film.JDBC;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author p1623082
 */
public class FenetreConnexion extends JFrame /*implements ItemListener*/ {

    JLabel titre, logo, textFooter, labelmdp, labelid;
    JTextField mdp, id;
    JButton bconnexion /*, bnewcompte*/;
    JPanel panel, panellogo, paneltire, panelsaisi, panelbouton, panelfooter;
    Object c;
    ArrayList<Personne> staff;

    public FenetreConnexion() {
        try {
            this.staff = JDBC.selectStaffFromDB();
        } catch (Exception exp) {
        }

        bconnexion = new JButton("Se connecter");
        //bnewcompte = new JButton("creer un compte");
        //bconnexion.setBackground(Color.GREEN);
        c = bconnexion.getColorModel();
        mdp = new JTextField("", 10);
        id = new JTextField("", 10);
        logo = new JLabel(new ImageIcon("src/windows/img2.png"));
        titre = new JLabel("Acceder à votre session ");
        //changer la taille et la police du titre
        Font f = new Font("Serif", Font.PLAIN, 36); // par exemple
        titre.setFont(f);
        labelmdp = new JLabel("saisissez votre mot de passe ");
        labelid = new JLabel("saisissez votre identifiant ");
        textFooter = new JLabel("Created by GUEYE & DECROZANT & PERREAUT");

        panel = (JPanel) getContentPane();
        panel.setLayout(new GridLayout(6, 1));

        FlowLayout posLayout = new FlowLayout(FlowLayout.LEFT);
        GridLayout layoutsaisi = new GridLayout(2, 2, 15, 20);
        GridLayout layouttitre = new GridLayout(1, 0);
        FlowLayout posLayoutCenter = new FlowLayout(FlowLayout.CENTER);
        paneltire = new JPanel(posLayoutCenter);
        panelsaisi = new JPanel(layoutsaisi);
        panelbouton = new JPanel(posLayoutCenter);
        panelfooter = new JPanel(posLayoutCenter);
        panellogo = new JPanel(posLayoutCenter);

        // AJOUT DE BORDURE
        panel.setBorder(BorderFactory.createTitledBorder("connexion"));
        paneltire.setBorder(BorderFactory.createTitledBorder("  "));
        panelsaisi.setBorder(BorderFactory.createTitledBorder("  "));
        panelbouton.setBorder(BorderFactory.createTitledBorder("  "));
        //on affecte à chaque panel les comppsants appropriés
        panellogo.add(logo);
        paneltire.add(titre);
        panelsaisi.add(labelid);
        panelsaisi.add(id);
        panelsaisi.add(labelmdp);
        panelsaisi.add(mdp);
        // panelbouton.add(bnewcompte);
        panelbouton.add(bconnexion);
        panelfooter.add(textFooter);
        //on ajoute les panels dans le panel principal
        panel.add(panellogo);
        panel.add(paneltire);
        panel.add(panelsaisi);
        panel.add(panelbouton);
        panel.add(panelfooter);
        // GESTION  DES EVENEMENTS
        //on relie les elements concernés au classes interne
        bconnexion.addActionListener(new verifyconnexion());

    }
    
    class verifyconnexion implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            boolean reponse=true;
            if(tryParseFloat(id.getText()) == null) {
                    JOptionPane.showMessageDialog(FenetreConnexion.this, "'identifiant est composé de chiffre",
                            "message information", JOptionPane.INFORMATION_MESSAGE);
            }else{ //verification avec la bd
                //convertir l'id en int
                 int idint = Integer.parseInt(id.getText());
                reponse=verifybd (idint, mdp.getText());
                if(reponse==false){
                    JOptionPane.showMessageDialog(FenetreConnexion.this, "identifiant/mot de passe incorrecte!",
                            "message information", JOptionPane.INFORMATION_MESSAGE);
                }else{
                   JOptionPane.showMessageDialog(FenetreConnexion.this, "identifiant/mot de passe correcte. veuillez attendre la redirection!",
                            "message information", JOptionPane.INFORMATION_MESSAGE); 
                }
            }
                
        }
   }
    //comparer les donnes entrees avec celles de la bd
   public boolean verifybd (int id, String mdp)
         {
             //parcour de la table staff
             for(Personne s : staff){
                 String mdpbd=s.getMdp();
                 int idbd=s.getid();
                 if (id== idbd && mdp==mdpbd){
                    return true;
                }
             }           
             return false;
         }
    //chiffrer l'id
    Float tryParseFloat(String num) {
        try {
            return Float.parseFloat(num);
        } catch (NumberFormatException e) {
            //dialog
            return null;
        }
    }

    //classe interne qui change la couleur du bouton connecion lorsk la souris passe dessus
    class BoutonModifer extends MouseAdapter {

        public void mouseEntered(MouseEvent e) {
            bconnexion.setSize(120, 40);
            bconnexion.setForeground(Color.green);
            //bconnexion.setBackground(Color.blue);
        }

        public void mouseExited(MouseEvent e) {
            bconnexion.setText("Se connecter");
            bconnexion.setForeground(Color.black);
            //  bconnexion.setBackground(Color.getColor(c));
        }

    }
 
    public static void main(String[] args) {
        FenetreConnexion connexion = new FenetreConnexion();
        //taille de la fenetre( ya deux 2 manieres de le faire) 
        //ça 
        connexion.setSize(500, 700);
        //ou ça
        //premFen.pack();

        // Positionnement au centre de l'écran
        connexion.setLocationRelativeTo(null);
        //titre de la fenetre
        connexion.setTitle("FVC: Gestion des planning");
        //affichage
        connexion.setVisible(true);
        //j'essaie de  changer le background mais ça n'a pas marché
        connexion.setBackground(Color.red);
        //  connexion.setIconImage(new ImageIcon("src/windows/logo.jpg").getImage());

    }

}
