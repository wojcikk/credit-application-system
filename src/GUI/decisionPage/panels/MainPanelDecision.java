package GUI.decisionPage.panels;

import GUI.template.StatusBar;
import GUI.template.TitlePanel;
import logic.Decision;


import javax.swing.*;
import java.awt.*;

public class MainPanelDecision {

    private JPanel decisionPanel;
    private JPanel scoringTable;

    public JPanel createMainPanel(Decision decision) {
        JPanel panel = new JPanel();

        TitlePanel titlePanelClass = new TitlePanel();
        StatusBar statusBarClass = new StatusBar();

        panel.setBackground(Color.WHITE);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));

        JPanel titlePanel = titlePanelClass.createTitlePanel("DECISION");
        JPanel statusBar = statusBarClass.createStatusBarPanel(5);
        DecisionPanel decisionPanelClass = new DecisionPanel();
        ScoringPanel scoringPanelClass = new ScoringPanel();


        decisionPanel = decisionPanelClass.createPanel(decision);
        scoringTable = scoringPanelClass.createPanel(decision.getScoringSystem());

        panel.add(Box.createVerticalGlue());
        panel.add(titlePanel);
        panel.add(statusBar);
        panel.add(Box.createVerticalGlue());
        panel.add(decisionPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(scoringTable);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

}
