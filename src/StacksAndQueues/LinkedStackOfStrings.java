package StacksAndQueues;

import java.util.Scanner;

public class LinkedStackOfStrings {
    private Node first = null;

    private class Node {
        private String value;
        private Node next;
    }

    public boolean isEmpty() {
        return (first.value == null);
    }

    public void push(String value) {
        Node oldFirst = first;
        first = new Node();
        first.value = value;
        first.next = oldFirst;
    }

    public String pop() {
        String value = first.value;
        if (first.next == null) {
            return "Stack is empty!";
        }
        first = first.next;
        return value;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");

        LinkedStackOfStrings stack = new LinkedStackOfStrings();

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