import java.util.*;

/**
 * Created by Vilcho on 7/29/2017.
 */
public class Nested_Lab_p01_AverageStudenGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Double>> studentGrades = new LinkedHashMap<String, List<Double>>();

        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            String[] inputAsArray = input.split(" ");
            if (!studentGrades.containsKey(inputAsArray[0])){
                studentGrades.put(inputAsArray[0], new ArrayList<Double>());
                studentGrades.get(inputAsArray[0]).add(Double.valueOf(inputAsArray[1]));
            } else {
                studentGrades.get(inputAsArray[0]).add(Double.valueOf(inputAsArray[1]));
            }
        }

        for (Map.Entry<String, List<Double>> kvp : studentGrades.entrySet()) {
            String name = kvp.getKey();
            List<Double> grades = kvp.getValue();

            System.out.print(name + " -> ");
            for (int i = 0; i < grades.size() ; i++) {
                System.out.printf("%.2f ",grades.get(i));
            }
            double average = findAverageForList(grades);
            System.out.printf("(avg: %.2f)%n",average);
        }

    }

    static double findAverageForList(List<Double> grades) {
        double avg = 0.0;
        double sum = 0.0;
        for (Double num:grades) {
            sum += num;
        }
        avg = sum/grades.size();
        return avg;
    }
}
