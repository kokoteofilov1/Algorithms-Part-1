package UnionFind;

import java.util.Arrays;
import java.util.Scanner;

public class QuickUnion {
    private int[] array;

    public QuickUnion(int n) {
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public int root(int i) {
        while (array[i] != i) {
            i = array[i];
        }

        return i;
    }

    public void union(int p, int q) {
        int proot = root(p);
        int qroot = root(q);
        array[proot] = qroot;
    }

    public boolean connected(int p, int q) {
        return (root(p) == root(q));
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        QuickUnion alg = new QuickUnion(n);

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
