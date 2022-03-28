package GUI.template;

import javax.swing.*;
import java.awt.*;

public class TitlePanel {

    public JPanel createTitlePanel(String title) {
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(1000, 50));
        panel.setMaximumSize(new Dimension(100000, 100));

        JLabel nameLabel = new JLabel(title);

        panel.setOpaque(false);
        panel.setBackground(new Color(0,0,0,0));

        nameLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        nameLabel.setForeground(Color.DARK_GRAY);

        panel.add(nameLabel);


        return panel;
    }
}
