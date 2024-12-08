import java.util.Random;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        int studentNumber = 16;

        System.out.println("Номер у списку групи: 16");

        int C5 = studentNumber % 5;
        int C7 = studentNumber % 7;
        int C11 = studentNumber % 11;

        System.out.println("C5: " + C5 + ", Дія з матрицею(ями): C = (транспонування)");
        System.out.println("C7: " + C7 + ", Тип елементів матриці: = short");
        System.out.println("C11: " + C11 + ", Дія з матрицею С: Обчислити суму найбільших елементів в рядках матриці з непарними номерами та найменших елементів в рядках матриці з парними номерами");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Кількість рядків: ");
        int rows = scanner.nextInt();

        System.out.print("Кількість стовпців: ");
        int cols = scanner.nextInt();

        // Створення матриці B з випадковими значеннями
        short[][] B = new short[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                B[i][j] = (short) (random.nextInt(25));
            }
        }

        // Виведення матриці B
        System.out.println("\nМатриця B:");
        printMatrix(B);

        // Транспонування матриці
        short[][] C = transposeMatrix(B);

        // Виведення матриці C
        System.out.println("\nТранспонована матриця C:");
        printMatrix(C);

        // Обчислення суми
        int sum = calculateSum(C);
        System.out.println("\nСума потрібних елементів: " + sum);
    }

    // Метод для транспонування матриці
    public static short[][] transposeMatrix(short[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        short[][] transposed = new short[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    // Метод для обчислення суми найбільших і найменших елементів в рядках
    public static int calculateSum(short[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            short extremeValue = matrix[i][0]; // Початкове значення

            for (int j = 1; j < matrix[i].length; j++) {
                if (i % 2 == 0) { // Непарний рядок
                    if (matrix[i][j] > extremeValue) {
                        extremeValue = matrix[i][j];
                    }
                } else { // Парний рядок
                    if (matrix[i][j] < extremeValue) {
                        extremeValue = matrix[i][j];
                    }
                }
            }
            sum += extremeValue;
        }
        return sum;
    }

    // Метод для виведення матриці
    public static void printMatrix(short[][] matrix) {
        for (short[] row : matrix) {
            for (short value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
