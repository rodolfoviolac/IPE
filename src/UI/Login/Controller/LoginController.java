package UI.Login.Controller;

import Handlers.DataBase.DB;
import Handlers.DataBase.Data.UserData;
import Handlers.Model.Lot;
import UI.Emulator.Controller.EmulateSensorController;
import Handlers.Model.User;
import UI.Info.Controller.InfoController;
import UI.Login.View.LoginFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController{


    private LoginFrame loginFrame;
    private JButton confirmButton;
    private JTextField loginTextField;
    private JPasswordField passwordTextField;
    private UserData user_handler;


    public LoginController() {
        this.user_handler = new UserData();
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
                DB db = new DB();
                db.setLogedUser(user);
                Lot main_lot = new Lot();
                InfoController infoController = new InfoController(main_lot);
                loginFrame.setVisible(false);
                new EmulateSensorController(main_lot).showEmulatorSensorWindow();
                infoController.showLoginWindow();
            }

        }
    }

}
