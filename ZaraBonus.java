public class ZaraBonus {
    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData(10);
        double[][] newSalaryData = calculateNewSalaryAndBonus(employeeData);
        displayResults(newSalaryData);
    }

    public static double[][] generateEmployeeData(int numEmployees) {
        double[][] data = new double[numEmployees][3];
        for (int i = 0; i < numEmployees; i++) {
            data[i][0] = Math.random() * 90000 + 10000;
            data[i][1] = Math.random() * 10 + 1;
        }
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] newData = new double[employeeData.length][3];
        for (int i = 0; i < employeeData.length; i++) {
            newData[i][0] = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonusPercentage = yearsOfService > 5 ? 0.05 : 0.02;
            double bonusAmount = newData[i][0] * bonusPercentage;
            newData[i][1] = newData[i][0] + bonusAmount;
            newData[i][2] = bonusAmount;
        }
        return newData;
    }

    public static void displayResults(double[][] newData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;
        System.out.println("Old Salary\tNew Salary\tBonus");
        for (double[] employee : newData) {
            totalOldSalary += employee[0];
            totalNewSalary += employee[1];
            totalBonus += employee[2];
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\n", employee[0], employee[1], employee[2]);
        }
        System.out.println("------------------------------------");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
    }
}