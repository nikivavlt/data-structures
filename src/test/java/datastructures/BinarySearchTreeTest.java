package datastructures;

import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<>();
    }

    @Test
    void testNewTreeIsEmpty() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
    }

    @Test
    void testInsertSingleElement() {
        tree.insert(50);
        
        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());
        assertTrue(tree.search(50));
    }

    @Test
    void testInsertMultipleElements() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        
        assertEquals(5, tree.size());
        assertTrue(tree.search(50));
        assertTrue(tree.search(30));
        assertTrue(tree.search(70));
        assertTrue(tree.search(20));
        assertTrue(tree.search(40));
    }

    @Test
    void testInsertDuplicateDoesNotIncrementSize() {
        tree.insert(50);
        tree.insert(50);
        
        assertEquals(1, tree.size());
    }

    @Test
    void testSearch() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        
        assertTrue(tree.search(50));
        assertTrue(tree.search(30));
        assertTrue(tree.search(70));
        assertFalse(tree.search(40));
        assertFalse(tree.search(100));
    }

    @Test
    void testSearchEmptyTree() {
        assertFalse(tree.search(50));
    }

    @Test
    void testFindMin() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        
        assertEquals(20, tree.findMin());
    }

    @Test
    void testFindMinSingleElement() {
        tree.insert(50);
        assertEquals(50, tree.findMin());
    }

    @Test
    void testFindMinEmptyTree() {
        assertNull(tree.findMin());
    }

    @Test
    void testFindMax() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(80);
        
        assertEquals(80, tree.findMax());
    }

    @Test
    void testFindMaxSingleElement() {
        tree.insert(50);
        assertEquals(50, tree.findMax());
    }

    @Test
    void testFindMaxEmptyTree() {
        assertNull(tree.findMax());
    }

    @Test
    void testRemoveLeafNode() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        
        tree.remove(20);
        
        assertEquals(3, tree.size());
        assertFalse(tree.search(20));
        assertTrue(tree.search(30));
    }

    @Test
    void testRemoveNodeWithOneChild() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        
        tree.remove(30);
        
        assertEquals(2, tree.size());
        assertFalse(tree.search(30));
        assertTrue(tree.search(20));
        assertTrue(tree.search(50));
    }

    @Test
    void testRemoveNodeWithTwoChildren() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        
        tree.remove(30);
        
        assertEquals(6, tree.size());
        assertFalse(tree.search(30));
        assertTrue(tree.search(40));
        assertTrue(tree.search(20));
    }

    @Test
    void testRemoveRoot() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        
        tree.remove(50);
        
        assertEquals(2, tree.size());
        assertFalse(tree.search(50));
        assertTrue(tree.search(30));
        assertTrue(tree.search(70));
    }

    @Test
    void testRemoveNonExistentElement() {
        tree.insert(50);
        int sizeBefore = tree.size();
        
        tree.remove(100);
        
        assertEquals(sizeBefore, tree.size());
    }

    @Test
    void testInOrderTraversal() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        
        List<Integer> result = tree.inOrder();
        
        assertEquals(List.of(20, 30, 40, 50, 60, 70, 80), result);
    }

    @Test
    void testInOrderEmptyTree() {
        List<Integer> result = tree.inOrder();
        assertTrue(result.isEmpty());
    }

    @Test
    void testHeight() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        
        assertEquals(2, tree.height());
    }

    @Test
    void testHeightSingleNode() {
        tree.insert(50);
        assertEquals(0, tree.height());
    }

    @Test
    void testHeightEmptyTree() {
        assertEquals(-1, tree.height());
    }

    @Test
    void testHeightUnbalancedTree() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        
        assertEquals(3, tree.height());
    }

    @Test
    void testComplexScenario() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        
        assertEquals(7, tree.size());
        assertEquals(2, tree.height());
        assertEquals(20, tree.findMin());
        assertEquals(80, tree.findMax());
        
        tree.remove(20);
        tree.remove(30);
        tree.remove(50);
        
        assertEquals(4, tree.size());
        assertEquals(List.of(40, 60, 70, 80), tree.inOrder());
    }

    @Test
    void testWithStringType() {
        BinarySearchTree<String> stringTree = new BinarySearchTree<>();
        
        stringTree.insert("dog");
        stringTree.insert("cat");
        stringTree.insert("elephant");
        stringTree.insert("ant");
        
        assertTrue(stringTree.search("cat"));
        assertEquals("ant", stringTree.findMin());
        assertEquals("elephant", stringTree.findMax());
        assertEquals(List.of("ant", "cat", "dog", "elephant"), stringTree.inOrder());
    }
}
