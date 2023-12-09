import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public final static String fm = "mod";
    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static double[][] differencesOfDifferences(double[] y) {
        int n = y.length;
        double[][] differences = new double[n][n];

        for (int i = 0; i < n; i++) {
            differences[i][0] = y[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                differences[i][j] = differences[i + 1][j - 1] - differences[i][j - 1];
            }
        }

        return differences;
    }

    public static double lagrangeInterpolation(double[] x, double[] y, double value) {
        int n = x.length;
        double result = 0;

        double[][] differences = differencesOfDifferences(y);

        for (int i = 0; i < n; i++) {
            double term = differences[0][i] / (factorial(i) * Math.pow(x[1] - x[0], i));
            for (int j = 0; j < i; j++) {
                term *= (value - x[j]);
            }
            result += term;
        }

        return result;
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

            // double[] xV = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
            // double[] yV = { 10.0, 13.0, 16.0, 21.0, 30.0, 45.0 };
            // double result = lagrangeInterpolation(xV, yV, 7.0);
            // long b = (long) lagrangeInterpolation(newArray, lineArray, (double) lineArray.length + 1.0);
            // long b = (long) nevilleExtrapolate(newArray, lineArray, (double) lineArray.length + 1.0);

            System.out.println(b);
            // n += b;
        }
        System.out.println(n);


        r.close();
    }
}