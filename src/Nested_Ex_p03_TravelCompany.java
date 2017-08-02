import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Vilcho on 7/31/2017.
 */
public class Nested_Ex_p03_TravelCompany {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> categorised = new LinkedHashMap<String, LinkedHashMap<String, Integer>>();
        String[] cityVehiclesPairs = scanner.nextLine().split(":");

        while (!cityVehiclesPairs[0].equals("ready")) {
            if (!categorised.containsKey(cityVehiclesPairs[0])) {
                categorised.put(cityVehiclesPairs[0], new LinkedHashMap<String, Integer>());
            }
            String[] vehiclesAndCapacity = cityVehiclesPairs[1].split(",");
            for (int i = 0; i < vehiclesAndCapacity.length; i++) {
                String[] eachVehicleWithCapacity = vehiclesAndCapacity[i].split("-");
                String vehicle = eachVehicleWithCapacity[0];
                int capacity = Integer.valueOf(eachVehicleWithCapacity[1]);
               // if (!categorised.get(cityVehiclesPairs[0]).containsKey(vehicle)) {
                    // categorised.get(cityVehiclesPairs[0]).put(vehicle, 0);
                    categorised.get(cityVehiclesPairs[0]).put(vehicle, capacity);
                //}
                //categorised.get(cityVehiclesPairs[0]).put(vehicle, categorised.get(cityVehiclesPairs[0]).get(vehicle) + capacity);
                //} else {
               // categorised.get(cityVehiclesPairs[0]).put(vehicle, categorised.get(cityVehiclesPairs[0]).get(vehicle) + capacity);
                //не ги добавяме а ги презаписваме, т.е. стария транспорт не се брои вече
            }

            cityVehiclesPairs = scanner.nextLine().split(":");
        }

        String[] groups = scanner.nextLine().split(" ");
        while (!groups[0].contains("travel")){

            for (String city : categorised.keySet()) {
                if (city.equals(groups[0])){
                    System.out.printf("%s -> ", city);
                    int totalCapacity = 0;
                    LinkedHashMap<String, Integer> citiesVehiclesCap = categorised.get(city);
                    for (String vehicle : citiesVehiclesCap.keySet()) {
                        totalCapacity += citiesVehiclesCap.get(vehicle);
                    }
                    if (totalCapacity >= Integer.valueOf(groups[1])){
                        System.out.printf("all %d accommodated%n", Integer.valueOf(groups[1]));
                    } else {
                        int left = Integer.valueOf(groups[1]) - totalCapacity;
                        System.out.printf("all except %d accommodated%n", left);
                    }

                }
            }

            groups = scanner.nextLine().split(" ");
        }
    }
}
