import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Created by Vilcho on 7/30/2017.
 */
public class Nested_Lab_p03_RecordUniqueNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        LinkedHashSet <String> uniqueNames = new LinkedHashSet<String>();

        for (int i = 0; i < N; i++) {
            String newName = scanner.nextLine();
            uniqueNames.add(newName);
        }
        for (String name: uniqueNames) {
            System.out.println(name);
        }
    }
}
