import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class d1p2 {
    private static int tally;
    private static Set<Integer> uniqFreq;
    private static boolean dupFound;
    private static int firstFinalFreq;

    public static void main(String[] args) {
        System.out.println("Starting! Day 1, Part 2");
        List<String> frequencies = d1p1.populateList("rsc/d1p1");
        if (frequencies.size() != 0) {
            firstFinalFreq = -1;
            dupFound = false;
            System.out.println("Adding up frequencies");
            tally = 0;
            uniqFreq = new HashSet<>();
            while (!dupFound) {
                frequencies.forEach(d1p2::tallyIt);
                firstFinalFreq = firstFinalFreq == -1 ? tally : firstFinalFreq;
            }
        }
        System.out.println("First Frequency is " + firstFinalFreq);
       // System.out.println("Final Frequency after duplicate is found " + tally);
        System.out.println("Program done!");
    }

    public static void tallyIt(String value) {
        int val = Integer.parseInt(value.substring(1));
        if (value.charAt(0) == 45)
            tally -= val;
        else
            tally += val;
        if (uniqFreq.contains(tally)) {
            if (dupFound) return;
            System.out.println("Duplicate value " + tally);
            dupFound = true;
        } else
            uniqFreq.add(tally);
    }
}
