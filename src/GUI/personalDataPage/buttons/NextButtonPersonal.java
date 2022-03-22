package GUI.personalDataPage.buttons;

import GUI.contactDataPage.ContactDataPage;
import GUI.errors.Errors;
import GUI.personalDataPage.panels.MainPanelPersonal;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButtonPersonal {

    private boolean flag = true;

    public JButton createNextButton(MainPanelPersonal mainPanelPersonal) {
        JButton button = new JButton("NEXT");
        button.setMinimumSize(new Dimension(100000, 100));
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
//                    Errors errors = new Errors();
//
//                    flag = errors.checkPersonalFields(mainPanelPersonal.getNameField(), mainPanelPersonal.getNameTextField(),
//                            mainPanelPersonal.getSurnameField(), mainPanelPersonal.getSurnameTextField(),
//                            mainPanelPersonal.getMothersMaidenNameField(), mainPanelPersonal.getMothersMaidenNameTextField(),
//                            mainPanelPersonal.getDateOfBirth(), mainPanelPersonal.getDaysBox().getSelectedItem().toString(),
//                            mainPanelPersonal.getMonthsBox().getSelectedItem().toString(),
//                            mainPanelPersonal.getYearsBox().getSelectedItem().toString(),
//                            mainPanelPersonal.getMartialStatus(), mainPanelPersonal.getStatusesBox().getSelectedItem().toString(),
//                            mainPanelPersonal.getEducation(), mainPanelPersonal.getStagesBox().getSelectedItem().toString()
//                    );

                    if(flag) {
                        PersonalData personalData = new PersonalData(mainPanelPersonal.getNameTextField().getText(),
                                mainPanelPersonal.getSurnameTextField().getText(),
                                mainPanelPersonal.getMothersMaidenNameTextField().getText(),
                                mainPanelPersonal.getDaysBox().getSelectedItem().toString(),
                                mainPanelPersonal.getMonthsBox().getSelectedItem().toString(),
                                "20",
                                //mainPanelPersonal.getYearsBox().getSelectedItem().toString(),
                                mainPanelPersonal.getStatusesBox().getSelectedItem().toString(),
                                mainPanelPersonal.getStagesBox().getSelectedItem().toString()
                        );

                        mainPanelPersonal.disposePersonalDataPage();
                        new ContactDataPage(personalData);
                    }
                }
            }
        });

        return button;
    }


}
