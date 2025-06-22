import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class transactionPage extends JFrame{
    JPanel transactionPanel;
    
    transactionPage()
    {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(575, 525);
        transactionPanel = new JPanel();
        transactionPanel.setPreferredSize(new Dimension(575,1175));
        transactionPanel.setBackground(new Color(0X007BFF));
        transactionPanel.setLayout(new GridBagLayout());

        createTransactionPanel();
        JScrollPane scrollPane = new JScrollPane(transactionPanel);
        this.add(scrollPane);
        
        this.setVisible(true);
    }
    void createTransactionPanel()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 15 , 5);
        int index = 0;
        String line = homePage.stack.pop();
        while(line != null)
        {
            String[] stack_content = line.split("\n");
            for(int i = 0 ; i < stack_content.length ; i++)
            {
                gbc.gridx = 0;
                gbc.gridy = i;
                gbc.gridheight = 1;
                gbc.gridwidth = 3;
                JLabel transactionLabel = new JLabel();
                transactionLabel.setText(stack_content[i]);
                transactionLabel.setFont(new Font("Arial", Font.PLAIN, 23));
                transactionPanel.add(transactionLabel, gbc);
                index++;
            }
            line = homePage.stack.pop();
        }

        try
        {
            FileReader fr = new FileReader("Transaction_History.txt");
            BufferedReader br = new BufferedReader(fr);
            String file_content = br.readLine();
            while(file_content != null)
            {
                gbc.gridx = 0;
                gbc.gridy = index;
                gbc.gridheight = 1;
                gbc.gridwidth = 3;
                JLabel transactionLabel = new JLabel();
                transactionLabel.setText(file_content);
                transactionLabel.setFont(new Font("Arial", Font.PLAIN, 23));
                transactionPanel.add(transactionLabel, gbc);
                file_content = br.readLine();
                index++;
            }
            br.close();
        }
        catch(IOException e1)
        {
            JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception e1)
        {
            JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }

        
    }
    
}
