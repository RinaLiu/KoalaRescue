import java.util.*;
/**
 * Write a description of class Reserve here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Reserve
{
    // instance variables - replace the example below with your own
    private ObservationPoint[] listOfObservationPoints;
    private SafeHaven safeHaven;
    private int relocateKoala;

    /**
     * Constructor for objects of class Reserve
     */
    public Reserve()
    {
        // initialise instance variables
        listOfObservationPoints = new ObservationPoint[10];
        for (int i = 0; i < 10; i++)
        {
            listOfObservationPoints[i] = new ObservationPoint();
        }
        safeHaven = new SafeHaven();
        relocateKoala = 0;
    }

    /**
     * Constructor for objects of class Reserve
     */
    public Reserve(ObservationPoint[] listOfObservationPoints, SafeHaven safeHaven,int relocateKoala)
    {
        // initialise instance variables
        this.listOfObservationPoints = listOfObservationPoints;
        this.safeHaven = safeHaven;
        this.relocateKoala = relocateKoala;
    }

    public int getRelocateKoala()
    {
        return relocateKoala;
    }

    public void setRelocateKoala(int relocateKoala)
    {
        this.relocateKoala = relocateKoala;
    }

    public void countAvailableShelter()
    {
        for (ObservationPoint ob : listOfObservationPoints)
        {
            ob.countAvailableShelter();
        }
    }

    public int countInjurdDeath(int i)
    {
        int countInjurdDeath = 0;
        countInjurdDeath = listOfObservationPoints[i].getListOfInjurdKoalas().size() + countInjurdDeath;
        listOfObservationPoints[i].getListOfInjurdKoalas().clear();
        return countInjurdDeath;
    }

    public int countInjurdKoalasInSafeHaven()
    {
        return safeHaven.countInjurdKoala();
    }

    public int countPredatorDeath(int i)
    {
        int predatorDeathKoala = 0;
        if (listOfObservationPoints[i].getNumberOfPredators() > 3)
        {
            if (RandomNumber.getRandom(100,1) <= 50)
            {
                listOfObservationPoints[i].getListOfHealthyKoalas().remove(0);
                predatorDeathKoala++;
            }
        }
        return predatorDeathKoala;
    }

    public int countShortageFoodKoalaDeath(int i)
    {
        int countShortageFoodKoala = 0;
        if (listOfObservationPoints[i].checkFoodShortage())
        {
            for (int j = 0; j < listOfObservationPoints[i].getListOfHealthyKoalas().size() - (int)(listOfObservationPoints[i].getWeightOfAvailableFood()) + 1; j++)
            {
                if (RandomNumber.getRandom(100,1) <= 80)
                {
                    listOfObservationPoints[i].getListOfHealthyKoalas().remove(0);
                    countShortageFoodKoala++;
                }
            }
        }
        return countShortageFoodKoala;
    }

    public int countShortageShelterKoalaDeath(int i)
    {
        int countShortageShelterKoalaDeath = 0;
        if (listOfObservationPoints[i].checkShelterShortage())
        {
            for (int j = 0; j < listOfObservationPoints[i].getListOfHealthyKoalas().size() - listOfObservationPoints[i].getAvailableShelter(); j++)
            {
                if (RandomNumber.getRandom(100,1) <= 20)
                {
                    listOfObservationPoints[i].getListOfHealthyKoalas().remove(0);
                    countShortageShelterKoalaDeath++;
                }
            }
        }
        return countShortageShelterKoalaDeath;
    }

    public int countTotalHealthyKoala()
    {
        int totalHealthyKoalas = 0;
        for (ObservationPoint ob : listOfObservationPoints)
        {
            totalHealthyKoalas = ob.getListOfHealthyKoalas().size() + totalHealthyKoalas;
        }
        totalHealthyKoalas = totalHealthyKoalas + safeHaven.getListOfSafeKoalas().size();
        return totalHealthyKoalas;
    }

    public void countWeightFood()
    {
        for (ObservationPoint ob : listOfObservationPoints)
        {
            ob.countWeightOfAvailableFood();
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String display()
    {
        String observationPointState = "";
        for (ObservationPoint observationPoint : listOfObservationPoints)
        {
            observationPointState = observationPointState + observationPoint.display() + "\n";
        }
        String safeHavenState = safeHaven.display();
        return observationPointState + safeHavenState;
    }

    public ObservationPoint[] getListOfObservationPoints()
    {
        return listOfObservationPoints;
    }

    public ObservationPoint getOneObservationPoint(int position)
    {
        return listOfObservationPoints[position];
    }

    public String getTreeNumbers()
    {
        StringBuffer sb = new StringBuffer("");
        for (ObservationPoint observationPoint : listOfObservationPoints)
        {
            sb.append(observationPoint.getTreeNumbers());
        }
        return sb.toString();
    }

    public boolean moveHealthyKoala(int i)
    {
        if (listOfObservationPoints[i].checkFoodShortage() || listOfObservationPoints[i].checkShelterShortage())
        {
            safeHaven.addKoalas(listOfObservationPoints[i].getListOfHealthyKoalas().get(0));
            listOfObservationPoints[i].getListOfHealthyKoalas().remove(0);
            return true;
        }
        return false;
    }

    public boolean moveInjurdKoala(int i)
    {
        for (int j = 0; j < listOfObservationPoints[i].getListOfInjurdKoalas().size();j++)
        {
            safeHaven.addKoalas(listOfObservationPoints[i].getListOfInjurdKoalas().get(j));
            listOfObservationPoints[i].getListOfInjurdKoalas().remove(j);
            return true;
        }
        return false;
    }

    public boolean relocateKoala(int i)
    {
        if (!listOfObservationPoints[i].checkFoodShortage() && !listOfObservationPoints[i].checkShelterShortage()
        && safeHaven.getListOfSafeKoalas().size() > 0)
        {
            int oldestKoalaIndex = safeHaven.getOldestKoala();
            if (oldestKoalaIndex > 0)
            {
                listOfObservationPoints[i].addHealthyKoalas(safeHaven.getListOfSafeKoalas().get(oldestKoalaIndex));
                safeHaven.removeKoala(safeHaven.getListOfSafeKoalas().get(oldestKoalaIndex));
                setRelocateKoala(getRelocateKoala() + 1);
                return true;
            }
        }
        return false;
    }

    public void setHealthyKoalas()
    {
        for (int j = 0; j < listOfObservationPoints.length; j++)
        {
            int numberOfHealthyKoalas = RandomNumber.getRandom(9,0);
            for (int i = 0; i < numberOfHealthyKoalas; i++)
            {
                listOfObservationPoints[j].addHealthyKoalas(RandomNumber.getRandom(18,1));
            }
        }
    }

    public void setInjurdKoalas()
    {
        for (int j = 0; j < listOfObservationPoints.length; j++)
        {
            int numberOfInjurdKoalas = RandomNumber.getRandom(2,0);
            for (int i = 0; i < numberOfInjurdKoalas; i++)
            {
                listOfObservationPoints[j].addInjurdKoalas(RandomNumber.getRandom(18,1));
            }
        }
    }

    public void setListOfObservationPoints(ObservationPoint[] listOfObservationPoints)
    {
        this.listOfObservationPoints = listOfObservationPoints;
    }

    public void setPredators()
    {
        for (int j = 0; j < listOfObservationPoints.length; j++)
        {
            listOfObservationPoints[j].setNumberOfPredators(RandomNumber.getRandom(4,0));
        }
    }

    public void setTrees()
    {
        for (ObservationPoint observationPoint : listOfObservationPoints)
        {
            observationPoint.setListOfTrees();
        }
    }

    public int treeFall(int i)
    {
        int treeFallNumber = 0;
        for (int j = 0; j < listOfObservationPoints[i].getListOfTrees().length; j++)
        {
            if (RandomNumber.getRandom(100,1) <= 5)
            {
                listOfObservationPoints[i].getListOfTrees()[j].setNumberOfTrees(listOfObservationPoints[i].getListOfTrees()[j].getNumberOfTrees() - 1);
                treeFallNumber++;
            }
        }
        return treeFallNumber;
    }
}
