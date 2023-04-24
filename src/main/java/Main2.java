import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = new int[SIZE][SIZE];
        fillArrayWithRandomNumbers(colors);
        displayArray(colors);
        int x = 1;
        int[][] rotatedColors = transportMatrix(colors, x);
        displayArray(colors); // Почему массив colors меняет своё значение?? И как сделать так, чтобы он не менял своего значения
        System.out.println("\n");
        displayArray(rotatedColors);
    }

    public static void displayArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.format("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] transportMatrix(int[][] arr, int angle) {
        if (angle == 360) return arr;
        int times = angle / 90;
        for (int n = 0; n < times; n++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr[0].length; j++) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                int ri = arr[i].length - 1;
                int li = 0;
                while (li < ri) {
                    int temp = arr[i][li];
                    arr[i][li] = arr[i][ri];
                    arr[i][ri] = temp;
                    ri--;
                    li++;
                }
            }
        }
        return arr;
    }

    public static int[][] fillArrayWithRandomNumbers(int[][] arr) {

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = random.nextInt(12);
            }
        }
        return arr;
    }


}

