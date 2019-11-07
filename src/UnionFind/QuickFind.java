package UnionFind;

import java.util.Arrays;
import java.util.Scanner;

public class QuickFind {
    private int[] array;

    public QuickFind(int n) {
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public void union(int p, int q) {
        int pid = array[p];
        int qid = array[q];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == pid) {
                array[i] = qid;
            }
        }
    }

    public boolean connected(int p, int q) {
        return (array[p] == array[q]);
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        QuickFind alg = new QuickFind(n);

        String input = console.nextLine();
        while (!input.equals(" ")) {
            String[] pair = input.split("\\s+");
            int p = Integer.parseInt(pair[0]);
            int q = Integer.parseInt(pair[1]);

            if (alg.connected(p, q)) {
                System.out.println("Already connected!");
                continue;
            }

            alg.union(p, q);

            alg.printArray();

            input = console.nextLine();
        }
    }
}




