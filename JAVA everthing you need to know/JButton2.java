/* import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class MainFrame extends JFrame{
    JButton button;
    JLabel label;
    MainFrame(){
        ImageIcon icon= new ImageIcon("JFrame1.png");

        label = new JLabel();
        label.setText("kokokok");
        label.setBounds(150,250,150,150);
        label.setVisible(false);

        button = new JButton();
        button.setBounds(100,200,250,50*2);
        button.addActionListener(e -> func1());//this is a shorter version called landa
        button.setText("I am a button");//chanegs the text
        button.setFocusable(false);//removes the box around the text
        //button.setIcon(icon);//put a icon in the button
        button.setHorizontalTextPosition(JButton.CENTER);//align the text in the button
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans",Font.BOLD,25));
        button.setForeground(Color.cyan);//color of the text
        button.setBackground(Color.LIGHT_GRAY);//color of the button
        button.setBorder(BorderFactory.createEtchedBorder());//border
        button.setEnabled(true);//this makes that the button can be pressed

        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(button);
        this.add(label);

        
    
    }
    public void func1(){
        System.out.println("lalalalo");
        label.setVisible(true);
    }

    
} */