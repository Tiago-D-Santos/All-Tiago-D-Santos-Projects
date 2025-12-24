/* import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener {
    JComboBox comboBox;

    MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] array1 = {"OP1","OP2","OP3"};
        comboBox = new JComboBox(array1);
        comboBox.addActionListener(this);

        //comboBox.setEditable(true);//you can type the option
        //System.out.println(comboBox.getItemCount());//How maNY OPTIONS are there
        //comboBox.addItem("OP4");//this adds an option
        //comboBox.insertItemAt("changed OP1", 0);//change at index x
        //comboBox.setSelectedIndex(0);//this shows x button first
        //comboBox.removeItem("OP3");//removes an option by name
        //comboBox.removeItemAt(0);//removes an option by index
        //comboBox.removeAllItems();removes all items

        this.add(comboBox);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
            //System.out.println(comboBox.getSelectedItem());//this prints the option clicked
            System.out.println(comboBox.getSelectedIndex());//this prints the index of the selected item
        }
        
    }
    
}
 */