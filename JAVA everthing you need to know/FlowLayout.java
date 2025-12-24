/* 
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(500,500);
         //frame.setLayout(new FlowLayout(FlowLayout.LEADING));//puts the flowlayout and makes i tstart on the left of the window
         //frame.setLayout(new FlowLayout(FlowLayout.CENTER));//puts the flowlayout and makes i tstart on the center of the window
         //frame.setLayout(new FlowLayout(FlowLayout.TRAILING));//puts the flowlayout and makes i tstart on the right of the window
         frame.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100,200));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new FlowLayout());

         //longer version
         //JButton button1 = new JButton();
         //frame.add(button1);
         //short cut
         panel.add(new Button("1"));

         panel.add(new Button("2"));
         panel.add(new Button("3"));
         panel.add(new Button("4"));
         panel.add(new Button("5"));
         panel.add(new Button("6"));
         panel.add(new Button("7"));
         panel.add(new Button("8"));
         panel.add(new Button("9"));

         frame.add(panel);
         frame.setVisible(true);
    }
}
 */