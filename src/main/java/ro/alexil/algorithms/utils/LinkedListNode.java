package ro.alexil.algorithms.utils;

public class LinkedListNode<T> {
    public final T data;
    public LinkedListNode<T> next;
    // LinkedListNode() will be used to make a LinkedListNode type object.
    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "(D:" + data + ", N:" + (next == null? "None" : next.data) + ")";
    }
}