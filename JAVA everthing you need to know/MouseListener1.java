/* import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListener1 extends JFrame  implements MouseListener{

    JLabel label;


    MouseListener1(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setBackground(Color.red);
        label.setOpaque(true);//to make it appear
        label.addMouseListener(this);

        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //when the mouse has beeen clicked(press and release)
        //System.out.println("you clicked it");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //when the mouse button has been pressed
        //System.out.println("you pressed it");
        label.setBackground(Color.orange);
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //when the mouse button has been released
        //System.out.println("you released it");
        label.setBackground(Color.red);
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //when the mouse enters the area of a component
        //System.out.println("you entered it");
        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
         //when the mouse leaves the area of a component
         //System.out.println("you exited it");
        
    }
    
}
 */