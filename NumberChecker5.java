public class NumberChecker5 {

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors[index++] = i;
        }
        return factors;
    }

    public static int findGreatestFactor(int[] factors) {
        return factors[factors.length - 2];
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) sum += factor;
        return sum;
    }

    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) product *= factor;
        return product;
    }

    public static int productOfCubeOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) product *= Math.pow(factor, 3);
        return product;
    }

    public static boolean isPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum == number;
    }

    public static boolean isAbundantNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum > number;
    }

    public static boolean isDeficientNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum < number;
    }

    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }

    private static int factorial(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++) fact *= i;
        return fact;
    }

    public static void main(String[] args) {
        int number = 28;
        int[] factors = findFactors(number);
        int greatestFactor = findGreatestFactor(factors);
        int sumFactors = sumOfFactors(factors);
        int productFactors = productOfFactors(factors);
        int productCubeFactors = productOfCubeOfFactors(factors);
        boolean isPerfect = isPerfectNumber(number);
        boolean isAbundant = isAbundantNumber(number);
        boolean isDeficient = isDeficientNumber(number);
        boolean isStrong = isStrongNumber(number);

        System.out.println("Number: " + number);
        System.out.println("Factors: " + java.util.Arrays.toString(factors));
        System.out.println("Greatest Factor: " + greatestFactor);
        System.out.println("Sum of Factors: " + sumFactors);
        System.out.println("Product of Factors: " + productFactors);
        System.out.println("Product of Cube of Factors: " + productCubeFactors);
        System.out.println("Is Perfect Number: " + isPerfect);
        System.out.println("Is Abundant Number: " + isAbundant);
        System.out.println("Is Deficient Number: " + isDeficient);
        System.out.println("Is Strong Number: " + isStrong);
    }
}