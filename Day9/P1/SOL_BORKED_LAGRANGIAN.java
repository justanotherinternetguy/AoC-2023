import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public final static String fm = "final";

    private static long lagrangeInterpolation(double[] x, double[] y, double xValue) {
        long result = 0;

        for (int i = 0; i < x.length; i++) {
            double term = y[i];
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    term = term * (xValue - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }

    private static String arrayToString(double[] array) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (i < array.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(fm + ".in"));
        PrintWriter pw = new PrintWriter(System.out);

        List<String> lines = r.lines().collect(Collectors.toList());
        long n = 0;

        for (int x = 0; x < lines.size(); x++) {
            String line = lines.get(x);
            String[] sArr = line.split(" ");
            // System.out.println(lagrangeInterpolation(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}, new double[]{10.0, 13.0, 16.0, 21.0, 30.0, 45.0}, 7.0));
            String[] numbersAsString = line.split("\\s+");
            double[] lineArray = new double[numbersAsString.length];
            for (int i = 0; i < numbersAsString.length; i++) {
                lineArray[i] = Double.parseDouble(numbersAsString[i]);
            }

            double[] newArray = new double[lineArray.length];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = 1.0 + i;
            }

            // System.out.println("Original array: " + arrayToString(lineArray));
            System.out.println(lagrangeInterpolation(newArray, lineArray, (double) lineArray.length + 1.0));
            n += lagrangeInterpolation(newArray, lineArray, (double) lineArray.length + 1.0);

        }
        System.out.println(n);


        r.close();
    }
}