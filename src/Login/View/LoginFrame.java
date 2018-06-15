package Login.View;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JPanel loginPanel;
    private JButton confirmButton;
    private JTextField loginTextField;
    private JPasswordField passwordTextField;


    public LoginFrame() throws HeadlessException {
        setSize(400,400);
        setTitle("Login");
        setContentPane(loginPanel);
        setLocationRelativeTo(null);
    }

    public JTextField getLoginTextField() {
        return loginTextField;
    }

    public JPasswordField getPasswordTextField() {
        return passwordTextField;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }
}
