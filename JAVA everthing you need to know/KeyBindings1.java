/* import java.awt.Color;
import java.awt.Frame;
import java.awt.event.*;

import javax.swing.*;

public class KeyBindings1 {
    //dont require to click a component
    //give more flexebility
    //only works wwith swing methodes
    JFrame frame;
    JLabel label;
    Action upAction;
    Action downAction;
    Action rightAction;
    Action leftAction;

    KeyBindings1(){
        frame = new JFrame("lolo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(660,660);
        frame.setLayout(null);
        
        label = new JLabel();
        label.setBackground(Color.red);
        label.setBounds(100,100,100,100);
        label.setOpaque(true);

        upAction = new UpAction1();
        downAction = new DownAction1();
        leftAction = new LeftAction1();
        rightAction = new RightAction1();

        label.getInputMap().put(KeyStroke.getKeyStroke("UP"),"upAction");
        label.getActionMap().put("upAction",upAction);//the key must be the key of the line before

        label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"downAction");
        label.getActionMap().put("downAction",downAction);

        label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"rightAction");
        label.getActionMap().put("rightAction",rightAction);

        label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"leftAction");
        label.getActionMap().put("leftAction",leftAction);

        
        frame.add(label);
        frame.setVisible(true);
    }

    public class UpAction1 extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(),label.getY()-10);
        }
    }
    public class DownAction1 extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(),label.getY()+10);
        }
    }
    public class RightAction1 extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX()+10,label.getY());

        }
    }
    public class LeftAction1 extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX()-10,label.getY());

        }
    }
}
 */