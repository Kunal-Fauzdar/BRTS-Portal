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


public class schedulePage extends JFrame implements  ActionListener {

    int newWidth = 75;
    int newHeight = 75;
    int bus_id = 0;
    int route_id = 0;

    static JPanel welcomePanel;
    static JLabel welcomeLabel;

    static JPanel mainPanel;
    static JLabel scheduleLabel;

    static JLabel stationLablel;
    

    JButton payButton;

    scheduleQueue queue_for_schedule;

    int size;

    timing temporary;
    timing[] timingarr = new timing[5];

    stationLinkedList linkedList_for_Station = new stationLinkedList();

    JButton[] buttons = new JButton[6];
    schedulePage(int bus_id , int route_id)
    {
        this.bus_id = bus_id;
        this.route_id = route_id;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(0X007BFF));
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

        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(0x007BFF));
        mainPanel.setLayout(null);

        scheduleLabel = new JLabel();
        scheduleLabel.setOpaque(true);
        scheduleLabel.setBackground(Color.WHITE);
        scheduleLabel.setBounds(5,10, 900, 575);
        scheduleLabel.setBorder(searchTabBorder);
        scheduleLabel.setLayout(new GridBagLayout());


        payButton = new JButton();
        payButton.setText("Pay Now");
        payButton.setBackground(Color.RED);
        payButton.setForeground(Color.WHITE);
        payButton.setFont(new Font("Arial", Font.PLAIN, 30));
        payButton.setBounds(350, 579, 400 , 35);
        payButton.addActionListener(this);
        payButton.setFocusable(false);
        payButton.setEnabled(false);
        
        // button1 = new JButton();
        // button1.setText("Hello");
        // button1.setBackground(Color.WHITE);
        // button1.setForeground(Color.WHITE);
        // button1.setFont(new Font("Arial", Font.PLAIN, 22));
        // button1.setPreferredSize(new Dimension(865,80));
        // button1.addActionListener(this);
        // button1.setBorder(null);
        // button1.setFocusable(false);
        

        
        
        // button2 = new JButton();
        // button2.setText("Hello");
        // button2.setBackground(Color.WHITE);
        // button2.setForeground(Color.WHITE);
        // button2.setFont(new Font("Arial", Font.PLAIN, 22));
        // button2.setPreferredSize(new Dimension(865,80));
        // button2.addActionListener(this);
        // button2.setBorder(null);
        // button2.setFocusable(false);


        
        
        // button3 = new JButton();
        // button3.setText("Hello");
        // button3.setBackground(Color.WHITE);
        // button3.setForeground(Color.WHITE);
        // button3.setFont(new Font("Arial", Font.PLAIN, 22));
        // button3.setPreferredSize(new Dimension(865,80));
        // button3.addActionListener(this);
        // button3.setBorder(null);
        // button3.setFocusable(false);


        
        // button4 = new JButton();
        // button4.setText("Hello");
        // button4.setBackground(Color.WHITE);
        // button4.setForeground(Color.WHITE);
        // button4.setFont(new Font("Arial", Font.PLAIN, 22));
        // button4.setPreferredSize(new Dimension(865,80));
        // button4.addActionListener(this);
        // button4.setBorder(null);
        // button4.setFocusable(false);



        
        
        // button5 = new JButton();
        // button5.setText("<html>Hello how are <br>khanna khake ke jaan</html>");
        // button5.setBackground(Color.WHITE);
        // button5.setForeground(Color.WHITE);
        // button5.setFont(new Font("Arial", Font.PLAIN, 22));
        // button5.setPreferredSize(new Dimension(865,80));
        // button5.addActionListener(this);
        // button5.setBorder(null);
        // button5.setFocusable(false);

        createscheduleLabel();



        stationLablel = new JLabel();
        stationLablel.setBounds(903,10, 625, 650);
        stationLablel.setBorder(searchTabBorder);
        stationLablel.setLayout(new GridBagLayout());


        mainPanel.add(scheduleLabel);
        mainPanel.add(payButton);

        this.setLayout(new BorderLayout());
        this.add(welcomePanel,BorderLayout.NORTH);
        this.add(mainPanel,BorderLayout.CENTER);
        this.setVisible(true);

    }

    void createscheduleLabel ()
    {
        queryForBusSchedule();
        

        size = queue_for_schedule.size();;
        for(int i = 0 ; i <= size ; i++)
        {   
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 22));
            buttons[i].setPreferredSize(new Dimension(865,80));
            buttons[i].addActionListener(this);
            buttons[i].setBorder(null);
            buttons[i].setFocusable(false);
        }


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10,  10 , 10); 

        schedule retrival_object = queue_for_schedule.dequeue();
        int i = 0;
        while(retrival_object != null)
        {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.gridheight = 1;
            gbc.gridwidth = 4;
            temporary = new timing(retrival_object.departure_time, retrival_object.arrival_time);
            timingarr[i] = temporary;
            buttons[i].setBackground(new Color(0x007BFF));
            buttons[i].setText("<html>Bus Number&nbsp;&nbsp;&nbsp;&nbsp; Route Name &nbsp;&nbsp;&nbsp;&nbsp; Route Description &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Departure Time &nbsp; Arrival Time &nbsp;<br>"+retrival_object.bus_number+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+retrival_object.route_name+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+retrival_object.route_description+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;"+retrival_object.departure_time+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+retrival_object.arrival_time+"</html>");

            scheduleLabel.add(buttons[i],gbc);
            retrival_object = queue_for_schedule.dequeue();
            i++;
            
        }
        






        // gbc.gridx = 0;
        // gbc.gridy = 0;
        // gbc.gridheight = 1;
        // gbc.gridwidth = 4;
        // if(retrival_object != null)
        // {
        //     temporary = new timing(retrival_object.departure_time, retrival_object.arrival_time);
        //     timingarr[i] = temporary;
        //     button1.setBackground(new Color(0x007BFF));
        //     button1.setText("<html>Bus Number&nbsp;&nbsp;&nbsp;&nbsp; Route Name &nbsp;&nbsp;&nbsp;&nbsp; Route Description &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Departure Time &nbsp; Arrival Time &nbsp;<br>"+retrival_object.bus_number+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+retrival_object.route_name+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+retrival_object.route_description+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;"+retrival_object.departure_time+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+retrival_object.arrival_time+"</html>");
        //     retrival_object = queue_for_schedule.dequeue();
        //     i++;

        // }
        // scheduleLabel.add(button1,gbc);

        // gbc.gridx = 0;
        // gbc.gridy = 1;
        // gbc.gridheight = 1;
        // gbc.gridwidth = 4;
        // if(retrival_object != null)
        // {
        //     temporary = new timing(retrival_object.departure_time, retrival_object.arrival_time);
        //     timingarr[i] = temporary;
        //     button2.setBackground(new Color(0x007BFF));
        //     button2.setText("<html>Bus Number&nbsp;&nbsp;&nbsp;&nbsp; Route Name &nbsp;&nbsp;&nbsp;&nbsp; Route Description &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Departure Time &nbsp; Arrival Time &nbsp;<br>"+retrival_object.bus_number+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+retrival_object.route_name+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+retrival_object.route_description+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;"+retrival_object.departure_time+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+retrival_object.arrival_time+"</html>");
        //     retrival_object = queue_for_schedule.dequeue();
        //     i++;

        // }
        // scheduleLabel.add(button2,gbc);

        // gbc.gridx = 0;
        // gbc.gridy = 2;
        // gbc.gridheight = 1;
        // gbc.gridwidth = 4;
        // if(retrival_object != null)
        // {
        //     temporary = new timing(retrival_object.departure_time, retrival_object.arrival_time);
        //     timingarr[i] = temporary;
        //     button3.setBackground(new Color(0x007BFF));
        //     button3.setText("<html>Bus Number&nbsp;&nbsp;&nbsp;&nbsp; Route Name &nbsp;&nbsp;&nbsp;&nbsp; Route Description &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Departure Time &nbsp; Arrival Time &nbsp;<br>"+retrival_object.bus_number+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+retrival_object.route_name+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+retrival_object.route_description+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;\"+retrival_object.departure_time+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"+retrival_object.arrival_time+\"</html>");
        //     retrival_object = queue_for_schedule.dequeue();
        //     i++;

        // }
        // scheduleLabel.add(button3,gbc);

        // gbc.gridx = 0;
        // gbc.gridy = 3;
        // gbc.gridheight = 1;
        // gbc.gridwidth = 4;
        // if(retrival_object != null)
        // {
        //     temporary = new timing(retrival_object.departure_time, retrival_object.arrival_time);
        //     timingarr[i] = temporary;
        //     button4.setBackground(new Color(0x007BFF));
        //     button4.setText("<html>Bus Number&nbsp;&nbsp;&nbsp;&nbsp; Route Name &nbsp;&nbsp;&nbsp;&nbsp; Route Description &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Departure Time &nbsp; Arrival Time &nbsp;<br>"+retrival_object.bus_number+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+retrival_object.route_name+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+retrival_object.route_description+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;"+retrival_object.departure_time+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+retrival_object.arrival_time+"</html>");
        //     retrival_object = queue_for_schedule.dequeue();
        //     i++;

        // }
        // scheduleLabel.add(button4,gbc);

        // gbc.gridx = 0;
        // gbc.gridy = 4;
        // gbc.gridheight = 1;
        // gbc.gridwidth = 4;
        // if(retrival_object != null)
        // {
        //     temporary = new timing(retrival_object.departure_time, retrival_object.arrival_time);
        //     timingarr[i] = temporary;
        //     button5.setBackground(new Color(0x007BFF));
        //     button5.setText("<html>Bus Number&nbsp;&nbsp;&nbsp;&nbsp; Route Name &nbsp;&nbsp;&nbsp;&nbsp; Route Description &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Departure Time &nbsp; Arrival Time &nbsp;<br>"+retrival_object.bus_number+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+retrival_object.route_name+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+retrival_object.route_description+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;"+retrival_object.departure_time+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+retrival_object.arrival_time+"</html>");
        //     retrival_object = queue_for_schedule.dequeue();
           

        // }
        // scheduleLabel.add(button5,gbc);
        // linkedList_for_Station.emptyList();
        // this.revalidate();
        
    }
    void queryForBusSchedule()
    {
        try
        {
            queue_for_schedule = new scheduleQueue();
            String query = "select bt.Bus_number , rt.route_name , rt.route_description , bs.departure_time , bs.arrival_time  from bus_schedules bs join buses_table bt on bs.bus_id = bt.Bus_id JOIN routes_table rt on bs.route_id = rt.route_id where bs.route_id = ? and bs.bus_id = ? ;";
            // String query = "{Call getBusSchedule(?,?)";
            PreparedStatement pst = main1.con.prepareStatement(query);
            pst.setInt(1,route_id);
            pst.setInt(2,bus_id);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                String bus_number = rs.getString(1);
                String route_name = rs.getString(2);
                String route_description = rs.getString(3);
                Time departure_time = rs.getTime(4);
                Time arrival_time = rs.getTime(5);
                schedule schedule = new schedule(bus_number, route_name, route_description,departure_time ,arrival_time);
                queue_for_schedule.enqueue(schedule);
                
            }

        }
        catch(SQLException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            for(int i = 0 ; i <= size ; i++)
            {
                if(e.getSource() == buttons[i])
                {
                    payButton.setEnabled(true);
                    linkedList_for_Station.emptyList();
                    System.out.println("hello");
                    String query = "select st.station_name , rs.arrival_time from route_stations rs join station_table st on rs.station_id = st.station_id where rs.route_id = ? and rs.bus_id = ? and rs.arrival_time >= ? and rs.arrival_time <= ? order by rs.arrival_time ;";
                    PreparedStatement pst = main1.con.prepareStatement(query);
                    pst.setInt(1,route_id);
                    pst.setInt(2,bus_id);
                    pst.setTime(3, timingarr[i].departure_time);
                    pst.setTime(4, timingarr[i].arrival_time);
                    ResultSet rs1 = pst.executeQuery();
                    while(rs1.next())
                    {
                        station station = new station(rs1.getString(1), rs1.getTime(2));
                        linkedList_for_Station.addLast(station);
                    }
                    displayStations();
                }
            }
            if(e.getSource() == payButton)
            {
                new paymentPage(bus_id , route_id , homePage.source , homePage.destination);
                this.dispose();
            }
        }
        catch(SQLException e1)
        {

        }
        // try{
        //     if(e.getSource() == button1)
        //     {
        //         linkedList_for_Station.emptyList();
        //         System.out.println("hello");
        //         String query = "select st.station_name , rs.arrival_time from route_stations rs join station_table st on rs.station_id = st.station_id where rs.route_id = ? and rs.bus_id = ? and rs.arrival_time >= ? and rs.arrival_time <= ? order by rs.arrival_time ;";
        //         PreparedStatement pst = main1.con.prepareStatement(query);
        //         pst.setInt(1,route_id);
        //         pst.setInt(2,bus_id);
        //         pst.setTime(3, timingarr[0].departure_time);
        //         pst.setTime(4, timingarr[0].arrival_time);
        //         ResultSet rs1 = pst.executeQuery();
        //         while(rs1.next())
        //         {
        //             station station = new station(rs1.getString(1), rs1.getTime(2));
        //             linkedList_for_Station.addLast(station);
        //         }
        //         displayStations();
        //     }
        //     else if(e.getSource() == button2)
        //     {
        //         linkedList_for_Station.emptyList();
        //         String query = "select st.station_name , rs.arrival_time from route_stations rs join station_table st on rs.station_id = st.station_id where rs.route_id = ? and rs.bus_id = ? and rs.arrival_time >= ? and rs.arrival_time <= ? order by rs.arrival_time ;";
        //         PreparedStatement pst = main1.con.prepareStatement(query);
        //         pst.setInt(1,route_id);
        //         pst.setInt(2,bus_id);
        //         pst.setTime(3, timingarr[1].departure_time);
        //         pst.setTime(4, timingarr[1].arrival_time);
        //         ResultSet rs1 = pst.executeQuery();
        //         while(rs1.next())
        //         {
        //             station station = new station(rs1.getString(1), rs1.getTime(2));
        //             linkedList_for_Station.addLast(station);
        //         }
        //         displayStations();
        //     }
        //     else if(e.getSource() == button3)
        //     {
        //         linkedList_for_Station.emptyList();
        //         String query = "select st.station_name , rs.arrival_time from route_stations rs join station_table st on rs.station_id = st.station_id where rs.route_id = ? and rs.bus_id = ? and rs.arrival_time >= ? and rs.arrival_time <= ? order by rs.arrival_time ;";
        //         PreparedStatement pst = main1.con.prepareStatement(query);
        //         pst.setInt(1,route_id);
        //         pst.setInt(2,bus_id);
        //         pst.setTime(3, timingarr[2].departure_time);
        //         pst.setTime(4, timingarr[2].arrival_time);
        //         ResultSet rs1 = pst.executeQuery();
        //         while(rs1.next())
        //         {
        //             station station = new station(rs1.getString(1), rs1.getTime(2));
        //             linkedList_for_Station.addLast(station);
        //         }
        //         displayStations();
        //     }
        //     else if(e.getSource() == button4)
        //     {
        //         linkedList_for_Station.emptyList();
        //         String query = "select st.station_name , rs.arrival_time from route_stations rs join station_table st on rs.station_id = st.station_id where rs.route_id = ? and rs.bus_id = ? and rs.arrival_time >= ? and rs.arrival_time <= ? order by rs.arrival_time ;";
        //         PreparedStatement pst = main1.con.prepareStatement(query);
        //         pst.setInt(1,route_id);
        //         pst.setInt(2,bus_id);
        //         pst.setTime(3, timingarr[3].departure_time);
        //         pst.setTime(4, timingarr[3].arrival_time);
        //         ResultSet rs1 = pst.executeQuery();
        //         while(rs1.next())
        //         {
        //             station station = new station(rs1.getString(1), rs1.getTime(2));
        //             linkedList_for_Station.addLast(station);
        //         }
        //         displayStations();
        //     }
        //     else if(e.getSource() == button5)
        //     {
        //         linkedList_for_Station.emptyList();
        //         String query = "select st.station_name , rs.arrival_time from route_stations rs join station_table st on rs.station_id = st.station_id where rs.route_id = ? and rs.bus_id = ? and rs.arrival_time >= ? and rs.arrival_time <= ? order by rs.arrival_time ;";
        //         PreparedStatement pst = main1.con.prepareStatement(query);
        //         pst.setInt(1,route_id);
        //         pst.setInt(2,bus_id);
        //         pst.setTime(3, timingarr[4].departure_time);
        //         pst.setTime(4, timingarr[4].arrival_time);
        //         ResultSet rs1 = pst.executeQuery();
        //         while(rs1.next())
        //         {
        //             station station = new station(rs1.getString(1), rs1.getTime(2));
        //             linkedList_for_Station.addLast(station);
        //         }
        //         displayStations();
        //     }
        // }
        // catch(SQLException e1)
        // {
        //     e1.printStackTrace();
        //     JOptionPane.showMessageDialog(null,e1.getMessage(), "title", JOptionPane.WARNING_MESSAGE);
        // }
        
    }
    void displayStations()
    {
        stationLablel.removeAll();
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10,  10 , 10);
        int i = 0;
        stationLinkedList.node temp = linkedList_for_Station.getHeadNode();
        while(temp != null)
        {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.gridheight = 1;
            gbc.gridwidth = 3;
            JLabel stationResultLabel = new JLabel();
            stationResultLabel.setText("Station :- "+temp.station.station_name+"      Arrival Time :- "+temp.station.arrival_time);
            stationResultLabel.setOpaque(true);
            stationResultLabel.setBackground(new Color(0x007BFF));
            stationResultLabel.setForeground(Color.WHITE);
            stationResultLabel.setFont(new Font("Arial", Font.PLAIN, 22));;
            stationLablel.add(stationResultLabel, gbc);
            i++;
            temp = temp.next;
        }
        mainPanel.add(stationLablel);
        this.revalidate();
    }
    
   
}
