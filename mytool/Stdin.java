package mytool;

import java.util.Scanner; // Import the Scanner class to read text files

public class Stdin
{
    private static Scanner scanner;
    

    static {
        resync();
    }
    /**
     * If StdIn changes, use this to reinitialize the scanner.
     */
    private static void resync() {
        Stdin.scanner = new Scanner(new java.io.BufferedInputStream(System.in));
    }
    public static int readInt()
    {
        return scanner.nextInt();
    }

    public static boolean isEmpty()
    {
        return !scanner.hasNext();
    }
    public static void main(String[] args)
    {

        while(!Stdin.isEmpty())
        {
            System.out.println(Stdin.readInt());
        }

    }
}