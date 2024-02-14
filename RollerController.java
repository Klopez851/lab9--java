//Filename: RollerController.java
//Author: Keidy Lopez
//Description:

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollerController implements ActionListener {
    private Roller roller;
    private RollerView view;

    public RollerController() {
        roller = new Roller();
        view = new RollerView(roller, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof  JButton){
            JButton source = (JButton) e.getSource();
            if (source.getText().equals("Start Roll/s")){
                roller.roll(view.getRollAmount());
                view.update_view(roller);
            }
        }

    }


    public static void main(String[] args) {
        RollerController game = new RollerController();
    }
}
