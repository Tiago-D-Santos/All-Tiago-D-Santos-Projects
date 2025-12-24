/* import java.awt.*;

import javax.crypto.spec.PBEKeySpec;
import javax.swing.*;
import javax.swing.event.*;

public class Slider implements ChangeListener {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;
    Slider(){
        frame = new JFrame("Slider Demo");
        panel = new JPanel();
        label = new JLabel();
        slider = new JSlider(0,100,50);//MIN number on the slider , max number on the slider,staring point

        slider.setPreferredSize(new Dimension(400,200));
        
        slider.setPaintTicks(true);//puts a scale
        slider.setMinorTickSpacing(5);//puts a scaleline every 10px

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(20);//puts numebrs every x px

        slider.setPaintLabels(true);//this makes the numbers visible under the scale
        slider.setFont(new Font("MV Boli",Font.PLAIN,15));//set the font of the scale numbers

        slider.setOrientation(SwingConstants.VERTICAL);//changes the slider to a vertical slider
        //slider.setOrientation(SwingConstants.HORIZONTAL);//changes the slider to a HORIZONTAL slider

        label.setFont(new Font("MV Boli",Font.PLAIN,25));
        label.setText("°C =" + slider.getValue());//gets the curent value of the slider

        slider.addChangeListener(this);//this trigers an event

        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        frame.setSize(440,400);
        frame.setVisible(true);
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("°C =" + slider.getValue());
    }
    

}
 */