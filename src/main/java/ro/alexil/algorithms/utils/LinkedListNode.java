package ro.alexil.algorithms.utils;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // LinkedListNode() will be used to make a LinkedListNode type object.
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "(D:" + data + ", N:" + (next == null? "None" : next.data) + ")";
    }
}