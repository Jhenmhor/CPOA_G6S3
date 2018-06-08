package windows;

//<editor-fold defaultstate="collapsed" desc="#import mindfusion">
import com.mindfusion.common.DateTime;
import com.mindfusion.common.Duration;
import com.mindfusion.common.MouseButtons;
import com.mindfusion.common.ChangeListener;
import com.mindfusion.drawing.Brushes;
import com.mindfusion.drawing.Colors;
import com.mindfusion.drawing.awt.AwtImage;
import com.mindfusion.scheduling.*;
import com.mindfusion.drawing.Color;
import com.mindfusion.scheduling.awt.AwtCalendar;
import com.mindfusion.scheduling.model.*;
import com.mindfusion.scheduling.model.ItemEvent;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="#import java windows item">
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

//<editor-fold defaultstate="collapsed" desc="#import JDatePicker">
import java.util.Locale;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//</editor-fold>

import gestion_film.*;
import java.sql.SQLException;

/**
 * Original creation by Golemija on 12/9/2015. modification by Toussaint on
 * 6/6/2018.
 *
 * @author Golemija & Toussaint
 */
public class PlanningWindow extends JFrame {
    
    private JCheckBox lmBox;
    private JCheckBox cmBox;
    private JCheckBox hcBox;
    private JCheckBox ucrBox;
    private Choice films;
    private AwtCalendar calendar;
    private ArrayList<Contact> CfilmList;
    
    private final ArrayList<Film> filmList;

