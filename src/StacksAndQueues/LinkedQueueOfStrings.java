package StacksAndQueues;

import java.util.Scanner;

public class LinkedQueueOfStrings {
    private Node first = null;
    private Node last = null;

    private class Node {
        private String value;
        private Node next;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void enqueue(String value) {
        Node oldLast = last;
        last = new Node();
        last.value = value;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public String dequeue() {
        String value = first.value;

        if (first.next == null) {
            return "Queue is empty!";
        }
        first = first.next;

        if (isEmpty()) {
            last = null;
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");

        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();

        for (int i = 0; i < input.length; i++) {
            String word = input[i];
            if (!word.equals("-")) {
                queue.enqueue(word);
            } else {
                System.out.println(queue.dequeue());
            }
        }
    }
}