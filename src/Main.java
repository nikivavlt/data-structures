import Queue.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();

        System.out.println("Empty? " + q.isEmpty());  // true

        q.add("First");
        q.add("Second");
        q.add("Third");

        System.out.println("Size: " + q.size());      // 3
        System.out.println("Peek: " + q.peek());      // First
        System.out.println("Remove: " + q.remove());  // First
        System.out.println("Remove: " + q.remove());  // Second
        System.out.println("Size: " + q.size());      // 1
        System.out.println("Remove: " + q.remove());  // Third
        System.out.println("Empty? " + q.isEmpty());  // true
    }
}