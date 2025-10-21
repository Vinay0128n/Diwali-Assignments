import java.util.Scanner;

class CircularLinkedList {
    // Node structure
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    // Function for insert node at nth position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (head == null) { // if list is empty
            head = newNode;
            tail = newNode;
            tail.next = head;
            return;
        }

        if (position == 1) { // insert at head
            newNode.next = head;
            head = newNode;
            tail.next = head;
            return;
        }

        Node current = head;
        int count = 1;

        while (count < position - 1 && current.next != head) {
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        current.next = newNode;

        if (current == tail) { // if inserted at end
            tail = newNode;
            tail.next = head;
        }
    }


    // Function for delete node by data
    public void deleteByData(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        Node prev = tail;

        // If the node to delete is the head
        if (head.data == data) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            System.out.println("Node deleted successfully.");
            return;
        }

        // Traverse to find node
        do {
            if (current.data == data) {
                prev.next = current.next;
                if (current == tail) {
                    tail = prev;
                }
                System.out.println("Node deleted successfully.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Data not found in the list.");
    }

    // Function to modify node by data
    public void modifyNode(int oldData, int newData) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        boolean found = false;

        do {
            if (current.data == oldData) {
                current.data = newData;
                found = true;
                System.out.println("Node modified successfully.");
                break;
            }
            current = current.next;
        } while (current != head);

        if (!found)
            System.out.println("Data not found in the list.");
    }

    // Function to display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        System.out.print("Circular Linked List: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        while (true) {
            System.out.println("\n--- Circular Linked List Menu ---");
            System.out.println("1. Insert at position");
            System.out.println("2. Delete by data");
            System.out.println("3. Modify node");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    list.insertAtPosition(data, pos);
                    break;
                case 2:
                    System.out.print("Enter data to delete: ");
                    int delData = sc.nextInt();
                    list.deleteByData(delData);
                    break;
                case 3:
                    System.out.print("Enter old data to modify: ");
                    int oldData = sc.nextInt();
                    System.out.print("Enter new data: ");
                    int newData = sc.nextInt();
                    list.modifyNode(oldData, newData);
                    break;
                case 4:
                    list.display();
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
