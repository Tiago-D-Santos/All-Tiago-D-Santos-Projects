/* import java.nio.file.AccessDeniedException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class NewWindowLaunchpage implements ActionListener{
    
    JFrame frame = new JFrame();
    JButton myButton = new JButton("HELLOOOOO.....");


    NewWindowLaunchpage(){
        myButton.setBounds(100,200,200,40);
        myButton.setFocusable(false);//so that the button isnt higlighted
        myButton.addActionListener(this);

        frame.add(myButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()== myButton){
            for (int i = 0 ; i<100; i++)
            {
                NewWindow myWindow = new NewWindow();
            }            
            NewWindow myWindow = new NewWindow();
            //frame.dispose();//this clears the old page
            //frame.setVisible(false);
        }   
    }
}
 */