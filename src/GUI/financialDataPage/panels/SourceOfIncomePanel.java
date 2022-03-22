package GUI.financialDataPage.panels;

import GUI.financialDataPage.dataArrays.ArrayOfSources;
import GUI.financialDataPage.dataArrays.ArrayOfTypes;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.util.ArrayList;

public class SourceOfIncomePanel {

    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JCheckBox checkBox7;



    public JPanel createSourceOfIncome(ArrayList<JCheckBox> box) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel nameLabel = new JLabel("SOURCE OF INCOME");
        JPanel select = new JPanel();

        select.setLayout(new GridLayout(7, 1, 0, 10));

        nameLabel.setPreferredSize(new Dimension(200, 20));
        nameLabel.setMaximumSize(new Dimension(200, 20));
        //select.setMaximumSize(new Dimension(100000, 100));

        nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 35, 0, 0));

        select.setBackground(new Color(250, 250, 250));

        nameLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        nameLabel.setForeground(Color.DARK_GRAY);

        ArrayOfSources sources = new ArrayOfSources();
        checkBox1 = new JCheckBox(sources.getTypes()[0]);
        checkBox2 = new JCheckBox(sources.getTypes()[1]);
        checkBox3 = new JCheckBox(sources.getTypes()[2]);
        checkBox4 = new JCheckBox(sources.getTypes()[3]);
        checkBox5 = new JCheckBox(sources.getTypes()[4]);
        checkBox6 = new JCheckBox(sources.getTypes()[5]);
        checkBox7 = new JCheckBox(sources.getTypes()[6]);

        box.add(checkBox1);
        box.add(checkBox2);
        box.add(checkBox3);
        box.add(checkBox4);
        box.add(checkBox5);
        box.add(checkBox6);
        box.add(checkBox7);

        //sourceBox.setFocusable(false);

        for(int i = 0; i < box.size(); i++) {
            box.get(i).setBackground(new Color(250, 250, 250));
            box.get(i).setFont(new Font("Consolas", Font.PLAIN, 14));
            box.get(i).setForeground(Color.DARK_GRAY);
            box.get(i).setFocusable(false);
            box.get(i).setBorderPainted(false);
            select.add(box.get(i));
        }


        panel.add(nameLabel);
        panel.add(select);

        return panel;
    }

//    public static class MyComboBoxUI extends BasicComboBoxUI {
//        @Override
//        protected void installDefaults() {
//            super.installDefaults();
//            LookAndFeel.uninstallBorder(comboBox);
//        }
//
//        @Override
//        protected JButton createArrowButton() {
//            final JButton button = new JButton("+");
//            button.setMargin(new Insets(0, 0, 0, 0));
//            return button;
//        }
//
//        @Override
//        public void configureArrowButton() {
//            super.configureArrowButton(); //Do not forget this!
//            arrowButton.setBackground(new Color(250, 250, 250));
//            arrowButton.setForeground(Color.lightGray);
//            arrowButton.setBorder(BorderFactory.createEmptyBorder(-5, 0 , 0, 0));
//        }
//    }
}

