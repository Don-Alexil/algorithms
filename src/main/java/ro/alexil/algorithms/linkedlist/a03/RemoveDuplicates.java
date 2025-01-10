package ro.alexil.algorithms.linkedlist.a03;

import ro.alexil.algorithms.utils.LinkedList;
import ro.alexil.algorithms.utils.LinkedListNode;
import ro.alexil.algorithms.utils.PrintList;

public class RemoveDuplicates {

    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> curr = head;
        while(curr != null && curr.next != null) {
            if(curr.data.equals(curr.next.data)) {
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 2, 3, 3, 3},
                {-21, -21, -21, -21, -21, -21, -21},
                {3, 7, 9},
                {-100, -100, -100, -10, -10, 0, 10, 10, 100, 100, 100},
                {-77, -77, -7, -7, -7, -7, 7, 7, 7, 7, 77, 77, 77, 77}
        };

        for(int i=0; i < inputs.length; i++) {
            var input = LinkedList.createLinkedList(inputs[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList.printListWithForwardArrow(input);
            System.out.print("\n");
            LinkedListNode head = removeDuplicates(input);
            System.out.print("\n\tList with removed duplicates: ");
            PrintList.printListWithForwardArrow(head);
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

}
