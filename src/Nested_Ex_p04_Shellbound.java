import com.sun.org.apache.xpath.internal.SourceTree;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Vilcho on 7/31/2017.
 */
public class Nested_Ex_p04_Shellbound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashSet<Integer>> output = new LinkedHashMap<String, LinkedHashSet<Integer>>();

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("Aggregate")) {
            if (!output.containsKey(input[0])) {
                output.put(input[0], new LinkedHashSet<Integer>());
            }
            output.get(input[0]).add(Integer.valueOf(input[1]));

            input = scanner.nextLine().split(" ");
        }

        for (Map.Entry<String, LinkedHashSet<Integer>> kvp : output.entrySet()) {
            System.out.printf("%s -> ", kvp.getKey());
            int sum = 0;
            int count = 0;
            for (Integer shell : kvp.getValue()) {
                count++;
                sum += shell;
            }

            List<String> listFromSet = new ArrayList<String>();

            for (Integer shell : kvp.getValue()) {
                listFromSet.add(String.valueOf(shell));
            }
            System.out.print(String.join(", ", listFromSet));

            double giantShell = sum - sum / count;
            DecimalFormat df = new DecimalFormat("#############.################");
            System.out.printf(" (%s)%n", df.format(giantShell));

        }
    }
}
