import java.util.Scanner;

class Node {
    String text;
    Node prev, next;

    Node(String text) {
        this.text = text;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private Node head, tail, current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void addText(String text) {
        Node newNode = new Node(text);

        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        }

        current = newNode;

        if (head == null) {
            head = tail = newNode;
        } else {
            tail = newNode;
        }

        size++;

        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Undo not possible.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Redo not possible.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.text);
        } else {
            System.out.println("No content available.");
        }
    }
}

public class UndoRedoEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;

        do {
            System.out.println("\n1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    editor.addText(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }
}
