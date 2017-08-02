import java.util.*;

/**
 * Created by Vilcho on 7/30/2017.
 */
public class Nested_Ex_p01_Wardrobe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        int countDuplicates = 0;
        LinkedHashMap<String, LinkedHashMap<String, Integer>> output = new LinkedHashMap<String, LinkedHashMap<String, Integer>>();

        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();

            String[] inputByColor = input.split(" -> ");
            String color = inputByColor[0];
            String[] items = inputByColor[1].split(",");

            if (!output.containsKey(color)){
                output.put(color, new LinkedHashMap<String, Integer>());
            }
            for (int j = 0; j < items.length; j++) {
                if (!output.get(color).containsKey(items[j])){
                    output.get(color).put(items[j], 0);
                }
                output.get(color).put(items[j],(output.get(color).get(items[j]) + 1));
            }
        }

        String[] lookFor = scanner.nextLine().split(" ");

        for (Map.Entry<String, LinkedHashMap<String, Integer>> kvp : output.entrySet()) {
            System.out.printf("%s clothes:%n", kvp.getKey());
            LinkedHashMap<String, Integer> clothesTimes = kvp.getValue();
            for (Map.Entry<String, Integer> clothes : clothesTimes.entrySet()) {
                System.out.printf(" * %s - %d", clothes.getKey(), clothes.getValue());
                if (kvp.getKey().equals(lookFor[0]) && clothes.getKey().equals(lookFor[1])){
                    System.out.println(" (found!)");
                } else {
                    System.out.println();
                }
            }
        }
    }
}
