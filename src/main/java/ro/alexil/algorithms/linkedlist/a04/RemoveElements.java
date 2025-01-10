package ro.alexil.algorithms.linkedlist.a04;

import ro.alexil.algorithms.utils.LinkedList;
import ro.alexil.algorithms.utils.LinkedListNode;
import ro.alexil.algorithms.utils.PrintList;

public class RemoveElements {

    public static LinkedListNode<Integer> removeElements(LinkedListNode<Integer> head, int k) {
        var dummy = new LinkedListNode<>(0);
        dummy.next = head;

        var prev = dummy;
        var current = head;

        while(current != null) {
            if(current.data == k) {
                prev.next = current.next;
            }
            else {
                prev = current;
            }
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 2, 3, 3, 3},
                {-21, -21, -21, -21, -21, -21, -21},
                {3, 7, 9},
                {-100, -100, -100, -10, -10, 0, 10, 10, 100, 100, 100},
                {-77, -77, -7, -7, -7, -7, 7, 7, 7, 7, 77, 77, 77, 77}
        };

        int[] remove = { 3, -21, 7, 10, 7};

        for(int i=0; i < inputs.length; i++) {
            var input = LinkedList.createLinkedList(inputs[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList.printListWithForwardArrow(input);
            System.out.print("\n");
            LinkedListNode head = removeElements(input, remove[i]);
            System.out.print("\n\tList with removed duplicates: ");
            PrintList.printListWithForwardArrow(head);
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
