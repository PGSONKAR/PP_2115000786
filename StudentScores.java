import java.util.Scanner;
public class StudentScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStudents = sc.nextInt();
        int[][] studentScores = generateRandomScores(numStudents);
        double[][] studentResults = calculateResults(studentScores);
        displayScorecard(studentResults);
    }

    public static int[][] generateRandomScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = (int) (Math.random() * 100);
            scores[i][1] = (int) (Math.random() * 100);
            scores[i][2] = (int) (Math.random() * 100);
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][4];
        for (int i = 0; i < scores.length; i++) {
            results[i][0] = scores[i][0];
            results[i][1] = scores[i][1];
            results[i][2] = scores[i][2];
            results[i][3] = scores[i][0] + scores[i][1] + scores[i][2];
            results[i][4] = Math.round((results[i][3] / 3.0) * 100.0) / 100.0;
            results[i][5] = Math.round((results[i][3] / 300.0) * 100.0) / 100.0;
        }
        return results;
    }

    public static void displayScorecard(double[][] results) {
        System.out.println("Student\tPhysics\tChemistry\tMath\t\tTotal\tAverage\tPercentage");
        for (int i = 0; i < results.length; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f%%\n",
                    i + 1, results[i][0], results[i][1], results[i][2], results[i][3], results[i][5]);
        }
    }
}