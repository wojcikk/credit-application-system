package GUI.financialDataPage.buttons;

import GUI.contactDataPage.ContactDataPage;
import GUI.financialDataPage.panels.MainPanelFinancial;
import logic.data.PersonalData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousButtonFinancial {

    public JButton createPreviousButton(MainPanelFinancial mainPanel, PersonalData personalData) {
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
                    mainPanel.getFinancialDataPage().dispose();
                    new ContactDataPage(personalData);

                }
            }
        });

        return button;
    }
}
