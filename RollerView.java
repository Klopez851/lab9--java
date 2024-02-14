//Filename: RollerView.java
//Author: Keidy Lopez
//Description:

import javax.swing.*;
import java.awt.event.ActionListener;

public class RollerView extends JFrame{
    private JFrame frame = new JFrame("Dice Roll");
    private SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1);
    private JSpinner jSpinner = new JSpinner(spinnerNumberModel);
    private JPanel mainPanel = new JPanel();
    private JLabel averageRolls, results, numberOfRolls, averageLabel, resultsLabel;
    private JButton initiateRoll;

    public RollerView(Roller roller, ActionListener rollAction){
        super("Dice Roller");
        // jSpinner and its label
        numberOfRolls = new JLabel("How many die would you like to roll?");
        mainPanel.add(numberOfRolls);
        mainPanel.add(jSpinner);

        //button nto initiate roll
        initiateRoll = new JButton("Start Roll/s");
        initiateRoll.addActionListener(rollAction);
        mainPanel.add(initiateRoll);

        //displays the current average of all rolls
        averageLabel = new JLabel("Average roll amount:");
        mainPanel.add(averageLabel);
        averageRolls = new JLabel(String.valueOf(roller.getAverage()));
        mainPanel.add(averageRolls);

        //displays the result of the last roll
        resultsLabel = new JLabel("last Roll total");
        mainPanel.add(resultsLabel);
        results = new JLabel(String.valueOf(roller.getLastRoll()));
        mainPanel.add(results);

        //adds panel to frame and sets it to visible
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    public int getRollAmount(){
        int rollAmount = (Integer) jSpinner.getValue();
        return rollAmount;
    }

    public void update_view(Roller roller) {
        averageRolls.setText(String.valueOf(roller.getAverage()));
        results.setText(String.valueOf(roller.getLastRoll()));
        update(this.getGraphics());
    }
}
//Problem woth JSpinner model, doest do anyhting if spinner = 1
//average works fine when small numbers are rolled but d