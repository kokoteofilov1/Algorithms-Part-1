package UnionFind;

import java.util.Arrays;
import java.util.Scanner;

public class WeightedQuickUnionWithPathCompression {
    private int[] array;
    private int[] size;

    public WeightedQuickUnionWithPathCompression(int n) {
        array = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = i;
            size[i] = 1;
        }
    }

    public int root(int i) {
        while (array[i] != i) {
            array[i] = array[array[i]];
            i = array[i];
        }

        return i;
    }

    public void union(int p, int q) {
        int proot = root(p);
        int qroot = root(q);

        if (size[proot] < size[qroot]) {
            array[proot] = qroot;
            size[qroot] += size[proot];
        } else {
            array[qroot] = proot;
            size[proot] += size[qroot];
        }
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
        WeightedQuickUnionWithPathCompression alg = new WeightedQuickUnionWithPathCompression(n);

        String input = console.nextLine();
        while (!input.equals(" ")) {
            String[] pair = input.split("\\s+");
            int p = Integer.parseInt(pair[0]);
            int q = Integer.parseInt(pair[1]);

            if (alg.connected(p, q)) {
                System.out.println("Already connected!");
                input = console.nextLine();
                continue;
            }

            alg.union(p, q);

            alg.printArray();

            input = console.nextLine();
        }
    }
}