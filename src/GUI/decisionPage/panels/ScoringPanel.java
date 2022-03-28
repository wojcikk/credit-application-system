package GUI.decisionPage.panels;

import logic.Decision;
import logic.scoring.ScoringSystem;

import javax.swing.*;
import java.awt.*;

public class ScoringPanel {
    public JPanel createPanel(ScoringSystem scoringSystem) {
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(1000000, 100));
        panel.setMaximumSize(new Dimension(1000000, 100));

        JPanel scoringTable = new JPanel();
        scoringTable.setLayout(new BoxLayout(scoringTable, BoxLayout.Y_AXIS));

        JPanel totalPoints = new JPanel();
        JPanel personalPoints = new JPanel();
        JPanel financialPoints = new JPanel();
        JPanel creditTermsPoints = new JPanel();

        totalPoints.setLayout(new BoxLayout(totalPoints, BoxLayout.X_AXIS));
        personalPoints.setLayout(new BoxLayout(personalPoints, BoxLayout.X_AXIS));
        financialPoints.setLayout(new BoxLayout(financialPoints, BoxLayout.X_AXIS));
        creditTermsPoints.setLayout(new BoxLayout(creditTermsPoints, BoxLayout.X_AXIS));
        totalPoints.setMaximumSize(new Dimension(10000, 50));
        personalPoints.setMaximumSize(new Dimension(10000, 50));
        financialPoints.setMaximumSize(new Dimension(10000, 50));
        creditTermsPoints.setMaximumSize(new Dimension(10000, 50));

        JLabel totalPointsPrompt = new JLabel("TOTAL POINTS: ");
        JLabel totalPointsScore = new JLabel(String.valueOf(scoringSystem.getScore()));
        JLabel personalPointsPrompt = new JLabel("personal points: ");
        JLabel personalPointsScore = new JLabel(String.valueOf(scoringSystem.getPersonalScore()));
        JLabel financialPointsPrompt = new JLabel("financial points: ");
        JLabel financialPointsScore = new JLabel(String.valueOf(scoringSystem.getFinancialScore()));
        JLabel creditTermsPointsPrompt = new JLabel("credit terms points: ");
        JLabel creditTermsPointsScore = new JLabel(String.valueOf(scoringSystem.getCreditTermsScore()));

        totalPointsPrompt.setFont(new Font("Consolas", Font.PLAIN, 20));
        personalPointsPrompt.setFont(new Font("Consolas", Font.PLAIN, 20));
        financialPointsPrompt.setFont(new Font("Consolas", Font.PLAIN, 20));
        creditTermsPointsPrompt.setFont(new Font("Consolas", Font.PLAIN, 20));

        totalPointsScore.setFont(new Font("Consolas", Font.PLAIN, 20));
        personalPointsScore.setFont(new Font("Consolas", Font.PLAIN, 20));
        financialPointsScore.setFont(new Font("Consolas", Font.PLAIN, 20));
        creditTermsPointsScore.setFont(new Font("Consolas", Font.PLAIN, 20));

        totalPointsPrompt.setForeground(Color.DARK_GRAY);
        personalPointsPrompt.setForeground(Color.DARK_GRAY);
        financialPointsPrompt.setForeground(Color.DARK_GRAY);
        creditTermsPointsPrompt.setForeground(Color.DARK_GRAY);

        totalPointsScore.setForeground(Color.DARK_GRAY);
        personalPointsScore.setForeground(Color.DARK_GRAY);
        financialPointsScore.setForeground(Color.DARK_GRAY);
        creditTermsPointsScore.setForeground(Color.DARK_GRAY);

        totalPointsPrompt.setBackground(Color.blue);
        totalPointsScore.setBackground(Color.green);

        totalPoints.add(Box.createHorizontalGlue());
        totalPoints.add(totalPointsPrompt);
        totalPoints.add(Box.createHorizontalGlue());
        totalPoints.add(totalPointsScore);
        totalPoints.add(Box.createHorizontalGlue());

        personalPoints.add(Box.createHorizontalGlue());
        personalPoints.add(personalPointsPrompt);
        personalPoints.add(Box.createHorizontalGlue());
        personalPoints.add(personalPointsScore);
        personalPoints.add(Box.createHorizontalGlue());

        financialPoints.add(Box.createHorizontalGlue());
        financialPoints.add(financialPointsPrompt);
        financialPoints.add(Box.createHorizontalGlue());
        financialPoints.add(financialPointsScore);
        financialPoints.add(Box.createHorizontalGlue());

        creditTermsPoints.add(Box.createHorizontalGlue());
        creditTermsPoints.add(creditTermsPointsPrompt);
        creditTermsPoints.add(Box.createHorizontalGlue());
        creditTermsPoints.add(creditTermsPointsScore);
        creditTermsPoints.add(Box.createHorizontalGlue());

        scoringTable.add(totalPoints);
        scoringTable.add(personalPoints);
        scoringTable.add(financialPoints);
        scoringTable.add(creditTermsPoints);

        panel.add(scoringTable);

        return panel;
    }
}
