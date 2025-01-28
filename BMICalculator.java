import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3]; 
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }
        calculateBMI(data);
        String[] status = determineBMIStatus(data);
        System.out.println("\nHeight (cm)\tWeight (kg)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t\t%s\n", data[i][1], data[i][0], data[i][2], status[i]);
        }
    }

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < 10; i++) {
            double heightM = data[i][1] / 100; 
            data[i][2] = data[i][0] / (heightM * heightM);
        }
    }

    public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[10];
        for (int i = 0; i < 10; i++) {
            if (data[i][2] < 18.5) {
                status[i] = "Underweight";
            } else if (data[i][2] < 25) {
                status[i] = "Normal";
            } else if (data[i][2] < 40) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }
}