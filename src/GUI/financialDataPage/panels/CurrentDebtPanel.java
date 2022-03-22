package GUI.financialDataPage.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentDebtPanel {

    public JPanel createCurrentDebtPanel(JPanel propertyDetailsPanel, ButtonGroup group) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel nameLabel = new JLabel("CURRENT DEBT");
        JPanel select = new JPanel();

        select.setLayout(new BoxLayout(select, BoxLayout.X_AXIS));

        nameLabel.setPreferredSize(new Dimension(200, 20));
        nameLabel.setMaximumSize(new Dimension(200, 20));
        select.setMaximumSize(new Dimension(100000, 100));

        nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 55, 0, 0));

        select.setBackground(new Color(250, 250, 250));
        select.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        nameLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        nameLabel.setForeground(Color.DARK_GRAY);

        JLabel text = new JLabel("Do you have any obligations?");
        JRadioButton yes = new JRadioButton("YES");
        JRadioButton no = new JRadioButton("NO");

        text.setFont(new Font("Consolas", Font.PLAIN, 14));
        text.setForeground(Color.DARK_GRAY);
        yes.setFont(new Font("Consolas", Font.PLAIN, 14));
        yes.setForeground(Color.DARK_GRAY);
        no.setFont(new Font("Consolas", Font.PLAIN, 14));
        no.setForeground(Color.DARK_GRAY);

        yes.setFocusable(false);
        yes.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        yes.setBackground(new Color(250, 250, 250));

        no.setFocusable(false);
        no.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        no.setBackground(new Color(250, 250, 250));

        group.add(yes);
        group.add(no);

        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == yes) {
                    propertyDetailsPanel.setVisible(true);
                }
            }
        });

        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == no) {
                    propertyDetailsPanel.setVisible(false);
                }
            }
        });

        select.add(Box.createHorizontalGlue());
        select.add(text);
        select.add(Box.createHorizontalGlue());
        select.add(yes);
        select.add(Box.createHorizontalGlue());
        select.add(no);
        select.add(Box.createHorizontalGlue());

        panel.add(nameLabel);
        panel.add(select);

        return panel;
    }
}
