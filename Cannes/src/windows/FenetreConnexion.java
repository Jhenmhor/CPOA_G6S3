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
import javax.swing.JScrollPane;

/**
 *
 * @author p1623082
 */
public class FenetreConnexion extends JFrame /*implements ItemListener*/ {

    JLabel titre, logo, textFooter, labelmdp, labelid;
    JTextField mdp, id;
    JButton bconnexion /*, bnewcompte*/;
    JPanel panel, panellogo, paneltire, panelsaisi, panelbouton, panelfooter, panelvide;
    JScrollPane scroll;
    Object c;
    ArrayList<Personne> staff;
    Color or = new Color(200, 164, 97);

    public FenetreConnexion() {
        //On recupere depuis la base de données les informations du staff
        //et on les stock dans  la table staff
        try {
            this.staff = JDBC.selectStaffFromDB();
        } catch (Exception exp) {

        }//tester la connexion
        for (Personne s : staff) {
            String mdpbd = s.getMdp();
            int idbd = s.getid();
            System.out.println(mdpbd + " " + Integer.toString(idbd) + "test");
        }

        bconnexion = new JButton("Se connecter");
        bconnexion.setPreferredSize(new Dimension(120, 40));
        bconnexion.setBackground(or);
        c = bconnexion.getColorModel();
        mdp = new JTextField("", 10);
        id = new JTextField("", 10);
        
        logo = new JLabel(new ImageIcon("src/windows/logo2.jpg"));
        titre = new JLabel("Acceder à votre session ");
        //changer la taille et la police du titre
        Font f = new Font("Serif", Font.PLAIN, 36);
        titre.setFont(f);
        titre.setForeground(or);
        labelmdp = new JLabel("saisissez votre mot de passe ");
        labelid = new JLabel("saisissez votre identifiant ");
        Font fontsaisi = new Font("Serif", Font.PLAIN, 20);
        labelid.setFont(fontsaisi);
        labelmdp.setFont(fontsaisi);
        textFooter = new JLabel("Created by GUEYE & DECROZANT & PERREAUT");
        labelmdp.setForeground(or);
        labelid.setForeground(or);
        textFooter.setForeground(or);

        //Container c = getContentPane();
        //c.add(panel);
        panel = (JPanel) getContentPane();
        //scroll=new JScrollPane(logo);
        //this.add(scroll);
        //c.add(scroll);

        panel.setLayout(
                new GridLayout(6, 1));
        //definition des layouts
        FlowLayout posLayout = new FlowLayout(FlowLayout.LEFT);
        GridLayout layoutsaisi = new GridLayout(2, 2, 15, 20);
        GridLayout layouttitre = new GridLayout(1, 0);
        FlowLayout posLayoutCenter = new FlowLayout(FlowLayout.CENTER);
        //affectation des layouts
        paneltire = new JPanel(posLayoutCenter);
        panelsaisi = new JPanel(layoutsaisi);
        panelbouton = new JPanel(posLayoutCenter);
        panelfooter = new JPanel(posLayoutCenter);
        panellogo = new JPanel(posLayoutCenter);
        panelvide = new JPanel(posLayoutCenter);

        // AJOUT DE BORDURE
        panel.setBorder(BorderFactory.createTitledBorder("connexion"));
        //paneltire.setBorder(BorderFactory.createTitledBorder("  "));
        panelsaisi.setBorder(BorderFactory.createTitledBorder("  "));
        panelbouton.setBorder(BorderFactory.createTitledBorder("  "));
        //changer la couleur des bordures
        //Haut //Gauche //Bas //Droite
        /* panel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, or));
        panel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, or));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, or));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, or));
        /*
        panelsaisi.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, or));
        panelsaisi.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, or));
        panelsaisi.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, or));
        panelsaisi.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, or));
        
        panelbouton.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, or));
        panelbouton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, or));
        panelbouton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, or));
        panelbouton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, or));
         */
        //panelsaisi.setBorder(BorderFactory.createLineBorder(or));

        //changer la couleur des panels
        panel.setBackground(Color.BLACK);
        panelsaisi.setBackground(Color.black);
        panelbouton.setBackground(Color.BLACK);
        panellogo.setBackground(Color.BLACK);
        paneltire.setBackground(Color.BLACK);
        panelfooter.setBackground(Color.BLACK);
        panelvide.setBackground(Color.BLACK);

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
        //panel.add(panellogo);
        panel.add(paneltire);
        panel.add(panelsaisi);
        panel.add(panelbouton);
        panel.add(panelvide);
        panel.add(panelfooter);

        // GESTION  DES EVENEMENTS
        //on relie les elements concernés au classes interne
        bconnexion.addActionListener(new verifyconnexion());
        bconnexion.addMouseListener(new BoutonModifer());
        //windosw
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    }

