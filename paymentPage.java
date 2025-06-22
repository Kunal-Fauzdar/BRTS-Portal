import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class paymentPage extends JFrame implements ActionListener {

    int bus_id;
    int route_id;
    String source;
    String destination;

    JPanel paymentPanel;
    JTextField accountNumberTextField;
    JPasswordField passwordField;
    JButton paymentButton;
    String accountNumber;
    char[] password;

    int amount;
    paymentPage(int bus_id , int route_id , String source , String destination)
    {

        this.bus_id = bus_id;
        this.route_id = route_id;
        this.source = source;
        this.destination = destination;

        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        paymentPanel = new JPanel();
        paymentPanel.setPreferredSize(new Dimension(575,525));
        paymentPanel.setBackground(new Color(0X007BFF));
        paymentPanel.setLayout(new GridBagLayout());

        createPaymentLabel();

        this.add(paymentPanel);
        this.pack();
        this.setVisible(true);
    }
    void createPaymentLabel()
    {

        Border lowBorder = BorderFactory.createMatteBorder(0, 0 ,3, 0 ,Color.WHITE);
        Border reaminingBorder = BorderFactory.createMatteBorder(1, 1, 0, 1, new Color(0x007BFF));
        Border combinedBorder = BorderFactory.createCompoundBorder(lowBorder, reaminingBorder);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 15 , 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel accountNumberLabel = new JLabel();
        accountNumberLabel.setText("Account Number");
        accountNumberLabel.setForeground(Color.WHITE);
        accountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        paymentPanel.add(accountNumberLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel passwordJLabel = new JLabel();
        passwordJLabel.setText("Password");
        passwordJLabel.setForeground(Color.WHITE);
        passwordJLabel.setFont(new Font("Arial", Font.PLAIN, 23));
        paymentPanel.add(passwordJLabel, gbc);

        calculateAmount();

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel amountJLabel1 = new JLabel();
        amountJLabel1.setText("Amount ");
        amountJLabel1.setForeground(Color.WHITE);
        amountJLabel1.setFont(new Font("Arial", Font.PLAIN, 23));
        paymentPanel.add(amountJLabel1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        JLabel amountJLabel2 = new JLabel();
        amountJLabel2.setText("RS "+amount);
        amountJLabel2.setForeground(Color.WHITE);
        amountJLabel2.setFont(new Font("Arial", Font.PLAIN, 23));
        paymentPanel.add(amountJLabel2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        accountNumberTextField = new JTextField();
        accountNumberTextField.setForeground(Color.GRAY);
        accountNumberTextField.setFont(new Font("Arial", Font.PLAIN, 22));
        accountNumberTextField.setPreferredSize(new Dimension(175,32));
        accountNumberTextField.setBorder(combinedBorder);
        paymentPanel.add(accountNumberTextField, gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        passwordField = new JPasswordField();
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 22));
        passwordField.setPreferredSize(new Dimension(175,32));
        passwordField.setBorder(combinedBorder);
        paymentPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        paymentButton = new JButton();
        paymentButton.setText("Pay Now");
        paymentButton.setBackground(Color.RED);
        paymentButton.setForeground(Color.WHITE);
        paymentButton.setFont(new Font("Arial", Font.PLAIN, 30));
        paymentButton.setPreferredSize(new Dimension(320,32));
        paymentButton.addActionListener(this);
        paymentButton.setFocusable(false);
        paymentPanel.add(paymentButton, gbc);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == paymentButton)
        {
            accountNumber = accountNumberTextField.getText();
            password = passwordField.getPassword();

            
                if(password.length == 0 || accountNumber.length() != 12 )
                {
                    accountNumberTextField.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(null,"Invalid account number or password", "title", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    LocalTime currentTime = LocalTime.now();
                    LocalDate currentDate = LocalDate.now();
                    String transaction_statement = "Account number "+accountNumber+"\nAmount "+amount+"\nDate "+currentDate+"\nTime "+currentTime;
                    homePage.stack.push(transaction_statement);
                    JOptionPane.showMessageDialog(null,"Payment Succesful", "title", JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
                    
                }
        
            
        }
    }
    void calculateAmount()
    {
        try
        {

            int source_station_id = 0;
            int destination_station_id = 0;

            String q = "{call getStationId(?)}";
            CallableStatement cst = main1.con.prepareCall(q);
            cst.setString(1,source);
            ResultSet rs = cst.executeQuery();
            while(rs.next())
            {
                source_station_id = rs.getInt(1);
            }
            

            cst.setString(1,destination);
            ResultSet rs1 = cst.executeQuery();
            while(rs1.next())
            {
                destination_station_id = rs1.getInt(1);
            }
            


            String q1 = "{call distanceCalc(?,?,?,?,?,?)}";
            CallableStatement cst1 = main1.con.prepareCall(q1);
            cst1.setInt(1,bus_id);
            cst1.setInt(2,route_id);
            cst1.setInt(3,source_station_id);
            cst1.setInt(4,destination_station_id);
            cst1.executeQuery();
            float source_distance = cst1.getFloat(5);
            float destination_distance = cst1.getFloat(6);

            float distance = destination_distance - source_distance;
            if(distance < 5.0)
            {
                amount = 5;
            }
            else if(distance < 10)
            {
                amount = 10;
            }
            else if(distance < 15)
            {
                amount = 15;
            }
            else if(distance < 20)
            {
                amount = 20;
            }
            else
            {
                amount = 30;
            }
        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
