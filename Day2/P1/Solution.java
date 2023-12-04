import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public final static String fm = "test";
    public final static int LINES = 5;
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
            inArr.set(i, inArr.get(i).substring(5));
        }

    
        // OTHER METHOD (same)
                // inArr = inArr.stream()
                // .map(s -> s.startsWith("Game") ? s.substring(4) : s)
                // .collect(Collectors.toList());

        for (int i = 0; i  < inArr.size(); i++) {
            System.out.println(inArr.get(i));
        }


        pw.close();
    }
}