import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Vilcho on 7/27/2017.
 */
public class Ex_p01_LetterRepetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        LinkedHashMap<Character, Integer> symbolCounter = new LinkedHashMap<Character, Integer>();

        for (int i = 0; i < input.length; i++) {
            if (! symbolCounter.containsKey(input[i])){
                symbolCounter.put(input[i], 0);
            }
            symbolCounter.put(input[i], symbolCounter.get(input[i]) + 1);
        }
        for (Map.Entry<Character, Integer> kvp : symbolCounter.entrySet()) {
            System.out.printf("%c -> %d%n", kvp.getKey(), kvp.getValue());
        }



    }
}
