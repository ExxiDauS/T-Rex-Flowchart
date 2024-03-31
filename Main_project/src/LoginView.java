import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginView {
    private JFrame fr;
    private JPanel bagPanel, logoPanel, guestPanel;
    private JLabel logoLabel, signLabel, noaccLabel;
    private CustomTextField usernameTf;
    private CustomPasswordField passwordTf;
    private CustomButton loginBtn;
    private JButton contGuest;

    public LoginView() {
        try {
            //init
            fr = new JFrame("Login");
            logoPanel = new JPanel();   guestPanel = new JPanel();  bagPanel = new JPanel();
            signLabel = new JLabel();
            noaccLabel = new JLabel();
            contGuest = new JButton();
            usernameTf = new CustomTextField(); passwordTf = new CustomPasswordField();
            loginBtn = new CustomButton();

            //Register Font
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Thin.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Regular.ttf")));

            //GridBagLayout
            bagPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            //load image-logo and signLabel text config
            BufferedImage logo = ImageIO.read(new File("Main_project\\src\\picture\\Logo96.png"));
            logoLabel = new JLabel(new ImageIcon(logo));
            signLabel.setText("T-Rex");
            signLabel.setFont(new Font("Montserrat", Font.BOLD, 64));
            signLabel.setForeground(Color.BLACK);

            //logoPanel config
            logoPanel.add(logoLabel);
            logoPanel.add(signLabel);
            ((FlowLayout)logoPanel.getLayout()).setHgap(35);

            //TextField Config
            usernameTf.setText("Username");
            passwordTf.setText("Password");
            usernameTf.setForeground(new Color(119, 119, 119));
            passwordTf.setForeground(new Color(119, 119, 119));

            //Button Config
            loginBtn.setText("LOGIN");
            loginBtn.setForeground(Color.BLACK);

            //No account text
            noaccLabel.setText("No account?");
            noaccLabel.setFont(new Font("Montserrat", Font.PLAIN, 18));
            noaccLabel.setForeground(new Color(142, 142, 142));
            contGuest.setText("Continue as Guest");
            contGuest.setFont(new Font("Montserrat", Font.PLAIN, 18));
            contGuest.setOpaque(false);
            contGuest.setContentAreaFilled(false);
            contGuest.setBorder(new EmptyBorder(0,3,0,0));
            contGuest.setBorderPainted(false);
            contGuest.setForeground(new Color(0, 150, 136));
            guestPanel.add(noaccLabel);
            guestPanel.add(contGuest);
            ((FlowLayout)guestPanel.getLayout()).setHgap(0);

            //add to GridBag
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(0,0,20,0);
            gbc.gridx = 0;
            gbc.gridy = 0;
            bagPanel.add(logoPanel, gbc);
            gbc.insets = new Insets(60,0,0,0);
            gbc.gridy = 1;
            bagPanel.add(usernameTf, gbc);
            gbc.gridy = 2;
            bagPanel.add(passwordTf, gbc);
            gbc.gridy = 3;
            bagPanel.add(loginBtn, gbc);
            gbc.insets = new Insets(30,0,0,0);
            gbc.gridy = 4;
            bagPanel.add(guestPanel, gbc);
            ImageIcon img = new ImageIcon("Main_project//src//picture//logo96.png");
            fr.setIconImage(img.getImage());

            // showing frame config
            fr.add(bagPanel, BorderLayout.CENTER);
            fr.getContentPane().setBackground(new Color(234,234,234));
            fr.setSize(1280, 720);
            fr.setResizable(false);
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fr.setLocationRelativeTo(null);
            fr.setVisible(true);
        } catch (IOException|FontFormatException e) {
            e.printStackTrace();
        }
    }

    public JButton getLoginButton(){
        return loginBtn;
    }

    public JButton getGuestButton(){
        return contGuest;
    }

    public JTextField getUsernameTextField(){
        return usernameTf;
    }

    public JTextField getPasswordTextField(){
        return passwordTf;
    }

    public void setUsername(String text) {
        usernameTf.setText(text);
    }

    public void setPassword(String text) {
        if (text.equals("Password")) {
            passwordTf.setEchoChar((char)0);
            passwordTf.setText(text);
        }
        else {
            passwordTf.setEchoChar('*');
            passwordTf.setText(text);
        }
    }

    public JFrame getFrame() {
        return fr;
    }
}