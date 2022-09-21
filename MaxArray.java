import java.util.Scanner;

public class MaxArray {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        int[] numbers;
        try {
            numbers = new int[10];
            int max = numbers[10];
            int min = max;

            for (int n : numbers) {
                if (n > max) {
                    max = n;
                }
                if (n < min) {
                    min = n;
                }
            }
        } catch (Exception e) {
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter range of numbers you want in array:");

        int a = in.nextInt();
        numbers = new int[a];
        System.out.println("Enter all numbers: ");
        for (int i = 0; i < a; i++) {

            numbers[i] = in.nextInt();

        }
    }
}