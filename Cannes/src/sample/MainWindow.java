package sample;

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

/**
 * Created by Golemija on 12/9/2015.
 */

public class MainWindow extends JFrame {

    private JCheckBox guitarBox;
    private JCheckBox frenchBox;
    private JCheckBox germanBox;
    private JCheckBox pianoBox;
    private Choice teachers;
    private AwtCalendar calendar;
    ArrayList<Contact> contactsList;

    public MainWindow() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MindFusion Java Scheduler: Course Timetable");

        setMinimumSize(new Dimension(800, 600));

        contactsList = new ArrayList<Contact>();

        Container container = this.getContentPane();
        SpringLayout springLayout = new SpringLayout();
        container.setLayout(springLayout);

        teachers = new Choice();
        container.add(teachers);

        guitarBox = new JCheckBox("Guitar");
        guitarBox.setSelected(true);

        guitarBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });
        container.add(guitarBox);

        pianoBox = new JCheckBox("Piano");

        pianoBox.setSelected(true);
        pianoBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });

        container.add(pianoBox);

        germanBox = new JCheckBox("German");
        germanBox.setSelected(true);
        germanBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });

        container.add(germanBox);

        frenchBox = new JCheckBox("French");

        frenchBox.setSelected(true);
        frenchBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });

        container.add(frenchBox);

        springLayout.putConstraint(SpringLayout.SOUTH, frenchBox, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, frenchBox, 5, SpringLayout.EAST, guitarBox);

        springLayout.putConstraint(SpringLayout.SOUTH, pianoBox, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, pianoBox, 5, SpringLayout.EAST, frenchBox);

        springLayout.putConstraint(SpringLayout.SOUTH, germanBox, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, germanBox, 5, SpringLayout.EAST, pianoBox);

        JLabel label = new JLabel("Select a teacher:");
        container.add(label);

        calendar = new AwtCalendar();
        calendar.beginInit();
        calendar.setCurrentView(3);
        calendar.setTheme(4);
        calendar.setCustomDraw(CustomDrawElements.TimetableItem);
        calendar.setGroupType(GroupType.FilterByContacts);

       /* calendar.getSelection().getSelectedElementsStyle().setBorderBottomColor(com.mindfusion.drawing.Colors.Transparent);
        calendar.getSelection().getSelectedElementsStyle().setBorderBottomWidth(-1);
        calendar.getSelection().getSelectedElementsStyle().setBorderLeftColor(Colors.Transparent);
        calendar.getSelection().getSelectedElementsStyle().setBorderLeftWidth(-1);
        calendar.getSelection().getSelectedElementsStyle().setBorderRightColor(Colors.Transparent);
        calendar.getSelection().getSelectedElementsStyle().setBorderRightWidth(-1);
        calendar.getSelection().getSelectedElementsStyle().setBorderTopColor(Colors.Transparent);
        calendar.getSelection().getSelectedElementsStyle().setBorderTopWidth(-1);
        calendar.getSelection().getSelectedElementsStyle().setFillColor(Colors.Transparent);
        calendar.getSelection().getSelectedElementsStyle().setBrush(Brushes.Transparent);
        calendar.getSelection().getSelectedElementsStyle().setHeaderBorderBottomColor(new Color(0, 0, 0, 0)); */

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

        for (int i = 0; i < 7; i++)
            calendar.getTimetableSettings().getDates().add(DateTime.today().addDays(i - 1));

        calendar.getTimetableSettings().setItemOffset(30);
        calendar.getTimetableSettings().setShowItemSpans(false);
        calendar.getTimetableSettings().setSnapInterval(Duration.fromMinutes(1));
        calendar.getTimetableSettings().setVisibleColumns(7);
        calendar.endInit();

        springLayout.putConstraint(SpringLayout.EAST, calendar, 0, SpringLayout.EAST, container);
        springLayout.putConstraint(SpringLayout.NORTH, calendar, 0, SpringLayout.NORTH, container);
        springLayout.putConstraint(SpringLayout.WEST, calendar, 0, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.SOUTH, calendar, -35, SpringLayout.NORTH, guitarBox);

        springLayout.putConstraint(SpringLayout.WEST, teachers, 5, SpringLayout.EAST, label);
        springLayout.putConstraint(SpringLayout.SOUTH, teachers, -5, SpringLayout.NORTH, guitarBox);

        springLayout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.SOUTH, label, -5, SpringLayout.NORTH, guitarBox);

        springLayout.putConstraint(SpringLayout.SOUTH, guitarBox, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, guitarBox, 5, SpringLayout.WEST, container);

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

        initializeContacts();

        container.add(calendar);
    }

    /** Listens to the check boxes. */
    private void checkBoxChanged(java.awt.event.ItemEvent e) {
        boolean addItems = true;
        //Now that we know which Box was pushed, find out
        //whether it was selected or deselected.
        if (e.getStateChange() == java.awt.event.ItemEvent.DESELECTED) {
            addItems = false;
        }

        Object source = e.getItemSelectable();

        if (source == guitarBox) {

            for (Contact c : contactsList) {
                if (c.getId().startsWith("guitar")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        teachers.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        teachers.remove(c.getName());
                    }
                }
            }
        } else if (source == pianoBox) {
            for (Contact c : contactsList) {
                if (c.getId().startsWith("piano")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        teachers.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        teachers.remove(c.getName());
                    }
                }
            }
        } else if (source == germanBox) {
            for (Contact c : contactsList) {
                if (c.getId().startsWith("german")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        teachers.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        teachers.remove(c.getName());
                    }

                }
            }
        }
        else if (source == frenchBox) {
            for (Contact c : contactsList) {
                if (c.getId().startsWith("french")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        teachers.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        teachers.remove(c.getName());
                    }
                }
            }

        }
    }


    private void initializeContacts() {

        Contact contact = new Contact();
        contact.setId("german_MW");
        contact.setName("Michael Walmann");
        teachers.add(contact.getName());
        calendar.getContacts().add(contact);
        contactsList.add(contact);

        contact = new Contact();
        contact.setId("german_LB");
        contact.setName("Brigitte Koepf");
        calendar.getContacts().add(contact);
        teachers.add(contact.getName());
        contactsList.add(contact);

        contact = new Contact();
        contact.setId("piano_DR");
        contact.setName("David Rohnson");
        calendar.getContacts().add(contact);
        teachers.add(contact.getName());
        contactsList.add(contact);

        contact = new Contact();
        contact.setId("piano_EE");
        contact.setName("Elisabeth Evans");
        calendar.getContacts().add(contact);
        teachers.add(contact.getName());
        contactsList.add(contact);

        contact = new Contact();
        contact.setId("guitar_RS");
        contact.setName("Ricardo Smith");
        calendar.getContacts().add(contact);
        teachers.add(contact.getName());
        contactsList.add(contact);

        contact = new Contact();
        contact.setId("guitar_RW");
        contact.setName("Robert Wilson");
        calendar.getContacts().add(contact);
        teachers.add(contact.getName());
        contactsList.add(contact);

        contact = new Contact();
        contact.setId("french_FT");
        contact.setName("Francois Toreau");
        calendar.getContacts().add(contact);
        teachers.add(contact.getName());
        contactsList.add(contact);

        contact = new Contact();
        contact.setId("french_CR");
        contact.setName("Chantale Saron");
        calendar.getContacts().add(contact);
        teachers.add(contact.getName());
        contactsList.add(contact);

        contact = new Contact();
        contact.setId("piano_PD");
        contact.setName("Peter Drysdale");
        calendar.getContacts().add(contact);
        teachers.add(contact.getName());
        contactsList.add(contact);

        contact = new Contact();
        contact.setId("guitar_ER");
        contact.setName("Emma Rodriguez");
        calendar.getContacts().add(contact);
        teachers.add(contact.getName());
        contactsList.add(contact);
    }


    protected void onCalendarDraw(DrawEvent e) {
        if (e.getElement() == CustomDrawElements.TimetableItem) {

            Appointment app = (Appointment) e.getItem();

            if (app.getContacts().size() == 0)
                return;
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
                    e.getGraphics().drawImage(awtImage, e.getBounds().getLeft(), e.getBounds().getTop()+20);

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
        Appointment item = (Appointment)e.getItem();

        String teacherName = teachers.getSelectedItem();
        for(Contact c:calendar.getSchedule().getContacts()) {
            if (c.getName().equals(teacherName)) {
                item.getContacts().add(calendar.getContacts().get(c.getId()));

            }
        }
        item.setHeaderText(teacherName);

    }

    protected void onCalendarItemCreating(ItemConfirmEvent e)
    {
        DateTime start = e.getItem().getStartTime();
        DateTime end = e.getItem().getEndTime();


        if(start.getDayOfWeek() == 0 || end.getDayOfWeek() == 0)
        {
            JOptionPane.showMessageDialog(this, "No Classes on Sunday!");
            e.setConfirm(false);
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow window = null;
                try {
                    window = new MainWindow();
                    window.setVisible(true);
                }
                catch (Exception exp) {
                }
            }
        });
    }
}
