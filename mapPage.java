import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mapPage extends JFrame{
    mapPage()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logoImage = new ImageIcon("C:\\Users\\Kunal Fauzdar\\OneDrive\\Pictures\\Screenshots\\map.png");
        JLabel mapLabel = new JLabel();
        mapLabel.setIcon(logoImage);
        this.add(mapLabel);
        this.pack();
        this.setVisible(true);
    }
}
