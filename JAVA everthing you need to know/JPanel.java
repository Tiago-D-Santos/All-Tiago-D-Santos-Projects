/* import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanel {
    public static void main(String[] args) {

        ImageIcon icon = new ImageIcon("JFrame1.png");

        //LABEL : DIVIsion, cointainer
        JLabel label = new JLabel();
        label.setText("yoooo9oooo");
        //label.setIcon(icon);
        label.setVerticalAlignment(JLabel.BOTTOM);//no need for this if used cords
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBounds(0,0,200,20);//where it is in the Panel adn the size of the label

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0,0,250,250);
        //redPanel.setLayout(new BorderLayout());
        redPanel.setLayout(null);


        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250,0,250,250);
        //bluePanel.setLayout(new BorderLayout());
        bluePanel.setLayout(null);

        
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0,250,250,250);
        //greenPanel.setLayout(new BorderLayout());
        greenPanel.setLayout(null);
        

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setVisible(true);
        
        bluePanel.add(label);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
        
    }
}
 */