package datastructures;

import java.util.Iterator;
import java.util.Objects;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + ", Size " + size);

        Node<T> currentItem = head;

        for (int i = 0; i < index; i += 1) {
            currentItem = currentItem.next;
        }

        return currentItem;
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

    public void add(int index, T data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index " + index + ", Size " + size);

        Node<T> newItem = new Node<T>(data);

        if (index == 0) {
            if (isEmpty()) {
                tail = newItem;
            }

            newItem.next = head;
            head = newItem;
        }
        else if (index == size) {
            tail.next = newItem;
            tail = newItem;
        } else {
            Node<T> frontNode = getNode(index - 1);
            newItem.next = frontNode.next;
            frontNode.next = newItem;
        }

        size += 1;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + ", Size " + size);

        Node<T> selectedNode = getNode(index);

        if (index == 0) {
            head = head.next;

            if (head == null) {
                tail = null;
            }
        } else if (index == size - 1) {
            Node <T> frontNode = getNode(index - 1);
            frontNode.next = null;
            tail = frontNode;
        } else {
            getNode(index - 1).next = selectedNode.next;
        }

        size -= 1;
        return selectedNode.data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + ", Size " + size);
        return getNode(index).data;
    }

    public void set(int index, T data) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + ", Size " + size);
        getNode(index).data = data;
    }

    public int indexOf(T data) {
        Node<T> currentItem = head;
        int index = 0;

        while (currentItem != null) {
            if (Objects.equals(currentItem.data, data)) return index;

            currentItem = currentItem.next;
            index += 1;
        }
        return -1;
    }

    public boolean remove(T data) {
        Node<T> currentItem = head;
        int index = 0;

        while (currentItem != null) {
            if (Objects.equals(currentItem.data, data)) {
                if (index == 0) {
                   head = head.next;
                } else {
                    getNode(index - 1).next = currentItem.next;
                }

                if (currentItem.next == null) {
                    tail = (index == 0) ? null : getNode(index - 1);
                }

                size -= 1;
                return true;
            }

            currentItem = currentItem.next;
            index += 1;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
