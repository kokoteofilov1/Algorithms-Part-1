package StacksAndQueues;

import java.util.Scanner;

public class ResizingArrayStackOfStrings {

    private String[] stringArray;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        stringArray = new String[1];
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = stringArray[i];
        }

        stringArray = copy;
    }

    public void push(String item) {
        if (N == stringArray.length) {
            resize(stringArray.length * 2);
        }

        stringArray[N++] = item;
    }

    public String pop() {
        String value = stringArray[--N];
        stringArray[N] = null;

        if (N > 0 && N == stringArray.length / 4) {
            resize(stringArray.length / 2);
        }

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