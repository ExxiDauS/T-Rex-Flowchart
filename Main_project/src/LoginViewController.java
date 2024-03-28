import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

public class LoginViewController implements FocusListener, ActionListener{
    private LoginView loginView;
    private FlowchartModel model;

    public LoginViewController(FlowchartModel model) {
        loginView = new LoginView();
        this.model = model;
        init();
    }

    public void init() {
        loginView.getLoginButton().addActionListener(this);
        loginView.getGuestButton().addActionListener(this);
        loginView.getUsernameTextField().addFocusListener(this);
        loginView.getPasswordTextField().addFocusListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(loginView.getLoginButton())) {
            if (model.logIn(loginView.getUsernameTextField().getText(), loginView.getPasswordTextField().getText())) {
                loginView.getFrame().dispose();
                model.setStatus("logged");
            }
            else {
                JOptionPane.showMessageDialog(null, "User not found");
            }
        }
        else if (ae.getSource().equals(loginView.getGuestButton())) {
            loginView.getFrame().dispose();
            model.setStatus("Guest");
            model.setUsername("Guest");
        }
    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (fe.getSource().equals(loginView.getUsernameTextField())) {
            if (loginView.getUsernameTextField().getText().equals("Username")) {
                loginView.setUsername("");
            }
        }
        else if (fe.getSource().equals(loginView.getPasswordTextField())) {
            if (loginView.getPasswordTextField().getText().equals("Password")) {
                loginView.setPassword("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        if (fe.getSource().equals(loginView.getUsernameTextField())) {
            if (loginView.getUsernameTextField().getText().isEmpty()) {
                loginView.setUsername("Username");
            }
        }
        else if (fe.getSource().equals(loginView.getPasswordTextField())) {
            if (loginView.getPasswordTextField().getText().isEmpty()) {
                loginView.setPassword("Password");
            }
        }
    }

    public static void main(String[] args) {
        new LoginViewController(new FlowchartModel());
    }

    public LoginView getLoginView() {
        return loginView;
    }
}
