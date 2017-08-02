import java.util.*;

/**
 * Created by Vilcho on 8/1/2017.
 */
public class Nested_Ex_p07_SocialMediaPosts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> pLikes = new LinkedHashMap<String, LinkedHashMap<String, Integer>>();
        LinkedHashMap<String, List<String>> pComments = new LinkedHashMap<String, List<String>>();

        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals("drop")) {
            switch (input[0]) {
                case "post":
                    if (!pLikes.containsKey(input[1])) {
                        pLikes.put(input[1], new LinkedHashMap<String, Integer>());
                        pLikes.get(input[1]).put("Likes", 0);
                        pLikes.get(input[1]).put("Dislikes", 0);
                        pComments.put(input[1], new ArrayList<String>());
                    }
                    break;
                case "like":
                    pLikes.get(input[1]).put("Likes", (pLikes.get(input[1]).get("Likes") + 1));
                    break;
                case "dislike":
                    pLikes.get(input[1]).put("Dislikes", (pLikes.get(input[1]).get("Dislikes") + 1));
                    break;
                case "comment":
                    String post = input[1];
                    String comName = input[2];
                    String comContent = "";
                    for (int i = 3; i < input.length; i++) {
                        comContent = comContent.concat(" ").concat(input[i]);
                    }

                    pComments.get(input[1]).add(comName + ":" + comContent);
                    break;
            }

            input = scanner.nextLine().split(" ");
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> pLikesEntries : pLikes.entrySet()) {
            System.out.printf("Post: %s", pLikesEntries.getKey());

            LinkedHashMap<String, Integer> valuesLikes = pLikesEntries.getValue();
            for (Map.Entry<String, Integer> kvp : valuesLikes.entrySet()) {
                System.out.printf(" | %s: %d", kvp.getKey(), kvp.getValue());
            }
            for (Map.Entry<String, List<String>> commentsTable : pComments.entrySet()) {
                if (pLikesEntries.getKey().equals(commentsTable.getKey())) {
                    System.out.printf("%nComments:%n");
                    if (commentsTable.getValue().size() > 0) {
                        for (String com : commentsTable.getValue()) {
                            System.out.println("*  " + com);
                        }
                    } else {
                        System.out.println("None");
                    }

                }
            }
        }
    }
}

