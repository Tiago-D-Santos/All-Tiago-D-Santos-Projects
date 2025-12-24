import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsConfigTemplate;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class TextEditor extends JPanel implements KeyListener, MouseListener,MouseMotionListener{

    private ArrayList< LineHitbox> alLinesHitboxes;
    //private ArrayList<Integer> alLineCharWidths;


    //private int lineCount;
    private final int lineHeight =18;
    
    private final int tbgaddOn =10;//how much the tbg become bigger when it bacome 10 times bigger
    private final int tbginit=30;//initial space for the numbers
    private final int tabSize=4;
    private final Color dragColor=new Color(192, 232, 237);
    private final Color scrollbarBackGroundColor=new Color(209, 209, 209);
    private final Color scrollbarColor=new Color(153, 153, 153);
    private final Color curserColor=Color.BLACK;
    private final int rightScrollbarWidth =15;

    //private String text;
    private int tbg;//espace for the numbers
    private int currentLine;
    private int  currentcharPos;
    private int dragedLine;
    private int dragedCharPos;
    private boolean isDraging;
    private boolean curserIsVisible;
    private int withOfOneChar;
    private JScrollPane scrollPane;
    private char[] allChars = {
        //Basic Latin
        'A','B','C','D','E','F','G','H','I','J','K','L','M',
        'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
        'a','b','c','d','e','f','g','h','i','j','k','l','m',
        'n','o','p','q','r','s','t','u','v','w','x','y','z',

        //Latin-1 Supplement
        'À','Á','Â','Ã','Ä','Å','Æ','Ç','È','É','Ê','Ë',
        'Ì','Í','Î','Ï','Ð','Ñ','Ò','Ó','Ô','Õ','Ö','Ø',
        'Ù','Ú','Û','Ü','Ý','Þ','ß',
        'à','á','â','ã','ä','å','æ','ç','è','é','ê','ë',
        'ì','í','î','ï','ð','ñ','ò','ó','ô','õ','ö','ø',
        'ù','ú','û','ü','ý','þ','ÿ',
        
        ' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        ':', ';', '<', '=', '>', '?', '@','[', '\\', ']', '^', '_', '`',
        '{', '|', '}', '~',' ','卐','☭',
    };

    

    
    


    public TextEditor(){
        alLinesHitboxes = new ArrayList<>();
        //alLineCharWidths= new ArrayList<>();
        this.setVisible(true);
        this.setOpaque(false);
        this.setLayout(null);
        this.setFocusable(true);//ENABLES input
        this.setFocusTraversalKeysEnabled(false);//THIS ENABLES THE TAB!!!!
        currentLine=-1;
        currentcharPos=-1;
        dragedLine = -1;
        dragedCharPos =-1;
        isDraging =false;
        tbg =tbginit;
        curserIsVisible=true;

        //curser blinking
        Timer timer = new Timer(500, e->{
            curserIsVisible=!curserIsVisible;
            this.repaint();
        });










        //this are all the action key listeners 
        InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, InputEvent.SHIFT_DOWN_MASK), "shiftTab");
        am.put("shiftTab", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentLine==-1)return;
               
                if(isDraging){
                    int firstLine =Math.min(currentLine,dragedLine);
                    int lastLine =Math.max(currentLine,dragedLine);
                    for(int l = firstLine; l<=lastLine; l++){
                        shiftTabOneLine(l,(currentLine==l),(dragedLine==l));
                        
                    }

                }
                else{
                    shiftTabOneLine(currentLine, true,false);
                }
                setScrollPanePosition();
                repaint();

            }
        });

        im.put(KeyStroke.getKeyStroke("ENTER"), "newLine");
        am.put("newLine", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentLine==-1)return;
                
                dragRelease(true);
                addNewLine();
                
                setScrollPanePosition();
                repaint();

            }
        });

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB,0), "tab_Key22");
        am.put("tab_Key22", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentLine==-1)return;

                if(isDraging){
                    int firstLine =Math.min(currentLine,dragedLine);
                    int lastLine =Math.max(currentLine,dragedLine);
                    for(int l = firstLine; l<=lastLine; l++){
                        tabOneLine(l,(currentLine==l),(dragedLine==l));
                    }
                }else{
                    dragRelease(false);
                    goToNextTabPoint();
                }
                
                
                setScrollPanePosition();
                repaint();

            }
        });

        im.put(KeyStroke.getKeyStroke("UP"), "up_Key");
        am.put("up_Key", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentLine==-1)return;
                
                if(currentLine>0){
                
                if(currentcharPos>alLinesHitboxes.get(currentLine-1).getText().length()){
                    currentcharPos=alLinesHitboxes.get(currentLine-1).getText().length();
                }else{

                }
                currentLine--;
               }
                dragRelease(false);
                setScrollPanePosition();
                repaint();

            }
        });

        im.put(KeyStroke.getKeyStroke("DOWN"), "down_Key");
        am.put("down_Key", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(currentLine==-1)return;
                
                if(currentLine<alLinesHitboxes.size()-1){
                    
                    if(currentcharPos>alLinesHitboxes.get(currentLine+1).getText().length()){
                        currentcharPos=alLinesHitboxes.get(currentLine+1).getText().length();
                    }else{

                    }
                    currentLine++;
                }
                dragRelease(false);
                setScrollPanePosition();
                repaint();

            }
        });

        im.put(KeyStroke.getKeyStroke("LEFT"), "left_Key");
        am.put("left_Key", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(currentLine==-1)return;
                
                if(currentcharPos-1>=0){
                    currentcharPos-=1;
                }else if(currentLine!=0){
                    //go to next line
                    currentcharPos=alLinesHitboxes.get(currentLine-1).getText().length();
                    currentLine--;
                }
                dragRelease(false);
                setScrollPanePosition();
                repaint();

            }
        });

        im.put(KeyStroke.getKeyStroke("RIGHT"), "right_Key");
        am.put("right_Key", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                if(currentLine==-1)return;
                
                if(currentcharPos+1<=alLinesHitboxes.get(currentLine).getText().length()){
                    currentcharPos+=1;
                }else if(currentLine!=alLinesHitboxes.size()-1){
                    //go to next line
                    currentcharPos=0;
                    currentLine++;
                }
                
                dragRelease(false);
                setScrollPanePosition();
                repaint();

            }
        });

        im .put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "delete_Key");
        am.put("delete_Key", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentLine==-1)return;
                
                if(!isDraging){
                    if(currentcharPos>=tabSize){
                        String tab ="";
                        for(int i=0;i<tabSize;i++){
                            tab+=" ";
                        }
                        if(alLinesHitboxes.get(currentLine).getText().substring(currentcharPos-tabSize,currentcharPos).equals(tab)&&(currentcharPos%tabSize==0)){
                            for(int i=0;i<tabSize-1;i++){
                                deleteChar();
                            }
                        }
                    } 
                }else{
                    dragRelease(true);
                }
                

                setScrollPanePosition();
                deleteChar();
                repaint();

            }
        });

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK), "ctrlV");
        am.put("ctrlV", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(currentLine==-1)return;
                ArrayList<String> newLineList = new ArrayList<>();
                String data="";
                try {
                    dragRelease(true);
                    data = (String) Toolkit.getDefaultToolkit()
                            .getSystemClipboard().getData(DataFlavor.stringFlavor);

                    for (int i = 0; i < data.length(); i++) {
                        char c = data.charAt(i);
                        if(c =='\r'){
                            currentcharPos=0;
                        }
                        else if(c=='\n'){
                            addNewLine();
                        }
                        else{
                            insertChar(c+"");
                        }
                    }
                    //dragRelease(true);
                    setScrollPanePosition(); 
                    repaint();
                }
                catch (IOException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                } catch (HeadlessException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (UnsupportedFlavorException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } 
           
            }
        });


        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK), "ctrlC");
        am.put("ctrlC", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
                if(currentLine==-1)return;
            
                StringSelection stringSelection = new StringSelection(copyText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            
               
           
            }
        });



        //action key listener for every character form the list
        for(int i=0;i<allChars.length;i++){
            final char c = allChars[i];
            im.put(KeyStroke.getKeyStroke(c), "type:"+c);
            am.put("type:"+c, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(currentLine==-1)return;
                    //System.out.println("You pressed: "+c);
                    dragRelease(true);
                    insertChar(c+"");
                    setScrollPanePosition();
                    repaint();
                     
                }
            });
        }
        this.requestFocusInWindow();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        timer.start();

    }



















    @Override
    protected void paintComponent(Graphics g){


        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, lineHeight-5));
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth()-1, this.getHeight()-1);
        withOfOneChar = getCharWidth("a",g);


        if(currentLine!=-1){
            if(!isDraging){//curser
                drawSelctedLine(currentLine, g);
                if(curserIsVisible){
                    g.setColor(curserColor);
                    g.drawLine(currentcharPos*withOfOneChar+tbg+1, lineHeight*currentLine, currentcharPos*withOfOneChar+tbg+1, lineHeight*(currentLine+1));                  
                }
            }
            
                
            drawSelctedLines(g);      
        }

        if(!alLinesHitboxes.isEmpty()){      
            drawAllLines(g);
            drawLineNumbers(g);
            //drawRightScrollbar(g);
            makeThePanelBiggerIfNeeded();
        }  
    }












    /**
     * this function deletes the text that  is selected by draging your mouse
     */
    private void deleteSelectedText() {
        //could be written more efficient && chatgbt assistance
        if (!isDraging || currentLine == -1 || currentcharPos == -1 || dragedLine == -1)
            return ;

        
        int startLine, endLine;
        int startChar, endChar;

        if (currentLine < dragedLine ||
        (currentLine == dragedLine && currentcharPos < dragedCharPos)) {

            startLine = currentLine;
            startChar = currentcharPos;
            endLine = dragedLine;
            endChar = dragedCharPos;

        } else {
            startLine = dragedLine;
            startChar = dragedCharPos;
            endLine = currentLine;
            endChar = currentcharPos;
        }

        //SAME LINE
        if (startLine == endLine) {
            alLinesHitboxes.get(startLine)
                    .removeString(startChar, endChar);

        } 
        //MULTI LINE 
        else {
            //Remove tail of first line
            alLinesHitboxes.get(startLine)
                    .removeString(startChar,
                            alLinesHitboxes.get(startLine).getTextLength());

            //Remove head of last line
            alLinesHitboxes.get(endLine)
                    .removeString(0, endChar);

            //Remove full middle lines (IMPORTANT: remove from bottom!)
            for (int i = endLine - 1; i > startLine; i--) {
                alLinesHitboxes.remove(i);
            }

            alLinesHitboxes.get(startLine)
                    .append(alLinesHitboxes.get(startLine + 1).getText());
            alLinesHitboxes.remove(startLine + 1);
        }

        currentLine = startLine;
        currentcharPos = startChar;

        changeHitBoxAfterNewLine();
      


    }


    /**
     * reads the selected text
     * @return String text that is currently selected or from the line if no line is slelected
     */
    private String copyText(){//needs to be more efficient
        String text="";
      
        if(isDraging && currentLine!=-1 && currentcharPos!=-1 && dragedLine!=-1){
           
            
            int totalSelectedLines = Math.abs(dragedLine-currentLine)+1;//total number of selected lines and +1 because of null index
            int c =Math.min(currentLine, dragedLine);//first line that is is painted
            for(int i =1;i<totalSelectedLines-1;i++){
                if(alLinesHitboxes.get(i+c).getTextLength()!=0){
                    text=text + alLinesHitboxes.get(i+c).getText()+'\n';
                }else{
                    text=text +'\n';
                }
            }

            if(currentLine-dragedLine>0){//dragging under
                text =  alLinesHitboxes.get(c).subString(dragedCharPos,alLinesHitboxes.get(c).getTextLength()) +'\n' +text+ alLinesHitboxes.get(currentLine).subString(0,currentcharPos);
            }else if(currentLine-dragedLine<0){//draging over
                text =  alLinesHitboxes.get(c).subString(currentcharPos,alLinesHitboxes.get(c).getTextLength())+'\n' +text+ alLinesHitboxes.get(dragedLine).subString(0,dragedCharPos);
            }else if(currentcharPos-dragedCharPos>0 ){//same line draging left
                text =  text+alLinesHitboxes.get(currentLine).subString(dragedCharPos,(currentcharPos));
            }  else if(currentcharPos-dragedCharPos<0){//same line draging right
                text =  text+alLinesHitboxes.get(currentLine).subString(currentcharPos,dragedCharPos);
            }      
            
        }else{
            text= alLinesHitboxes.get(currentLine).getText();
        }
        return text;
    }




    /**
     * sets the scorllbar to a positition so that the currentline and currentchar are not out of the visible panel
     */
    private void setScrollPanePosition(){
        
        JViewport viewport = scrollPane.getViewport();
        Rectangle visible = viewport.getViewRect();

      
        int x = visible.x;
        int y = visible.y;
        int width = visible.width-tbg;
        int height = visible.height;
        int yPosition = (currentLine)*lineHeight;
        int xPosition = currentcharPos*withOfOneChar;

        int xParameter =-1;
        if(xPosition<x){
            xParameter = xPosition;
        }else if(xPosition>x+width){////////////////////////////////////////////////fix here
            int margin = 1 * withOfOneChar;//ther was a 2 times here
            xParameter = xPosition - width + margin;
        }

        int yParameter =-1;
        if(yPosition<y){
            yParameter=(currentLine)*lineHeight;
        }else if(yPosition>=y+height){
            yParameter=yPosition - height+lineHeight ;
        }

        
        if(xParameter!=-1 || yParameter!=-1){
            scrollPane.getViewport().setViewPosition(
                new Point(
                    xParameter!=-1?xParameter:x,
                    yParameter!=-1?yParameter:y

                )
            );
        }
        
        
    }

    

    /**
     * gets the largest line so the scrollpane can adjust acording to it on the width 
     * @return length ot the larges line in char
     */
    private int getTheLargestLineLength(){
        int lSize=0;
        for(int i=0;i<alLinesHitboxes.size();i++){
            if(alLinesHitboxes.get(i).getTextLength()>lSize){
                lSize=alLinesHitboxes.get(i).getTextLength();
            }
        }
        return lSize;
    }



    /**
    * make this panel bigger for the scrolllpane
    */
    private void makeThePanelBiggerIfNeeded(){
        int lineCount = alLinesHitboxes.size();
        Dimension d = getPreferredSize();      
        d = new Dimension(getTheLargestLineLength()*withOfOneChar+tbg*2,(lineCount+1)*lineHeight);
        setPreferredSize(d);
        revalidate();   //tells scrollpane that size changed
    } 


    /**
     * @param sp passes the jscrollpane to the panel for parameters
     */
    public void setScrollPane(JScrollPane sp){
        this.scrollPane = sp;
    }
   

    /**
     * this draws the selcted,  when draged for the ctr c 
     * @param g Graphics from the main paintcomponent
     */
    private void drawSelctedLines(Graphics g){//needs to be more
        //for(int i=0;i< )
        if(isDraging && currentLine!=-1 && currentcharPos!=-1 && dragedLine!=-1){
            g.setColor(dragColor);

            int totalSelectedLines = Math.abs(dragedLine-currentLine)+1;//total number of selected lines and +1 because of null index
            int c =Math.min(currentLine, dragedLine);//first line that is is painted
            for(int i =1;i<totalSelectedLines-1;i++){
                //System.out.println(Math.min(currentLine, dragedLine)+"----");
                if(alLinesHitboxes.get(i+c).getTextLength()!=0){
                    g.fillRect(tbg,(i+c)*lineHeight, alLinesHitboxes.get(i+c).getTextLength()*withOfOneChar ,   lineHeight);
                }else{
                    g.fillRect(tbg,(i+c)*lineHeight, withOfOneChar ,   lineHeight);
                }
            }
            if(currentLine-dragedLine>0){//dragging under
                g.fillRect(tbg+dragedCharPos*withOfOneChar,(c)*lineHeight, alLinesHitboxes.get(c).getTextLength()*withOfOneChar - dragedCharPos*withOfOneChar,   lineHeight);
                g.fillRect(tbg,(currentLine)*lineHeight, currentcharPos*withOfOneChar,   lineHeight);
            }else if(currentLine-dragedLine<0){//draging over
                g.fillRect(tbg+currentcharPos*withOfOneChar,(c)*lineHeight, alLinesHitboxes.get(c).getTextLength()*withOfOneChar - currentcharPos*withOfOneChar,   lineHeight);
                g.fillRect(tbg,(dragedLine)*lineHeight, dragedCharPos*withOfOneChar,   lineHeight);
            }else if(currentcharPos-dragedCharPos>0){//same line draging left
                g.fillRect(tbg+dragedCharPos*withOfOneChar, currentLine*lineHeight, (currentcharPos-dragedCharPos)*withOfOneChar,lineHeight);
            }  else if(currentcharPos-dragedCharPos<0){//same line draging right
                g.fillRect(tbg+currentcharPos*withOfOneChar, currentLine*lineHeight, (dragedCharPos-currentcharPos)*withOfOneChar,lineHeight);
            }         
            
            
        }
        //System.out.println("you will be deleted"+isDraging);
        
        

    }



    /**
    * delets char and goes to the line bevor if in charpos 0
    */
    private void deleteChar(){
        String line =alLinesHitboxes.get(currentLine).getText();
        if(currentcharPos!=0){
            String bevorText=line.substring(0,currentcharPos-1);
            String afterText=line.substring(currentcharPos,line.length());
            alLinesHitboxes.get(currentLine).setText(bevorText+afterText);
            currentcharPos--;
        }else{
            if(currentLine!=0){
                String bevorText = alLinesHitboxes.get(currentLine-1).getText();
                String afterText = alLinesHitboxes.get(currentLine).getText();
                alLinesHitboxes.get(currentLine-1).setText(bevorText+afterText);
                alLinesHitboxes.remove(currentLine);
                currentcharPos=bevorText.length();
                currentLine--;

            }
            //delete the line

        }
    }

    /**
     * adds new line for enter
     */
    public void addNewLine(){
        Point pPointF = new Point(0,lineHeight*currentLine+1);
        Point pPointE = new Point(this.getWidth(),lineHeight*currentLine+2);


        String line =alLinesHitboxes.get(currentLine).getText();
        String bevorText=line.substring(0,currentcharPos);
        String afterText=line.substring(currentcharPos,line.length());


        alLinesHitboxes.get(currentLine).setText(bevorText);
        
        alLinesHitboxes.add(currentLine+1,new LineHitbox(pPointF, pPointE,afterText));
        currentLine++;
        currentcharPos=0;
      
        changeHitBoxAfterNewLine();
    }   


    /**
     * return on which line you are clicking
     * @param x xPos from the event
     * @param y yPos from the event
     * @return the line that you clicked or -1 if you dont click one a line
     */
    public int isOnLineX(int x, int y){
        for(int i =0;i<alLinesHitboxes.size();i++){      
                if((alLinesHitboxes.get(i).getFPoint().y<y)&&(y<alLinesHitboxes.get(i).getEPoint().y)){
                    return i;
                }      
        }
        return -1;
    }

    /**
     * creates teh lines in the begining
     * @param lineText text of one line
     */
    public void createNewLine(String lineText){
        Point pPointF = new Point(0,lineHeight*alLinesHitboxes.size());
        Point pPointE = new Point(this.getWidth(),lineHeight*(alLinesHitboxes.size()+1));
        alLinesHitboxes.add(new LineHitbox(pPointF, pPointE, lineText));
    }

    /**
     * draws all lines from the array
     * @param g Graphics from paintcomponent
     */
    public void drawAllLines(Graphics g){
        for(int i=0;i<alLinesHitboxes.size();i++){
            g.setColor(Color.BLACK);
            g.drawString(alLinesHitboxes.get(i).getText(),tbg,(i+1)*lineHeight-5);
        } 
    }


    /**
     * draws the numeratation and makes the space for the number bigger when the line  x10
     * @param g Graphics from paintcomponent
     */
    public void drawLineNumbers(Graphics g){

        tbg =tbginit;
        int stellen =(alLinesHitboxes.size()-1+"").length();
        String emptySpace ="";
        for(int i=0;i<alLinesHitboxes.size();i++){
            for(int j=0;j<((stellen-(i+"").length()));j++){
                emptySpace+=" ";
            }
            if(i==1000){
                tbg=tbginit+tbgaddOn;
            }else if(i==10000){
                tbg=tbginit+2*tbgaddOn;
            }else if(i==100000){//it will only break if it reaches 10M lines, which will never happen with or actual computers
                tbg=tbginit+3*tbgaddOn;
            }
            g.setColor(Color.BLACK);
            g.drawString(emptySpace+i+"",0,(i+1)*lineHeight-5);
            emptySpace ="";
        } 
    }

    /**
     * daws a rect to mark the line
     * @param line current line
     * @param g Graphics from paintcomponent
     */
    private void drawSelctedLine(int line,Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,lineHeight*line,this.getWidth(),lineHeight);
    }

    /**
     * current character that you clicked
     * @param xPos xPos of the event
     * @param pointerLine line
     * @return current char, -1 if not clicking on line or (-2 should not happen)
     */
    private int getPositionInLine(int xPos,int pointerLine){
        String line;
        if(pointerLine!=-1)line=alLinesHitboxes.get(pointerLine).getText();
        else return -1;//not in line
        
        if(xPos<=0){
            return 0;
        }else if(xPos>line.length()*withOfOneChar){
            return line.length();
        }else{
            for(int i=0;i<line.length();i++){
                if(withOfOneChar*i<xPos&&withOfOneChar*(i+1)>=xPos){
                    return i;
                }
            }
        }

        return -2;//this should never happen
        

        
    }
    
    /**
     * gets the widt of one char
     * @param pChar one sample char
     * @param g graphics from paintcomponent
     * @return the width of the char with the parameters from g
     */
    private int getCharWidth(String pChar, Graphics g){
        FontMetrics metrics = g.getFontMetrics(g.getFont());
         return metrics.stringWidth(pChar);


    }

    /**
     * insert a char or a string that you clicked, with multiple use
     * @param input the input char
     */
    private void insertChar(String input){
        String line =alLinesHitboxes.get(currentLine).getText();
        String bevorText=line.substring(0,currentcharPos);
        String afterText=line.substring(currentcharPos,line.length());
        currentcharPos+= input.length();

        alLinesHitboxes.get(currentLine).setText(bevorText+input+afterText);
        
        
    
    }


    /**
     * resets the hitboxes fro every out of line line
     */
    private void changeHitBoxAfterNewLine(){
        for(int i=0;i< alLinesHitboxes.size();i++){
            Point pPointF = new Point(0,lineHeight*i);
            Point pPointE = new Point(this.getWidth(),lineHeight*(i+1));
            alLinesHitboxes.get(i).setEPoint(pPointE);
            alLinesHitboxes.get(i).setFPoint(pPointF); 


        }

        
    }

    /**
     * goes to nex tab point
     */
    private void goToNextTabPoint(){
        int  space = currentcharPos%tabSize;
        String tabText = "";
        int numberOfSpace;

        if(space==0){
            numberOfSpace=tabSize;
        }
        else{
            numberOfSpace =tabSize-space;
        } 
        

        for(int i =0;i<numberOfSpace;i++){
            tabText+=" ";
        }
        String line =alLinesHitboxes.get(currentLine).getText();
        String bevorText=line.substring(0,currentcharPos);
        String afterText=line.substring(currentcharPos,line.length());
        alLinesHitboxes.get(currentLine).setText(bevorText+tabText+afterText);

        currentcharPos+=numberOfSpace;
    }

    /**
     * check if you arent clicking outside the text editor
     * @param xPos event xpos
     * @return boolean if you are clicking on the lines
     */
    private boolean checkIfYouAreClickingOnTheLines(int xPos){
        return (xPos <this.getWidth()-rightScrollbarWidth);
    }    

    /**
     * realeses the drag and if you give a true it delets the selected text
     * @param deleteRest true: to deleteSelectedText()
     */
    private void dragRelease(boolean deleteRest){   
        if(deleteRest){//for when you select and write something
            deleteSelectedText();
            
        }
        isDraging=false;
        dragedLine = -1;
        dragedCharPos =-1;
    }

    /**
     * exectutes  teh comand shift tab to delete teh tab bevor
     * @param lineN  the currentline beeing changed
     * @param isCurrentLine boolean adjust the currentline if it is the line being changed
     * @param isDragedLine boolen adjust the dragedLine if it is the line being changed
     */
    private void shiftTabOneLine(int lineN, boolean isCurrentLine,boolean isDragedLine){
        if(alLinesHitboxes.get(lineN).getTextLength()>tabSize){
            if(alLinesHitboxes.get(lineN).getText().startsWith(getTab())){
                alLinesHitboxes.get(lineN).removeString(0, tabSize);
                
                if(isCurrentLine&&(currentcharPos>=tabSize)){
                    currentcharPos-=tabSize;
                }
                if(isDragedLine&&dragedCharPos>=tabSize){
                    dragedCharPos-=tabSize; 
                }
            }
        }
    }

    /**
     * adds an tab on the begining of the line
     * @param lineN the currentline beeing changed
     * @param isCurrentLine boolean adjust the currentline if it is the line being changed
     * @param isDragedLine boolen adjust the dragedLine if it is the line being changed
     */
    private void tabOneLine(int lineN, boolean isCurrentLine,boolean isDragedLine){   
        alLinesHitboxes.get(lineN).addTab(getTab());

        if(isCurrentLine){
            currentcharPos+=tabSize;
            
        }
        if(isDragedLine){
            dragedCharPos+=tabSize;
            
        }
      
    }

    /**
     * creates a sting from spaces to create a tab
     * @return a tab out of ' '
     */
    private String getTab(){
        String tab ="";
        for(int i=0;i<tabSize;i++){
            tab+=" ";
        }
        return tab;
    }


    /**
     * sets the of the editor
     * @param text text for the texteditor in form of String
     */
    public void setText(String text){
        alLinesHitboxes.clear();
        Stream<String> lines =text.lines();
        lines.forEach(this::createNewLine);
    }











    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        repaint();
        //System.out.println("hgh");
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
        //System.out.println("fdsf");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
        //System.out.println(isOnLineX(e.getX(), e.getY()));
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        dragRelease(false);
        if(checkIfYouAreClickingOnTheLines(e.getX())){
            currentLine=isOnLineX(e.getX(), e.getY());
            currentcharPos=getPositionInLine(e.getX()-tbg,currentLine);
        // System.out.println("currentchar"+currentcharPos);
            this.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");

        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if(checkIfYouAreClickingOnTheLines(e.getX())){
            int pdragedLine=isOnLineX(e.getX(), e.getY());
            int pdragedCharPos=getPositionInLine(e.getX()-tbg,dragedLine);
            
            if(pdragedLine!=-1){
                dragedLine=pdragedLine;
                
            }
            if(pdragedCharPos!=-1){
                dragedCharPos=pdragedCharPos;
            }

            isDraging=true;
            repaint();
        }
        
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
