import java.util.Scanner;
/**
 * A input class is used to accept user's input.
 *
 * @author         Ruimeng Liu
 * @version        1.0 (31.May.2019)
 */
public class Input
{
    
    /**
     * Constructor for objects of class Input
     */
    public Input()
    {
    }

    /**
     * This is the method which accepts String input from keboard
     *
     * @param  displayMessage  A String to indicate the message printed on the screen
     */
    public static String acceptStringInput(String displayMessage)
    {
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        String value = console.nextLine().trim();
        return value;
    }
}