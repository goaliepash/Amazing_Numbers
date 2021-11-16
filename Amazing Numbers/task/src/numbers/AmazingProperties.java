package numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * Свойства "невероятных" чисел.
 *
 * @author Иванов Павел Александрович
 */
public class AmazingProperties {

    public static boolean isEven(long naturalNumber) {
        return naturalNumber % 2 == 0;
    }

    public static boolean isBuzzNumber(long naturalNumber) {
        if (naturalNumber < 0) {
            return false;
        }
        boolean isDivisibleBy7 = (naturalNumber % 7 == 0);
        boolean isEndsWith7 = (naturalNumber % 10 == 7);
        if (isDivisibleBy7 && isEndsWith7) {
            return true;
        } else if (isDivisibleBy7) {
            return true;
        } else {
            return isEndsWith7;
        }
    }

    public static boolean isDuckNumber(long naturalNumber) {
        String stringNumber = String.valueOf(naturalNumber);
        for (int i = 0; i < stringNumber.length(); i++) {
            if (stringNumber.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }

    public static boolean isPalindromicNumber(long naturalNumber) {
        String stringNumber = String.valueOf(naturalNumber);
        int lengthNumber = stringNumber.length();
        for (int i = 0; i < lengthNumber / 2; i++) {
            if (stringNumber.charAt(i) != stringNumber.charAt(lengthNumber - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isGapful(long naturalNumber) {
        String strNaturalNumber = String.valueOf(naturalNumber);
        if (strNaturalNumber.length() < 3) {
            return false;
        }
        String strFirstLastDigitsNumber = String.format(
                "%c%c",
                strNaturalNumber.charAt(0),
                strNaturalNumber.charAt(strNaturalNumber.length() - 1));
        int firstLastDigitsNumber = Integer.parseInt(strFirstLastDigitsNumber);
        return naturalNumber % firstLastDigitsNumber == 0;
    }

    public static boolean isSpy(long naturalNumber) {
        String strNaturalNumber = String.valueOf(naturalNumber);
        long sumOfDigits = 0;
        long productOfDigits = 1;
        for (int i = 0; i < strNaturalNumber.length(); i++) {
            int currentDigits = Integer.parseInt(String.valueOf(strNaturalNumber.charAt(i)));
            sumOfDigits += currentDigits;
            productOfDigits *= currentDigits;
        }
        return sumOfDigits == productOfDigits;
    }

    public static boolean isSquare(long naturalNumber) {
        long lngSqrt = (long) Math.sqrt(naturalNumber);
        return lngSqrt * lngSqrt == naturalNumber;
    }

    public static boolean isSunny(long naturalNumber) {
        return isSquare(naturalNumber + 1);
    }

    public static boolean isJumping(long naturalNumber) {
        String strNaturalNumber = String.valueOf(naturalNumber);
        int previousDigit = Integer.parseInt(String.valueOf(strNaturalNumber.charAt(0)));
        for (int i = 1; i < strNaturalNumber.length(); i++) {
            int currentDigit = Integer.parseInt(String.valueOf(strNaturalNumber.charAt(i)));
            if (Math.abs(currentDigit - previousDigit) != 1) {
                return false;
            }
            previousDigit = currentDigit;
        }
        return true;
    }

    public static boolean isHappy(long number) {
        Set<Long> digits = new HashSet<>();
        while (digits.add(number)) {
            int result = 0;
            while (number > 0) {
                result += Math.pow(number % 10, 2);
                number = number / 10;
            }
            number = result;
        }
        return number == 1;
    }
}
