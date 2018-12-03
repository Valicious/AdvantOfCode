import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d3p1 {
    private static final String regex = "[^#].*(?= \\@)|(?<=\\@ ).*(?=:)|(?<=: ).*";
    private static final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

    private static Cell[][] cells;

    public static void main(String[] args) {
        System.out.println("Starting! Day 3, Part 1");
        List<String> ids = d1p1.populateList("rsc/d3p1");
        cells = new Cell[2000][2000];
        for (int row = 0; row < 2000; row++) {
            for (int col = 0; col < 2000; col++) {
                cells[col][row] = new Cell(row, col);
            }
        }
        ids.forEach(d3p1::lex);
        for (int col = 0; col < 1000; col++) {
            for (int row = 0; row < 1000; row++) {
                if (cells[col][row].size() == 0)
                    System.out.print("*");
                else
                    System.out.print(cells[col][row].size());
            }
            System.out.println();
        }
        System.out.println();
        //part1
        int count = 0;
        for (int col = 0; col < 1000; col++) {
            for (int row = 0; row < 1000; row++) {
                if (cells[col][row].size() > 1)
                    count++;
            }
        }
        System.out.println(count);
    }

    private static void lex(String value) {
        Matcher matcher = pattern.matcher(value);
        ArrayList<String> values = new ArrayList();
        while (matcher.find()) {
            values.add(matcher.group(0));
        }

        int ID = Integer.parseInt(values.get(0));
        String[] pos = values.get(1).split(",");
        String[] dim = values.get(2).split("x");
        draw(ID, pos, dim);
    }

    private static void draw(int id, String[] pos, String[] dim) {
        int rowS = Integer.parseInt(pos[0]) + 1;
        int colS = Integer.parseInt(pos[1]) + 1;
        for (int row = 0; row < Integer.parseInt(dim[0]); row++) {
            for (int col = 0; col < Integer.parseInt(dim[1]); col++) {
                cells[colS + col][rowS + row].add(id);
            }
        }
    }

    private static class Cell {
        int row;
        int col;
        List<Integer> ID;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
            ID = new ArrayList<>();
        }

        public void add(int id) {
            ID.add(id);
        }

        public int size() {
            return ID.size();
        }
    }

}
