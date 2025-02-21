package ro.alexil.algorithms.utils;

// Template for printing the linked list with forward arrows
public class PrintList {

    public static void printListWithForwardArrow(LinkedListNode head) {
        printListWithForwardArrowLoop(head);
        // if this is the last node, print null at the end
        System.out.print(" → null ");
    }

    public static void printCircularList(LinkedListNode head) {
        if(head == null) {
            System.out.print("↓");
            return;
        }
        LinkedListNode temp = head;

        while (temp.next != head) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            System.out.print(" → ");
        }
        System.out.print(temp.data);
        System.out.print(" ↓");
    }


    public static void printListWithForwardArrowLoop(LinkedListNode head) {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
    }


}