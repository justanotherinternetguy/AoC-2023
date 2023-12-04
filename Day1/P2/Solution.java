import java.io.*;
import java.util.*;

public class Solution {
    public final static List<String> numberWords = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
    public static String replace(String line) {
        for (int i = 0; i < numberWords.size(); i++) {
            String word = numberWords.get(i);
            if (line.contains(word)) {
                line = line.replace(word, word + (i + 1) + word);
            }
        }
        return line;
    }

    public static char find(String line) {
        String digits = "0123456789";
        for (char c : line.toCharArray()) {
            if (digits.contains(String.valueOf(c))) {
                return c;
            }
        }
        return '0';
    }

    public static int process(List<String> lines) {
        int totalSum = 0;
        for (String line : lines) {
            line = replace(line);
            char firstDigit = find(line);
            char lastDigit = find(new StringBuilder(line).reverse().toString());
            totalSum += Integer.parseInt(String.valueOf(firstDigit) + lastDigit);
        }
        return totalSum;
    }

    public static void main(String[] args) {
        String inputFilePath = "final.in";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            List<String> lines = Arrays.asList(content.toString().split("\n"));
            int result = process(lines);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
