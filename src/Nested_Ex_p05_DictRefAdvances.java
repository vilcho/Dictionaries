import java.util.*;

/**
 * Created by Vilcho on 8/1/2017.
 */
public class Nested_Ex_p05_DictRefAdvances {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<Integer>> result = new LinkedHashMap<String, List<Integer>>();

        String[] input = scanner.nextLine().split(" -> ");

        while (!input[0].equals("end")){
            String key = input[0];
            String values = input[1];
            String[] valuesArr = values.split(", ");

            if (!result.containsKey(key)){
                result.put(key, new ArrayList<Integer>());
            }

            boolean doValuesContainNonNumASCIIcharacter = checkASCIIcodes(valuesArr[0]);
            if (!doValuesContainNonNumASCIIcharacter){
                result = addIntegersToKey(result, valuesArr, key);
            } else {
                boolean doesKeyExist = checkIfKeyExists(result, valuesArr[0]);
                if (doesKeyExist){
                    result = addReferencedValuesToKey(result, values, key);
                } else {
                    result.remove(key);
                }
            }

            input = scanner.nextLine().split(" -> ");
        }

        for (Map.Entry<String, List<Integer>> kvp : result.entrySet()) {
            System.out.printf("%s === ", kvp.getKey());

            List<String> kvpValues = new ArrayList<String>();
            for (int i = 0; i < kvp.getValue().size(); i++) {
                kvpValues.add(String.valueOf(kvp.getValue().get(i)));
            }
            System.out.println(String.join(", ", kvpValues));
        }

    }

    static boolean checkASCIIcodes(String s) {
        boolean containsLetters = false;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] <= 48 || sChars[i] >= 57){
                containsLetters = true;
                break;
            }
        }
        return containsLetters;
    }

    static LinkedHashMap<String,List<Integer>> addReferencedValuesToKey(LinkedHashMap<String, List<Integer>> result, String values, String currentKey) {
        List<Integer> listToAppendToNewKey = result.get(values);
        for (int i = 0; i < listToAppendToNewKey.size(); i++) {
            result.get(currentKey).add(listToAppendToNewKey.get(i));
        }
        return result;
    }

    static LinkedHashMap<String,List<Integer>> addIntegersToKey(LinkedHashMap<String, List<Integer>> result, String[] valuesArr, String key) {
        int[] valuesArrInt = new int[valuesArr.length];
        for (int i = 0; i < valuesArrInt.length; i++) {
            valuesArrInt[i] = Integer.valueOf(valuesArr[i]);
            result.get(key).add(valuesArrInt[i]);
        }
        return result;
    }

    static boolean checkIfKeyExists(LinkedHashMap<String, List<Integer>> result, String refKey) {
        boolean doesKeyExist = false;
        if (result.containsKey(refKey)){
            doesKeyExist = true;
        }

        return doesKeyExist;
    }
}
