import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SOL_ACTUAL {
    public static final String fm = "final";
    public static void main(String[] args) throws IOException {
        long s1 = 0;
        long s2 = 0;

        BufferedReader r = new BufferedReader(new FileReader(fm + ".in"));
        PrintWriter pw = new PrintWriter(System.out);

        List<String> lines = r.lines().collect(Collectors.toList());
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            
                List<List<Integer>> values = new ArrayList<>();
                List<Integer> lVals = new ArrayList<>();
                for (String number : line.split(" ")) {
                    lVals.add(Integer.parseInt(number));
                }
                values.add(lVals);

                findDifferences(values);
                extrapolate(values);

                s1 += values.get(0).get(values.get(0).size() - 1);
                s2 += values.get(0).get(0);
            }

            System.out.println(s1);
            System.out.println(s2);

    }

    public static void findDifferences(List<List<Integer>> values) {
        int numRows = values.size();

        for (;;) {
            List<Integer> currentRow = values.get(numRows - 1);
            List<Integer> nextRow = new ArrayList<>();

            for (int i = 0; i < currentRow.size() - 1; i++) {
                nextRow.add(currentRow.get(i + 1) - currentRow.get(i));
            }

            values.add(nextRow);
            numRows++;

            if (nextRow.stream().allMatch(number -> number == 0)) {
                break;
            }
        }
    }


    public static void extrapolate(List<List<Integer>> values) {
        int numRows = values.size();

        for (int i = numRows - 2; i >= 0; i--) {
            List<Integer> currentRow = values.get(i);
            List<Integer> nextRow = values.get(i + 1);

            int lastElement = currentRow.get(currentRow.size() - 1) + nextRow.get(nextRow.size() - 1);
            currentRow.add(lastElement);

            int firstElement = currentRow.get(0) - nextRow.get(0);
            currentRow.add(0, firstElement);
        }

        List<Integer> lastRow = values.get(numRows - 1);
        lastRow.add(0);
        lastRow.add(0);
    }

}
