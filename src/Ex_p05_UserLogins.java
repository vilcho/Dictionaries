import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Vilcho on 7/28/2017.
 */
public class Ex_p05_UserLogins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, String> logins = new LinkedHashMap<String, String>();

        while (!input.equals("login")) {
            String[] inputAsArray = input.split(" -> ");
            logins.put(inputAsArray[0], inputAsArray[1]);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        int countUnsucsessfulLoginAttempts = 0;
        while (!input.equals("end")) {
            String[] inputAsArray = input.split(" -> ");
            boolean isLoginValid = validateLogin(logins, inputAsArray);
            if (isLoginValid) {
                System.out.printf("%s: logged in successfully%n", inputAsArray[0]);
            } else {
                countUnsucsessfulLoginAttempts ++;
                System.out.printf("%s: login failed%n", inputAsArray[0]);
            }
            input = scanner.nextLine();
        }
        System.out.printf("unsuccessful login attempts: %d%n", countUnsucsessfulLoginAttempts);
    }

    static boolean validateLogin(LinkedHashMap<String, String> logins, String[] inputAsArray) {
        boolean isLoginValid = false;
        if (logins.containsKey(inputAsArray[0]) && logins.get(inputAsArray[0]).equals(inputAsArray[1])) {
            isLoginValid = true;
        }
        return isLoginValid;
    }
}
