import java.awt.Point;

public class LineHitbox {
    private Point fPoint;
    private Point ePoint;
    private String text;


    /**
     * Constructor for one line
     * @param fPoint firstPoint the upper left point
     * @param ePoint endPoint the lower right point
     * @param text text in the line
     */
    public LineHitbox(Point fPoint, Point ePoint, String text){
        this.fPoint = fPoint;
        this.ePoint = ePoint;
        this.text = text;
    }

    /**
     * @return firstPoint
     */
    public Point getFPoint(){
        return fPoint;
    }

    /**
     * @return endPoint
     */
    public Point getEPoint(){
        return ePoint;
    }

    /**
     * @return line Text
     */
    public String getText(){
        return text;
    }

    /**
     * sets the text to the line
     * @param text line text
     */
    public void setText(String text){
        this.text= text;
    }

    /**
     * sets the firstpoint for the hitbox
     * @param fPoint
     */
    public void setFPoint(Point fPoint){
        this.fPoint=fPoint;
    }

    /**
     * sets the endPoint for the hitbox
     * @param ePoint
     */
    public void setEPoint(Point ePoint){
        this.ePoint=ePoint;
    }

    public int getTextLength(){
        return this.text.length();
    }
    public String subString(int fIndex,int eIndex){
        return text.substring(fIndex,eIndex);
    }

    /**
     * removes part of the String from  text
     * @param fIndex first index to clear
     * @param eIndex last index to clear
     */
    public void removeString(int fIndex,int eIndex){
        text= text.substring(0, fIndex) + text.substring(eIndex);
        
    }

    public void append(String s) {
        if (s == null || s.isEmpty()) return;
        this.text += s;
    }

    /**
     * adds tab to begining
     * @param tab a string with a tab
     */
    public void addTab(String tab) {
        if (tab == null || tab.isEmpty()) return;
        this.text =tab+this.text;
    }
}
