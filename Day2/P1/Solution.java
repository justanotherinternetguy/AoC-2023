import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public final static String fm = "test";
    public final static int LINES = 5;
    public final static int RED_MAX = 12;
    public final static int BLUE_MAX = 13;
    public final static int GREEN_MAX = 14;

    public static void check(String str) {
        String[] rounds = str.split("; ");
        for (String sub : rounds) {
            int r = 0; int g = 0; int b = 0;
            // System.out.println(sub);
            List<String> tokens = Arrays.asList(sub.split("\\s*;\\s*"));
            // for (String s : tokens) {
            //     System.out.println(s);
            // }
            
            for (int i = 0; i < tokens.size(); i++) {
                List<String> each = Arrays.asList(tokens.get(i).split("\\s*,\\s*"));
                for (int j = 0; j < each.size(); j++) {
                    r = 0; g = 0; b = 0;
                    System.out.println(r + " " + g + " " + b);

                    // TODO
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(fm + ".in"));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        // read everything into array
        List<String> inArr = new ArrayList<>();
        String line;
        while ((line = r.readLine()) != null) {
            inArr.add(line);
        }

        // ID RGB, RGB, RGB
        // remove "Game"
        for (int i = 0; i < inArr.size(); i++) {
            inArr.set(i, inArr.get(i).substring(8)); // IDs implied
        }

    
        // OTHER METHOD (same)
                // inArr = inArr.stream()
                // .map(s -> s.startsWith("Game") ? s.substring(4) : s)
                // .collect(Collectors.toList());

        for (int i = 0; i  < inArr.size(); i++) {
            System.out.println(inArr.get(i));
        }
        System.out.println();
        // for (int i = 0; i  < inArr.size(); i++) {
        //     System.out.println(check(inArr.get(i)));
        // }
        check(inArr.get(2));
        pw.close();
    }
}