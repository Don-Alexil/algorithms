package ro.alexil.algorithms.fastslow.a04;

import ro.alexil.algorithms.utils.LinkedList;
import ro.alexil.algorithms.utils.LinkedListNode;
import ro.alexil.algorithms.utils.Print;
import ro.alexil.algorithms.utils.PrintList;

public class SplitCircularLinkedList {

    public static LinkedListNode[] splitCircularLinkedList(LinkedListNode head) {
        if(head == null) {
            return new LinkedListNode[]{null, null};
        }
        if(head.next == head) {
            return new LinkedListNode[]{head, null};
        }
        LinkedListNode slow = head;
        LinkedListNode fast = slow;
        while (fast.next != head){
            fast = fast.next;
            if(fast.next != head) {
                fast = fast.next;
            }
            else {
                break;
            }
            slow = slow.next;
        }

        // split the column
        LinkedListNode headSecondHalf = slow.next;
        slow.next = head;
        fast.next = headSecondHalf;

        // Placeholder for actual implementation
        return new LinkedListNode[]{head, headSecondHalf}; // Return two empty lists as placeholders
    }


    public static void main(String[] args) {
        int[][] input = {
                {}, {16 }, {3, 4, 7}, {1, 2, 3, 7}, {1, 2, 3, 4, 5},  {1, 2, 3, 4, 5, 6}
        };

        for (int[] ints : input) {
            LinkedListNode<Integer> current = LinkedList.createCircularLinkedList(ints);
            System.out.print("Initial List: ");
            PrintList.printCircularList(current);
            LinkedListNode[] listHeads = splitCircularLinkedList(current);
            System.out.print("\nFirst Half: ");
            PrintList.printCircularList(listHeads[0]);
            System.out.print("\nSecond Half: ");
            PrintList.printCircularList(listHeads[1]);
            System.out.println("\n" + Print.repeat("-", 50));
        }
    }
}
