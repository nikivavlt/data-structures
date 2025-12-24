package Queue;

import java.util.NoSuchElementException;

public class Queue<T> {
    private class Item {
        T data;
        Item next;

        Item(T data) {
            this.data = data;
            this.next = null;
        }
    }
    private Item head;
    private Item tail;
    private int size;

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data) {
        Item newItem = new Item(data);

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
        if (head == null) {
            return null;
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
