import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

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

public class homePage extends JFrame implements ActionListener{
    int newWidth = 75;
    int newHeight = 75;
    static JPanel homePanel;
    static JLabel searchLabel;
    static JLabel searchResultLabel;
    static JPanel welcomePanel;
    static JLabel welcomeLabel;
    static JLabel settingLabel ;
    static JButton searchButton;
    static JButton payButton;
    static JTextField destinationTextField ;
    static JTextField sourceTextField;
    static JLabel ResultLabel;
    static JButton button1;
    static JButton button2;
    static JButton button3;
    static String source;
    static String destination;
    static JButton profileButton;
    static JButton mapButton;
    static JButton logoutButton;
    static JButton transactionButton;
    static payment_stack stack = new payment_stack(); 

    int bus_id_for_button1 = 0;
    int route_id_for_button1 = 0;

    int bus_id_for_button2 = 0;
    int route_id_for_button2 = 0;

    int bus_id_for_button3 = 0;
    int route_id_for_button3 = 0;
    homePage()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(0X007BFF));
        Border settingBorder = BorderFactory.createMatteBorder(3, 3, 3, 3 , Color.WHITE);
        Border searchTabBorder = BorderFactory.createMatteBorder(7, 7, 7, 7 , new Color(0X007BFF));
        Image image = new ImageIcon("C:\\Users\\Kunal Fauzdar\\OneDrive\\Pictures\\Screenshots\\logo.png").getImage();
        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon logoImage = new ImageIcon(resizedImage);
        welcomeLabel = new JLabel();
        welcomeLabel.setIcon(logoImage);
        welcomeLabel.setText("Welcome To BRTS Portal");
        welcomeLabel.setFont(new Font("Serif Bold",Font.BOLD,30));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
        welcomeLabel.setIconTextGap(-10);
        welcomePanel = new JPanel();
        welcomePanel.add(welcomeLabel);
        welcomePanel.setBackground(new Color(0x007BFF));
        homePanel = new JPanel();
        homePanel.setBackground(new Color(0x007BFF));
        homePanel.setLayout(null);
        searchLabel = new JLabel();
        searchLabel.setOpaque(true);
        searchLabel.setBackground(Color.WHITE);
        searchLabel.setBounds(5,10, 1175, 300);
        searchLabel.setBorder(searchTabBorder);


        searchResultLabel = new JLabel();
        searchResultLabel.setOpaque(true);
        searchResultLabel.setBackground(Color.WHITE);
        searchResultLabel.setBounds(5,310, 1175, 375);
        searchResultLabel.setBorder(searchTabBorder);
        searchResultLabel.setLayout(new GridBagLayout());


        // ResultLabel = new JLabel();
        // ResultLabel.setOpaque(true);
        // ResultLabel.setBackground(new Color(0x007BFF));
        // ResultLabel.setBounds(23,45, 1130, 225);
        // ResultLabel.setForeground(Color.WHITE);
        // ResultLabel.setFont(new Font("Arial", Font.BOLD, 23));

        settingLabel = new JLabel();
        settingLabel.setBounds(1185,10, 325, 600);
        settingLabel.setBorder(settingBorder);
        settingLabel.setLayout(new GridBagLayout());

        createsettingLabel();


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10,  10 , 10);

        
        button1 = new JButton();
        button1.setText("");
        button1.setBackground(Color.WHITE);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.PLAIN, 22));
        button1.setPreferredSize(new Dimension(1130,80));
        button1.addActionListener(this);
        button1.setBorder(null);
        button1.setFocusable(false);

        
        button2 = new JButton();
        button2.setText("");
        button2.setBackground(Color.WHITE);
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.PLAIN, 22));
        button2.setPreferredSize(new Dimension(1130,80));
        button2.addActionListener(this);
        button2.setBorder(null);
        button2.setFocusable(false);

        
        button3 = new JButton();
        button3.setText("");
        button3.setBackground(Color.WHITE);
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("Arial", Font.PLAIN, 22));
        button3.setPreferredSize(new Dimension(1130,80));
        button3.addActionListener(this);
        button3.setBorder(null);
        button3.setFocusable(false);



        createSearchTab();

        

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        searchResultLabel.add(button1,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        searchResultLabel.add(button2,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        searchResultLabel.add(button3,gbc);



        homePanel.add(searchLabel);
        homePanel.add(searchResultLabel);
        homePanel.add(settingLabel);
        
        this.revalidate();
        

        this.setLayout(new BorderLayout());
        this.add(welcomePanel,BorderLayout.NORTH);
        this.add(homePanel,BorderLayout.CENTER);
        this.setVisible(true);
    }
    void createSearchTab()
    {

        Border lowBorder = BorderFactory.createMatteBorder(0, 0 ,3, 0 ,new Color(0x007BFF));
        Border reaminingBorder = BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK);
        Border combinedBorder = BorderFactory.createCompoundBorder(lowBorder, reaminingBorder);
        Border buttonBorder = BorderFactory.createMatteBorder(2, 2, 2, 2 , Color.BLACK);
        Border leftBorder = BorderFactory.createMatteBorder(0, 3 ,0, 0 ,new Color(0x007BFF));
        searchLabel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10,  10 , 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 6;
        JLabel titleLabel = new JLabel();
        titleLabel.setText("                                    Search for Routes                                       ");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(0x007BFF));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        searchLabel.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel sourceLabel = new JLabel();
        sourceLabel.setText("                   Source");
        sourceLabel.setForeground(Color.BLACK);
        sourceLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        searchLabel.add(sourceLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel destinationLabel = new JLabel();
        destinationLabel.setText("          Destination");
        destinationLabel.setForeground(Color.BLACK);
        destinationLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        searchLabel.add(destinationLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        sourceTextField = new JTextField();
        sourceTextField.setForeground(Color.GRAY);
        sourceTextField.setFont(new Font("Arial", Font.PLAIN, 22));
        sourceTextField.setPreferredSize(new Dimension(175,30));
        sourceTextField.setBorder(combinedBorder);
        searchLabel.add(sourceTextField, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        destinationTextField = new JTextField();
        destinationTextField.setForeground(Color.GRAY);
        destinationTextField.setFont(new Font("Arial", Font.PLAIN, 22));
        destinationTextField.setPreferredSize(new Dimension(175,30));
        destinationTextField.setBorder(combinedBorder);
        searchLabel.add(destinationTextField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setBackground(Color.RED);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Arial", Font.PLAIN, 30));
        searchButton.setPreferredSize(new Dimension(400,32));
        searchButton.addActionListener(this);
        searchButton.setBorder(buttonBorder);
        searchButton.setFocusable(false);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(e.getSource() == searchButton)
                    {
                        source = sourceTextField.getText();
                        destination = destinationTextField.getText();
                        if(source.isEmpty() || destination.isEmpty())
                        {
                            sourceTextField.setText("");
                            destinationTextField.setText("");
                            JOptionPane.showMessageDialog(null,"Enter all details ", "Error", JOptionPane.WARNING_MESSAGE);

                        }
                        else
                        {
                            int source_station_id = 0;
                            int destination_station_id = 0;
                            String query = "{Call getStationId(?)}";
                            CallableStatement cst = main1.con.prepareCall(query);
                            cst.setString(1, source);
                            ResultSet rs = cst.executeQuery();
                            while(rs.next())
                            {
                                source_station_id = rs.getInt(1);
                            } 
                            System.out.println(source_station_id);
                            cst.setString(1, destination);
                            ResultSet rs1 = cst.executeQuery();
                            while(rs1.next())
                            {
                                destination_station_id = rs1.getInt(1);
                            }

                            if(source_station_id == 0 || destination_station_id == 0)
                            {
                                sourceTextField.setText("");
                                destinationTextField.setText("");
                                JOptionPane.showMessageDialog(null,"Buses not found", "Error", JOptionPane.WARNING_MESSAGE);
                            }
                            bus_id_for_button1 = 0;
                            route_id_for_button1 = 0;

                            bus_id_for_button2 = 0;
                            route_id_for_button2 = 0;

                            bus_id_for_button3 = 0;
                            route_id_for_button3 = 0;

                            button1.setText("");
                            button2.setText("");
                            button3.setText("");

                            button1.setBackground(Color.WHITE);
                            button2.setBackground(Color.WHITE);
                            button3.setBackground(Color.WHITE);
                            String bus_number = "";
                            String route_name = "";
                            String route_description = "";
                            System.out.println(destination_station_id);
                            String query2 = "SELECT DISTINCT b.bus_id , b.bus_number , r.route_name , r.route_description , r.route_id FROM buses_table b JOIN routes_table r ON b.route_id = r.route_id JOIN Route_Stations rs1 ON r.route_id = rs1.route_id JOIN Route_Stations rs2 ON r.route_id = rs2.route_id WHERE rs1.station_id = ? AND rs2.station_id = ? AND rs1.station_order < rs2.station_order and b.bus_id = rs1.bus_id ;";
                            PreparedStatement pst2 = main1.con.prepareStatement(query2);
                            pst2.setInt(1,source_station_id);
                            pst2.setInt(2, destination_station_id);
                            ResultSet rs2 = pst2.executeQuery();
                            if(rs2.next())
                            {
                                bus_id_for_button1 = rs2.getInt(1);
                                bus_number = rs2.getString(2);
                                route_name = rs2.getString(3);
                                route_description = rs2.getString(4);
                                route_id_for_button1 = rs2.getInt(5);
                                button1.setBackground(new Color(0x007BFF));
                                button1.setText("<html>Bus Number &nbsp;&nbsp;&nbsp;&nbsp; Bus Name &nbsp;&nbsp;&nbsp;&nbsp; Route Name &nbsp;&nbsp;&nbsp;&nbsp; Route Description &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>"+bus_id_for_button1+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+bus_number+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+route_name+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+route_description+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;</html>");
                            }
                            
                            
                            if(rs2.next())
                            {
                                bus_id_for_button2 = rs2.getInt(1);
                                bus_number = rs2.getString(2);
                                route_name = rs2.getString(3);
                                route_description = rs2.getString(4);
                                route_id_for_button2 = rs2.getInt(5);
                                button2.setBackground(new Color(0x007BFF));
                                button2.setText("<html>Bus Number &nbsp;&nbsp;&nbsp;&nbsp; Bus Name &nbsp;&nbsp;&nbsp;&nbsp; Route Name &nbsp;&nbsp;&nbsp;&nbsp; Route Description &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>"+bus_id_for_button2+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+bus_number+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+route_name+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+route_description+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;</html>");
                            }
                            

                            if(rs2.next())
                            {
                                bus_id_for_button3 = rs2.getInt(1);
                                bus_number = rs2.getString(2);
                                route_name = rs2.getString(3);
                                route_description = rs2.getString(4);
                                route_id_for_button3 = rs2.getInt(5);
                                button3.setBackground(new Color(0x007BFF));
                                button3.setText("<html>Bus Number &nbsp;&nbsp;&nbsp;&nbsp; Bus Name &nbsp;&nbsp;&nbsp;&nbsp; Route Name &nbsp;&nbsp;&nbsp;&nbsp; Route Description &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>"+bus_id_for_button3+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+bus_number+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+route_name+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+route_description+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;</html>");
                            }
                        }
                    }
                }
                catch(SQLException e1)
                {
                    JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);

                }
            }
        });


        searchLabel.add(searchButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel trending1Label = new JLabel();
        trending1Label.setText("4D Zundal - LD engineering");
        trending1Label.setForeground(Color.BLACK);
        trending1Label.setFont(new Font("Arial", Font.PLAIN, 18));
        trending1Label.setBorder(leftBorder);
        searchLabel.add(trending1Label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel trending2Label = new JLabel();
        trending2Label.setText("4U Zundal - LD engineering");
        trending2Label.setForeground(Color.BLACK);
        trending2Label.setFont(new Font("Arial", Font.PLAIN, 18));
        trending2Label.setBorder(leftBorder);
        searchLabel.add(trending2Label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel trending3Label = new JLabel();
        trending3Label.setText("12D LDE Engineering - RTO");
        trending3Label.setForeground(Color.BLACK);
        trending3Label.setFont(new Font("Arial", Font.PLAIN, 18));
        trending3Label.setBorder(leftBorder);
        searchLabel.add(trending3Label, gbc);


        // payButton = new JButton();
        // payButton.setText("Pay Now ");
        // payButton.setBackground(new Color(0x007BFF));
        // payButton.setForeground(Color.WHITE);
        // payButton.setFont(new Font("Arial", Font.PLAIN, 30));
        // payButton.setPreferredSize(new Dimension(320,32));
        // payButton.addActionListener(this);
        // payButton.setBorder(buttonBorder1);
        // payButton.setBounds(200, 295, 225, 40);
        // searchButton.setFocusable(false);

        // searchResultLabel.add(payButton);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
            if(e.getSource() == button1)
            {
                // this.dispose();
                new schedulePage(bus_id_for_button1, route_id_for_button1);
            }
            else if(e.getSource() == button2)
            {
                // this.dispose();
                new schedulePage(bus_id_for_button2,route_id_for_button2);
            }
            else if(e.getSource() == button3)
            {
                // this.dispose();
                new schedulePage(bus_id_for_button3, route_id_for_button3);
            }
            if(e.getSource() == profileButton)
            {
                new profilePage();
            }
            if(e.getSource() == mapButton)
            {
                new mapPage();
            }
            if(e.getSource() == logoutButton)
            {
                String old_content = "";
                FileReader fr = new FileReader("Transaction_History.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while(line != null)
                {
                    old_content = old_content + line+"\n";
                    line = br.readLine();
                }



                FileWriter fw = new FileWriter("Transaction_History.txt",false);
                BufferedWriter bw = new BufferedWriter(fw);
                while(!stack.isEmpty())
                {
                    String stack_content = stack.pop();
                    bw.write(stack_content);
                    bw.newLine();
                }
                bw.write(old_content);
                bw.flush();
                bw.close();
                this.dispose();
                new loginPage();
            }
            if(e.getSource() == transactionButton)
            {
                new transactionPage();
            }
        }
        catch(Exception e2)
        {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(null,e2.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    void createsettingLabel()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 10,  30 , 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        profileButton = new JButton();
        profileButton.setText("Profile");
        profileButton.setBackground(new Color(0x007BFF));
        profileButton.setForeground(Color.WHITE);
        profileButton.setFont(new Font("Arial", Font.PLAIN, 23));
        profileButton.setPreferredSize(new Dimension(400,75));
        profileButton.addActionListener(this);
        profileButton.setFocusable(false);
        profileButton.setBorder(null);
        settingLabel.add(profileButton , gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        mapButton = new JButton();
        mapButton.setText("Map");
        mapButton.setBackground(new Color(0x007BFF));
        mapButton.setForeground(Color.WHITE);
        mapButton.setFont(new Font("Arial", Font.PLAIN, 23));
        mapButton.setPreferredSize(new Dimension(400,75));
        mapButton.addActionListener(this);
        mapButton.setFocusable(false);
        mapButton.setBorder(null);
        settingLabel.add(mapButton , gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        transactionButton = new JButton();
        transactionButton.setText("Transaction History");
        transactionButton.setBackground(new Color(0x007BFF));
        transactionButton.setForeground(Color.WHITE);
        transactionButton.setFont(new Font("Arial", Font.PLAIN, 23));
        transactionButton.setPreferredSize(new Dimension(400,75));
        transactionButton.addActionListener(this);
        transactionButton.setFocusable(false);
        transactionButton.setBorder(null);
        settingLabel.add(transactionButton , gbc);
        


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        logoutButton = new JButton();
        logoutButton.setText("Log Out");
        logoutButton.setBackground(new Color(0x007BFF));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 23));
        logoutButton.setPreferredSize(new Dimension(400,75));
        logoutButton.addActionListener(this);
        logoutButton.setFocusable(false);
        logoutButton.setBorder(null);
        settingLabel.add(logoutButton , gbc);


    }
    public static void main(String[] args) {
        new homePage();
    }
}
