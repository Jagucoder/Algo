package mytool;

import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.Arrays;

public class MyTool
{

    public static Integer [] FileAccessReadToArray(String [] args)
    {
        ArrayList<Integer> lines = new ArrayList<Integer>();
        try
        {
            File inputFile = new File(args[0]);
            Scanner myReader = new Scanner(inputFile);
               
            while (myReader.hasNextLine())
            {
                lines.add(Integer.parseInt(myReader.nextLine().trim()));
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An file open error occurred.");
            e.printStackTrace();
        }

       

        return  lines.toArray(new Integer[lines.size()]);
    }


    public static Integer [] StdInToArray()
    {
        ArrayList<Integer> lines = new ArrayList<Integer>();
        Scanner myReader = new Scanner(new java.io.BufferedInputStream(System.in));
            
        while (myReader.hasNextLine())
        {
            lines.add(Integer.parseInt(myReader.nextLine().trim()));
        }

        myReader.close();

        return  lines.toArray(new Integer[lines.size()]);
    }
    
    public static void main(String[] args)
    {
        //Integer [] IntList = FileAcessReadToArray(args);
        Integer [] IntList = StdInToArray();
        Arrays.sort(IntList);
        for (int x : IntList)
        {
            System.out.println(x);
        }

    }
}