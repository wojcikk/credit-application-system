package GUI.template;

import javax.swing.*;
import java.awt.*;

public class StatusBar {

    public JPanel createStatusBarPanel(int status) {

        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(1000, 5));
        panel.setMaximumSize(new Dimension(100000, 100));

        panel.setLayout(new GridLayout(1, 4, 5, 0));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        panel.setOpaque(false);
        panel.setBackground(new Color(0,0,0,0));
        panel.setBorder(null);

        panel1.setBackground(Color.white);
        panel2.setBackground(Color.white);
        panel3.setBackground(Color.white);
        panel4.setBackground(Color.white);

        panel1.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        panel2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        panel3.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        panel4.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        if(status == 1) {
            panel1.setBackground(Color.lightGray);
            panel2.setBackground(Color.white);
            panel3.setBackground(Color.white);
            panel4.setBackground(Color.white);

            panel1.setBorder(BorderFactory.createLineBorder(Color.lightGray));
            panel2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
            panel3.setBorder(BorderFactory.createLineBorder(Color.lightGray));
            panel4.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        } else if(status == 2) {
            panel1.setBackground(new Color(181, 255, 201));
            panel2.setBackground(Color.lightGray);
            panel3.setBackground(Color.white);
            panel4.setBackground(Color.white);

            panel1.setBorder(BorderFactory.createLineBorder(new Color(181, 255, 201)));
            panel2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
            panel3.setBorder(BorderFactory.createLineBorder(Color.lightGray));
            panel4.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        } else if(status == 3) {
            panel1.setBackground(new Color(181, 255, 201));
            panel2.setBackground(new Color(181, 255, 201));
            panel3.setBackground(Color.lightGray);
            panel4.setBackground(Color.white);

            panel1.setBorder(BorderFactory.createLineBorder(new Color(181, 255, 201)));
            panel2.setBorder(BorderFactory.createLineBorder(new Color(181, 255, 201)));
            panel3.setBorder(BorderFactory.createLineBorder(Color.lightGray));
            panel4.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        } else if(status == 4) {
            panel1.setBackground(new Color(181, 255, 201));
            panel2.setBackground(new Color(181, 255, 201));
            panel3.setBackground(new Color(181, 255, 201));
            panel4.setBackground(Color.lightGray);

            panel1.setBorder(BorderFactory.createLineBorder(new Color(181, 255, 201)));
            panel2.setBorder(BorderFactory.createLineBorder(new Color(181, 255, 201)));
            panel3.setBorder(BorderFactory.createLineBorder(new Color(181, 255, 201)));
            panel4.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        } else if(status == 5) {
            panel1.setBackground(new Color(181, 255, 201));
            panel2.setBackground(new Color(181, 255, 201));
            panel3.setBackground(new Color(181, 255, 201));
            panel4.setBackground(new Color(181, 255, 201));

            panel1.setBorder(BorderFactory.createLineBorder(new Color(181, 255, 201)));
            panel2.setBorder(BorderFactory.createLineBorder(new Color(181, 255, 201)));
            panel3.setBorder(BorderFactory.createLineBorder(new Color(181, 255, 201)));
            panel4.setBorder(BorderFactory.createLineBorder(new Color(181, 255, 201)));
        }


        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);


        return panel;
    }

}
