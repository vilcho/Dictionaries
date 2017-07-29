import com.sun.org.apache.bcel.internal.classfile.SourceFile;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Vilcho on 7/28/2017.
 */
public class Ex_p06_FilterBase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Integer> age = new LinkedHashMap<String, Integer>();
        LinkedHashMap<String, Double> salary = new LinkedHashMap<String, Double>();
        LinkedHashMap<String, String> position = new LinkedHashMap<String, String>();

        while (!input.equals("filter base")) {

            String[] inputAsArray = input.split(" -> ");

            boolean isEntryAge = determineIfEntryIsAge(inputAsArray[1]);
            boolean isEntrySalary = determineIfEntryIsSalary(inputAsArray[1]);

            if (isEntryAge) {
                age.put(inputAsArray[0], Integer.valueOf(inputAsArray[1]));
            } else if (isEntrySalary) {
                salary.put(inputAsArray[0], Double.valueOf(inputAsArray[1]));
            } else {
                position.put(inputAsArray[0], inputAsArray[1]);
            }
            input = scanner.nextLine();
        }

         input = scanner.nextLine();
        switch (input) {
            case "Position":
                for (Map.Entry<String, String> kvp : position.entrySet()) {
                    System.out.printf("Name: %s%nPosition: %s%n====================%n", kvp.getKey(), kvp.getValue());
                }
                break;
            case "Age":
                for (Map.Entry<String, Integer> kvp : age.entrySet()) {
                    System.out.printf("Name: %s%nAge: %d%n===================%n", kvp.getKey(), kvp.getValue());
                }
                break;
            case "Salary":
                for (Map.Entry<String, Double> kvp : salary.entrySet()) {
                    System.out.printf("Name: %s%nSalary: %.2f%n====================%n", kvp.getKey(), kvp.getValue());
                }
                break;
        }
    }

    static boolean determineIfEntryIsSalary(String secondInput) {
        boolean isEntrySalary = true;
        char[] charSecondPart = secondInput.toCharArray();
        for (int i = 0; i < charSecondPart.length; i++) {
            if (!((charSecondPart[i] >= 48 && charSecondPart[i] <= 57) || charSecondPart[i] == '.')) {
                isEntrySalary = false;
                break;
            }
        }
        return isEntrySalary;
    }

    static boolean determineIfEntryIsAge(String secondInput) {
        boolean isEntryAge = true;
        char[] charSecondPart = secondInput.toCharArray();
        for (int i = 0; i < charSecondPart.length; i++) {
            if (!(charSecondPart[i] >= 48 && charSecondPart[i] <= 57)) {
                isEntryAge = false;
                break;
            }
        }
        return isEntryAge;
    }
}
