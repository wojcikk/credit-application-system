package GUI.template;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class ComboBoxPanel {


    public JPanel createPanel(int leftMargin, String labelText, JComboBox<String> comboBox) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel label = new JLabel(labelText);
        JPanel select = new JPanel();

        select.setLayout(new BoxLayout(select, BoxLayout.X_AXIS));

        label.setPreferredSize(new Dimension(200, 20));
        label.setMaximumSize(new Dimension(200, 20));
        select.setMaximumSize(new Dimension(100000, 100));

        label.setBorder(BorderFactory.createEmptyBorder(5, leftMargin, 0, 0));

        select.setBackground(new Color(250, 250, 250));

        label.setFont(new Font("Consolas", Font.PLAIN, 14));
        label.setForeground(Color.DARK_GRAY);

        comboBox.setSelectedIndex(0);

        comboBox.setFocusable(false);

        comboBox.setBackground(new Color(250, 250, 250));

        comboBox.setUI(new MyComboBoxUI());

        comboBox.setFont(new Font("Consolas", Font.PLAIN, 14));
        comboBox.setForeground(Color.DARK_GRAY);

        comboBox.setBorder(BorderFactory.createEmptyBorder(4, 15, 0, 0));

        select.add(comboBox);

        panel.add(label);
        panel.add(select);

        return panel;
    }

    public static class MyComboBoxUI extends BasicComboBoxUI {
        @Override
        protected void installDefaults() {
            super.installDefaults();
            LookAndFeel.uninstallBorder(comboBox);
        }

        @Override
        protected JButton createArrowButton() {
            final JButton button = new JButton("+");
            button.setMargin(new Insets(0, 0, 0, 0));
            return button;
        }

        @Override
        public void configureArrowButton() {
            super.configureArrowButton(); //Do not forget this!
            arrowButton.setBackground(new Color(250, 250, 250));
            arrowButton.setForeground(Color.lightGray);
            arrowButton.setBorder(BorderFactory.createEmptyBorder(-5, 0 , 0, 0));
        }
    }
}
