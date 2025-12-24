/* import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DragPanel extends JPanel{

    ImageIcon image = new ImageIcon("icons8-launch-32.png");
    final int WIDTH = image.getIconWidth();
    final int HEIGHT = image.getIconHeight();
    Point imageCorner;
    Point prevPT;

    DragPanel(){
        imageCorner = new Point(0,0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);

    }

    public void paintComponent(Graphics g){
        //repaint out image after we change the image
        super.paintComponent(g);
        image.paintIcon(this,g,(int)imageCorner.getX(),(int)imageCorner.getY());
    }
    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e){
            prevPT = e.getPoint();//update the previus point to this point
        }
        
    }
    private class DragListener extends MouseMotionAdapter {
        //is to move our obj
        public void mouseDragged(MouseEvent e){
            Point currentPT = e.getPoint();
            imageCorner.translate(
                (int)(currentPT.getX()- prevPT.getX()),
                (int)(currentPT.getY()- prevPT.getY())
            );
            prevPT = currentPT;
            repaint();
        }
        
    }
}
 */