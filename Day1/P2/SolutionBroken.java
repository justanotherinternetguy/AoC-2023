import java.io.*;
import java.util.regex.*;
import java.util.*;

public class SolutionBroken {
    public final static String fm = "final";
    public final static int LINES = 1000;
    public static final Map<String, Integer> nn = new HashMap<String, Integer>() {{
        put("zero", 0);
        put("one", 1);
        put("two", 2);
        put("three", 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9);
    }};


    public static int reSearchFirst(String str) {
        Matcher matcher = Pattern.compile("(?:[1-9]|one|two|three|four|five|six|seven|eight|nine)").matcher(str);
        matcher.find();
        int res = 0;
        if (matcher.group().length() > 1) { // string
            int t = nn.get(matcher.group());
            t *= 10;
            res = t;
        } else if (matcher.group().length() == 1) { // num
            res = Character.getNumericValue(matcher.group().charAt(0)) * 10;
        }
        return res;
    }

    public static int reSearchLast(String str) {
        Matcher matcher = Pattern.compile("(?:(?:[1-9])|(?:one|two|three|four|five|six|seven|eight|nine))(?!.*(?:[1-9]|one|two|three|four|five|six|seven|eight|nine))").matcher(str);
        matcher.find();
        int res = 0;
        if (matcher.group().length() > 1) { // string
            int t = nn.get(matcher.group());
            res = t;
        } else if (matcher.group().length() == 1) { // num
            res = Character.getNumericValue(matcher.group().charAt(0));
        }
        return res;
    }

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

        for (int i = 0; i < inArr.size(); i++) {
            int a = Integer.valueOf(reSearchFirst(inArr.get(i))) + Integer.valueOf(reSearchLast(inArr.get(i)));
            System.out.println((i+1) + " " + reSearchFirst(inArr.get(i)) + " " + reSearchLast(inArr.get(i)) + " " + (a));
            sum += a;
        }
        pw.println("FINAL------");

        pw.println(sum);

        pw.close();
    }
}