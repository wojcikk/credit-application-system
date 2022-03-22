package GUI.startingPage.buttons;

import GUI.personalDataPage.PersonalDataPage;
import GUI.startingPage.StartingPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartCalculationsButton {


    public JButton createStartCalculationsButton(StartingPage startingPage) {
        JButton button = new JButton();

        button.setText("Calculate your possible credit!");

        button.setFont(new Font("Consolas", Font.PLAIN, 20));

        button.setBackground(new Color(248,248,248));
        button.setForeground(Color.DARK_GRAY);
        button.setBorder(null);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingPage.dispose();
                new PersonalDataPage();
            }
        });

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { }

            @Override
            public void mousePressed(MouseEvent e) { }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(243,243,243));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(248,248,248));
            }
        });

        return button;
    }
}
