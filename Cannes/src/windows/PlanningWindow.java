/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

//<editor-fold defaultstate="collapsed" desc="#import java windows item">
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="#import mindfusion">
import com.mindfusion.common.DateTime;
import com.mindfusion.common.Duration;
import com.mindfusion.common.MouseButtons;
import com.mindfusion.common.ChangeListener;
import com.mindfusion.drawing.Brushes;
import com.mindfusion.drawing.Colors;
import com.mindfusion.drawing.awt.AwtImage;
import com.mindfusion.scheduling.*;
import com.mindfusion.scheduling.awt.AwtCalendar;
import com.mindfusion.scheduling.model.*;
import com.mindfusion.scheduling.model.ItemEvent;
import com.mindfusion.scheduling.Calendar;
//</editor-fold>

/**
 *
 * @author Toussaint
 */
public class PlanningWindow extends javax.swing.JFrame {


    /**
     * Creates new form PlanningWindow
     */
    public PlanningWindow() {
        initComponents();
        
        Color myBlack = new Color(20, 20, 20);
        Color myGold = new Color(200, 164, 97);
        
        getContentPane().setBackground(myBlack);

        calendar.beginInit();
        calendar.setCurrentView(CalendarView.Timetable);
        calendar.setTheme(ThemeType.Light);
        calendar.setCustomDraw(CustomDrawElements.TimetableItem);
        calendar.setGroupType(GroupType.FilterByContacts);

        calendar.getTimetableSettings().getCellStyle().setBorderBottomColor(new com.mindfusion.drawing.Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderBottomWidth(1);
        calendar.getTimetableSettings().getCellStyle().setBorderLeftColor(new com.mindfusion.drawing.Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderLeftWidth(1);
        calendar.getTimetableSettings().getCellStyle().setBorderRightColor(new com.mindfusion.drawing.Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderRightWidth(1);
        calendar.getTimetableSettings().getCellStyle().setBorderTopColor(new com.mindfusion.drawing.Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderTopWidth(1);
        calendar.getTimetableSettings().getCellStyle().setHeaderTextShadowOffset(0);
        calendar.getTimetableSettings().getCellStyle().setHeaderTextShadowStyle(ShadowStyle.None);
        calendar.getTimetableSettings().getDates().clear();

        DateTime startingDate = getStartingDate();
        
        for (int i = 0; i < 15; i++) {
            calendar.getTimetableSettings().getDates().add(startingDate.addDays(i - 1));
        }

        calendar.getTimetableSettings().setItemOffset(30);
        calendar.getTimetableSettings().setShowItemSpans(false);
        calendar.getTimetableSettings().setSnapInterval(Duration.fromMinutes(1));
        calendar.getTimetableSettings().setVisibleColumns(7);
        calendar.endInit();
        
        
        
        
    }

    private DateTime getStartingDate() {
        DateTime startingdate = DateTime.today();
        return startingdate;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        quitPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        detail = new javax.swing.JPanel();
        detailLabel = new javax.swing.JLabel();
        panelCalendar = new javax.swing.JPanel();
        panelJour = new javax.swing.JPanel();
        jpButton = new javax.swing.JButton();
        cdButton = new javax.swing.JButton();
        jsButton = new javax.swing.JButton();
        panelSchedule = new javax.swing.JPanel();
        calendar = new com.mindfusion.scheduling.awt.AwtCalendar();
        jTabbedOption2 = new javax.swing.JTabbedPane();
        jTabbedAffichage2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lmCheck2 = new javax.swing.JCheckBox();
        ucrCheck2 = new javax.swing.JCheckBox();
        cmCheck2 = new javax.swing.JCheckBox();
        hcCheck2 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        soiCheck2 = new javax.swing.JCheckBox();
        bunCheck2 = new javax.swing.JCheckBox();
        debCheck2 = new javax.swing.JCheckBox();
        gtlCheck2 = new javax.swing.JCheckBox();
        bazCheck2 = new javax.swing.JCheckBox();
        jTabbedEvenement = new javax.swing.JPanel();
        modifButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        createPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(20, 20, 20));
        setPreferredSize(new java.awt.Dimension(840, 720));

        title.setBackground(new java.awt.Color(20, 20, 20));
        title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        title.setToolTipText("");

        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/windows/logo2.jpg"))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(200, 164, 97));
        jLabel4.setText("Cannes");

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addComponent(titleLabel)
                .addGap(217, 217, 217)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 326, Short.MAX_VALUE))
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(titleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        quitPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 164, 97)));

        saveButton.setBackground(new java.awt.Color(200, 164, 97));
        saveButton.setForeground(new java.awt.Color(20, 20, 20));
        saveButton.setText("Sauvegarde Modification");

        cancelButton.setBackground(new java.awt.Color(200, 164, 97));
        cancelButton.setForeground(new java.awt.Color(20, 20, 20));
        cancelButton.setText("Annuler Modification");

