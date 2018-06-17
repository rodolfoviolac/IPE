package UI.Info.Controller;

import Handlers.Model.User;
import UI.Info.View.InfoFrame;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class InfoController {

    private InfoFrame infoFrame;
    private User currentUser;
    private JButton plowButton;
    private JButton stockButton;


    public InfoController(User currentUser) {
        infoFrame = new InfoFrame();
        this.currentUser = currentUser;
        this.initComponents();
        this.initializerListeners();
    }

    public void showLoginWindow(){

        infoFrame.setVisible(true);
    }


    private void initComponents(){

        this.plowButton = infoFrame.getPlowButton();
        this.stockButton = infoFrame.getStockButton();

        //this.infoFrame.setPhLabel();



    }
    private void initializerListeners(){
        stockButton.addActionListener(new stockButtonListener());
        plowButton.addActionListener(new plowButtonListener());

    }


    private class plowButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.print("plow button");

        }
    }

    private class stockButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.print("stock button");

        }
    }

}
