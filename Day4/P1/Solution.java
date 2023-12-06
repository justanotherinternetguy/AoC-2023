import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public final static String fm = "final";
    public final static int RED_MAX = 12;
    public final static int BLUE_MAX = 13;
    public final static int GREEN_MAX = 14;

    public static int count(String s1, String s2) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        process(s1, freqMap); process(s2, freqMap);

        int c = 0;
        for (int x : freqMap.values()) {
            if (x == 2) {
                c++;
            }
        }
        return c;
    }

    public static void process(String s, HashMap<Integer, Integer> freqMap) {
        String[] integers = s.split("\\s+");
        for (String i : integers) {
            int n = Integer.parseInt(i);
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(fm + ".in"));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        List<String> lines = r.lines().collect(Collectors.toList());
        int sum = 0;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String winning = line.split("\\|")[0].trim().split(":")[1].trim();
            String guesses = line.split("\\|")[1].trim();
            int n = count(winning, guesses);
            if (n > 1) {
                sum += (Math.pow(2, n-1));
            } else if (n == 1) {
                sum++;
            }
            pw.println((Math.pow(2, n-1)));
        }
        pw.println(sum);
        pw.close();
        r.close();
    }
}