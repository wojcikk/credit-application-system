package GUI.template;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TextFieldPanel {

    public JPanel createPanel(int leftMargin, String labelText, String textFieldText, JTextField textField) {
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel label = new JLabel(labelText);
        textField.setText(textFieldText);

        label.setPreferredSize(new Dimension(200, 20));
        label.setMaximumSize(new Dimension(200, 20));
        textField.setMaximumSize(new Dimension(100000, 100));

        label.setBorder(BorderFactory.createEmptyBorder(5, leftMargin, 0, 0));

        textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));

        textField.setBackground(new Color(250, 250, 250));

        label.setFont(new Font("Consolas", Font.PLAIN, 14));
        label.setForeground(Color.DARK_GRAY);
        textField.setFont(new Font("Consolas", Font.PLAIN, 14));
        textField.setForeground(Color.DARK_GRAY);

        textField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(textField.getText().contains("Enter") || textField.getText().contains("Wrong"))
                    textField.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        panel.add(label);
        panel.add(textField);

        return panel;
    }
}
