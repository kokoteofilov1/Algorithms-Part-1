package ElementarySorts;

import java.util.Arrays;
import java.util.Scanner;

public class FisherYatesShuffle {

    public static void shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (i + 1));
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] input = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        FisherYatesShuffle.shuffle(input);

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}