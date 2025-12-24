/* import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListener1 extends JFrame implements KeyListener1{

    JLabel label;
    ImageIcon icon;
    KeyListener1(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);

        this.addKeyListener(this);

        icon = new ImageIcon("icons8-launch-32.png");
        

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setIcon(icon);
        //label.setBackground(Color.red);
        //label.setOpaque(true);
        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            //uses KeyChar, char Output
            case 'a' : label.setLocation(label.getX()-10,label.getY()   );
                break;
            case 'w' : label.setLocation(label.getX()   ,label.getY()-10);
                break;
            case 's' : label.setLocation(label.getX()   ,label.getY()+10);
                break;
            case 'd' : label.setLocation(label.getX()+10,label.getY()   );
                break;

            default:
                break;
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Uses KeyCode, int Output
        switch (e.getKeyCode()) {
            case 37 : label.setLocation(label.getX()-10,label.getY()   );
                break;
            case 38 : label.setLocation(label.getX()   ,label.getY()-10);
                break;
            case 40 : label.setLocation(label.getX()   ,label.getY()+10);
                break;
            case 39 : label.setLocation(label.getX()+10,label.getY()   );
                break;

            default:
                break;
    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //called when a button is released
        System.out.println("Key Char: "+ e.getKeyChar());
        System.out.println("Key Code: "+ e.getKeyCode());

    }
    
    
}
 */