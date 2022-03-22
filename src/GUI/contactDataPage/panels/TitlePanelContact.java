package GUI.contactDataPage.panels;

import javax.swing.*;
import java.awt.*;

public class TitlePanelContact {

    public JPanel createTitlePanel() {
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(1000, 50));
        panel.setMaximumSize(new Dimension(100000, 100));


        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel nameLabel = new JLabel("CONTACT DATA");

        panel.setOpaque(false);
        panel.setBackground(new Color(0,0,0,0));
        panel.setBorder(null);

        nameLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        nameLabel.setForeground(Color.DARK_GRAY);

        panel.add(nameLabel);

        return panel;
    }

}
