import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.Arrays;

public class BasicToolSet
{

    public static void FileAcess(String [] args)
    {
        try
        {
            String a = new String(args[0]);
            System.out.println(a);

            File inputFile = new File(a);
            Scanner myReader = new Scanner(inputFile);
            while (myReader.hasNextLine())
            {
                System.out.println(myReader.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An file open error occurred.");
            e.printStackTrace();
        }
    }

    public static Integer [] FileAcessReadToArray(String [] args)
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
            return lines.toArray(new Integer[lines.size()]);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An file open error occurred.");
            e.printStackTrace();
        }
        return  lines.toArray(new Integer[lines.size()]);
    }
    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.out.println("Error:input required.");
            return;
        }

        //FileAcess(args);
        Integer [] IntList = FileAcessReadToArray(args);
        Arrays.sort(IntList);
        for (int x : IntList)
        {
            System.out.println(x);
        }

    }
}