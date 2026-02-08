package datastructures;

import org.junit.jupiter.api.*;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void testNewQueueIsEmpty() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void testAddSingleElement() {
        queue.add("First");
        
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals("First", queue.peek());
    }

    @Test
    void testAddMultipleElements() {
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        
        assertEquals(3, queue.size());
        assertEquals("First", queue.peek());
    }

    @Test
    void testRemoveElements() {
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        
        assertEquals("First", queue.remove());
        assertEquals(2, queue.size());
        assertEquals("Second", queue.remove());
        assertEquals(1, queue.size());
        assertEquals("Third", queue.remove());
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testPeekDoesNotRemove() {
        queue.add("Test");
        
        assertEquals("Test", queue.peek());
        assertEquals("Test", queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    void testRemoveFromEmptyQueueThrowsException() {
        assertThrows(NoSuchElementException.class, () -> queue.remove());
    }

    @Test
    void testPeekEmptyQueueThrowsException() {
        assertThrows(NoSuchElementException.class, () -> queue.peek());
    }

    @Test
    void testFIFOOrder() {
        queue.add("A");
        queue.add("B");
        queue.add("C");
        
        assertEquals("A", queue.remove());
        assertEquals("B", queue.remove());
        assertEquals("C", queue.remove());
    }

    @Test
    void testMixedOperations() {
        queue.add("First");
        queue.add("Second");
        assertEquals("First", queue.remove());
        queue.add("Third");
        assertEquals("Second", queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void testQueueWithNullValues() {
        queue.add(null);
        queue.add("NotNull");
        
        assertNull(queue.remove());
        assertEquals("NotNull", queue.remove());
    }

    @Test
    void testQueueWithIntegers() {
        Queue<Integer> intQueue = new Queue<>();
        intQueue.add(1);
        intQueue.add(2);
        intQueue.add(3);
        
        assertEquals(1, intQueue.remove());
        assertEquals(2, intQueue.remove());
        assertEquals(3, intQueue.remove());
    }
}
