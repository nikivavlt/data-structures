package datastructures;

import org.junit.jupiter.api.*;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void testNewListIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testAddElements() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void testAddAtIndex() {
        list.add("A");
        list.add("C");
        list.add(1, "B");
        
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void testAddAtBeginning() {
        list.add("B");
        list.add("C");
        list.add(0, "A");
        
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void testAddAtEnd() {
        list.add("A");
        list.add("B");
        list.add(2, "C");
        
        assertEquals("C", list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void testRemoveByIndex() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    void testRemoveFirst() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        assertEquals("A", list.remove(0));
        assertEquals("B", list.get(0));
    }

    @Test
    void testRemoveLast() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        assertEquals("C", list.remove(2));
        assertEquals(2, list.size());
        assertEquals("B", list.get(1));
    }

    @Test
    void testRemoveByValue() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        assertTrue(list.remove("B"));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
        
        assertFalse(list.remove("D"));
    }

    @Test
    void testGet() {
        list.add("First");
        list.add("Second");
        list.add("Third");
        
        assertEquals("First", list.get(0));
        assertEquals("Second", list.get(1));
        assertEquals("Third", list.get(2));
    }

    @Test
    void testSet() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        list.set(1, "X");
        
        assertEquals("X", list.get(1));
        assertEquals(3, list.size());
    }

    @Test
    void testIndexOf() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        assertEquals(0, list.indexOf("A"));
        assertEquals(1, list.indexOf("B"));
        assertEquals(2, list.indexOf("C"));
        assertEquals(-1, list.indexOf("D"));
    }

    @Test
    void testIndexOfNull() {
        list.add("A");
        list.add(null);
        list.add("C");
        
        assertEquals(1, list.indexOf(null));
    }

    @Test
    void testGetThrowsIndexOutOfBounds() {
        list.add("A");
        
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void testAddThrowsIndexOutOfBounds() {
        list.add("A");
        
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "B"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2, "B"));
    }

    @Test
    void testRemoveThrowsIndexOutOfBounds() {
        list.add("A");
        
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void testSetThrowsIndexOutOfBounds() {
        list.add("A");
        
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, "B"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, "B"));
    }

    @Test
    void testIterator() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        Iterator<String> iterator = list.iterator();
        
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testForEachLoop() {
        list.add("A");
        list.add("B");
        list.add("C");
        
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item);
        }
        
        assertEquals("ABC", sb.toString());
    }

    @Test
    void testRemoveOnlyElement() {
        list.add("Only");
        
        assertEquals("Only", list.remove(0));
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testAddToEmptyListAtIndexZero() {
        list.add(0, "First");
        
        assertEquals("First", list.get(0));
        assertEquals(1, list.size());
    }
}
