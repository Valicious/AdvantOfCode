import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class d2p1 {
    private static HashMap<Integer, Integer> tally = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Starting! Day 2, Part 1");
        List<String> ids = d1p1.populateList("rsc/d2p1");
        ids.forEach(d2p1::checksum);
        System.out.println(tally.values().stream().reduce((prev, next) -> prev * next).get());
    }

    public static void checksum(String value) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (Character cur : value.toCharArray()) {
            if (count.containsKey(cur))
                count.put(cur, count.get(cur) + 1);
            else
                count.put(cur, 1);
        }
        new HashSet<Integer>(count.values()).forEach(d2p1::addToTally);
    }

    public static void addToTally(Integer value){
        if (value != 2 && value != 3) return;
        if (tally.containsKey(value))
            tally.put(value, tally.get(value) + 1);
        else
            tally.put(value, 1);
    }
}
