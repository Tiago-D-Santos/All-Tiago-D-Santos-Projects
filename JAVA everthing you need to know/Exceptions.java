/*import java.util.InputMismatchException;
import java.util.Scanner;
public class Exceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            
            System.out.println("Enter:");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = x/y;
            System.out.println(z);
        }
        catch(ArithmeticException e) {
            System.out.println("you cant divide by zero");
        }
        catch(InputMismatchException e){
            System.out.println("you must write a number");
        }
        catch(Exception e){
            System.out.println("Every other errors");
        }
        finally{
            scanner.close();
            System.out.println("this will always print at the final");
        }

    }
}
*/