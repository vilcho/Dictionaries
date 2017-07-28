import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Vilcho on 7/28/2017.
 */
public class Ex_p04_ExamShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Integer> stock = new LinkedHashMap<String, Integer>();

        while (!input.equals("exam time")) {
            String[] inputAsArray = input.split(" ");
            if (inputAsArray.length == 3) {

                switch (inputAsArray[0]) {

                    case "stock":
                        stock = addCurrentProductWithQtyToStock(stock, inputAsArray);
                        break;
                    case "buy":
                        if (stock.containsKey(inputAsArray[1])) {
                            boolean isProductOnStock = checkIfProductIsOnStock(inputAsArray[1], stock);
                            if (!isProductOnStock) {
                                System.out.printf("%s out of stock%n", inputAsArray[1]);
                            } else {
                                stock = removeCurrentProductWithQtyFromStock(stock, inputAsArray);
                            }
                        } else {
                            System.out.printf("%s doesn't exist%n", inputAsArray[1]);
                        }

                        break;
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> kvp : stock.entrySet()) {
            if (kvp.getValue() != 0) {
                System.out.printf("%s -> %d%n", kvp.getKey(), kvp.getValue());
            }
        }
    }

    static LinkedHashMap<String, Integer> removeCurrentProductWithQtyFromStock(LinkedHashMap<String, Integer> stock, String[] inputAsArray) {
        int currentQuantityOfProduct = Integer.valueOf(stock.get(inputAsArray[1]));
        int quantityOfProductAfterBuyCommand = currentQuantityOfProduct - Integer.valueOf(inputAsArray[2]);
        if (quantityOfProductAfterBuyCommand < 0) {
            quantityOfProductAfterBuyCommand = 0;
        }
        stock.put(inputAsArray[1], quantityOfProductAfterBuyCommand);

        return stock;
    }

    static LinkedHashMap<String, Integer> addCurrentProductWithQtyToStock(LinkedHashMap<String, Integer> stock, String[] inputAsArray) {
        if (!stock.containsKey(inputAsArray[1])) {
            stock.put(inputAsArray[1], Integer.valueOf(inputAsArray[2]));
        } else {
            int currentQuantityOfProduct = Integer.valueOf(stock.get(inputAsArray[1]));
            int quantityOfProductAfterReStockingCommand = currentQuantityOfProduct + Integer.valueOf(inputAsArray[2]);
            stock.put(inputAsArray[1], quantityOfProductAfterReStockingCommand);
        }
        return stock;
    }

    static boolean checkIfProductIsOnStock(String currentProduct, LinkedHashMap<String, Integer> stock) {
        boolean isProductOnStock = true;
        if (stock.get(currentProduct) <= 0) {
            isProductOnStock = false;
        }

        return isProductOnStock;
    }
}
