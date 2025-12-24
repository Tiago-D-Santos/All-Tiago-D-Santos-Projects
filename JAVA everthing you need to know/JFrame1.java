/* import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
public class JFrame2 extends JFrame {
    //other way to create a Jthis
    JFrame2(){
        this.setTitle("Jthis Title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setDefaultCloseOperation(Jthis.HIDE_ON_CLOSE);//this makes so that the this hides and continues working in the background
        //this.setDefaultCloseOperation(Jthis.DO_NOTHING_ON_CLOSE);//this makes that the button dont works
        this.setResizable(false);//prevent this from being resized
        
        this.setSize(420,420);
        this.setVisible(true);//makes it visible
        ImageIcon image = new ImageIcon("JFrame1.png");//create an img icon
        this.setIconImage(image.getImage());//change the icon of the this
        //  this.getContentPane().setBackground(Color.BLUE);//cahge color of background
        this.getContentPane().setBackground(new Color(255,255,0));
    }
}
  */