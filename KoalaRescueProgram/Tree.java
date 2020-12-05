
/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree
{
    // instance variables - replace the example below with your own
    private String type;
    private boolean isForFood;//true is for food
    private double kgOfEdible;
    private int numberOfTrees;

    /**
     * Constructor for objects of class Tree
     */
    public Tree()
    {
        // initialise instance variables
        type = "unknown";
        isForFood = true;
        kgOfEdible = 0.00;
        numberOfTrees = 0;
    }

    /**
     * Constructor for objects of class Tree
     */
    public Tree(String type, boolean isForFood, double kgOfEdible, int numberOfTrees)
    {
        // initialise instance variables
        this.type = type;
        this. isForFood= isForFood;
        this.kgOfEdible = kgOfEdible;
        this.numberOfTrees = numberOfTrees;
    }
    
    public String display()
    {
        return "type: " + type + " isForFood: " + isForFood + " kgOfEdible: " + kgOfEdible + " numberOfTrees: " + numberOfTrees;
    }
    
    public boolean getIsFOrFood()
    {
        return isForFood;
    }
    
    public double getKgOfEdible()
    {
        return kgOfEdible;
    }
    
    public int getNumberOfTrees()
    {
        return numberOfTrees;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setIsForFood(boolean newIsForFood)
    {
        isForFood = newIsForFood;
    }
    
    public void setKgOfEdible(double newKgOfEdible)
    {
        kgOfEdible = newKgOfEdible;
    }
    
    public void setNumberOfTrees(int numberOfTrees)
    {
        this.numberOfTrees = numberOfTrees;
    }
    
    public void setType(String newType)
    {
        type = newType;
    }
}
