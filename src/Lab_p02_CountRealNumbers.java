import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Vilcho on 7/27/2017.
 */
public class Lab_p02_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Stream.of(scanner.nextLine().split(" ")).mapToDouble(Double::valueOf).toArray();

        TreeMap<Double, Integer> doubleCounter = new TreeMap<Double, Integer>();

        for (int i = 0; i < input.length; i++) {
            if (! doubleCounter.containsKey(input[i])){
                doubleCounter.put(input[i], 0);
            }
            doubleCounter.put(input[i], doubleCounter.get(input[i]) + 1);
        }
        DecimalFormat df = new DecimalFormat("#########.#########");

        for (Double num : doubleCounter.keySet()) {
            System.out.printf("%s -> %d %n", df.format(num), doubleCounter.get(num));
        }

    }
}
