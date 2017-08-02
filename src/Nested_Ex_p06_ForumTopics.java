import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * Created by Vilcho on 8/1/2017.
 */
public class Nested_Ex_p06_ForumTopics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashSet<String>> result = new LinkedHashMap<String, LinkedHashSet<String>>();

        String[] input = scanner.nextLine().split(" -> ");

        while (!input[0].equals("filter")){
            if (!result.containsKey(input[0])){
                result.put(input[0], new LinkedHashSet<String>());
            }
            String[] valuesInput = input[1].split(", ");
            for (int i = 0; i < valuesInput.length; i++) {
                result.get(input[0]).add(valuesInput[i]);
            }

            input = scanner.nextLine().split(" -> ");
        }

        String[] filterBy = scanner.nextLine().split(", ");

        for (Map.Entry<String, LinkedHashSet<String>> kvp : result.entrySet()) {
            boolean areAllCriteriaSatisfied = true;
            for (int i = 0; i < filterBy.length; i++) {
                if (!(String.valueOf(kvp.getValue())).contains(filterBy[i])){
                    areAllCriteriaSatisfied = false;
                    break;
                }
            }
            if (areAllCriteriaSatisfied){
                System.out.printf("%s | ", kvp.getKey());
                List<String> outputResultTags = new ArrayList<String>();
                for (String tag:kvp.getValue()) {
                    outputResultTags.add("#" + tag);
                }

                System.out.println(String.join(", ", outputResultTags));
            }
        }




    }
}
