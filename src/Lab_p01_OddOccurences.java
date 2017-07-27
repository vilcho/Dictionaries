import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Vilcho on 7/27/2017.
 */
public class Lab_p01_OddOccurences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().toLowerCase().split(" ");

        LinkedHashMap<String, Integer> wordsCounter = new LinkedHashMap<String, Integer>();

        for (int i = 0; i < words.length; i++) {
            if (! wordsCounter.containsKey(words[i])){
                wordsCounter.put(words[i], 0);
            }
            wordsCounter.put(words[i], wordsCounter.get(words[i]) + 1);
        }

        ArrayList<String> result = new ArrayList<String>();

        for (Map.Entry<String, Integer> key : wordsCounter.entrySet()) {
            if (!(key.getValue() % 2 ==0)){
                result.add(key.getKey());
            }
        }
        System.out.println(String.join(", ", result));
    }
}
