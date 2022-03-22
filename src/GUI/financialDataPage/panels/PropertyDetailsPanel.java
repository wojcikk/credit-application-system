package GUI.financialDataPage.panels;

import javax.swing.*;
import java.awt.*;

public class PropertyDetailsPanel {

    JTextField value;

    public PropertyDetailsPanel(JTextField value) {
        this.value = value;
    }

    public JPanel createPropertyDetailsPanel() {
        JPanel details = new JPanel();
        JLabel valueText = new JLabel("Total value of owned real estate:");

        details.setLayout(new BoxLayout(details, BoxLayout.X_AXIS));

        //details.setBorder(BorderFactory.createEmptyBorder(0, 300, 0, 0));

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
