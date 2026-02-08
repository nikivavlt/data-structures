package datastructures;

import org.junit.jupiter.api.*;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void testNewStackIsEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void testPushSingleElement() {
        stack.push("First");
        
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals("First", stack.peek());
    }

    @Test
    void testPushMultipleElements() {
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        
        assertEquals(3, stack.size());
        assertEquals("Third", stack.peek());
    }

    @Test
    void testPopElements() {
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        
        assertEquals("Third", stack.pop());
        assertEquals(2, stack.size());
        assertEquals("Second", stack.pop());
        assertEquals(1, stack.size());
        assertEquals("First", stack.pop());
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPeekDoesNotRemove() {
        stack.push("Test");
        
        assertEquals("Test", stack.peek());
        assertEquals("Test", stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void testPopFromEmptyStackThrowsException() {
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    void testPeekEmptyStackThrowsException() {
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    @Test
    void testLIFOOrder() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    void testMixedOperations() {
        stack.push("First");
        stack.push("Second");
        assertEquals("Second", stack.pop());
        stack.push("Third");
        assertEquals("Third", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void testStackWithNullValues() {
        stack.push(null);
        stack.push("NotNull");
        
        assertEquals("NotNull", stack.pop());
        assertNull(stack.pop());
    }

    @Test
    void testStackWithIntegers() {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        
        assertEquals(3, intStack.pop());
        assertEquals(2, intStack.pop());
        assertEquals(1, intStack.pop());
    }

    @Test
    void testPushAfterEmpty() {
        stack.push("First");
        stack.pop();
        assertTrue(stack.isEmpty());
        
        stack.push("Second");
        assertEquals("Second", stack.peek());
        assertEquals(1, stack.size());
    }
}
