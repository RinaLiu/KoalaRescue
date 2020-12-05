import java.util.*;
import java.io.*;
/**
 * Write a description of class KoalaRescue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KoalaRescue
{
    // instance variables - replace the example below with your own
    private String name;
    private int budget;
    private Reserve reserve;
    /**
     * Constructor for objects of class KoalaRescue
     */
    public KoalaRescue()
    {
        // initialise instance variables
        reserve = new Reserve();
        budget = 0;
        name = "unknown";
    }

    public KoalaRescue(Reserve reserve, int budget, String name)
    {
        // initialise instance variables
        this.reserve = reserve;
        this.budget = budget;
        this.name = name;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setBudget(int budget)
    {
        // put your code here
        this.budget = budget;
    }

    public void setReserve(Reserve reserve)
    {
        // put your code here
        this.reserve = reserve;
    }

    public int getBudget()
    {
        // put your code here
        return budget;
    }

    public Reserve getReserve()
    {
        // put your code here
        return reserve;
    }

    public void setName(String name)
    {
        // put your code here
        this.name = name;
    }

    public String getName()
    {
        // put your code here
        return name;
    }

    public void display()
    {
        System.out.println(name + reserve.display() + budget);
    }

    private void printWelcome()
    {
        System.out.println(">->->->->->->>->->->->->->>->->->->->->>->->->->->->>->->->->->->");
        System.out.println(">->->->->->->Weclome to Koala Rescue Program!->->->->>->->->->->-");
        System.out.println(">->->->->->->>->->->->->->>->->->->->->>->->->->->->>->->->->->->");
        enterToConitnue();
    }

    public void startProgram()
    {
        printWelcome();
        enterName();
        int initialBudget = enterBudget();
        reserve.setTrees();
        readTreesFile();
        reserve.countWeightFood();
        reserve.countAvailableShelter();
        reserve.setInjurdKoalas();
        reserve.setHealthyKoalas();
        reserve.setPredators();
        int totalDeath = goEachObservationPoint();
        System.out.println("Amount Spent on the Recue: " + (initialBudget - budget));
        enterToConitnue();
        printSuccess(totalDeath);
        writeUpdatedTrees();
    }

    private void printSuccess(int totalDeath)
    {
        if (totalDeath == 0)
        {
            System.out.println("Rescue was successful, with no koala deaths");
        }
        else
        {
            System.out.println("Rescue completed with " + totalDeath + " koalas deaths");
        }
    }

    private void enterName()
    {
        String name = Input.acceptStringInput("Please enter your name");
        while(!Validation.checkStringCharacter(name) || !Validation.checkStringLength(name,1,16))
        {
            name = Input.acceptStringInput("Please input a name less than 16 alphabetic characters");
        }
        setName(name);
    }

    private int enterBudget()
    {
        String budget = Input.acceptStringInput("Please enter the budget for the rescue (between 100 and 200)");
        while((!Validation.stringNumeric(budget)) || Integer.parseInt(budget) > 200 || Integer.parseInt(budget) < 100)
        {
            budget = Input.acceptStringInput("Please input a valid number between 100 and 200");
        }
        setBudget(Integer.parseInt(budget));
        return Integer.parseInt(budget);
    }

    private void readTreesFile()
    {
        try
        {
            ArrayList<String[]> information = new ArrayList<String[]>();
            String[] allInformation = FileIO.readFile("trees.txt").split("\n");
            for (int i = 0; i < allInformation.length; i++)
            {
                int[] oneLine = transferStringtoIntegerArray(allInformation[i].split(","));
                for (int j = 0; j < oneLine.length; j++)
                {
                    reserve.getListOfObservationPoints()[i].getListOfTrees()[j].setNumberOfTrees(oneLine[j]);
                }
            }
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("File not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occurs");
        }
    }

    private int[] transferStringtoIntegerArray(String[] a)
    {
        int[] integerArray = new int[a.length];
        for (int i = 0; i < a.length; i++)
        {
            integerArray[i] = Integer.parseInt(a[i]);
        }
        return integerArray;
    }

    private int treeFall(int index)
    {
        int treeFallNumber = reserve.treeFall(index);
        System.out.println("There are " + treeFallNumber + " trees damaged");
        enterToConitnue();
        return treeFallNumber;
    }

    private void displayObservationPointStatua(int i)
    {
        System.out.println("Observation Point " + (i + 1)+ " Status: ");
        System.out.println("The number of injured koalas: " + reserve.getListOfObservationPoints()[i].getListOfInjurdKoalas().size());
        System.out.println("The number of Healthy koalas: " + reserve.getListOfObservationPoints()[i].getListOfHealthyKoalas().size());
        System.out.println("The weight of available food: " + reserve.getListOfObservationPoints()[i].getWeightOfAvailableFood());
        System.out.println("The number of shelter trees: " + reserve.getListOfObservationPoints()[i].getAvailableShelter());
        System.out.println("The number of predators: " + reserve.getListOfObservationPoints()[i].getNumberOfPredators());
        System.out.println(">->->->->->->>->->->->->->>->->->->->->>->->->->->->>->->->->->->");
        enterToConitnue();
        System.out.println("The available budget: " + budget);
        enterToConitnue();
    }

    private void enterToConitnue()
    {
        Scanner console = new Scanner(System.in);
        console.nextLine();
    }

    private void printMenu()
    {
        System.out.println(">->->->->->->>->->->->->->>->->->->->->>->->->->->->>->->->->->->");
        System.out.println(">->->->->->Pleaase Choose Your Option From Below->->->->>->->->->");
        System.out.println(">->->->->->->>->->->->->->>->->->->->->>->->->->->->>->->->->->->");
        System.out.println("A.Move an injured koala to the safe haven ----> Cost $20");
        System.out.println("B. Move a healthy koala to the safe haven ----> Cost $10");
        System.out.println("C. Relocate a koala to this location      ----> Add  $5");
        System.out.println("D. Take no further action.");
    }

    private boolean checkOption(String option, int index)
    {
        boolean check = false;
        switch (option)
        {
            case "A": moveInjurdKoala(index); check = true; break;
            case "B": moveHealthyKoala(index); check = true; break;
            case "C": relocateKoala(index); check = true; break;
            case "D": System.out.println("You choose no further action"); check = false; break;
        }
        return check;
    }

    private boolean enterOption(int index)
    {
        printMenu();
        String option = Input.acceptStringInput("Please enter your oprion").toUpperCase();
        while (!option.equals("A") && !option.equals("B") && !option.equals("C") && !option.equals("D") )
        {
            option = Input.acceptStringInput("Please enter a valid oprion").toUpperCase();
        }
        return checkOption(option, index);
    }

    private void moveInjurdKoala(int index)
    {
        if (budget >= 20)
        {
            if (reserve.moveInjurdKoala(index))
            {
                System.out.println("Moved one injurd koala to safe Haven ----> Cost $20");
                budget = budget - 20;
                System.out.println("The budget: " + budget);
            }
            else
            {
                System.out.println("There is no injurd koala in ovservation point");
            }
        }
        else
        {
            System.out.println("There is no enough money");
        }
    }

    private void moveHealthyKoala(int index)
    {
        if (budget >= 10)
        {
            if (reserve.moveHealthyKoala(index))
            {
                System.out.println("Moved one healthy koala to safe Haven ----> Cost $10");
                budget = budget - 10;
                System.out.println("The budget: " + budget);
            }
            else
            {
                System.out.println("There is no a shortage of food or shelter in any ovservation point");
            }
        }
        else
        {
            System.out.println("There is no enough money");
        }
    }

    private void relocateKoala(int index)
    {
        if (reserve. relocateKoala(index))
        {
            System.out.println("Relocate an koala to observation point ----> Add $5");
            budget = budget + 5;
            System.out.println("The budget: " + budget);
        }
        else
        {
            System.out.println("There is no injurd koalas in safe haven or this observation point is not suitable for koalas");
        }
    }

    private int printKoalaDeathInfor(int i)
    {
        enterToConitnue();
        int injurdDeath = reserve.countInjurdDeath(i);
        int shortageFoodDeath = reserve.countShortageFoodKoalaDeath(i);
        int shortageShelterDeath = reserve.countShortageShelterKoalaDeath(i);
        int predatorDeath = reserve.countPredatorDeath(i);
        int totalDeath = injurdDeath + shortageFoodDeath + shortageShelterDeath + predatorDeath;
        System.out.println("Injurd Death: " + injurdDeath);
        System.out.println("Shortage Food Death: " + shortageFoodDeath);
        System.out.println("Shortage Shelter Death: " + shortageShelterDeath);
        System.out.println("Predator Death: " + predatorDeath);
        System.out.println("Total Death: " + totalDeath);
        return totalDeath;
    }

    private int goEachObservationPoint()
    {
        int treeLost = 0;
        int relocateKoala = 0;
        int totalDeath = 0;
        for (int i = 0; i < reserve.getListOfObservationPoints().length; i++)
        {
            System.out.println("Let's go to obsertation point: " + (i + 1));
            treeLost = treeFall(i) + treeLost;
            displayObservationPointStatua(i);
            while (enterOption(i))
            {
                displayObservationPointStatua(i);
            }
            totalDeath = printKoalaDeathInfor(i) + totalDeath;
        }
        printFinallInfor(treeLost);
        return totalDeath;
    }

    private void printFinallInfor(int treeLost)
    {
        System.out.println("Total " + treeLost + " trees lost");
        System.out.println("Total Healthy Koalas: " + reserve.countTotalHealthyKoala());
        System.out.println("Total Injurd Koalas in Safe Haven: " + reserve.countInjurdKoalasInSafeHaven());
        System.out.println("Total Koalas Relocated: " + reserve.getRelocateKoala());
    }

    public void test()
    {
        enterBudget();
        reserve.setTrees();
        readTreesFile();
        reserve.countWeightFood();
        reserve.countAvailableShelter();
        reserve.setInjurdKoalas();
        reserve.setHealthyKoalas();
        reserve.setPredators();
        goEachObservationPoint();
    }

    private void writeUpdatedTrees()
    {
        try
        {
            PrintWriter pw = new PrintWriter("updatedTrees.txt");
            try
            {
                String treeNumbers = reserve.getTreeNumbers();
                FileIO.writeFile(treeNumbers,"updatedTrees.txt");
                System.out.println("The tree numbers in the file have been update");
            }
            finally
            {
                pw.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Write file failed");
        }
    }

}
