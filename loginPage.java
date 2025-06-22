import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginPage extends JFrame implements ActionListener{
    int newWidth = 200;
    int newHeight = 200;
    // static loginPage ob = new loginPage();
    static JPanel loginPanel;
    static JLabel loginLabel;
    static JPanel welcomePanel;
    static JLabel welcomeLabel;
    static JButton loginButton;
    static JButton registerButton;
    static JTextField usernameTextField;
    static JPasswordField passwordTextField;
    static String username;
    static char[] password;
    loginPage()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(0X007BFF));
        this.setLayout(new BorderLayout());
        Image image = new ImageIcon("C:\\Users\\Kunal Fauzdar\\OneDrive\\Pictures\\Screenshots\\logo.png").getImage();
        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon logoImage = new ImageIcon(resizedImage);
        welcomeLabel = new JLabel();
        welcomeLabel.setIcon(logoImage);
        welcomeLabel.setText("Welcome To BRTS Portal");
        welcomeLabel.setFont(new Font("Serif Bold",Font.BOLD,45));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
        welcomeLabel.setIconTextGap(-10);
        welcomePanel = new JPanel();
        welcomePanel.add(welcomeLabel);
        welcomePanel.setBackground(new Color(0x007BFF));
        loginPanel = new JPanel();
        loginPanel.setBackground(new Color(0x007BFF));
        loginLabel = new JLabel();
        loginLabel.setPreferredSize(new Dimension(575,525));
        loginLabel.setOpaque(true);
        loginLabel.setBackground(Color.WHITE);
        loginLabel.setVerticalAlignment(JLabel.CENTER);
        loginLabel.setHorizontalAlignment(JLabel.CENTER);
        loginLabel.setLayout(new GridBagLayout());
        createLoginPage();
        loginPanel.add(loginLabel);
        this.add(welcomePanel,BorderLayout.NORTH);
        this.add(loginPanel,BorderLayout.CENTER);
        this.setVisible(true);
    }
    public void createLoginPage()
    {
        Border lowBorder = BorderFactory.createMatteBorder(0, 0 ,3, 0 ,new Color(0x007BFF));
        Border reaminingBorder = BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK);
        Border combinedBorder = BorderFactory.createCompoundBorder(lowBorder, reaminingBorder);
        Border buttonBorder = BorderFactory.createMatteBorder(2, 2, 2, 2 , Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 15 , 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel username = new JLabel();
        username.setText("username");
        username.setForeground(Color.BLACK);
        username.setFont(new Font("Arial", Font.PLAIN, 23));
        loginLabel.add(username, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel passwordJLabel = new JLabel();
        passwordJLabel.setText("Password");
        passwordJLabel.setForeground(Color.BLACK);
        passwordJLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        loginLabel.add(passwordJLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        usernameTextField = new JTextField();
        usernameTextField.setForeground(Color.GRAY);
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 22));
        usernameTextField.setPreferredSize(new Dimension(175,32));
        usernameTextField.setBorder(combinedBorder);
        loginLabel.add(usernameTextField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        passwordTextField = new JPasswordField();
        passwordTextField.setForeground(Color.GRAY);
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 22));
        passwordTextField.setPreferredSize(new Dimension(175,32));
        passwordTextField.setBorder(combinedBorder);
        loginLabel.add(passwordTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        loginButton = new JButton();
        loginButton.setText("Login");
        loginButton.setBackground(Color.RED);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.PLAIN, 30));
        loginButton.setPreferredSize(new Dimension(320,32));
        loginButton.addActionListener(this);
        loginButton.setBorder(buttonBorder);
        loginButton.setFocusable(false);
        loginLabel.add(loginButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        JLabel label = new JLabel();
        label.setText("OR");
        label.setForeground(Color.DARK_GRAY);
        label.setFont(new Font("Arial", Font.PLAIN, 25));
        loginLabel.add(label, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        registerButton = new JButton();
        registerButton.setText("Register");
        registerButton.setBackground(Color.ORANGE);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Arial", Font.PLAIN, 30));
        registerButton.setPreferredSize(new Dimension(320,32));
        registerButton.addActionListener(this);
        registerButton.setBorder(buttonBorder);
        registerButton.setFocusable(false);
        loginLabel.add(registerButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        JLabel messJLabel = new JLabel();
        messJLabel.setText("create a new user for freshly signup ");
        messJLabel.setFont(new Font("Arial",Font.PLAIN , 23));
        messJLabel.setForeground(Color.BLUE);
        loginLabel.add(messJLabel,gbc);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
            if(e.getSource() == loginButton)
            {
                username = usernameTextField.getText();
                password = passwordTextField.getPassword();
                
                if(username.isEmpty() || password.length == 0)
                {
                    JOptionPane.showMessageDialog(null,"Invalid username or password", "title", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    System.out.println("hello");
                    String query = "select name from login_info where username = ? and password = ? ;";
                    PreparedStatement pst = main1.con.prepareStatement(query);
                    pst.setString(1,username);
                    pst.setString(2, new String(password)); 
                    ResultSet rs = pst.executeQuery();
                    if(rs.next())
                    {
                        String name = rs.getString(1);
                        JOptionPane.showMessageDialog(null,"Welcome "+name, "title", JOptionPane.PLAIN_MESSAGE);
                        this.dispose();
                        new homePage();
                    }
                    else
                    {
                        usernameTextField.setText("");
                        passwordTextField.setText("");
                        JOptionPane.showMessageDialog(null,"Invalid username or password", "title", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            else if(e.getSource() == registerButton)
            {
                this.dispose();
                new registerPage();   
            }
        }
        catch(SQLException e1)
        {
            System.out.println(e1.getMessage());
        }
        catch(Exception e2)
        {
            System.out.println(e2.getMessage());
        }
    }
}
