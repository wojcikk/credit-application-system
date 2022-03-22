package GUI.personalDataPage.buttons;

import GUI.contactDataPage.panels.MainPanelContact;
import GUI.personalDataPage.PersonalDataPage;
import GUI.personalDataPage.panels.MainPanelPersonal;
import GUI.startingPage.StartingPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousButtonPersonal {

    public JButton createPreviousButton(MainPanelPersonal mainPanel) {
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
                    mainPanel.getPersonalDataPage().dispose();
                    new StartingPage();
                }
            }
        });

        return button;
    }
}
