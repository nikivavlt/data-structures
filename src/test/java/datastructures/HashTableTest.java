package datastructures;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    private HashTable<String, Integer> table;

    @BeforeEach
    void setUp() {
        table = new HashTable<>();
    }

    @Test
    void testNewTableIsEmpty() {
        assertTrue(table.isEmpty());
        assertEquals(0, table.size());
        assertEquals(16, table.getCapacity());
    }

    @Test
    void testPutAndGet() {
        table.put("apple", 5);
        
        assertEquals(5, table.get("apple"));
        assertEquals(1, table.size());
        assertFalse(table.isEmpty());
    }

    @Test
    void testPutMultipleEntries() {
        table.put("apple", 5);
        table.put("banana", 7);
        table.put("cherry", 9);
        
        assertEquals(3, table.size());
        assertEquals(5, table.get("apple"));
        assertEquals(7, table.get("banana"));
        assertEquals(9, table.get("cherry"));
    }

    @Test
    void testPutUpdateExistingKey() {
        table.put("apple", 5);
        table.put("apple", 10);
        
        assertEquals(10, table.get("apple"));
        assertEquals(1, table.size());
    }

    @Test
    void testGetNonExistentKey() {
        assertNull(table.get("nonexistent"));
    }

    @Test
    void testContainsKey() {
        table.put("apple", 5);
        table.put("banana", 7);
        
        assertTrue(table.containsKey("apple"));
        assertTrue(table.containsKey("banana"));
        assertFalse(table.containsKey("cherry"));
    }

    @Test
    void testRemove() {
        table.put("apple", 5);
        table.put("banana", 7);
        table.put("cherry", 9);
        
        assertEquals(7, table.remove("banana"));
        assertEquals(2, table.size());
        assertFalse(table.containsKey("banana"));
        assertNull(table.get("banana"));
    }

    @Test
    void testRemoveNonExistentKey() {
        table.put("apple", 5);
        
        assertNull(table.remove("banana"));
        assertEquals(1, table.size());
    }

    @Test
    void testResize() {
        HashTable<String, Integer> smallTable = new HashTable<>(4);
        
        assertEquals(4, smallTable.getCapacity());
        
        smallTable.put("apple", 5);
        smallTable.put("banana", 7);
        smallTable.put("cherry", 9);
        
        assertEquals(4, smallTable.getCapacity());
        
        smallTable.put("date", 11); // This triggers resize
        
        assertEquals(8, smallTable.getCapacity());
        assertEquals(4, smallTable.size());
        
        // Verify all entries still accessible after resize
        assertEquals(5, smallTable.get("apple"));
        assertEquals(7, smallTable.get("banana"));
        assertEquals(9, smallTable.get("cherry"));
        assertEquals(11, smallTable.get("date"));
    }

    @Test
    void testMultipleResizes() {
        HashTable<String, Integer> smallTable = new HashTable<>(2);
        
        for (int i = 0; i < 10; i++) {
            smallTable.put("key" + i, i);
        }
        
        assertEquals(10, smallTable.size());
        assertTrue(smallTable.getCapacity() >= 8);
        
        for (int i = 0; i < 10; i++) {
            assertEquals(i, smallTable.get("key" + i));
        }
    }

    @Test
    void testCollisionHandling() {
        HashTable<String, Integer> smallTable = new HashTable<>(2);
        
        // Force collisions with small capacity
        smallTable.put("a", 1);
        smallTable.put("b", 2);
        smallTable.put("c", 3);
        
        assertEquals(1, smallTable.get("a"));
        assertEquals(2, smallTable.get("b"));
        assertEquals(3, smallTable.get("c"));
    }

    @Test
    void testPutNullValue() {
        table.put("key", null);
        
        assertTrue(table.containsKey("key"));
        assertNull(table.get("key"));
        assertEquals(1, table.size());
    }

    @Test
    void testRemoveAndReAdd() {
        table.put("apple", 5);
        table.remove("apple");
        table.put("apple", 10);
        
        assertEquals(10, table.get("apple"));
        assertEquals(1, table.size());
    }

    @Test
    void testWithDifferentTypes() {
        HashTable<Integer, String> intTable = new HashTable<>();
        
        intTable.put(1, "one");
        intTable.put(2, "two");
        intTable.put(3, "three");
        
        assertEquals("one", intTable.get(1));
        assertEquals("two", intTable.get(2));
        assertEquals("three", intTable.get(3));
        assertEquals(3, intTable.size());
    }

    @Test
    void testComplexScenario() {
        table.put("apple", 5);
        table.put("banana", 7);
        table.put("cherry", 9);
        table.put("date", 11);
        
        assertEquals(4, table.size());
        
        table.put("banana", 15);
        assertEquals(4, table.size());
        assertEquals(15, table.get("banana"));
        
        table.remove("cherry");
        assertEquals(3, table.size());
        assertFalse(table.containsKey("cherry"));
        
        table.put("elderberry", 13);
        assertEquals(4, table.size());
        assertTrue(table.containsKey("elderberry"));
    }

    @Test
    void testEmptyTableOperations() {
        assertNull(table.get("key"));
        assertFalse(table.containsKey("key"));
        assertNull(table.remove("key"));
        assertTrue(table.isEmpty());
    }

    @Test
    void testSizeAfterOperations() {
        assertEquals(0, table.size());
        
        table.put("a", 1);
        assertEquals(1, table.size());
        
        table.put("b", 2);
        assertEquals(2, table.size());
        
        table.put("a", 3);
        assertEquals(2, table.size());
        
        table.remove("a");
        assertEquals(1, table.size());
        
        table.remove("b");
        assertEquals(0, table.size());
        assertTrue(table.isEmpty());
    }

    @Test
    void testLoadFactorThreshold() {
        HashTable<String, Integer> smallTable = new HashTable<>(4);
        
        smallTable.put("key1", 1);
        smallTable.put("key2", 2);
        smallTable.put("key3", 3);
        
        assertEquals(4, smallTable.getCapacity());
        
        // Adding 4th element exceeds 0.75 load factor
        smallTable.put("key4", 4);
        
        assertEquals(8, smallTable.getCapacity());
    }
}
