import java.util.*;
/**
 * Write a description of class SafeHaven here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SafeHaven
{
    // instance variables - replace the example below with your own
    private ArrayList<Koala> listOfSafeKoalas;

    /**
     * Constructor for objects of class SafeHaven
     */
    public SafeHaven()
    {
        // initialise instance variables
        listOfSafeKoalas = new ArrayList<Koala>();
    }

    /**
     * Constructor for objects of class SafeHaven
     */
    public SafeHaven(ArrayList<Koala> listOfSafeKoalas)
    {
        // initialise instance variables
        this.listOfSafeKoalas = listOfSafeKoalas;
    }
    
    public void addKoalas(Koala koala)
    {
        //Koala k = new Koala(koala.getAge(), false);
        listOfSafeKoalas.add(koala);
    }

    public int countInjurdKoala()
    {
        int injurdKoalas = 0;
        for (Koala k : listOfSafeKoalas)
        {
            if (!k.getIsHealthy())
            {
                injurdKoalas++;
            }
        }
        return injurdKoalas;
    }

    public String display()
    {
        String koalasState = "";
        for (Koala koala : listOfSafeKoalas)
        {
            koalasState = koalasState + koala.display() + "\n";
        }
        return koalasState;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public ArrayList<Koala> getListOfSafeKoalas()
    {
        // put your code here
        return listOfSafeKoalas;
    }
    
    public int getOldestKoala()
    {
        Koala oldestKoala = new Koala(0, true);
        int oldestKoalaIndex = -1;
        for (Koala k : listOfSafeKoalas)
        {
            if (k.getAge() >= oldestKoala.getAge() && k.getIsHealthy())
            {
                oldestKoala = k;
                oldestKoalaIndex = listOfSafeKoalas.indexOf(k);
            }
        }
        return oldestKoalaIndex;
    }
    
    public void removeKoala(Koala k)
    {
        listOfSafeKoalas.remove(k);
    }
    
    public void setListOfSafeKoalas(ArrayList<Koala> listOfSafeKoalas)
    {
        // put your code here
        this.listOfSafeKoalas = listOfSafeKoalas;
    }
}
