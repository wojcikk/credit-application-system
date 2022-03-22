package GUI.startingPage.panels;

import GUI.startingPage.StartingPage;
import GUI.startingPage.buttons.StartCalculationsButton;

import javax.swing.*;
import java.awt.*;

public class MainPanel {

    // BUTTONS
    private final StartingPage startingPage;

    public MainPanel(StartingPage startingPage) {
        this.startingPage = startingPage;
    }

    private final StartCalculationsButton startCalculationsButtonClass = new StartCalculationsButton();

    public JPanel createMainPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBackground(Color.WHITE);

        JButton startCalculationsButton = startCalculationsButtonClass.createStartCalculationsButton(startingPage);

        startCalculationsButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(startCalculationsButton);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

}
