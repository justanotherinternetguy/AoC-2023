import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public final static String fm = "final";
    public final static String INS = "LLRLRRLLRLRRLLRLRRLRRRLRLRLRRRLLRLRRRLRLRRRLRLRLLLRRLRLRLLRLRRLRRRLRRRLLRRLRLRRRLRRLRRRLRLLRRLRRRLRRRLRRLRLRRLLLRLRLLRRRLRRLLRLRLRRLLRLRRLLRLRRLRRLLRRRLRLRLRRRLLRRRLRRLRRRLRRRLRLRRRLRRLLLRRRLRLLLRRRLRLLRLLRRRLLRRLRRRLRRRLRLLRLRLRRRLLRRLRRRLRRLRLLRRRLRRLRRRLRRRLRRRLRLRRRLRRRLRLRRRR";

    // public static String navigate(String current, String instruction, Map<String, String[]> nodes) {
    //     String[] nextNodes = nodes.get(current);
    //     return instruction.equals("R") ? nextNodes[1] : nextNodes[0];
    // }

    public static Set<String> navigate(Set<String> currentNodes, String instruction, Map<String, String[]> nodes) {
        Set<String> nextNodes = new HashSet<>();
        for (String current : currentNodes) {
           String[] nextNodeArray = nodes.get(current);
           String nextNode = instruction.equals("R") ? nextNodeArray[1] : nextNodeArray[0];
           nextNodes.add(nextNode);
        }
        return nextNodes;
    }

    // public static int countSteps(String instructions, Map<String, String[]> nodes) {
    //     String current = START;
    //     int steps = 0;
    //     int instructionIndex = 0;
    //     while (!current.equals(END)) {
    //         String instruction = instructions.charAt(instructionIndex % instructions.length()) == 'R' ? "R" : "L";
    //         current = navigate(current, instruction, nodes);
    //         steps++;
    //         instructionIndex++;
    //         System.out.println(current + " " + (instructionIndex % instructions.length()));
    //     }
    //     return steps;
    // }

    public static int countSteps(Set<String> startNodes, String instructions, Map<String, String[]> nodes) {
        Set<String> currentNodes = new HashSet<>(startNodes);
        int steps = 0;
        int instructionIndex = 0;
        while (!allNodesEndWith(currentNodes, "Z")) {
            String instruction = instructions.charAt(instructionIndex % instructions.length()) == 'R' ? "R" : "L";
            currentNodes = navigate(currentNodes, instruction, nodes);
            steps++;
            instructionIndex++;
            for (String s : currentNodes) {
                System.out.println(s + " " + (instructionIndex % instructions.length()) + " " + steps);
            }
        }
        return steps;
    }

    public static boolean allNodesEndWith(Set<String> nodes, String suffix) {
        for (String node : nodes) {
           if (!node.endsWith(suffix)) {
              return false;
           }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(fm + ".in"));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        Map<String, String[]> nodes = new HashMap<>();
        List<String> lines = r.lines().collect(Collectors.toList());
        Set<String> currentNodes = new HashSet<>();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(" = ");
            String node = parts[0];
            // String nextNodes = parts[1];
            // System.out.println(nextNodes);
            String[] nextNodes = parts[1].substring(1, parts[1].length() - 1).split(", ");
            nodes.put(node, nextNodes);
        }


        List<String> startNodes = nodes.keySet().stream()
        .filter(node -> node.endsWith("A"))
        .collect(Collectors.toList());
        Set<String> startSet = new HashSet<>(startNodes);
        // for (String s : startSet) {
        //     System.out.println(s);
        // }
        int steps = countSteps(startSet, INS, nodes);
        System.out.println(steps);

        // for (Map.Entry<String, String[]> node : nodes.entrySet()) {
        //     if (node.getKey().charAt(2) == ('A')) {
        //         System.out.println(node.getKey());
        //     }
        // }


        pw.close();
        r.close();
    }
}