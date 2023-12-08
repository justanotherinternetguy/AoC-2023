import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        try {
            // Read input from file
            BufferedReader reader = new BufferedReader(new FileReader("test.in"));
            String instructions = reader.readLine();
            String networkDescription = reader.readLine();
            reader.close();

            // Create a map to store the network
            Map<String, String[]> network = parseNetwork(networkDescription);

            // Follow instructions and count steps
            int steps = followInstructions("AAA", instructions, network);

            // Print the result
            System.out.println("Steps required to reach ZZZ: " + steps);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, String[]> parseNetwork(String networkDescription) {
        Map<String, String[]> network = new HashMap<>();
        String[] nodes = networkDescription.split("\\s+");

        for (String node : nodes) {
            String[] parts = node.split("=");
            String nodeName = parts[0].trim();
            String[] connections = parts[1].replace("(", "").replace(")", "").split(",");
            network.put(nodeName, connections);
        }

        return network;
    }

    private static int followInstructions(String startNode, String instructions, Map<String, String[]> network) {
        int steps = 0;
        String currentNode = startNode;

        for (char instruction : instructions.toCharArray()) {
            String[] connections = network.get(currentNode);
            if (instruction == 'L') {
                currentNode = connections[0];
            } else if (instruction == 'R') {
                currentNode = connections[1];
            }

            steps++;
        }

        return steps;
    }
}
