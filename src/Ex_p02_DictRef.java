import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Vilcho on 7/27/2017.
 */
public class Ex_p02_DictRef {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        LinkedHashMap<String, Integer> result = new LinkedHashMap<String, Integer>();

        while (!inputString.equals("end")) {
            String[] input = inputString.split(" = ");
            boolean isInputValueAnInteger = analyseInputValue(input[1]);

            if (isInputValueAnInteger == true) {
                result.put(input[0], Integer.valueOf(input[1]));
            } else {
                if (result.containsKey(input[1])) {
                    result.put(input[0], Integer.valueOf(result.get(input[1])));
                }
            }
            inputString = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : result.entrySet()) {
            System.out.printf("%s === %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }

    }

    static boolean analyseInputValue(String someString) {
        boolean isInputValueAnInteger = true;

        char[] inputValues = someString.toCharArray();

        for (int i = 0; i < inputValues.length; i++) {
            if (!(inputValues[i] >= 48 && inputValues[i] <= 57)) {
                isInputValueAnInteger = false;
                break;
            }
        }

        return isInputValueAnInteger;
    }
}
