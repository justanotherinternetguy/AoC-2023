import java.io.*;
import java.util.regex.*;
import java.util.*;

public class Solution {
    public final static String fm = "final";
    public final static int LINES = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(fm + ".in"));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        long sum = 0;
        // read everything into array
        List<String> inArr = new ArrayList<>();
        for (int i = 0; i < LINES; i++) {
            inArr.add(st.nextToken());
            if (i != LINES-1) {
                st = new StringTokenizer(r.readLine());
            }
        }

        for (int i = 0; i <  inArr.size(); i++) {
            Matcher matcher = Pattern.compile("\\d+").matcher(inArr.get(i));
            Matcher matcher2 = Pattern.compile("(\\d+)(?!.*\\d)").matcher(inArr.get(i));
            matcher.find();
            matcher2.find();
            int temp = ((Character.getNumericValue(matcher.group().charAt(0))) * 10) + (Character.getNumericValue(matcher2.group().charAt(matcher2.group().length()-1)));
            System.out.println(temp);
            sum += temp;
        }
        pw.println("FINAL -----");

        pw.println(sum);

        pw.close();
    }
}