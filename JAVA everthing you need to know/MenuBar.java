/* import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JFrame implements ActionListener{
    JMenuBar menuBar;
    JMenu menu1;
    JMenu menu2;
    JMenu menu3;

    JMenuItem item1;
    JMenuItem item2;
    JMenuItem item3;
    //this creates an menubar with multiple buttons
    MenuBar(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());

        menuBar = new JMenuBar();

        //create all the options of buttons
        menu1 = new JMenu("File");
        menu2 = new JMenu("Edit");
        menu3 = new JMenu("View");

        //this here are the options when you click a butotn
        item1 = new JMenuItem("load");
        item2 = new JMenuItem("save");
        item3 = new JMenuItem("exit");

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);

        //makess an event listener that creates a shorcut to this key
        menu1.setMnemonic(KeyEvent.VK_Q);//for the menu you have to press ALT + Q
        menu2.setMnemonic(KeyEvent.VK_W);//for the menu you have to press ALT + W
        menu3.setMnemonic(KeyEvent.VK_E);//for the menu you have to press ALT + E
        item1.setMnemonic(KeyEvent.VK_1);//press 1 shortcut
        item2.setMnemonic(KeyEvent.VK_2);//press 2 shortcut
        item3.setMnemonic(KeyEvent.VK_3);//press 3 shortcut



        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);


        //add the buttons to the menu bar
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);


        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==item1){
            System.out.println("ITEM1");
        }
        if(e.getSource()==item2){
            System.out.println("ITEM2");
        }
        if(e.getSource()==item3){
            System.out.println("ITEM3");
        }
    }

     
}*/
