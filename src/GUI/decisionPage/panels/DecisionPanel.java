package GUI.decisionPage.panels;

import logic.Decision;

import javax.swing.*;
import java.awt.*;

public class DecisionPanel {

    public JPanel createPanel(Decision decision) {
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(1000000, 30));
        panel.setMaximumSize(new Dimension(1000000, 100));

        JLabel decisionPrompt = new JLabel(decision.getDecisionPrompt().toUpperCase() + decision.getReasonPrompt().toUpperCase());

        decisionPrompt.setFont(new Font("Consolas", Font.BOLD, 20));
        decisionPrompt.setForeground(Color.DARK_GRAY);

        if(decision.isDecision()) panel.setBackground(new Color(181, 255, 201));
        else panel.setBackground(new Color(255, 181, 181));

        panel.add(decisionPrompt);

        return panel;
    }
}
