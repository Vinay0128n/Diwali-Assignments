import java.util.Scanner;

class CircularQueue {
    // Node structure
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front = null;
    private Node rear = null;

    // Enqueue operation
    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (front == null) {  
            front = newNode;
            rear = newNode;
            rear.next = front; 
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
        System.out.println("Inserted: " + data);
    }

    // Dequeue operation
    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        int value;
        if (front == rear) {  
            value = front.data;
            front = null;
            rear = null;
        } else {
            value = front.data;
            front = front.next;
            rear.next = front; // maintain circular link
        }
        System.out.println("Deleted: " + value);
    }

    // Peek (front element)
    public void peek() {
        if (front == null) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }

    // Display all elements
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Circular Queue: ");
        Node temp = front;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueue queue = new CircularQueue();

        while (true) {
            System.out.println("\n--- Circular Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    int data = sc.nextInt();
                    queue.enqueue(data);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
