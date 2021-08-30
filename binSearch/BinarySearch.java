package binSearch;

import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.Arrays;

import mytool.MyTool;

public class BinarySearch
{

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
        if (args.length < 1)
        {
            System.out.println("Error:"+2  +"input required.");
            return;
        }

        //FileAcess(args);
        Integer [] IntList = MyTool.FileAccessReadToArray(args);
        Integer [] StdList = StdInToArray();
        Arrays.sort(IntList);

        
        for(int x : StdList)
        {
            int ranknum = rank(x, IntList);
            if (ranknum != -1)
            {
                System.out.println(x);
                //System.out.println(ranknum);
            };
        }


    }
}
