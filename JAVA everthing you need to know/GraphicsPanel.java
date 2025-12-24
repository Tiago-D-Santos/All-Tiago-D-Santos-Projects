/* 
import javax.swing.*;
import java.awt.*;


public class GraphicsPanel extends JPanel{
    //I had to do a panel because the cordinates start on the bar of the window in a jframe
    //Jpanel is consideret as a component

    
    GraphicsPanel(){
       this.setPreferredSize(new Dimension(500,500));
    }
    public void paint(Graphics g){
        //anything more recently created will be displayed infornt


        Graphics2D g2D = (Graphics2D)g;// Graphics2D has more options tha a g^
        
        g2D.setPaint(Color.blue);//sets the color of the line/stroke
        //g2D.setStroke(new BasicStroke(5));//makes the stroke thicker
        //g2D.drawLine(0,0,500,500);//draws Line

        //g2D.drawRect(10,10,100,100);//draws a rect 
        //g2D.fillRect(0,0,100,100);//draws a filled rect

        //g2D.drawOval(10,10,100,100);//draws a oval||circle
        //g2D.fillOval(10,10,100,100);//draws a filled oval||circle

        //g2D.drawArc(0,0,100,100,0,180);//makes an not complete circle
        
        //int[]xPoints = {10,444,500};//xcords for pt1,pt2,pt3
        //int[]yPoints = {250,10,300};
        //g2D.drawPolygon(xPoints,yPoints,3);

        g2D.drawString("String",40,33);
    }
    
}
 */