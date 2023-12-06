import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public final static String fm = "final";
    public final static int RED_MAX = 12;
    public final static int BLUE_MAX = 13;
    public final static int GREEN_MAX = 14;

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(fm + ".in"));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int sum = 0;


        List<String> lines = r.lines().collect(Collectors.toList());
        for (String l : lines) {
            System.out.println(l);
        }
        // for (String line : lines) {
        for (int a = 0; a < lines.size(); a++) {
            String line = lines.get(a);
            String[] tokens = line.split(":");
            // int ID = Integer.parseInt(tokens[0].substring(5));
            String[] colorTokens = tokens[1].split("; ");
            boolean bad = false;
            for (String ct : colorTokens) {
                String[] colorVals = ct.split(", ");
                for (int i = 0; i < colorVals.length; i++) {
                    colorVals[i] = colorVals[i].trim(); // cleanup
                }
                for (String cv : colorVals) {
                    int n = Integer.parseInt(cv.split(" ")[0]);
                    if (cv.contains("blue") && n > BLUE_MAX) {
                        // System.out.println("blue wrong: " + cv + "ID: " + (a+1));
                        bad = true;
                    }
                    if (cv.contains("red") && n > RED_MAX) {
                        // System.out.println("red wrong: " + cv + "ID: " + (a+1));
                        bad = true;

                    }
                    if (cv.contains("green") && n > GREEN_MAX) {
                        // System.out.println("red wrong: " + cv + "ID: " + (a+1));
                        bad = true;
                    }
                }
            }
            if (!bad) {
                sum += (a+1);
            }
        }
        pw.println(sum);
        pw.close();
        r.close();
    }
}