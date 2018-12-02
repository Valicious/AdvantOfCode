import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d1p1 {
    private static int tally;

    public static void main(String[] args) {
        System.out.println("Starting! Day 1, Part 1");
        List<String> frequencies = populateList("rsc/d1p1");
        if (frequencies.size() != 0) {
            System.out.println("Adding up frequencies");
            tally = 0;
            frequencies.forEach(d1p1::tallyIt);
        }
        System.out.println("Frequency is " + tally);
        System.out.println("Program done!");
    }

    public static void tallyIt(String value) {
        int val = Integer.parseInt(value.substring(1));
        if (value.charAt(0) == 45)
            tally -= val;
        else
            tally += val;
    }

    public static List<String> populateList(String strFile) {
        System.out.println("Reading loading file!!");
        File file = new File(strFile);
        List<String> frequencies = new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext())
                frequencies.add(scan.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return frequencies;
    }

}
