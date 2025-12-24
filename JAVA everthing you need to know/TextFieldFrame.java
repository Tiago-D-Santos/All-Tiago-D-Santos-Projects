/* import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextFieldFrame extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    TextFieldFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.addActionListener(this);//this refers to this frame

        textField = new JTextField();//makes a box where you can write
        textField.setPreferredSize(new Dimension(250,50));//size of the box 
        textField.setFont(new Font("Consolas", Font.PLAIN,35));//sets the font in the box
        textField.setForeground(new Color(255,0,0));//color of the text
        textField.setBackground(Color.black);//color of the background
        textField.setCaretColor(Color.BLUE);//color of the pointer
        textField.setText("username");//set the text already in the box
        textField.setEditable(false);//makes it impossible to change the text field


        this.add(button);
        this.add(textField);
        this.pack();//the size will adjust to the size of the componenents
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== button) 
        {
            System.out.println(textField.getText());
        }
    }
    
}
  */