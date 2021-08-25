import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch
{

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

    public static int rank(int key, Integer [] list)
    {
        int lo = 0;
        int hi = list.length -1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            if (list[mid] < key) lo = mid + 1; // mid + 1 instead of mid
            else if (list[mid] > key) hi = mid -1;// mid -1 instead of mid
            else 
            {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Error:"+2  +"input required.");
            return;
        }

        //FileAcess(args);
        Integer [] IntList = FileAcessReadToArray(args);
        Arrays.sort(IntList);

        int ranknum = rank(Integer.parseInt(args[1]), IntList);
        if (ranknum != -1)
        {
            System.out.println("number=" + IntList[ranknum]);
            System.out.println(ranknum);
        };

    }
}
