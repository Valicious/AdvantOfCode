import java.math.BigInteger;
import java.util.*;

public class d2p2 {
    private static HashMap<BigInteger, List<String>> IDs = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Starting! Day 2, Part 2");
        List<String> ids = d1p1.populateList("rsc/d2p1");
        long startTime = System.currentTimeMillis();



        ids.forEach(d2p2::checkIds);
        IDs.values().forEach(cur -> {
            if (cur.size() == 1)
                return;
            System.out.println(cur.toString());
        });

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }

    private static void checkIds(String value) {
        List<BigInteger> allScores = new ArrayList<>();
        char[] values = value.toCharArray();
        for (int i = 0; i < values.length; i++) {
            allScores.add(
                    BigInteger.valueOf((values[i] - 96) * 26)
                            .multiply(BigInteger.valueOf(10).pow(i))
            );
        }

        Set<BigInteger> scores = new HashSet<>();
        allScores.forEach(cur -> {
            BigInteger sum = BigInteger.valueOf(0);
            for (int i = 0; i < allScores.size(); i++) {
                if (allScores.indexOf(cur) != i)
                    sum = sum.add(allScores.get(i));
            }
            scores.add(sum);
        });

        scores.forEach(cur -> {
            if (IDs.containsKey(cur))
                IDs.get(cur).add(value);
            else {
                IDs.put(cur, new ArrayList<>(Arrays.asList(value)));
            }
        });
    }

}
