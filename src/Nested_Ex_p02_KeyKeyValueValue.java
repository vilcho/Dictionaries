import java.util.*;

/**
 * Created by Vilcho on 7/31/2017.
 */
public class Nested_Ex_p02_KeyKeyValueValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyInput = scanner.nextLine();
        String valueInput = scanner.nextLine();
        int N = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<String>> output = new LinkedHashMap<String, List<String>>();

        for (int i = 0; i < N; i++) {
            String[] pairsInput = scanner.nextLine().split(" => ");

            if (pairsInput[0].contains(keyInput)) {
                if (!output.containsKey(pairsInput)) {
                    output.put(pairsInput[0], new ArrayList<String>());
                }
                String[] valuesArray = pairsInput[1].split(";");
                for (int j = 0; j < valuesArray.length; j++) {
                    if (valuesArray[j].contains(valueInput)) {
                        output.get(pairsInput[0]).add(valuesArray[j]);
                    }
                }
            }
        }
        for (Map.Entry<String, List<String>> kvp : output.entrySet()) {
            System.out.printf("%s:%n", kvp.getKey());
            for (String value : kvp.getValue()) {
                System.out.println("-" + value);
            }
        }

    }
}
