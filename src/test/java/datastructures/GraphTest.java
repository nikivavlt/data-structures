package datastructures;

import org.junit.jupiter.api.*;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    
    @Nested
    class UndirectedGraphTests {
        private Graph<String> graph;

        @BeforeEach
        void setUp() {
            graph = new Graph<>(false);
        }

        @Test
        void testNewGraphIsEmpty() {
            assertEquals(0, graph.getVertexCount());
            assertEquals(0, graph.getEdgeCount());
        }

        @Test
        void testAddVertex() {
            graph.addVertex("A");
            
            assertEquals(1, graph.getVertexCount());
            assertTrue(graph.hasVertex("A"));
        }

        @Test
        void testAddDuplicateVertex() {
            graph.addVertex("A");
            graph.addVertex("A");
            
            assertEquals(1, graph.getVertexCount());
        }

        @Test
        void testAddEdge() {
            graph.addEdge("A", "B");
            
            assertEquals(2, graph.getVertexCount());
            assertEquals(1, graph.getEdgeCount());
            assertTrue(graph.hasEdge("A", "B"));
            assertTrue(graph.hasEdge("B", "A"));
        }

        @Test
        void testAddMultipleEdges() {
            graph.addEdge("A", "B");
            graph.addEdge("B", "C");
            graph.addEdge("C", "D");
            graph.addEdge("A", "C");
            
            assertEquals(4, graph.getVertexCount());
            assertEquals(4, graph.getEdgeCount());
        }

        @Test
        void testGetNeighbours() {
            graph.addEdge("A", "B");
            graph.addEdge("A", "C");
            graph.addEdge("A", "D");
            
            Set<String> neighbors = graph.getNeighbours("A");
            
            assertEquals(3, neighbors.size());
            assertTrue(neighbors.contains("B"));
            assertTrue(neighbors.contains("C"));
            assertTrue(neighbors.contains("D"));
        }

        @Test
        void testGetNeighboursNonExistentVertex() {
            Set<String> neighbors = graph.getNeighbours("X");
            
            assertTrue(neighbors.isEmpty());
        }

        @Test
        void testRemoveEdge() {
            graph.addEdge("A", "B");
            graph.addEdge("B", "C");
            
            assertTrue(graph.removeEdge("A", "B"));
            
            assertEquals(1, graph.getEdgeCount());
            assertFalse(graph.hasEdge("A", "B"));
            assertFalse(graph.hasEdge("B", "A"));
            assertTrue(graph.hasEdge("B", "C"));
        }

        @Test
        void testRemoveNonExistentEdge() {
            graph.addEdge("A", "B");
            
            assertFalse(graph.removeEdge("A", "C"));
            assertEquals(1, graph.getEdgeCount());
        }

        @Test
        void testRemoveVertex() {
            graph.addEdge("A", "B");
            graph.addEdge("B", "C");
            graph.addEdge("C", "D");
            graph.addEdge("A", "C");
            
            assertTrue(graph.removeVertex("C"));
            
            assertEquals(3, graph.getVertexCount());
            assertEquals(1, graph.getEdgeCount());
            assertFalse(graph.hasVertex("C"));
            assertFalse(graph.hasEdge("A", "C"));
            assertFalse(graph.hasEdge("B", "C"));
            assertFalse(graph.hasEdge("C", "D"));
            assertTrue(graph.hasEdge("A", "B"));
        }

        @Test
        void testRemoveNonExistentVertex() {
            graph.addEdge("A", "B");
            
            assertFalse(graph.removeVertex("X"));
            assertEquals(2, graph.getVertexCount());
        }

        @Test
        void testComplexScenario() {
            graph.addEdge("A", "B");
            graph.addEdge("A", "C");
            graph.addEdge("B", "C");
            graph.addEdge("B", "D");
            graph.addEdge("C", "D");
            
            assertEquals(4, graph.getVertexCount());
            assertEquals(5, graph.getEdgeCount());
            
            graph.removeVertex("B");
            
            assertEquals(3, graph.getVertexCount());
            assertEquals(2, graph.getEdgeCount());
            assertTrue(graph.hasEdge("A", "C"));
            assertTrue(graph.hasEdge("C", "D"));
            assertFalse(graph.hasEdge("A", "B"));
            assertFalse(graph.hasEdge("B", "D"));
        }
    }

    @Nested
    class DirectedGraphTests {
        private Graph<String> graph;

        @BeforeEach
        void setUp() {
            graph = new Graph<>(true);
        }

        @Test
        void testNewGraphIsEmpty() {
            assertEquals(0, graph.getVertexCount());
            assertEquals(0, graph.getEdgeCount());
        }

        @Test
        void testAddEdge() {
            graph.addEdge("A", "B");
            
            assertEquals(2, graph.getVertexCount());
            assertEquals(1, graph.getEdgeCount());
            assertTrue(graph.hasEdge("A", "B"));
            assertFalse(graph.hasEdge("B", "A"));
        }

        @Test
        void testAddMultipleEdges() {
            graph.addEdge("A", "B");
            graph.addEdge("B", "C");
            graph.addEdge("D", "C");
            graph.addEdge("C", "A");
            
            assertEquals(4, graph.getVertexCount());
            assertEquals(4, graph.getEdgeCount());
        }

        @Test
        void testGetNeighbours() {
            graph.addEdge("A", "B");
            graph.addEdge("A", "C");
            graph.addEdge("B", "A");
            
            Set<String> neighborsA = graph.getNeighbours("A");
            Set<String> neighborsB = graph.getNeighbours("B");
            
            assertEquals(2, neighborsA.size());
            assertTrue(neighborsA.contains("B"));
            assertTrue(neighborsA.contains("C"));
            
            assertEquals(1, neighborsB.size());
            assertTrue(neighborsB.contains("A"));
        }

        @Test
        void testRemoveEdge() {
            graph.addEdge("A", "B");
            graph.addEdge("B", "A");
            
            assertTrue(graph.removeEdge("A", "B"));
            
            assertEquals(1, graph.getEdgeCount());
            assertFalse(graph.hasEdge("A", "B"));
            assertTrue(graph.hasEdge("B", "A"));
        }

        @Test
        void testRemoveVertex() {
            graph.addEdge("A", "B");
            graph.addEdge("B", "C");
            graph.addEdge("D", "C");
            graph.addEdge("C", "A");
            
            assertTrue(graph.removeVertex("C"));
            
            assertEquals(3, graph.getVertexCount());
            assertEquals(1, graph.getEdgeCount());
            assertFalse(graph.hasVertex("C"));
            assertFalse(graph.hasEdge("B", "C"));
            assertFalse(graph.hasEdge("D", "C"));
            assertFalse(graph.hasEdge("C", "A"));
            assertTrue(graph.hasEdge("A", "B"));
        }

        @Test
        void testCyclicGraph() {
            graph.addEdge("A", "B");
            graph.addEdge("B", "C");
            graph.addEdge("C", "A");
            
            assertTrue(graph.hasEdge("A", "B"));
            assertTrue(graph.hasEdge("B", "C"));
            assertTrue(graph.hasEdge("C", "A"));
            assertFalse(graph.hasEdge("B", "A"));
        }

        @Test
        void testSelfLoop() {
            graph.addEdge("A", "A");
            
            assertEquals(1, graph.getVertexCount());
            assertEquals(1, graph.getEdgeCount());
            assertTrue(graph.hasEdge("A", "A"));
        }
    }

    @Test
    void testGraphWithIntegerVertices() {
        Graph<Integer> intGraph = new Graph<>(false);
        
        intGraph.addEdge(1, 2);
        intGraph.addEdge(2, 3);
        intGraph.addEdge(3, 4);
        
        assertEquals(4, intGraph.getVertexCount());
        assertTrue(intGraph.hasEdge(1, 2));
        assertTrue(intGraph.hasEdge(3, 4));
        
        intGraph.removeVertex(2);
        
        assertEquals(3, intGraph.getVertexCount());
        assertFalse(intGraph.hasEdge(1, 2));
        assertTrue(intGraph.hasEdge(3, 4));
    }
}
