/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
/**
 *
 * @author p1623082
 */
public class FenetreConnexion extends JFrame {

    JLabel titre, logo, textFooter, labelmdp,labelid;
    JTextField mdp, id;
    JButton bconnexion, bnewcompte;
    JPanel panel,panellogo, paneltire, panelsaisi, panelbouton, panelfooter;
    public FenetreConnexion () {
        bconnexion = new JButton("Se connecter");
        bnewcompte = new JButton("creer un compte");
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
        panel.setLayout(new GridLayout(6,1));

        FlowLayout posLayout = new FlowLayout(FlowLayout.LEFT);
        GridLayout layoutsaisi = new GridLayout(2,2,15,20);
        GridLayout layouttitre = new GridLayout(1,0);
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
        panelbouton.add(bnewcompte);
        panelbouton.add(bconnexion);
        panelfooter.add(textFooter);
        //on ajoute les panels dans le panel principal
        panel.add(panellogo);
        panel.add(paneltire);
        panel.add(panelsaisi);
        panel.add(panelbouton);
        panel.add(panelfooter);
                     
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
