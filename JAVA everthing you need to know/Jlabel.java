/* import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {
    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("JFrame1.png");
        Border border = BorderFactory.createLineBorder(Color.green,3);


        JLabel label = new JLabel();//could write the text here in the ()
        label.setText("TEXXXXXXXXXXXXXXXT");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);//set text left,centermright of imageicon
        label.setVerticalTextPosition(JLabel.TOP);//set text top,center,bottom of imageicon
        label.setForeground(Color.GRAY);//set color of the text
        label.setFont(new Font("MV Boli",Font.PLAIN,20));//set font of the text
        label.setIconTextGap(25);//set gab to text ti image
        label.setBackground(Color.blue);//changes the background color to blue
        label.setOpaque(true);//makes the background color visible
        label.setBorder(border);//makes a border
        label.setVerticalAlignment(JLabel.CENTER);//set vertical position of icon + text within label
        label.setHorizontalAlignment(JLabel.CENTER);//set horizontal postion of icon + text
        //label.setBounds(100,100,250,250);//put divisions for the label



        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(500,500);
        //frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.pack();//the size of the label will adjust to the size of the content of the label and pack must be places at the end
    }
}
 */