    class verifyconnexion implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            boolean reponse;
            if (tryParseFloat(id.getText()) == null) {
                JOptionPane.showMessageDialog(FenetreConnexion.this, "'identifiant est composé de chiffre",
                        "message information", JOptionPane.INFORMATION_MESSAGE);
            } else { //verification avec la bd
                //convertir l'id en int
                int idint = Integer.parseInt(id.getText());
                reponse = verifybd(idint, mdp.getText());
                System.out.println(mdp.getText() + " " + Integer.toString(idint) + "test");
                if (reponse == false) {
                    JOptionPane.showMessageDialog(FenetreConnexion.this, "identifiant/mot de passe incorrecte!",
                            "message information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(FenetreConnexion.this, "identifiant/mot de passe correcte.",
                            "message information", JOptionPane.INFORMATION_MESSAGE);
<<<<<<< HEAD
                    
=======
>>>>>>> ad59cd94f38c144d0ea32c38b4d54ebc3942382f
                    FenetreConnexion.this.dispose();
                   PlanningWindow taSession = new PlanningWindow();
                  /* taSession.setIconImage(new ImageIcon("src/windows/logo.jpg").getImage());
                   taSession.setTitle("FVC: Gestion des plannings");*/
                   
                }
            }

        }
    }

    //comparer les donnes entrees avec celles de la bd
    public boolean verifybd(int id, String mdp) {
        //parcour de la table staff
        for (Personne s : staff) {
            String mdpbd = s.getMdp();
            int idbd = s.getid();
            if (id == idbd && mdp.equals(mdpbd)) {
                return true;
            }
        }
        return false;
    }

    //chiffrer l'identifiant
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
            bconnexion.setForeground(Color.black);
            bconnexion.setBackground(Color.GREEN);
        }

        public void mouseExited(MouseEvent e) {
            bconnexion.setText("Se connecter");
            bconnexion.setForeground(Color.black);
            bconnexion.setBackground(new Color(200, 164, 97));
        }

    }

    //CLASSE MAIN
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetreConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        PlanningWindow taSession = new PlanningWindow();

        FenetreConnexion connexion = new FenetreConnexion();
        //taille de la fenetre( ya deux 2 manieres de le faire) 
        //ça 
        connexion.setSize(600, 800);
        //ou ça
        //connexion.pack();
        // Positionnement au centre de l'écran
        connexion.setLocationRelativeTo(null);
        //titre de la fenetre
        connexion.setTitle("FVC: Gestion des plannings");
        //affichage
        connexion.setVisible(true);
        //j'essaie de  changer le background mais ça n'a pas marché
        connexion.getContentPane().setBackground(Color.white);
        //connexion.getContentPane().setBackground(new Color (20,20,20));
        //202020 //20016497
        //changer le logo
        connexion.setIconImage(new ImageIcon("src/windows/logo.jpg").getImage());
        //teste
        System.out.println(connexion.getWidth() + " " + connexion.getHeight());

    }

}
