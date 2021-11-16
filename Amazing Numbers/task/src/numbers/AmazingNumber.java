package numbers;

public class AmazingNumber {

    public static void showProperties(long naturalNumber) {
        System.out.printf("Properties of %s\n", naturalNumber);
        System.out.printf("even: %b\n", AmazingProperties.isEven(naturalNumber));
        System.out.printf("odd: %b\n", !AmazingProperties.isEven(naturalNumber));
        System.out.printf("buzz: %b\n", AmazingProperties.isBuzzNumber(naturalNumber));
        System.out.printf("duck: %b\n", AmazingProperties.isDuckNumber(naturalNumber));
        System.out.printf("palindromic: %b\n", AmazingProperties.isPalindromicNumber(naturalNumber));
        System.out.printf("gapful: %b\n", AmazingProperties.isGapful(naturalNumber));
        System.out.printf("spy: %b\n", AmazingProperties.isSpy(naturalNumber));
        System.out.printf("square: %b\n", AmazingProperties.isSquare(naturalNumber));
        System.out.printf("sunny: %b\n", AmazingProperties.isSunny(naturalNumber));
        System.out.printf("jumping: %b\n", AmazingProperties.isJumping(naturalNumber));
        System.out.printf("sad: %b\n", !AmazingProperties.isHappy(naturalNumber));
        System.out.printf("happy: %b\n", AmazingProperties.isHappy(naturalNumber));
    }

    public static void showProperties(long naturalNumber, int range) {
        System.out.println();
        for (int i = 0; i < range; i++) {
            long temporaryNaturalNumber = naturalNumber + i;
            StringBuilder naturalNumberInfo = new StringBuilder();
            naturalNumberInfo.append(String.format("%d is ", temporaryNaturalNumber));

            if (AmazingProperties.isEven(temporaryNaturalNumber)) {
                naturalNumberInfo.append("even, ");
            } else {
                naturalNumberInfo.append("odd, ");
            }

            if (AmazingProperties.isBuzzNumber(temporaryNaturalNumber)) {
                naturalNumberInfo.append("buzz, ");
            }

            if (AmazingProperties.isDuckNumber(temporaryNaturalNumber)) {
                naturalNumberInfo.append("duck, ");
            }

            if (AmazingProperties.isPalindromicNumber(temporaryNaturalNumber)) {
                naturalNumberInfo.append("palindromic, ");
            }

            if (AmazingProperties.isGapful(temporaryNaturalNumber)) {
                naturalNumberInfo.append("gapful, ");
            }

            if (AmazingProperties.isSpy(temporaryNaturalNumber)) {
                naturalNumberInfo.append("spy, ");
            }

            if (AmazingProperties.isSquare(temporaryNaturalNumber)) {
                naturalNumberInfo.append("square, ");
            } else if (AmazingProperties.isSunny(temporaryNaturalNumber)) {
                naturalNumberInfo.append("sunny, ");
            }

            if (AmazingProperties.isJumping(temporaryNaturalNumber)) {
                naturalNumberInfo.append("jumping, ");
            }

            if (AmazingProperties.isHappy(temporaryNaturalNumber)) {
                naturalNumberInfo.append("happy");
            } else {
                naturalNumberInfo.append("sad");
            }

            System.out.println(naturalNumberInfo);
        }
    }

