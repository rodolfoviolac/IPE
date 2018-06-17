package Login.Controller;

import DataBase.HandlerUserDB;
import EmulateSensors.Controller.EmulatorSensorController;
import Info.Controller.InfoController;
import Model.User;
import Login.View.LoginFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController{


    private LoginFrame loginFrame;
    private JButton confirmButton;
    private JTextField loginTextField;
    private JPasswordField passwordTextField;
    private HandlerUserDB user_handler;


    public LoginController() {
        this.user_handler = new HandlerUserDB();
        loginFrame = new LoginFrame();

        this.initComponents();
        this.initializerListeners();
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


    private class confirmButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            User user = user_handler.userWithParams(loginTextField.getText());
            if (user == null){
                JOptionPane.showMessageDialog(null, "Não exite usuário com esse login.");

            }
            else if (!user.getPassword().equals(new String(passwordTextField.getPassword()))){
                JOptionPane.showMessageDialog(null, "Senha incorreta.");
            }
            else{
                loginFrame.setVisible(false);
                new EmulatorSensorController().showEmulatorSensorWindow();
               // new InfoController();
            }

        }
    }

}
