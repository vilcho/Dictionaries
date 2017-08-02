import java.util.*;

/**
 * Created by Vilcho on 7/29/2017.
 */
public class Nested_Lab_p02_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> citiesByCountryAndContinent = new LinkedHashMap<String, LinkedHashMap<String, List<String>>>();

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            boolean continentExist = doesContinentExist(input, citiesByCountryAndContinent);
            if (!continentExist) {
                citiesByCountryAndContinent.put(input[0], new LinkedHashMap<String, List<String>>());
            }
            if (!(citiesByCountryAndContinent.get(continent).containsKey(country))) {
                citiesByCountryAndContinent.get(continent).put(country, new ArrayList<String>());
            }
            citiesByCountryAndContinent.get(continent).get(country).add(city);
        }


        for (Map.Entry<String, LinkedHashMap<String, List<String>>> CountiesEtc : citiesByCountryAndContinent.entrySet()) {
            String contName = CountiesEtc.getKey();
            LinkedHashMap<String, List<String>> countryNcity = CountiesEtc.getValue();

            System.out.printf("%s:%n", contName);

            for (Map.Entry<String, List<String>> couNCi : countryNcity.entrySet()) {
                System.out.printf(" %s -> ", couNCi.getKey());

                System.out.println(String.join(", ", couNCi.getValue()));
            }
        }
    }


    static boolean doesContinentExist(String[] input, LinkedHashMap<String, LinkedHashMap<String, List<String>>> citiesByCountryAndContinent) {
        boolean doesContinentExist = false;
        if (citiesByCountryAndContinent.containsKey(input[0])) {
            doesContinentExist = true;
        }

        return doesContinentExist;
    }


}
