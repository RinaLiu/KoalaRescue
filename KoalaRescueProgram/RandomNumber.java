
/**
 * A RNG class is used to generate RNG object.
 *
 * @author         
 * @version        
 */
public class RandomNumber
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class RandomNumber
     */
    public RandomNumber()
    { 
    }
    
    
    /**
     * This is the method which generates a random number between minimum and maximum value
     *
     * @return    The random number
     */
    public static int getRandom(int maximumValue, int minimumValue)
    {
        int a = maximumValue - minimumValue + 1;
        int b = (int)(Math.random() * a) + minimumValue;
        return b;
    }
    
    
}
