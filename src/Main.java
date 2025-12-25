import datastructures.LinkedList;
import datastructures.Queue;
import datastructures.Stack;

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

        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("C");
        list.add(1, "B");
        System.out.println(list.get(1));  // "B"
        list.remove(1);
        System.out.println(list.indexOf("C"));  // 1
    }
}