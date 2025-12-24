/* import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;
    ImageIcon UncheckIcon;
    ImageIcon CheckIcon;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        CheckIcon = new ImageIcon("checkBox.png");
    
        UncheckIcon = new ImageIcon("checkBox_unchecked.png");

        button = new JButton();
        button.setText("submit");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("Op1");
        checkBox.setFocusable(false);//removes the box  around the text
        checkBox.setFont(new Font("Cansolas", Font.PLAIN,35));
        checkBox.setIcon(UncheckIcon);//this is to change the icon of the check box
        checkBox.setSelectedIcon(CheckIcon);//this changes the selected box to the png
        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()== button){
            System.out.println(checkBox.isSelected());
        }     
    }
}
 */