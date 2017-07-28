import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Vilcho on 7/27/2017.
 */
public class Ex_o03_MixedPhones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, Long> phonebook = new TreeMap<String, Long>();

        while (!input.equals("Over")) {
            String[] inputToArray = input.split(" : ");
            boolean isDataInCorrectOrder = analyseInput(inputToArray);
            if (isDataInCorrectOrder == true) {
                phonebook.put(inputToArray[0], Long.valueOf(inputToArray[1]));
            } else {
                phonebook.put(inputToArray[1], Long.valueOf(inputToArray[0]));
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Long> kvp : phonebook.entrySet()) {
            System.out.printf("%s -> %d%n", kvp.getKey(), kvp.getValue());
        }
    }

    static boolean analyseInput(String[] inputToArray) {
        boolean isNameFirst = true;
        char[] secondElementToChars = inputToArray[1].toCharArray();
        for (int i = 0; i < secondElementToChars.length; i++) {
            if (!(secondElementToChars[i] >= 48 && secondElementToChars[i] <= 57)) {
                isNameFirst = false;
                break;
            }
        }
        return isNameFirst;
    }


}
