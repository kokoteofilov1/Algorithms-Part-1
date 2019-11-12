package StacksAndQueues;

import java.util.Scanner;

public class FixedCapacityStackOfStrings {
    private String[] stringArray;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        stringArray = new String[capacity];
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public void push(String item) {
        stringArray[N++] = item;
    }

    public String pop() {
        String value = stringArray[--N];
        stringArray[N] = null;
        return value;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");

        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);

        for (int i = 0; i < input.length; i++) {
            String word = input[i];
            if (!word.equals("-")) {
                stack.push(word);
            } else {
                System.out.println(stack.pop());
            }
        }
    }
}