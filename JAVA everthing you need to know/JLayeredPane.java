/* import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;

public class Main {
    public static void main(String[] args) {

        JLabel label1 = new JLabel();
        label1.setOpaque(true);//makes it visible
        label1.setBackground(Color.RED);
        label1.setBounds(50,50,200,200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);//makes it visible
        label2.setBackground(Color.GREEN);
        label2.setBounds(100,100,200,200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);//makes it visible
        label3.setBackground(Color.BLUE);
        label3.setBounds(150,150,200,200);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,500);

        //old version
        //layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);
        //layeredPane.add(label2, JLayeredPane.DEFAULT_LAYER);
        //layeredPane.add(label3, JLayeredPane.DRAG_LAYER);
        //better version
        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(label2, Integer.valueOf(2));
        layeredPane.add(label3, Integer.valueOf(1));

    


        JFrame frame = new JFrame();
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);//this must be null
        frame.setVisible(true);
    
    }
}
 */