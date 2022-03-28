package GUI.contactDataPage.buttons;

import GUI.contactDataPage.panels.MainPanelContact;
import GUI.personalDataPage.PersonalDataPage;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousButtonContact {

    public JButton createPreviousButton(MainPanelContact mainPanel, PersonalData personalData) {
        JButton button = new JButton("PREV");
        button.setMaximumSize(new Dimension(100000, 100));

        button.setFocusable(false);
        button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        button.setBackground(new Color(250, 250, 250));


        button.setFont(new Font("Consolas", Font.PLAIN, 18));
        button.setForeground(Color.DARK_GRAY);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button) {
                    mainPanel.getContactDataPage().dispose();
                    PersonalDataPage personalDataPage = new PersonalDataPage();

                    restorePage(personalDataPage, personalData);
                }
            }
        });

        return button;
    }

    private void restorePage(PersonalDataPage personalDataPage, PersonalData personalData) {
        personalDataPage.getMainPanelPersonal().getNameTextField().setText(personalData.getName());
        personalDataPage.getMainPanelPersonal().getSurnameTextField().setText(personalData.getSurname());
        personalDataPage.getMainPanelPersonal().getMothersMaidenNameTextField().setText(personalData.getMothersMaidenName());
        personalDataPage.getMainPanelPersonal().getDaysBox().setSelectedItem(personalData.getDayOfBirth());
        personalDataPage.getMainPanelPersonal().getMonthsBox().setSelectedItem(personalData.getMonthOfBirth());
        personalDataPage.getMainPanelPersonal().getYearsBox().setSelectedItem(personalData.getYearOfBirth());
        personalDataPage.getMainPanelPersonal().getStatusesBox().setSelectedItem(personalData.getMartialStatus());
        personalDataPage.getMainPanelPersonal().getStagesBox().setSelectedItem(personalData.getEducation());
    }
}