    public PlanningWindow(ArrayList<Film> filmList) {
        this.filmList = filmList;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MindFusion Java Scheduler : Film Timetable");

        setMinimumSize(new Dimension(800, 600));

        Container container = this.getContentPane();
        SpringLayout springLayout = new SpringLayout();
        container.setLayout(springLayout);

        films = new Choice();
        
        lmBox = new JCheckBox("Long Métrage");
        lmBox.setSelected(true);
        lmBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });

        ucrBox = new JCheckBox("Un Certain Regard");
        ucrBox.setSelected(true);
        ucrBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });

        hcBox = new JCheckBox("Hors Compétition");
        hcBox.setSelected(true);
        hcBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });

        cmBox = new JCheckBox("Court Métrage");
        cmBox.setSelected(true);
        cmBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });

        container.add(films);
        container.add(lmBox);
        container.add(ucrBox);
        container.add(hcBox);
        container.add(cmBox);
        
        springLayout.putConstraint(SpringLayout.SOUTH, cmBox, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, cmBox, 5, SpringLayout.EAST, lmBox);

        springLayout.putConstraint(SpringLayout.SOUTH, ucrBox, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, ucrBox, 5, SpringLayout.EAST, cmBox);

        springLayout.putConstraint(SpringLayout.SOUTH, hcBox, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, hcBox, 5, SpringLayout.EAST, ucrBox);

        JLabel label = new JLabel("Sélectionner un film :");
        container.add(label);

        calendar = new AwtCalendar();
        calendar.beginInit();
        calendar.setCurrentView(CalendarView.Timetable);
        calendar.setTheme(ThemeType.Light);
        calendar.setCustomDraw(CustomDrawElements.TimetableItem);
        calendar.setGroupType(GroupType.FilterByContacts);

        calendar.getTimetableSettings().getCellStyle().setBorderBottomColor(new Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderBottomWidth(1);
        calendar.getTimetableSettings().getCellStyle().setBorderLeftColor(new Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderLeftWidth(1);
        calendar.getTimetableSettings().getCellStyle().setBorderRightColor(new Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderRightWidth(1);
        calendar.getTimetableSettings().getCellStyle().setBorderTopColor(new Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderTopWidth(1);
        calendar.getTimetableSettings().getCellStyle().setHeaderTextShadowOffset(0);
        calendar.getTimetableSettings().getCellStyle().setHeaderTextShadowStyle(ShadowStyle.None);
        calendar.getTimetableSettings().getDates().clear();

        DateTime startingDate = DateTime.today();

//        DatePicker datepicker = new DatePicker();
//        String mes = "Choose Starting Date :\n";
//        Object[] params = {mes, datepicker};
//
        /*startingdate = */ JOptionPane.showMessageDialog(container, "Start date");
        for (int i = 0; i < 15; i++) {
            calendar.getTimetableSettings().getDates().add(startingDate.addDays(i - 1));
        }

        calendar.getTimetableSettings().setItemOffset(30);
        calendar.getTimetableSettings().setShowItemSpans(false);
        calendar.getTimetableSettings().setSnapInterval(Duration.fromMinutes(1));
        calendar.getTimetableSettings().setVisibleColumns(7);
        calendar.endInit();

        springLayout.putConstraint(SpringLayout.EAST, calendar, 0, SpringLayout.EAST, container);
        springLayout.putConstraint(SpringLayout.NORTH, calendar, 0, SpringLayout.NORTH, container);
        springLayout.putConstraint(SpringLayout.WEST, calendar, 0, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.SOUTH, calendar, -35, SpringLayout.NORTH, lmBox);

        springLayout.putConstraint(SpringLayout.WEST, films, 5, SpringLayout.EAST, label);
        springLayout.putConstraint(SpringLayout.SOUTH, films, -5, SpringLayout.NORTH, lmBox);

        springLayout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.SOUTH, label, -5, SpringLayout.NORTH, lmBox);

        springLayout.putConstraint(SpringLayout.SOUTH, lmBox, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, lmBox, 5, SpringLayout.WEST, container);

        calendar.setEnableDragCreate(true);

        calendar.addCalendarListener(new CalendarAdapter() {
            public void draw(DrawEvent e) {
                onCalendarDraw(e);
            }

            public void itemCreated(ItemEvent e) {
                onItemCreated(e);
            }

            public void itemCreating(ItemConfirmEvent e) {
                onCalendarItemCreating(e);
            }

        });
        
        initializeFilm();
        
        container.add(calendar);
    }

    /**
     * Listens to the check boxes.
     */
    private void checkBoxChanged(java.awt.event.ItemEvent e) {
        boolean addItems = true;
        //Now that we know which Box was pushed, find out
        //whether it was selected or deselected.
        if (e.getStateChange() == java.awt.event.ItemEvent.DESELECTED) {
            addItems = false;
        }

        Object source = e.getItemSelectable();

        if (source == lmBox) {

            for (Contact c : CfilmList) {
                if (c.getId().startsWith("LM")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        films.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        films.remove(c.getName());
                    }
                }
            }
        } else if (source == ucrBox) {
            for (Contact c : CfilmList) {
                if (c.getId().startsWith("UCR")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        films.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        films.remove(c.getName());
                    }
                }
            }
        } else if (source == hcBox) {
            for (Contact c : CfilmList) {
                if (c.getId().startsWith("HC")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        films.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        films.remove(c.getName());
                    }

                }
            }
        } else if (source == cmBox) {
            for (Contact c : CfilmList) {
                if (c.getId().startsWith("CM")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        films.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        films.remove(c.getName());
                    }
                }
            }

        }
    }

    private void initializeFilm() {

        for (Film film : filmList ) {
            Contact contact = new Contact();
            contact.setId(film.getType() + "_" + Integer.toString(film.getID()));
            contact.setName(film.getNom());
            films.add(contact.getName());
            calendar.getContacts().add(contact);
            CfilmList.add(contact);
            System.out.println("FilmID : " + film.getID() + " " + film.getNom() + " " + film.getType() + " " + film.getDuree());
        }
    }

    protected void onCalendarDraw(DrawEvent e) {
        if (e.getElement() == CustomDrawElements.TimetableItem) {

            Appointment app = (Appointment) e.getItem();

            if (app.getContacts().size() == 0) {
                return;
            }
            if (app.getContacts().get(0).getId().startsWith("guitar")) {

                java.awt.Image img = null;

                try {
                    // Read the image file from an input stream
                    InputStream is = new BufferedInputStream(
                            new FileInputStream("../guitar.png"));
                    img = ImageIO.read(is);

                    com.mindfusion.common.Rectangle r = e.getBounds();
                    AwtImage awtImage = new AwtImage(img);
                    //draw the image
                    e.getGraphics().drawImage(awtImage, e.getBounds().getLeft(), e.getBounds().getTop() + 20);

                } catch (IOException ioe) {
                }
            } else if (app.getContacts().get(0).getId().startsWith("piano")) {

                java.awt.Image img = null;

                try {
                    // Read the image file from an input stream
                    InputStream is = new BufferedInputStream(
                            new FileInputStream("../piano.png"));
                    img = ImageIO.read(is);

                    com.mindfusion.common.Rectangle r = e.getBounds();
                    AwtImage awtImage = new AwtImage(img);
                    //draw the image
                    e.getGraphics().drawImage(awtImage, e.getBounds().getLeft(), e.getBounds().getTop() + 20);

                } catch (IOException ioe) {
                }
            } else if (app.getContacts().get(0).getId().startsWith("german")) {

                java.awt.Image img = null;

                try {
                    // Read the image file from an input stream
                    InputStream is = new BufferedInputStream(
                            new FileInputStream("../german.png"));
                    img = ImageIO.read(is);

                    com.mindfusion.common.Rectangle r = e.getBounds();
                    AwtImage awtImage = new AwtImage(img);
                    //draw the
                    e.getGraphics().drawImage(awtImage, e.getBounds().getLeft(), e.getBounds().getTop() + 20);

                } catch (IOException ioe) {
                }
            } else if (app.getContacts().get(0).getId().startsWith("french")) {

                java.awt.Image img = null;

                try {
                    // Read the image file from an input stream
                    InputStream is = new BufferedInputStream(
                            new FileInputStream("../french.png"));
                    img = ImageIO.read(is);

                    com.mindfusion.common.Rectangle r = e.getBounds();
                    AwtImage awtImage = new AwtImage(img);
                    //draw the image
                    e.getGraphics().drawImage(awtImage, e.getBounds().getLeft(), e.getBounds().getTop() + 20);

                } catch (IOException ioe) {
                }
            }
        }
    }

    protected void onItemCreated(ItemEvent e) {
        Appointment item = (Appointment) e.getItem();

        String teacherName = films.getSelectedItem();
        for (Contact c : calendar.getSchedule().getContacts()) {
            if (c.getName().equals(teacherName)) {
                item.getContacts().add(calendar.getContacts().get(c.getId()));

            }
        }
        item.setHeaderText(teacherName);

    }

    protected void onCalendarItemCreating(ItemConfirmEvent e) {
        DateTime start = e.getItem().getStartTime();
        DateTime end = e.getItem().getEndTime();

        if (start.getDayOfWeek() == 0 || end.getDayOfWeek() == 0) {
            JOptionPane.showMessageDialog(this, "No Classes on Sunday!");
            e.setConfirm(false);
        }
    }

    private DateTime getStartingDate() {
        DateTime startingDate = DateTime.today();

        return startingDate;
    }

    public static void main(String[] args) {
        
        ArrayList<Film> filmList;
        
        try {
        
            filmList = JDBC.selectFilmFromDB();
            
            SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PlanningWindow window = null;
                try {
                    window = new PlanningWindow(filmList);
                    window.setVisible(true);
                } catch (Exception exp) {
                }
            }
        });
        } catch (SQLException exp) {
        }
    }

//    private class CustomDatePicker extends PlanningWindow {
//
//        private Stage stage;
//        private DatePicker startingDatePicker;
//
//        public void start(Stage stage) {
//            this.stage = stage;
//            stage.setTitle("DatePickerSample ");
//            initUI();
//            stage.show();
//        }
//
//        private void initUI() {
//            VBox vbox = new VBox(20);
//            vbox.setStyle("-fx-padding: 10;");
//            Scene scene = new Scene(vbox, 400, 400);
//            stage.setScene(scene);
//
//            startingDatePicker = new DatePicker();
//
//            GridPane gridPane = new GridPane();
//            gridPane.setHgap(10);
//            gridPane.setVgap(10);
//
//            Label checkInlabel = new Label("Starting Date :");
//            gridPane.add(checkInlabel, 0, 0);
//
//            GridPane.setHalignment(checkInlabel, HPos.LEFT);
//            gridPane.add(startingDatePicker, 0, 1);
//            vbox.getChildren().add(gridPane);
//        }
//    }
}
