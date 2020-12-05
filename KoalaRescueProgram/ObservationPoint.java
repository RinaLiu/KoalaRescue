import java.util.*;
/**
 * Write a description of class ObservationPoint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ObservationPoint
{
    // instance variables - replace the example below with your own
    private ArrayList<Koala> listOfInjurdKoalas;
    private ArrayList<Koala> listOfHealthyKoalas;
    private double weightOfAvailableFood;
    private Tree[] listOfTrees;
    private int availableShelter;
    private int numberOfPredators;

    /**
     * Constructor for objects of class ObservationPoint
     */
    public ObservationPoint()
    {
        // initialise instance variables
        listOfInjurdKoalas = new ArrayList<Koala>();
        listOfHealthyKoalas = new ArrayList<Koala>();
        weightOfAvailableFood = 0.00;
        listOfTrees = new Tree[5];
        availableShelter = 0;
        numberOfPredators = 0;
    }

    /**
     * Constructor for objects of class ObservationPoint
     */
    public ObservationPoint(ArrayList<Koala> listOfInjurdKoalas, ArrayList<Koala> listOfHealthyKoalas, 
    double weightOfAvailableFood, Tree[] listOfTrees, int numberOfPredators, int availableShelter)
    {
        // initialise instance variables
        this.listOfInjurdKoalas = listOfInjurdKoalas;
        this.listOfHealthyKoalas = listOfHealthyKoalas;
        this.weightOfAvailableFood = weightOfAvailableFood;
        this.listOfTrees = listOfTrees;
        this.availableShelter = availableShelter;
        this.numberOfPredators = numberOfPredators;
    }

    public void addHealthyKoalas(int age)
    {
        listOfHealthyKoalas.add(new Koala(age, true));
    }

    public void addHealthyKoalas(Koala k)
    {
        listOfHealthyKoalas.add(k);
    }

    public void addInjurdKoalas(int age)
    {
        listOfInjurdKoalas.add(new Koala(age, false));
    }

    public boolean checkFoodShortage()
    {
        int numberOfKoala = listOfInjurdKoalas.size() + listOfHealthyKoalas.size();
        boolean check = false;
        if (numberOfKoala >= (int)(weightOfAvailableFood))
        {
            check = true;
        }
        return check;
    }

    public boolean checkShelterShortage()
    {
        int numberOfKoala = listOfInjurdKoalas.size() + listOfHealthyKoalas.size();
        boolean check = false;
        if (numberOfKoala >= availableShelter)
        {
            check = true;
        }
        return check;
    }

    public void countAvailableShelter()
    {
        for (Tree tree : listOfTrees)
        {
            if (!tree.getIsFOrFood())
            {
                availableShelter = availableShelter + tree.getNumberOfTrees();
            }
        }
    }

    public int countShortageFoodKoala()
    {
        int numberShortageFoodKoala = 0;
        int numberOfKoala = listOfInjurdKoalas.size() + listOfHealthyKoalas.size();
        if (numberOfKoala > weightOfAvailableFood)
        {
            numberShortageFoodKoala = (int)(numberOfKoala - weightOfAvailableFood) + 1;
        }
        return numberShortageFoodKoala;
    }

    public int countShortageShelterKoala()
    {
        int numberShortageShelterKoala = 0;
        int numberOfKoala = listOfInjurdKoalas.size() + listOfHealthyKoalas.size();
        if (numberOfKoala > availableShelter)
        {
            numberShortageShelterKoala = numberOfKoala - availableShelter;
        }
        return numberShortageShelterKoala;
    }

    public void countWeightOfAvailableFood()
    {
        for (Tree tree : listOfTrees)
        {
            weightOfAvailableFood = weightOfAvailableFood + tree.getKgOfEdible() * tree.getNumberOfTrees();
        }
    }

    public String display()
    {
        String koalasState = "";
        for (Koala koala : listOfInjurdKoalas)
        {
            koalasState = koalasState + koala.display() + "\n";
        }
        for (Koala koala : listOfHealthyKoalas)
        {
            koalasState = koalasState + koala.display() + "\n";
        }
        String treesState = "";
        for (Tree tree : listOfTrees)
        {
            treesState = treesState + tree.display() + "\n";
        }
        String observationPointState = koalasState + treesState + "weightOfAvailableFood:" + weightOfAvailableFood +
            " availableShelter:" + availableShelter + " numberOfPredators: " + numberOfPredators;
        return observationPointState;
    }

    public int getAvailableShelter()
    {
        return availableShelter;
    }

    public ArrayList<Koala> getListOfHealthyKoalas()
    {
        return listOfHealthyKoalas;
    }

    public ArrayList<Koala> getListOfInjurdKoalas()
    {
        return listOfInjurdKoalas;
    }

    public Tree[] getListOfTrees()
    {
        return listOfTrees;
    }

    public int getNumberOfPredators()
    {
        return numberOfPredators;
    }

    public String getTreeNumbers()
    {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < listOfTrees.length; i++)
        {
            sb.append(listOfTrees[i].getNumberOfTrees());
            if (i != listOfTrees.length - 1)
                sb.append(",");
        }
        return sb.toString() + "\n";
    }

    public double getWeightOfAvailableFood()
    {
        return weightOfAvailableFood;
    }

    public void setAvailableShelter(int availableShelter)
    {
        this.availableShelter = availableShelter;
    }

    public void setListOfHealthyKoalas(ArrayList<Koala> listOfHealthyKoalas)
    {
        this.listOfHealthyKoalas = listOfHealthyKoalas;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setListOfInjurdKoalas(ArrayList<Koala> listOfInjurdKoalas)
    {
        this.listOfInjurdKoalas = listOfInjurdKoalas;
    }

    public void setListOfTrees()
    {
        listOfTrees[0] = new Tree("Manna Gum", true, 1.00, 0);
        listOfTrees[1] = new Tree("Swamp Gum", true, 0.34, 0);
        listOfTrees[2] = new Tree("Blue Gum", true, 0.90, 0);
        listOfTrees[3] = new Tree("River Red Gum", true, 0.40, 0);
        listOfTrees[4] = new Tree("Wattle", false, 0, 0);
    }

    public void setNumberOfPredators(int numberOfPredators)
    {
        this.numberOfPredators = numberOfPredators;
    }

    public void setWeightOfAvailableFood(double weightOfAvailableFood)
    {
        this.weightOfAvailableFood = weightOfAvailableFood;
    }

    public void setiLstOfTrees(Tree[] listOfTrees)
    {
        this.listOfTrees = listOfTrees;
    }
}
