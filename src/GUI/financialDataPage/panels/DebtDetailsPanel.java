package GUI.financialDataPage.panels;

import javax.swing.*;
import java.awt.*;

public class DebtDetailsPanel {

    JTextField value;

    public DebtDetailsPanel(JTextField value) {
        this.value = value;
    }

    public JPanel createDebtDetailsPanel() {
        JPanel details = new JPanel();
        JLabel valueText = new JLabel("Total debt to pay:");

        details.setLayout(new BoxLayout(details, BoxLayout.X_AXIS));

        //details.setBorder(BorderFactory.createEmptyBorder(0, 500, 0, -200));

        valueText.setPreferredSize(new Dimension(400, 20));
        valueText.setMaximumSize(new Dimension(400, 20));
        valueText.setHorizontalAlignment(JLabel.CENTER);
        value.setMaximumSize(new Dimension(100000, 100));

        valueText.setFont(new Font("Consolas", Font.PLAIN, 14));
        valueText.setForeground(Color.DARK_GRAY);

        value.setText("Enter value");
        value.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
        value.setBackground(new Color(250, 250, 250));
        value.setFont(new Font("Consolas", Font.PLAIN, 14));
        value.setForeground(Color.DARK_GRAY);

        details.add(valueText);
        details.add(value);

        details.setVisible(false);

        return details;
    }

}
