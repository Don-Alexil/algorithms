package ro.alexil.algorithms.utils;

public class LinkedList {
    // constructor will be used to make a LinkedList type object
    private LinkedList() {

    }
    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    private static <Q> LinkedListNode<Q> insertNodeAtHead(LinkedListNode<Q> head, LinkedListNode<Q> node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        return head;
    }
    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertNodeAtHead method.
    public static LinkedListNode<Integer> createLinkedList(int[] lst) {
        LinkedListNode<Integer> head = null;
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(lst[i]);
            head = insertNodeAtHead(head, newNode);
        }
        return head;
    }

    // returns the node at the specified position(index) of the linked list
    public static <Q> LinkedListNode<Q> getNode(LinkedListNode<Q> head, int pos) {
        LinkedListNode<Q> ptr = head;
        if (pos != -1){
            int p = 0;

            while (p < pos){
                ptr = ptr.next;
                p += 1;
            }

            return ptr;
        }
        return ptr;
    }

    // returns the number of nodes in the linked list
    public static <Q> int getLength(LinkedListNode<Q> head) {
        LinkedListNode<Q> temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static LinkedListNode<Integer> createCircularLinkedList(int[] ints) {
        if(ints == null || ints.length == 0) {
            return null;
        }
        LinkedListNode<Integer> tail = new LinkedListNode<>(ints[ints.length-1]);
        LinkedListNode<Integer> head = tail;
        for (int i = ints.length - 2; i >= 0; i--) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(ints[i]);
            head = insertNodeAtHead(head, newNode);
        }
        tail.next = head;
        return head;
    }
}