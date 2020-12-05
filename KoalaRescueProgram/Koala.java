
/**
 * Write a description of class Koala here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Koala
{
    // instance variables - replace the example below with your own
    private int age;
    private boolean isHealthy;

    /**
     * Constructor for objects of class Koala
     */
    public Koala()
    {
        // initialise instance variables
        age = 0;
        isHealthy = true;
    }

    /**
     * Constructor for objects of class Koala
     */
    
    public Koala(int newAge, boolean newIsHealthy)
    {
        // initialise instance variables
        age = newAge;
        isHealthy = newIsHealthy;
    }

    public String display()
    {
        String state = " age:" + age + " isHealthy: " + isHealthy;
        return state;
    }

    public int getAge()
    {
        return age;
    }

    public boolean getIsHealthy()
    {
        return isHealthy;
    }
    
    public void setAge(int newAge)
    {
        age = newAge;
    }
    
    public void setIsHealthy(boolean newIsHealthy)
    {
        isHealthy = newIsHealthy;
    }
}
