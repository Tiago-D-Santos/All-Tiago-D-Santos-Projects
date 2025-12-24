import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class Frame extends JFrame{


    /*
     * Things to do
     * -drag scroll
     * -coloring text
     * -code editor things
     */
    public Frame(){
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bad Text Editor");

        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(
            (int) (screen.width * 0.2),
            (int) (screen.height * 0.2),
            (int) (screen.width * 0.6),
            (int) (screen.height * 0.6)
        );
        
       
        TextEditor te = new TextEditor();
        JScrollPane sp = new JScrollPane(te);
        
        //Remove arrow keys from scrolling behavior
        InputMap im = sp.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        im.put(KeyStroke.getKeyStroke("UP"), "none");
        im.put(KeyStroke.getKeyStroke("DOWN"), "none");
        im.put(KeyStroke.getKeyStroke("LEFT"), "none");
        im.put(KeyStroke.getKeyStroke("RIGHT"), "none");


        //layout necessary for the scrollpane
        this.setLayout(new BorderLayout());
        this.add(sp, BorderLayout.CENTER);
        te.setScrollPane(sp);
        this.setVisible(true);
        


      
        

        try {
                String testst = getFileText("src/testFile.txt");
                te.setText(testst);
                /* Stream<String> lines =testst.lines();
                lines.forEach(te::createNewLine); */

                
        } catch (Exception e) {
            // TODO: handle exception
        }

    }


    @SuppressWarnings("resource")
    public String getFileText(String url) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(url));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
            }
            String everything = sb.toString();
            return everything;

        } catch(Exception e) {
            
            br.close();
            return null;
        }
    }



    public static void main(String[] args) {
        new Frame();
        
    }

    
}