    public static void showProperties(long naturalNumber, int range, String[] includedArray, String[] excludedArray) {
        System.out.println();
        int counter = 0;
        int counterOfPropertyByIteration;
        while (counter < range) {
            StringBuilder naturalNumberInfo = new StringBuilder();
            naturalNumberInfo.append(String.format("%d is ", naturalNumber));

            counterOfPropertyByIteration = 0;

            // Чётные и нечётные
            if (AmazingProperties.isEven(naturalNumber)) {
                if (Utilities.indexOfProperty(excludedArray, false, Property.EVEN) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("even, ");
                if (Utilities.indexOfProperty(includedArray, true, Property.EVEN) != -1) {
                    counterOfPropertyByIteration++;
                }
            } else {
                if (Utilities.indexOfProperty(excludedArray, false, Property.ODD) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("odd, ");
                if (Utilities.indexOfProperty(includedArray, true, Property.ODD) != -1) {
                    counterOfPropertyByIteration++;
                }
            }

            // Buzz-числа
            if (AmazingProperties.isBuzzNumber(naturalNumber)) {
                if (Utilities.indexOfProperty(excludedArray, false, Property.BUZZ) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("buzz, ");
                if (Utilities.indexOfProperty(includedArray, true, Property.BUZZ) != -1) {
                    counterOfPropertyByIteration++;
                }
            }

            // Duck-числа
            if (AmazingProperties.isDuckNumber(naturalNumber)) {
                if (Utilities.indexOfProperty(excludedArray, false, Property.DUCK) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("duck, ");
                if (Utilities.indexOfProperty(includedArray, true, Property.DUCK) != -1) {
                    counterOfPropertyByIteration++;
                }
            }

            // Палиндромы
            if (AmazingProperties.isPalindromicNumber(naturalNumber)) {
                if (Utilities.indexOfProperty(excludedArray, false, Property.PALINDROMIC) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("palindromic, ");
                if (Utilities.indexOfProperty(includedArray, true, Property.PALINDROMIC) != -1) {
                    counterOfPropertyByIteration++;
                }
            }

            // Gapful-числа
            if (AmazingProperties.isGapful(naturalNumber)) {
                if (Utilities.indexOfProperty(excludedArray, false, Property.GAPFUL) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("gapful, ");
                if (Utilities.indexOfProperty(includedArray, true, Property.GAPFUL) != -1) {
                    counterOfPropertyByIteration++;
                }
            }

            // Spy-числа
            if (AmazingProperties.isSpy(naturalNumber)) {
                if (Utilities.indexOfProperty(excludedArray, false, Property.SPY) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("spy, ");
                if (Utilities.indexOfProperty(includedArray, true, Property.SPY) != -1) {
                    counterOfPropertyByIteration++;
                }
            }

            // Квадратные и солнечные числа
            if (AmazingProperties.isSquare(naturalNumber)) {
                if (Utilities.indexOfProperty(excludedArray, false, Property.SQUARE) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("square, ");
                if (Utilities.indexOfProperty(includedArray, true, Property.SQUARE) != -1) {
                    counterOfPropertyByIteration++;
                }
            } else if (AmazingProperties.isSunny(naturalNumber)) {
                if (Utilities.indexOfProperty(excludedArray, false, Property.SUNNY) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("sunny, ");
                if (Utilities.indexOfProperty(includedArray, true, Property.SUNNY) != -1) {
                    counterOfPropertyByIteration++;
                }
            }

            // Прыгающие числа
            if (AmazingProperties.isJumping(naturalNumber)) {
                if (Utilities.indexOfProperty(excludedArray, false, Property.JUMPING) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("jumping, ");
                if (Utilities.indexOfProperty(includedArray, true, Property.JUMPING) != -1) {
                    counterOfPropertyByIteration++;
                }
            }

            // Счастливые и грустные числа
            if (AmazingProperties.isHappy(naturalNumber)) {
                if (Utilities.indexOfProperty(excludedArray, false, Property.HAPPY) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("happy");
                if (Utilities.indexOfProperty(includedArray, true, Property.HAPPY) != -1) {
                    counterOfPropertyByIteration++;
                }
            } else {
                if (Utilities.indexOfProperty(excludedArray, false, Property.SAD) != -1) {
                    naturalNumber++;
                    continue;
                }
                naturalNumberInfo.append("sad");
                if (Utilities.indexOfProperty(includedArray, true, Property.SAD) != -1) {
                    counterOfPropertyByIteration++;
                }
            }

            if (counterOfPropertyByIteration == includedArray.length) {
                System.out.println(naturalNumberInfo);
                counter++;
            }
            naturalNumber++;
        }
    }
}
