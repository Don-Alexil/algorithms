package ro.alexil.algorithms.fastslow.a03;

import ro.alexil.algorithms.utils.LinkedList;
import ro.alexil.algorithms.utils.LinkedListNode;
import ro.alexil.algorithms.utils.PrintList;

public class MiddleNode {

    public static LinkedListNode middleNode(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = next(head);
        while(fast != null) {
            fast = next(next(fast));
            slow = next(slow);
        }
        return slow;
    }

    private static LinkedListNode next(LinkedListNode node) {
        return node != null ? node.next : null;
    }

    public static void main(String[] args) {
        int[][] input = {
                {}, {16 }, {3, 4, 7}, {1, 2, 3, 7}
        };

        for(int i = 0; i < input.length; i++) {
            LinkedListNode<Integer> current = LinkedList.createLinkedList(input[i]);
            System.out.print("The Middle of the list: ");
            PrintList.printListWithForwardArrow(current);
            LinkedListNode middleNode = middleNode(current);
            System.out.println(" is " + ((middleNode != null) ? middleNode.data : null));
        }
    }
}
