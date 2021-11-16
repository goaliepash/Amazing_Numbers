package numbers;

import java.util.*;

/**
 * Класс с полезными функциями для программы.
 *
 * @author Иванов Павел Александрович
 */
public class Utilities {

    /**
     * Микро-функция для приветствия пользователя.
     */
    public static void userGreeting() {
        System.out.println("Welcome to Amazing Numbers!");
    }

    /**
     * Функция для печати доступных операций.
     */
    public static void printSupportedRequest() {
        System.out.println("\nSupported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    /**
     * Функция для печати свойств одного натурального числа.
     *
     * @param naturalNumber натуральное число
     */
    public static void forOneNumber(long naturalNumber) {
        AmazingNumber.showProperties(naturalNumber);
    }

    /**
     * Функция для печати свойств чисел, начиная с указанного.
     *
     * @param naturalNumber  натуральное число
     * @param rangeNumberStr сколько чисел напечатать
     */
    public static void forTwoNumbers(long naturalNumber, String rangeNumberStr) {
        try {
            int rangeNumber = Integer.parseInt(rangeNumberStr);
            if (rangeNumber <= 0) {
                System.out.println("\nThe second parameter should be a natural number.");
            } else {
                AmazingNumber.showProperties(naturalNumber, rangeNumber);
            }
        } catch (NumberFormatException e) {
            System.out.println("\nThe second parameter should be a natural number.");
        }
    }

    /**
     * Функция для печати указнных свойств для чисел, начиная с указанного.
     *
     * @param naturalNumber  натуральное число
     * @param rangeNumberStr сколько чисел напечатать
     * @param properties     свойства
     */
    public static void forTwoNumbersAndProperties(long naturalNumber, String rangeNumberStr, String[] properties) {
        try {
            int rangeNumber = Integer.parseInt(rangeNumberStr);
            if (rangeNumber <= 0) {
                System.out.println("\nThe second parameter should be a natural number.");
                return;
            }

            Set<String> included = new LinkedHashSet<>();
            Set<String> excluded = new LinkedHashSet<>();
            for (String property : properties) {
                if (property.startsWith("-")) {
                    excluded.add(property);
                } else {
                    included.add(property);
                }
            }

            String[] includedArray = new String[included.size()];
            included.toArray(includedArray);
            String[] excludedArray = new String[excluded.size()];
            excluded.toArray(excludedArray);
            if (checkValidProperties(includedArray, true) && checkValidProperties(excludedArray, false) &&
                    checkMutuallyExclusiveProperties(includedArray, true) && checkMutuallyExclusiveProperties(excludedArray, false) &&
                    checkSameProperties(included, excluded)) {
                AmazingNumber.showProperties(naturalNumber, rangeNumber, includedArray, excludedArray);
            }
        } catch (NumberFormatException e) {
            System.out.println("\nThe second parameter should be a natural number.");
        }
    }

    /**
     * Получить индекс свойства в массиве
     *
     * @param properties массив свойств
     * @param included   true, если свойство включаемое, false - если исключаемое (перед свойством стоит знак '-')
     * @param property   свойство для которого ищется индекс в массиве
     * @return индекс свойства в массиве, если индекс не найден - вернуть '-1'
     */
    public static int indexOfProperty(String[] properties, boolean included, Property property) {
        for (int i = 0; i < properties.length; i++) {
            String currentProperty = included ? properties[i] : properties[i].substring(1);
            if (property.getDescription().equals(currentProperty)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean checkValidProperties(String[] properties, boolean included) {
        List<String> invalidProperties = new ArrayList<>();
        for (String property : properties) {
            String currentProperty = included ? property : property.substring(1);
            boolean isPropertyValid = false;
            for (Property availableProperty : Property.values()) {
                if (currentProperty.equals(availableProperty.getDescription())) {
                    isPropertyValid = true;
                    break;
                }
            }
            if (!isPropertyValid) {
                invalidProperties.add(property);
            }
        }
        if (invalidProperties.size() == 0) {
            return true;
        } else if (invalidProperties.size() == 1) {
            System.out.printf("The property [%s] is wrong.\n", invalidProperties.get(0).toUpperCase());
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return false;
        } else {
            StringBuilder invalidPropertiesSB = new StringBuilder();
            for (int i = 0; i < invalidProperties.size(); i++) {
                invalidPropertiesSB.append(invalidProperties.get(i).toUpperCase());
                if (i != invalidProperties.size() - 1) {
                    invalidPropertiesSB.append(", ");
                }
            }
            System.out.printf("The properties [%s] are wrong.\n", invalidPropertiesSB);
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return false;
        }
    }

    private static boolean checkMutuallyExclusiveProperties(String[] properties, boolean included) {
        int indexOfSquare = indexOfProperty(properties, included, Property.SQUARE);
        int indexOfSunny = indexOfProperty(properties, included, Property.SUNNY);
        if (indexOfSquare != -1 && indexOfSunny != -1) {
            if (indexOfSquare < indexOfSunny) {
                if (included) {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [%s, %s]\n",
                            Property.SQUARE.getDescription().toUpperCase(),
                            Property.SUNNY.getDescription().toUpperCase());
                } else {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [-%s, -%s]\n",
                            Property.SQUARE.getDescription().toUpperCase(),
                            Property.SUNNY.getDescription().toUpperCase());
                }
            } else {
                if (included) {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [%s, %s]\n",
                            Property.SUNNY.getDescription().toUpperCase(),
                            Property.SQUARE.getDescription().toUpperCase());
                } else {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [-%s, -%s]\n",
                            Property.SUNNY.getDescription().toUpperCase(),
                            Property.SQUARE.getDescription().toUpperCase());
                }
            }
            System.out.println("There are no numbers with these properties.");
            return false;
        }

        int indexOfDuck = indexOfProperty(properties, included, Property.DUCK);
        int indexOfSpy = indexOfProperty(properties, included, Property.SPY);
        if (indexOfDuck != -1 && indexOfSpy != -1) {
            if (indexOfDuck < indexOfSpy) {
                if (included) {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [%s, %s]\n",
                            Property.DUCK.getDescription().toUpperCase(),
                            Property.SPY.getDescription().toUpperCase());
                } else {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [-%s, -%s]\n",
                            Property.DUCK.getDescription().toUpperCase(),
                            Property.SPY.getDescription().toUpperCase());
                }
            } else {
                if (included) {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [%s, %s]\n",
                            Property.SPY.getDescription().toUpperCase(),
                            Property.DUCK.getDescription().toUpperCase());
                } else {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [-%s, -%s]\n",
                            Property.SPY.getDescription().toUpperCase(),
                            Property.DUCK.getDescription().toUpperCase());
                }
            }
            System.out.println("There are no numbers with these properties.");
            return false;
        }

        int indexOfEven = indexOfProperty(properties, included, Property.EVEN);
        int indexOfOdd = indexOfProperty(properties, included, Property.ODD);
        if (indexOfEven >= 0 && indexOfOdd >= 0) {
            if (indexOfEven < indexOfOdd) {
                if (included) {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [%s, %s]\n",
                            Property.EVEN.getDescription().toUpperCase(),
                            Property.ODD.getDescription().toUpperCase());
                } else {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [-%s, -%s]\n",
                            Property.EVEN.getDescription().toUpperCase(),
                            Property.ODD.getDescription().toUpperCase());
                }
            } else {
                if (included) {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [%s, %s]\n",
                            Property.ODD.getDescription().toUpperCase(),
                            Property.EVEN.getDescription().toUpperCase());
                } else {
                    System.out.printf(
                            "The request contains mutually exclusive properties: [-%s, -%s]\n",
                            Property.EVEN.getDescription().toUpperCase(),
                            Property.ODD.getDescription().toUpperCase());
                }
            }
            System.out.println("There are no numbers with these properties.");
            return false;
        }

        return true;
    }

    private static boolean checkSameProperties(Set<String> included, Set<String> excluded) {
        for (String property : excluded) {
            if (included.contains(property.substring(1))) {
                System.out.printf(
                        "The request contains mutually exclusive properties: [%s, %s]\n",
                        property, property.substring(1));
                System.out.println("There are no numbers with these properties.");
                return false;
            }
        }
        return true;
    }
}
