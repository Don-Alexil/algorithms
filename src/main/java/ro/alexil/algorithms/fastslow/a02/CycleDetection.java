package ro.alexil.algorithms.fastslow.a02;

import ro.alexil.algorithms.utils.LinkedList;
import ro.alexil.algorithms.utils.LinkedListNode;
import ro.alexil.algorithms.utils.PrintList;

public class CycleDetection {

    public static boolean detectCycle(LinkedListNode head) {
        if (head == null) {
            return false;
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head.next;

        while(fast != null) {
            if(slow.equals(fast)) {
                return true;
            }
            slow = nextSlow(slow);
            fast = nextFast(fast);
        }
        // Replace this placeholder return statement with your code
        return false;
    }

    private static  LinkedListNode nextSlow(LinkedListNode slow) {
        if(slow != null) {
            return slow.next;
        }
        return null;
    }

    private static  LinkedListNode nextFast(LinkedListNode fast) {
        return nextSlow(nextSlow(fast));
    }

    public static void main(String[] args) {
        int[][] input = { { 2, 4, 6, 8, 10, 12 }, { 1, 3, 5, 7, 9, 11 },
                { 0, 1, 2, 3, 4, 6 }, { 3, 4, 7, 9, 11, 17 }, { 5, 1, 4, 9, 2, 3 } };
        int[] pos = { 0, -1, 1, -1, 2 };
        for (int i = 0; i < input.length; i++) {
            LinkedListNode<Integer> list = LinkedList.createLinkedList(input[i]);
            System.out.print(i + 1 + ".\tInput:");
            System.out.print("\t");
            if (pos[i] == -1) {
                PrintList.printListWithForwardArrow(list);
            } else {
                PrintList.printListWithForwardArrowLoop(list);
            }
            System.out.println("\n\tpos: " + pos[i]);

            if (pos[i] != -1) {
                int length = LinkedList.getLength(list);
                LinkedListNode lastNode = LinkedList.getNode(list, length - 1);
                lastNode.next = LinkedList.getNode(list, pos[i]);
            }
            System.out.println("\n\tDetected Cycle =  " + detectCycle(list));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
