/* import java.awt.*;
import javax.swing.*;
public class ProgressBar {
    
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar();//can add there the min and max value JProgressBar(0,100)

    ProgressBar(){
        bar.setValue(0);//set the in itial value
        bar.setBounds(0,0,420,50);
        bar.setStringPainted(true);//ads a writen porzentage in the progressbar
        bar.setFont(new Font("MV Boli",Font.BOLD,25));
        bar.setForeground(Color.red);//CHANGES THE COLOR OF THE FELING scale to red
        bar.setBackground(Color.BLACK);//changes the color of the Background of the scale to ...

        frame.add(bar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        
        fill();
    }
    public void fill(){
        int counter = 0;
        while(counter <=100){
            bar.setValue(counter);
            try {
                Thread.sleep(100);//sleep 1s must be sourounded by an try
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            counter +=1;
        }
        bar.setString("Done!!!");//chages the writen porzentage to this string
    }
}
 */