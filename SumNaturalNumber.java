import java.util.*;
public class SumNaturalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a valid natural number.");
            return;
        }
        
        int recursiveSum = findSumRecursive(n);
        int formulaSum = findSumFormula(n);
        
        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula: " + formulaSum);
        
        if (recursiveSum == formulaSum) {
            System.out.println("Both results are correct!");
        } else {
            System.out.println("There is an error in the computation.");
        }
    }
    
    public static int findSumRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + findSumRecursive(n - 1);
    }
    
    public static int findSumFormula(int n) {
        return n * (n + 1) / 2;
    }
}