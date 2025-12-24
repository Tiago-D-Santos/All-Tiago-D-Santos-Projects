/* import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class JFrameMain1_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();//creates frame
        frame.setTitle("Jframe Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//this makes so that the frame hides and continues working in the background
        //frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//this makes that the button dont works
        frame.setResizable(false);//prevent frame from being resized
        
        frame.setSize(420,420);
        frame.setVisible(true);//makes it visible
        ImageIcon image = new ImageIcon("JFrame1.png");//create an img icon
        frame.setIconImage(image.getImage());//change the icon of the frame
        //  frame.getContentPane().setBackground(Color.BLUE);//cahge color of background
        frame.getContentPane().setBackground(new Color(255,255,0));//cahge color of background
         





         //other way to create a Jframe
        JFrame2 myFrame2 = new JFrame2();

        
    
    }
}
 */