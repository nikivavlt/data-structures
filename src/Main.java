import datastructures.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Queue<String> q = new Queue<String>();
//
//        System.out.println("Empty? " + q.isEmpty());  // true
//
//        q.add("First");
//        q.add("Second");
//        q.add("Third");
//
//        System.out.println("Size: " + q.size());      // 3
//        System.out.println("Peek: " + q.peek());      // First
//        System.out.println("Remove: " + q.remove());  // First
//        System.out.println("Remove: " + q.remove());  // Second
//        System.out.println("Size: " + q.size());      // 1
//        System.out.println("Remove: " + q.remove());  // Third
//        System.out.println("Empty? " + q.isEmpty());  // true
//
//        Stack<String> s = new Stack<String>();
//
//        System.out.println("Empty? " + s.isEmpty());  // true
//
//        s.push("First");
//        s.push("Second");
//        s.push("Third");
//
//        System.out.println("Size: " + s.size());      // 3
//        System.out.println("Peek: " + s.peek());      // Third
//        System.out.println("Pop: " + s.pop());        // Third
//        System.out.println("Pop: " + s.pop());        // Second
//        System.out.println("Size: " + s.size());      // 1
//        System.out.println("Pop: " + s.pop());        // First
//        System.out.println("Empty? " + s.isEmpty());  // true

//        LinkedList<String> list = new LinkedList<>();
//        list.add("A");
//        list.add("C");
//        list.add(1, "B");
//        System.out.println(list.get(1));  // "B"
//        list.remove(1);
//        System.out.println(list.indexOf("C"));  // 1

//        Graph<String> graph = new Graph<>(false);
//        graph.addEdge("A", "B");
//        graph.addEdge("B", "C");
//        graph.addEdge("C", "D");
//        graph.addEdge("A", "C");
//        System.out.println(graph.getVertexCount());  // 4
//        System.out.println(graph.getEdgeCount());    // 4
//        System.out.println(graph.removeVertex("C"));  // true
//        System.out.println(graph.getVertexCount());  // 3
//        System.out.println(graph.getEdgeCount());    // 1
//        System.out.println(graph.hasEdge("A", "C"));  // false
//        System.out.println(graph.hasEdge("B", "C"));  // false
//        System.out.println(graph.hasEdge("C", "D"));  // false
//        System.out.println(graph.hasEdge("A", "B"));  // true

//        Graph<String> dirGraph = new Graph<>(true);
//
//        dirGraph.addEdge("A", "B");
//        dirGraph.addEdge("B", "C");
//        dirGraph.addEdge("D", "C");
//        dirGraph.addEdge("C", "A");
//        System.out.println(dirGraph.removeVertex("C"));  // true
//        System.out.println(dirGraph.hasEdge("B", "C"));  // false
//        System.out.println(dirGraph.hasEdge("D", "C"));  // false
//        System.out.println(dirGraph.hasEdge("C", "A"));  // false
//        System.out.println(dirGraph.hasEdge("A", "B"));  // true
//
//        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
//
//        System.out.println("Empty? " + tree.isEmpty());  // true
//        System.out.println("Size: " + tree.size());      // 0
//
//        tree.insert(50);
//        tree.insert(30);
//        tree.insert(70);
//        tree.insert(20);
//        tree.insert(40);
//        tree.insert(60);
//        tree.insert(80);
//
//        /*
//               50
//              /  \
//            30    70
//           /  \   / \
//          20  40 60  80
//        */
//
//        System.out.println("Size: " + tree.size());           // 7
//        System.out.println("Height: " + tree.height());       // 2
//        System.out.println("Min: " + tree.findMin());         // 20
//        System.out.println("Max: " + tree.findMax());         // 80
//        System.out.println("Search 40: " + tree.search(40));  // true
//        System.out.println("Search 25: " + tree.search(25));  // false
//        System.out.println("InOrder: " + tree.inOrder());
//        // [20, 30, 40, 50, 60, 70, 80]
//
//        tree.remove(20);  // Remove leaf
//        System.out.println("After remove(20): " + tree.inOrder());
//        // [30, 40, 50, 60, 70, 80]
//
//        tree.remove(30);  // Remove node with two children
//        System.out.println("After remove(30): " + tree.inOrder());
//        // [40, 50, 60, 70, 80]
//
//        tree.remove(50);  // Remove root
//        System.out.println("After remove(50): " + tree.inOrder());
//        // [40, 60, 70, 80]
//
//        System.out.println("Final size: " + tree.size());  // 4

        HashTable<String, Integer> table = new HashTable<>(4);

        System.out.println("Initial capacity: " + table.getCapacity());  // 4

        // Add entries to trigger resize
        table.put("apple", 5);
        table.put("banana", 7);
        table.put("cherry", 9);

        System.out.println("Before resize - Size: " + table.size());  // 3
        System.out.println("Before resize - Capacity: " + table.getCapacity());  // 4

        table.put("date", 11);  // This triggers resize (load factor > 0.75)

        System.out.println("After resize - Size: " + table.size());  // 4
        System.out.println("After resize - Capacity: " + table.getCapacity());  // 8

        // Verify all entries still accessible after resize
        System.out.println("Get apple: " + table.get("apple"));    // 5 ✓
        System.out.println("Get banana: " + table.get("banana"));  // 7 ✓
        System.out.println("Get cherry: " + table.get("cherry"));  // 9 ✓
        System.out.println("Get date: " + table.get("date"));      // 11 ✓


        // TODO: Implement tests
    }
}