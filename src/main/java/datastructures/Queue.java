package datastructures;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> newItem = new Node<T>(data);

        if (isEmpty()) {
            head = newItem;
        } else {
            tail.next = newItem;
        }
        tail = newItem;
        size += 1;
    }

    public T remove() {
        if (isEmpty()) {
          throw new NoSuchElementException("Queue is empty");
        }
        else {
            T removedItemData = head.data;
            head = head.next;
            size -= 1;

            if (head == null) {
                tail = null;
            }

            return removedItemData;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
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
