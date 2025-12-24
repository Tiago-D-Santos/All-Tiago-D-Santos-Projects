/* import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MyFrame extends JFrame implements ActionListener{
    JRadioButton Button1;
    JRadioButton Button2;
    JRadioButton Button3;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        Button1 = new JRadioButton("Button1");
        Button2 = new JRadioButton("Button2");
        Button3 = new JRadioButton("Button3");

        ButtonGroup group = new ButtonGroup();//this makes that jsut one button can bbe clicked at the time
        group.add(Button1);
        group.add(Button2);
        group.add(Button3);

        Button1.addActionListener(this);
        Button2.addActionListener(this);
        Button3.addActionListener(this);


        this.add(Button1);
        this.add(Button2);
        this.add(Button3);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== Button1){
            System.out.println("B1");
        }
        else if (e.getSource()== Button2) {
            System.out.println("B2");
        }
        else if (e.getSource()== Button3) {
            System.out.println("B3");
        }
        
    }
}
 */