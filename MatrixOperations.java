import java.util.*;
public class MatrixOperations {

    public static void main(String[] args) {
        int rows1 = 3, cols1 = 3;
        int rows2 = 3, cols2 = 3;

        double[][] matrix1 = createRandomMatrix(rows1, cols1);
        double[][] matrix2 = createRandomMatrix(rows2, cols2);

        System.out.println("Matrix 1:");
        displayMatrix(matrix1);

        System.out.println("Matrix 2:");
        displayMatrix(matrix2);

        if (rows1 == rows2 && cols1 == cols2) {
            System.out.println("Sum of Matrices:");
            displayMatrix(addMatrices(matrix1, matrix2));

            System.out.println("Difference of Matrices:");
            displayMatrix(subtractMatrices(matrix1, matrix2));
        }

        if (cols1 == rows2) { 
            System.out.println("Product of Matrices:");
            displayMatrix(multiplyMatrices(matrix1, matrix2));
        } else {
            System.out.println("Matrix multiplication not possible.");
        }

        System.out.println("Transpose of Matrix 1:");
        displayMatrix(transposeMatrix(matrix1));

        if (matrix1.length == 2) { 
            double det = determinant2x2(matrix1);
            System.out.println("Determinant of Matrix 1 (2x2): " + det);
            if (det != 0) {
                System.out.println("Inverse of Matrix 1 (2x2):");
                displayMatrix(inverse2x2(matrix1));
            } else {
                System.out.println("Matrix 1 is singular (no inverse).");
            }
        } else if (matrix1.length == 3) { 
            double det = determinant3x3(matrix1);
            System.out.println("Determinant of Matrix 1 (3x3): " + det);
            if (det != 0) {
                System.out.println("Inverse of Matrix 1 (3x3):");
                displayMatrix(inverse3x3(matrix1)); 
            } else {
                System.out.println("Matrix 1 is singular (no inverse).");
            }
        }
    }

    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextDouble() * 10; 
            }
        }
        return matrix;
    }

    public static double[][] addMatrices(double[][] matrix1, double[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static double[][] subtractMatrices(double[][] matrix1, double[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        double[][] result = new double[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transpose = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public static double determinant2x2(double[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static double determinant3x3(double[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
               matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
               matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    public static double[][] inverse2x2(double[][] matrix) {
        double det = determinant2x2(matrix);
        if (det == 0) {
            return null; 
        }
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] = matrix[0][0] / det;
        return inverse;
    }

    public static double[][] inverse3x3(double[][] matrix) {
        return null;
    }

    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}