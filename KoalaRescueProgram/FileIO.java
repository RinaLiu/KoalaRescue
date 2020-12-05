import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * A FileIO class is used to read and write file.
 *
 * @author         Ruimeng Liu
 * @version        1.0 (31.May.2019)
 */
public class FileIO
{
    /**
     * Constructor for objects of class FileIO
     */
    public FileIO()
    {
    }

    /**
     * This is method which can read a file and return all infromation.
     *
     * @param  filename  A string to indicate the filename
     * @return    All information from the file
     * @throws IOException If the method reads file failed ,it will throw IOException
     */
    public static String readFile(String filename)
    throws IOException
    {
        FileReader fr = null;
        String allInformation = "";
        try
        {
            fr = new FileReader(filename);
            Scanner parser = new Scanner(fr);
            StringBuffer buffer = new StringBuffer();
            while (parser.hasNextLine())
            {
                String line=parser.nextLine();
                if (!line.trim().equals(""))
                    buffer = buffer.append(line + "\n");
            }
            allInformation = buffer.toString();
        }
        finally
        {
            fr.close();
        }
        return allInformation;
    }

    /**
     * This is method which can read a file and return all infromation.
     *
     * @param  filename  A string to indicate the filename
     * @param contents  A string to indicate the contents which are wrote to the file 
     * @return    All information from the file
     * @throws IOException If the method reads file failed ,it will throw IOException
     */
    public static void writeFile(String contents,String filename)
    throws IOException
    {
        PrintWriter outputFile = null;
        try
        {
            outputFile = new PrintWriter(filename);
            outputFile.println(contents);
        }
        finally
        {
            outputFile.close();
        }
    }
}
