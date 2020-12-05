
/**
 * Write a description of class Validation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validation
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Validation
     */
    public Validation()
    {
        // initialise instance variables
    }

    public static boolean checkIntegerRange(int value, int min, int max)
    {
        boolean check = true;
        if (value >= min && value <= max)
            check = true;
        else
            check = false;
        return check;
    }
    
    public static boolean checkStringCharacter(String string)//check symbols
    {
        boolean check = true;
        string = string.trim();
        if(string.length() > 0)
        {
            for (int index = 0; index < string.length(); index++)
            {
                char i = string.charAt(index);
                if (i <'a' || i > 'z')
                {
                    check = false;
                }
            }
        }
        else
        {
            check = false;
        }
        return check;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static boolean checkStringLength(String aString, int min, int max)
    {
        aString = aString.trim();
        boolean check;
        if (aString.length() >=min && aString.length() <= max)
        {
            check = true;
        }
        else
        {
            check = false;
        }
        return check;
    }

    public static boolean stringNumeric(String string)
    {
        if (string.trim().equals(""))
            return false;
        for (int index = 0; index < string.length(); index++)
        {
            char i = string.charAt(index);
            if (i < '0' || i > '9')
                return false;
        }
        return true;
    }
}
