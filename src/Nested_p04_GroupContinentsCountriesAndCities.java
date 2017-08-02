import java.util.*;

/**
 * Created by Vilcho on 7/30/2017.
 */
public class Nested_p04_GroupContinentsCountriesAndCities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, TreeMap<String, TreeSet<String>>> groupedUniques = new TreeMap<String, TreeMap<String, TreeSet<String>>>();

        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < N; i++) {
            String[] newInput = scanner.nextLine().split(" ");
            String continent = newInput[0];
            String coutry = newInput[1];
            String city = newInput[2];

            if (!groupedUniques.containsKey(continent)) {
                groupedUniques.put(continent, new TreeMap<String, TreeSet<String>>());
            }
            if (!groupedUniques.get(continent).containsKey(coutry)) {
                groupedUniques.get(continent).put(coutry, new TreeSet<String>());
            }
            groupedUniques.get(continent).get(coutry).add(city);

        }

        for (Map.Entry<String, TreeMap<String, TreeSet<String>>> continentEtc : groupedUniques.entrySet()) {
            System.out.printf("%s: %n", continentEtc.getKey());
            TreeMap<String, TreeSet<String>> countryAndCity = continentEtc.getValue();
            for (Map.Entry<String, TreeSet<String>> coutriesEtc : countryAndCity.entrySet()) {
                System.out.printf(" %s -> ", coutriesEtc.getKey());
                System.out.println(String.join(", ", coutriesEtc.getValue()));
            }
        }
    }
}

