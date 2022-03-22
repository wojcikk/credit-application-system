package GUI.personalDataPage.panels;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class DateOfBirthPanel {

    private JComboBox<Integer> daysBox;
    private JComboBox<String> monthsBox;
    private JComboBox<Integer> yearsBox;

    public DateOfBirthPanel(JComboBox<Integer> daysBox, JComboBox<String> monthsBox, JComboBox<Integer> yearsBox) {
        this.daysBox = daysBox;
        this.monthsBox = monthsBox;
        this.yearsBox = yearsBox;
    }

    public JPanel createDateOfBirth() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel nameLabel = new JLabel("DATE OF BIRTH");
        JPanel selectDate = new JPanel();

        selectDate.setLayout(new BoxLayout(selectDate, BoxLayout.X_AXIS));

        nameLabel.setPreferredSize(new Dimension(200, 20));
        nameLabel.setMaximumSize(new Dimension(200, 20));
        selectDate.setMaximumSize(new Dimension(100000, 100));

        nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 50, 0, 0));

        selectDate.setBackground(new Color(250, 250, 250));

        nameLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        nameLabel.setForeground(Color.DARK_GRAY);

        daysBox.setSelectedIndex(0);
        monthsBox.setSelectedIndex(0);
        yearsBox.setSelectedIndex(122);

        daysBox.setFocusable(false);
        monthsBox.setFocusable(false);
        yearsBox.setFocusable(false);

        daysBox.setBackground(new Color(250, 250, 250));
        monthsBox.setBackground(new Color(250, 250, 250));
        yearsBox.setBackground(new Color(250, 250, 250));

        daysBox.setUI(new MyComboBoxUI());
        monthsBox.setUI(new MyComboBoxUI());
        yearsBox.setUI(new MyComboBoxUI());

        daysBox.setFont(new Font("Consolas", Font.PLAIN, 14));
        daysBox.setForeground(Color.DARK_GRAY);
        monthsBox.setFont(new Font("Consolas", Font.PLAIN, 14));
        monthsBox.setForeground(Color.DARK_GRAY);
        yearsBox.setFont(new Font("Consolas", Font.PLAIN, 14));
        yearsBox.setForeground(Color.DARK_GRAY);

        daysBox.setBorder(BorderFactory.createEmptyBorder(4, 15, 0, 0));
        monthsBox.setBorder(BorderFactory.createEmptyBorder(4, 15, 0, 0));
        yearsBox.setBorder(BorderFactory.createEmptyBorder(4, 15, 0, 0));

        selectDate.add(daysBox);
        selectDate.add(monthsBox);
        selectDate.add(yearsBox);

        panel.add(nameLabel);
        panel.add(selectDate);

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
