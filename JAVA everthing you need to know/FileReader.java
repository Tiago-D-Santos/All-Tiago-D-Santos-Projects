/* import java.io.FileReader;
public class FileReader {
    public static final String RED = "\033[0;31m";
    public static final String WHITE = "\033[0m";
    public static void main(String[] args) {
        
        try {
            FileReader reader = new FileReader("FileReaderFile.txt");
            int  data = reader.read();
            System.out.println(data);
            System.out.println(RED +"Exception in thread \"main\" java.lang.Error: Unresolved compilation problem: \r\n" + //
                                "        The method prtln(int) is undefined for the type PrintStream\r\n" + //
                                "\r\n" + //
                                "        at Main.main(Main.java:10)");
            while(data != -1){//data is -1 when nothing is there
                System.out.print(RED + (char)data+ WHITE);
                data =reader.read();
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }
}
 */