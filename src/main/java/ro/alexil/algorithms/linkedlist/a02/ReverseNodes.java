package ro.alexil.algorithms.linkedlist.a02;

import ro.alexil.algorithms.utils.LinkedList;
import ro.alexil.algorithms.utils.LinkedListNode;
import ro.alexil.algorithms.utils.PrintList;

public class ReverseNodes {

    public static LinkedListNode reverseEven(LinkedListNode head) {
        LinkedListNode prev = head;
        int groupLen = 2;
        LinkedListNode node = head;
        while (prev.next != null) {
            // advance in the group
            int numNodes = 0;
            for(int i = 0; i < groupLen; i++) {
                if(node.next == null) {
                    break;
                }
                node = node.next;
                numNodes++;
            }

            // check if even number
            if(numNodes % 2 == 0) {
                // reverse the nodes
                LinkedListNode curr = prev.next;
                LinkedListNode prevNext = node.next;
                node = curr;
                for (int i =1; i < numNodes; i++) {
                    LinkedListNode next = curr.next;
                    curr.next = prevNext;
                    prevNext = curr;
                    curr = next;
                }
                curr.next = prevNext;
                prev.next = curr;
            }
            prev = node;
            groupLen++;
        }
        return head;
    }

    public static void main(String[] args) {

        int[][] input = {
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4},
                {28, 21, 14, 7},
                {11, 12, 13, 14, 15},
                {1, 2}
        };

        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<>();
            inputLinkedList.createLinkedList(input[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            System.out.print("\n");
            LinkedListNode head = reverseEven(inputLinkedList.head);
            System.out.print("\n\tReversed even for linked list: ");
            PrintList.printListWithForwardArrow(head);
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
