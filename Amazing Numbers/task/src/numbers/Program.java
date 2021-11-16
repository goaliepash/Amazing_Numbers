package numbers;

import java.util.Scanner;

/**
 * Программа "Невероятные числа".
 *
 * @author Иванов Павел Александрович
 */
public class Program {

    /**
     * Метод для запуска программы.
     */
    public static void launch() {
        Utilities.userGreeting();
        Utilities.printSupportedRequest();

        while (true) {
            System.out.print("\nEnter a request: ");
            Scanner scanner = new Scanner(System.in);
            String request = scanner.nextLine();
            if ("".equals(request)) {
                Utilities.printSupportedRequest();
                continue;
            }

            String[] requestArray = request.toLowerCase().split(" ");
            long naturalNumber;
            try {
                naturalNumber = Long.parseLong(requestArray[0]);
            } catch (NumberFormatException e) {
                System.out.println("\nThe first parameter should be a natural number or zero.");
                continue;
            }
            if (naturalNumber == 0) {
                System.out.println("\nGoodbye!");
                break;
            }
            if (naturalNumber < 0) {
                System.out.println("\nThe first parameter should be a natural number or zero.");
                continue;
            }

            if (requestArray.length == 1) {
                Utilities.forOneNumber(naturalNumber);
            } else if (requestArray.length == 2) {
                Utilities.forTwoNumbers(naturalNumber, requestArray[1]);
            } else {
                String[] properties = new String[requestArray.length - 2];
                System.arraycopy(requestArray, 2, properties, 0, requestArray.length - 2);
                Utilities.forTwoNumbersAndProperties(naturalNumber, requestArray[1], properties);
            }
        }
    }
}
