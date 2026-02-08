package datastructures;

import java.util.NoSuchElementException;

public class Stack<T> {
    private Node<T> head;
    private int size;

    public Stack() {
        head = null;
        size = 0;
    }

    public void push(T data) {
        Node<T> newItem = new Node<T>(data);
        newItem.next = head;
        head = newItem;
        size += 1;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        else {
            T removedItemData = head.data;
            head = head.next;
            size -= 1;

            return removedItemData;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}