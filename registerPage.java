import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class registerPage extends JFrame implements ActionListener{
    int newWidth = 175;
    int newHeight = 175;
    static JPanel registerPanel;
    static JLabel registerLabel;
    static JPanel welcomePanel;
    static JLabel welcomeLabel;
    static JButton registerButton ;
    static String name;
    static String email;
    static String username;
    static String password;
    static int age;
    static String gender;
    static JTextField nameTextField ;
    static JTextField emailTextField ;
    static JTextField usernameTextField;
    static JPasswordField passwordTextField ;
    static JTextField ageTextField;
    static JComboBox<String> genderComboBox;
    String[] genders = {"Male" , "Female" , "Other"};
    registerPage()
    {
        Image image = new ImageIcon("C:\\Users\\Kunal Fauzdar\\OneDrive\\Pictures\\Screenshots\\logo.png").getImage();
        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon logoImage = new ImageIcon(resizedImage);
        welcomeLabel = new JLabel();
        welcomeLabel.setIcon(logoImage);
        welcomeLabel.setText("Welcome To BRTS Portal");
        welcomeLabel.setFont(new Font("Serif Bold",Font.BOLD,35));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
        welcomeLabel.setIconTextGap(-10);
        welcomePanel = new JPanel();
        welcomePanel.add(welcomeLabel);
        welcomePanel.setBackground(new Color(0x007BFF));

        registerLabel = new JLabel();
        registerLabel.setPreferredSize(new Dimension(575,570));
        registerLabel.setOpaque(true);
        registerLabel.setBackground(Color.WHITE);
        registerLabel.setVerticalAlignment(JLabel.CENTER);
        registerLabel.setHorizontalAlignment(JLabel.CENTER);
        registerLabel.setLayout(new GridBagLayout());
        createRegisterPage();

        registerPanel = new JPanel();
        registerPanel.setBackground(new Color(0x007BFF));
        registerPanel.add(registerLabel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(0X007BFF));
        this.setLayout(new BorderLayout());
        this.add(registerPanel,BorderLayout.CENTER);
        this.add(welcomePanel,BorderLayout.NORTH);
        this.setVisible(true);
    }
    public void createRegisterPage()
    {
        Border lowBorder = BorderFactory.createMatteBorder(0, 0 ,4, 0 ,new Color(0x007BFF));
        Border reaminingBorder = BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK);
        Border combinedBorder = BorderFactory.createCompoundBorder(lowBorder, reaminingBorder);
        Border buttonBorder = BorderFactory.createMatteBorder(2, 2, 2, 2 , Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 5, 20 , 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel nameJLabel = new JLabel();
        nameJLabel.setText("Name");
        nameJLabel.setForeground(Color.BLACK);
        nameJLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        registerLabel.add(nameJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        nameTextField = new JTextField();
        nameTextField.setForeground(Color.GRAY);
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 22));
        nameTextField.setPreferredSize(new Dimension(175,32));
        nameTextField.setBorder(combinedBorder);
        registerLabel.add(nameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel emailAddress = new JLabel();
        emailAddress.setText("email");
        emailAddress.setForeground(Color.BLACK);
        emailAddress.setFont(new Font("Arial", Font.PLAIN, 23));
        registerLabel.add(emailAddress, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        emailTextField = new JTextField();
        emailTextField.setForeground(Color.GRAY);
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 22));
        emailTextField.setPreferredSize(new Dimension(175,32));
        emailTextField.setBorder(combinedBorder);
        registerLabel.add(emailTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel usernameJLabel = new JLabel();
        usernameJLabel.setText("username");
        usernameJLabel.setForeground(Color.BLACK);
        usernameJLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        registerLabel.add(usernameJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        usernameTextField = new JTextField();
        usernameTextField.setForeground(Color.GRAY);
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 22));
        usernameTextField.setPreferredSize(new Dimension(175,32));
        usernameTextField.setBorder(combinedBorder);
        registerLabel.add(usernameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel password = new JLabel();
        password.setText("password");
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Arial", Font.PLAIN, 23));
        registerLabel.add(password, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        passwordTextField = new JPasswordField();
        passwordTextField.setForeground(Color.GRAY);
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 22));
        passwordTextField.setPreferredSize(new Dimension(175,32));
        passwordTextField.setBorder(combinedBorder);
        registerLabel.add(passwordTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel ageJLabel = new JLabel();
        ageJLabel.setText("Age");
        ageJLabel.setForeground(Color.BLACK);
        ageJLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        registerLabel.add(ageJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        ageTextField = new JTextField();
        ageTextField.setForeground(Color.GRAY);
        ageTextField.setFont(new Font("Arial", Font.PLAIN, 22));
        ageTextField.setPreferredSize(new Dimension(175,32));
        ageTextField.setBorder(combinedBorder);
        registerLabel.add(ageTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel genderJLabel = new JLabel();
        genderJLabel.setText("Gender");
        genderJLabel.setForeground(Color.BLACK);
        genderJLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        registerLabel.add(genderJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        genderComboBox = new JComboBox<String>(genders);
        genderComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
        genderComboBox.setPreferredSize(new Dimension(175,25));
        registerLabel.add(genderComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        registerButton = new JButton();
        registerButton.setText("Register");
        registerButton.setBackground(Color.RED);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Arial", Font.PLAIN, 30));
        registerButton.setPreferredSize(new Dimension(320,32));
        registerButton.addActionListener(this);
        registerButton.setBorder(buttonBorder);
        registerButton.setFocusable(false);
        registerLabel.add(registerButton, gbc);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registerButton)
        {
            try
            {
                name = nameTextField .getText();
                email = emailTextField.getText();
                username = usernameTextField.getText();
                password = new String(passwordTextField.getPassword());
                age = Integer.parseInt(ageTextField.getText());
                int index = genderComboBox.getSelectedIndex();
                gender = genders[index];
                if(name.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || age== 0 || gender.isEmpty())
                {
                    nameTextField.setText("");
                    emailTextField.setText("");
                    usernameTextField.setText("");
                    passwordTextField.setText("");
                    ageTextField.setText("");
                    JOptionPane.showMessageDialog(null,"Invalid Input", "Error", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    String query = "Call insertLogin_info(?,?,?,?,?,?)";
                    CallableStatement cst = main1.con.prepareCall(query);
                    cst.setString(1,name);
                    cst.setString(2,email);
                    cst.setString(3,username);
                    cst.setString(4,password);
                    cst.setInt(5, age);
                    cst.setString(6,gender);
                    int x = cst.executeUpdate();
                    if(x != 0)
                    {
                        JOptionPane.showMessageDialog(null,"Registration Successfull", "Error", JOptionPane.PLAIN_MESSAGE);
                        this.dispose();
                        new homePage();
                    }
                }

            }
            catch(SQLException e1)
            {
                JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
            catch(Exception e2)
            {
                JOptionPane.showMessageDialog(null,e2.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
