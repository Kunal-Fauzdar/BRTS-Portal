import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class profilePage extends JFrame{
    JPanel profilePanel;
    
    profilePage()
    {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        profilePanel = new JPanel();
        profilePanel.setPreferredSize(new Dimension(575,525));
        profilePanel.setBackground(new Color(0X007BFF));
        profilePanel.setLayout(new GridBagLayout());

        createProfileLabel();

        this.add(profilePanel);
        this.pack();
        this.setVisible(true);
    }
    void createProfileLabel()
    {

        String name = "";
        String emailAddress = "";
        String username = "";
        String password = "";
        int age =0;
        String gender = "";
        try
        {
            String query = "{Call getProfile(?,?)}";
            CallableStatement cst = main1.con.prepareCall(query);
            cst.setString(1,loginPage.username);
            cst.setString(2, new String(loginPage.password));
            ResultSet rs = cst.executeQuery();
            if(rs.next())
            {
                name = rs.getString(1);
                emailAddress = rs.getString(2);
                username = rs.getString(3);
                password = rs.getString(4);
                age = rs.getInt(5);
                gender = rs.getString(6);
            }
        }
        catch(SQLException e1)
        {
            JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name : "+name);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        profilePanel.add(nameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel emailAdressLabel = new JLabel();
        emailAdressLabel.setText("email address : "+emailAddress);
        emailAdressLabel.setForeground(Color.WHITE);
        emailAdressLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        profilePanel.add(emailAdressLabel, gbc);

    

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel usernameLabel1 = new JLabel();
        usernameLabel1.setText("username : "+username);
        usernameLabel1.setForeground(Color.WHITE);
        usernameLabel1.setFont(new Font("Arial", Font.PLAIN, 23));
        profilePanel.add(usernameLabel1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("password : "+password);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        profilePanel.add(passwordLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel ageLabel = new JLabel();
        ageLabel.setText("age : "+age);
        ageLabel.setForeground(Color.WHITE);
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        profilePanel.add(ageLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel genderLabel = new JLabel();
        genderLabel.setText("gender : "+gender);
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        profilePanel.add(genderLabel, gbc);
    }
}
