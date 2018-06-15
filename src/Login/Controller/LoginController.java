package Login.Controller;

import Login.View.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class LoginController{


    private LoginFrame loginFrame;
    private JButton confirmButton;
    private JTextField loginTextField;
    private JPasswordField passwordTextField;


    public LoginController() {

        loginFrame = new LoginFrame();

        this.initComponents();
        this.initializerListeners();

        this.setView();

    }


    public void showLoginWindow(){

        loginFrame.setVisible(true);
    }


    private void initComponents(){

        this.loginTextField = loginFrame.getLoginTextField();
        this.passwordTextField = loginFrame.getPasswordTextField();
        this.confirmButton = loginFrame.getConfirmButton();

    }
    private void initializerListeners(){

        confirmButton.addActionListener(new confirmButtonListener());

    }


    private void setView(){
    }


    private class confirmButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.print("Rodolfinhoooo");

        }
    }
}