        quitButton.setBackground(new java.awt.Color(200, 164, 97));
        quitButton.setForeground(new java.awt.Color(20, 20, 20));
        quitButton.setText("Quitter Application");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout quitPanelLayout = new javax.swing.GroupLayout(quitPanel);
        quitPanel.setLayout(quitPanelLayout);
        quitPanelLayout.setHorizontalGroup(
            quitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        quitPanelLayout.setVerticalGroup(
            quitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(quitButton)
                .addContainerGap())
        );

        detail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 164, 97)));

        detailLabel.setForeground(new java.awt.Color(20, 20, 20));
        detailLabel.setText("Detail Evenement :");

        javax.swing.GroupLayout detailLayout = new javax.swing.GroupLayout(detail);
        detail.setLayout(detailLayout);
        detailLayout.setHorizontalGroup(
            detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        detailLayout.setVerticalGroup(
            detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCalendar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 164, 97)));

        jpButton.setBackground(new java.awt.Color(200, 164, 97));
        jpButton.setForeground(new java.awt.Color(20, 20, 20));
        jpButton.setText("Jour Precedent");
        jpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpButtonActionPerformed(evt);
            }
        });
        panelJour.add(jpButton);

        cdButton.setBackground(new java.awt.Color(200, 164, 97));
        cdButton.setForeground(new java.awt.Color(20, 20, 20));
        cdButton.setText("Choisir Date");
        panelJour.add(cdButton);

        jsButton.setBackground(new java.awt.Color(200, 164, 97));
        jsButton.setForeground(new java.awt.Color(20, 20, 20));
        jsButton.setText("Jour Suivant");
        jsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsButtonActionPerformed(evt);
            }
        });
        panelJour.add(jsButton);

        javax.swing.GroupLayout panelScheduleLayout = new javax.swing.GroupLayout(panelSchedule);
        panelSchedule.setLayout(panelScheduleLayout);
        panelScheduleLayout.setHorizontalGroup(
            panelScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelScheduleLayout.setVerticalGroup(
            panelScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelCalendarLayout = new javax.swing.GroupLayout(panelCalendar);
        panelCalendar.setLayout(panelCalendarLayout);
        panelCalendarLayout.setHorizontalGroup(
            panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelJour, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
            .addComponent(panelSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCalendarLayout.setVerticalGroup(
            panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCalendarLayout.createSequentialGroup()
                .addComponent(panelJour, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedOption2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 164, 97)));
        jTabbedOption2.setMaximumSize(new java.awt.Dimension(6000, 6000));

        jTabbedAffichage2.setMaximumSize(new java.awt.Dimension(170, 390));
        jTabbedAffichage2.setMinimumSize(new java.awt.Dimension(170, 390));
        jTabbedAffichage2.setPreferredSize(new java.awt.Dimension(170, 390));

        jLabel7.setForeground(new java.awt.Color(20, 20, 20));
        jLabel7.setText("Types Film :");

        lmCheck2.setForeground(new java.awt.Color(20, 20, 20));
        lmCheck2.setSelected(true);
        lmCheck2.setText("Long Métrage");

        ucrCheck2.setForeground(new java.awt.Color(20, 20, 20));
        ucrCheck2.setSelected(true);
        ucrCheck2.setText("Un Certain Regard");
        ucrCheck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucrCheckActionPerformed(evt);
            }
        });

        cmCheck2.setForeground(new java.awt.Color(20, 20, 20));
        cmCheck2.setSelected(true);
        cmCheck2.setText("Court Métrage");

        hcCheck2.setForeground(new java.awt.Color(20, 20, 20));
        hcCheck2.setSelected(true);
        hcCheck2.setText("Hors Compétition");

        jLabel8.setText("Salles :");

        soiCheck2.setForeground(new java.awt.Color(20, 20, 20));
        soiCheck2.setSelected(true);
        soiCheck2.setText("La salle du Soixantième");

        bunCheck2.setForeground(new java.awt.Color(20, 20, 20));
        bunCheck2.setSelected(true);
        bunCheck2.setText("La salle Buñuel");
        bunCheck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bunCheckActionPerformed(evt);
            }
        });

        debCheck2.setForeground(new java.awt.Color(20, 20, 20));
        debCheck2.setSelected(true);
        debCheck2.setText("La salle Debussy");
        debCheck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debCheckActionPerformed(evt);
            }
        });

        gtlCheck2.setForeground(new java.awt.Color(20, 20, 20));
        gtlCheck2.setSelected(true);
        gtlCheck2.setText("Le Grand Théatre Lumière");
        gtlCheck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gtlCheckActionPerformed(evt);
            }
        });

        bazCheck2.setForeground(new java.awt.Color(20, 20, 20));
        bazCheck2.setSelected(true);
        bazCheck2.setText("La salle Bazin");

        javax.swing.GroupLayout jTabbedAffichage2Layout = new javax.swing.GroupLayout(jTabbedAffichage2);
        jTabbedAffichage2.setLayout(jTabbedAffichage2Layout);
        jTabbedAffichage2Layout.setHorizontalGroup(
            jTabbedAffichage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabbedAffichage2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jTabbedAffichage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bazCheck2)
                    .addComponent(soiCheck2)
                    .addComponent(bunCheck2)
                    .addComponent(debCheck2)
                    .addComponent(gtlCheck2)
                    .addComponent(hcCheck2)
                    .addComponent(cmCheck2)
                    .addComponent(ucrCheck2)
                    .addComponent(lmCheck2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jTabbedAffichage2Layout.setVerticalGroup(
            jTabbedAffichage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabbedAffichage2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lmCheck2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ucrCheck2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmCheck2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hcCheck2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gtlCheck2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(debCheck2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bunCheck2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soiCheck2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bazCheck2)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jTabbedOption2.addTab("Affichage", jTabbedAffichage2);

        jTabbedEvenement.setMaximumSize(new java.awt.Dimension(170, 390));
        jTabbedEvenement.setMinimumSize(new java.awt.Dimension(170, 390));
        jTabbedEvenement.setPreferredSize(new java.awt.Dimension(170, 390));

        modifButton.setBackground(new java.awt.Color(200, 164, 97));
        modifButton.setForeground(new java.awt.Color(20, 20, 20));
        modifButton.setText("Modifier Evenement");

        delButton.setBackground(new java.awt.Color(200, 164, 97));
        delButton.setForeground(new java.awt.Color(20, 20, 20));
        delButton.setText("Supprimer Evenement");

        jLabel1.setForeground(new java.awt.Color(20, 20, 20));
        jLabel1.setText("Création Evenement :");

        createButton.setBackground(new java.awt.Color(200, 164, 97));
        createButton.setForeground(new java.awt.Color(20, 20, 20));
        createButton.setText("Créer Evenement");

        jComboBox1.setBackground(new java.awt.Color(200, 164, 97));
        jComboBox1.setForeground(new java.awt.Color(20, 20, 20));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(200, 164, 97));
        jComboBox2.setForeground(new java.awt.Color(20, 20, 20));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Film", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setBackground(new java.awt.Color(200, 164, 97));
        jComboBox3.setForeground(new java.awt.Color(20, 20, 20));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Salle", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setBackground(new java.awt.Color(200, 164, 97));
        jComboBox4.setForeground(new java.awt.Color(20, 20, 20));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jury", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout createPanelLayout = new javax.swing.GroupLayout(createPanel);
        createPanel.setLayout(createPanelLayout);
        createPanelLayout.setHorizontalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        createPanelLayout.setVerticalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout jTabbedEvenementLayout = new javax.swing.GroupLayout(jTabbedEvenement);
        jTabbedEvenement.setLayout(jTabbedEvenementLayout);
        jTabbedEvenementLayout.setHorizontalGroup(
            jTabbedEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabbedEvenementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jTabbedEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modifButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delButton, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(createPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jTabbedEvenementLayout.setVerticalGroup(
            jTabbedEvenementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTabbedEvenementLayout.createSequentialGroup()
                .addComponent(createPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(modifButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delButton)
                .addContainerGap())
        );

        jTabbedOption2.addTab("Evenement", jTabbedEvenement);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelCalendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(detail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(quitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTabbedOption2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedOption2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpButtonActionPerformed

    private void jsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jsButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlanningWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlanningWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlanningWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanningWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanningWindow().setVisible(true);
            }
        });
    }

//<editor-fold defaultstate="collapsed" desc=" palette variable declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox bazCheck2;
    private javax.swing.JCheckBox bunCheck2;
    private com.mindfusion.scheduling.awt.AwtCalendar calendar;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cdButton;
    private javax.swing.JCheckBox cmCheck2;
    private javax.swing.JButton createButton;
    private javax.swing.JPanel createPanel;
    private javax.swing.JCheckBox debCheck2;
    private javax.swing.JButton delButton;
    private javax.swing.JPanel detail;
    private javax.swing.JLabel detailLabel;
    private javax.swing.JCheckBox gtlCheck2;
    private javax.swing.JCheckBox hcCheck2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jTabbedAffichage2;
    private javax.swing.JPanel jTabbedEvenement;
    private javax.swing.JTabbedPane jTabbedOption2;
    private javax.swing.JButton jpButton;
    private javax.swing.JButton jsButton;
    private javax.swing.JCheckBox lmCheck2;
    private javax.swing.JButton modifButton;
    private javax.swing.JPanel panelCalendar;
    private javax.swing.JPanel panelJour;
    private javax.swing.JPanel panelSchedule;
    private javax.swing.JButton quitButton;
    private javax.swing.JPanel quitPanel;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox soiCheck2;
    private javax.swing.JPanel title;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JCheckBox ucrCheck2;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
