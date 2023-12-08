import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public final static String fm = "test";
    public final static String INS = "LLR";
    public final static String START = "AAA";
    public final static String END = "ZZZ";


    public static String navigate(String current, String instruction, Map<String, String[]> nodes) {
        String[] nextNodes = nodes.get(current);
        return instruction.equals("R") ? nextNodes[1] : nextNodes[0];
    }

    public static int countSteps(String instructions, Map<String, String[]> nodes) {
        String current = START;
        int steps = 0;
        int instructionIndex = 0;
        while (!current.equals(END)) {
            String instruction = instructions.charAt(instructionIndex % instructions.length()) == 'R' ? "R" : "L";
            current = navigate(current, instruction, nodes);
            steps++;
            instructionIndex++;
            System.out.println(current + " " + (instructionIndex % instructions.length()));
        }
        return steps;
     }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(fm + ".in"));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        Map<String, String[]> nodes = new HashMap<>();
        List<String> lines = r.lines().collect(Collectors.toList());
        // try (BufferedReader br = new BufferedReader(new FileReader(fm + ".in"))) {
        //     String line;
        //     while ((line = br.readLine()) != null) {
        //         if (line.isEmpty()) break;
        //         String[] parts = line.split(" = ");
        //         String node = parts[0];
        //         // String nextNodes = parts[1];
        //         // System.out.println(nextNodes);
        //         String[] nextNodes = parts[1].substring(1, parts[1].length() - 1).split(", ");
        //         nodes.put(node, nextNodes);
        //     }
        //     System.out.println(countSteps("RL", nodes));
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(" = ");
            String node = parts[0];
            // String nextNodes = parts[1];
            // System.out.println(nextNodes);
            String[] nextNodes = parts[1].substring(1, parts[1].length() - 1).split(", ");
            nodes.put(node, nextNodes);
        }
        System.out.println(countSteps(INS, nodes));


        pw.close();
        r.close();
    }
}