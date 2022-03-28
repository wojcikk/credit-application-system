package GUI.personalDataPage.panels;

import GUI.personalDataPage.PersonalDataPage;
import GUI.personalDataPage.buttons.NextButtonPersonal;
import GUI.personalDataPage.buttons.PreviousButtonPersonal;
import GUI.personalDataPage.panels.dataArrays.ArrayOfDates;
import GUI.personalDataPage.panels.dataArrays.ArrayOfEducationStages;
import GUI.personalDataPage.panels.dataArrays.ArrayOfMartialStatuses;
import GUI.template.ComboBoxPanel;
import GUI.template.StatusBar;
import GUI.template.TextFieldPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanelPersonal {
    // BUTTONS
    private final PersonalDataPage personalDataPage;

    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField mothersMaidenNameTextField;

    private JComboBox<Integer> daysBox;
    private JComboBox<String> monthsBox;
    private JComboBox<Integer> yearsBox;

    private JComboBox<String> statusesBox;

    private JComboBox<String> stagesBox;

    private JPanel nameField;
    private JPanel surnameField;
    private JPanel mothersMaidenNameField;
    private JPanel dateOfBirth;
    private JPanel martialStatus;
    private JPanel education;

    public MainPanelPersonal(PersonalDataPage personalDataPage) {
        this.personalDataPage = personalDataPage;
    }

    public JPanel createMainPanel() {
        JPanel panel = new JPanel();

        nameTextField = new JTextField();
        surnameTextField = new JTextField();
        mothersMaidenNameTextField = new JTextField();

        ArrayOfDates datesClass = new ArrayOfDates();

        daysBox = new JComboBox(datesClass.getDays());
        monthsBox = new JComboBox(datesClass.getMonths());
        yearsBox = new JComboBox(datesClass.getYears());

        ArrayOfMartialStatuses martialStatuses = new ArrayOfMartialStatuses();

        statusesBox = new JComboBox(martialStatuses.getStatuses());

        ArrayOfEducationStages educationStages = new ArrayOfEducationStages();

        stagesBox = new JComboBox(educationStages.getStages());

        TextFieldPanel textFieldClass = new TextFieldPanel();
        ComboBoxPanel comboBoxClass = new ComboBoxPanel();

        TitlePanelPersonal titlePanelPersonalClass = new TitlePanelPersonal();
        StatusBar statusBarClass = new StatusBar();
        DateOfBirthPanel dateOfBirthPanelClass = new DateOfBirthPanel(daysBox, monthsBox, yearsBox);
        PreviousButtonPersonal previousButtonClass = new PreviousButtonPersonal();
        NextButtonPersonal nextButtonClass = new NextButtonPersonal();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        panel.setBackground(Color.white);

        JPanel titlePanel = titlePanelPersonalClass.createTitlePanel();
        JPanel statusBar = statusBarClass.createStatusBarPanel(1);
        nameField = textFieldClass.createPanel(90, "NAME", "Enter name", nameTextField);
        surnameField = textFieldClass.createPanel(78, "SURNAME", "Enter surname", surnameTextField);
        mothersMaidenNameField = textFieldClass.createPanel(20, "MOTHER'S MAIDEN NAME", "Enter mother's maiden name", mothersMaidenNameTextField);
        dateOfBirth = dateOfBirthPanelClass.createDateOfBirth();
        martialStatus = comboBoxClass.createPanel(50, "MARTIAL STATUS", statusesBox);
        education = comboBoxClass.createPanel(70, "EDUCATION", stagesBox);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout());
        buttons.setMaximumSize(new Dimension(10000, 100));
        JButton nextButton = nextButtonClass.createNextButton(this);
        JButton previousButton = previousButtonClass.createPreviousButton(this);
        buttons.add(previousButton);
        buttons.add(nextButton);

        panel.add(Box.createVerticalGlue());
        panel.add(titlePanel);
        panel.add(statusBar);
        panel.add(Box.createVerticalGlue());
        panel.add(nameField);
        panel.add(Box.createVerticalGlue());
        panel.add(surnameField);
        panel.add(Box.createVerticalGlue());
        panel.add(mothersMaidenNameField);
        panel.add(Box.createVerticalGlue());
        panel.add(dateOfBirth);
        panel.add(Box.createVerticalGlue());
        panel.add(martialStatus);
        panel.add(Box.createVerticalGlue());
        panel.add(education);
        panel.add(Box.createVerticalGlue());
        panel.add(buttons);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getSurnameTextField() {
        return surnameTextField;
    }

    public JTextField getMothersMaidenNameTextField() {
        return mothersMaidenNameTextField;
    }

    public JComboBox<Integer> getDaysBox() {
        return daysBox;
    }

    public JComboBox<String> getMonthsBox() {
        return monthsBox;
    }

    public JComboBox<Integer> getYearsBox() {
        return yearsBox;
    }

    public JComboBox<String> getStatusesBox() {
        return statusesBox;
    }

    public JComboBox<String> getStagesBox() {
        return stagesBox;
    }

    public void disposePersonalDataPage() {
        personalDataPage.dispose();
    }

    public PersonalDataPage getPersonalDataPage() {
        return personalDataPage;
    }

    public JPanel getNameField() {
        return nameField;
    }

    public JPanel getSurnameField() {
        return surnameField;
    }

    public JPanel getMothersMaidenNameField() {
        return mothersMaidenNameField;
    }

    public JPanel getDateOfBirth() {
        return dateOfBirth;
    }

    public JPanel getMartialStatus() {
        return martialStatus;
    }

    public JPanel getEducation() {
        return education;
    }
}
