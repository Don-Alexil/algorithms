package ro.alexil.algorithms.linkedlist.a01;

import ro.alexil.algorithms.utils.LinkedList;
import ro.alexil.algorithms.utils.LinkedListNode;
import ro.alexil.algorithms.utils.PrintList;

public class ReverseLinkedList {

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> next;
        LinkedListNode<Integer> curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }

    public static void main(String[] args) {

        int[][] input = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6},
                {3, 2, 1},
                {10},
                {1, 2}
        };

        for (int i = 0; i < input.length; i++) {
            LinkedListNode<Integer> inputLinkedList = LinkedList.createLinkedList(input[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList.printListWithForwardArrow(inputLinkedList);
            System.out.print("\n\tReversed linked list: ");
            PrintList.printListWithForwardArrow(reverse(inputLinkedList));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
