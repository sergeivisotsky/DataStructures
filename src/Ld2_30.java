import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

class Node<E> {
    protected E current;
    protected Node<E> next;

    Node(E num) {
        this.current = num;
    }
}

class LinkedList {
    private static Node<Integer> head = null;
    private static Node<Integer> tail = null;
    private static int size = 0;

    public boolean empty() {
        return head == null;
    }

    public void insert(int current) {
        if (empty() || !full()) {
            Node<Integer> node = new Node<>(current);
            node.next = head;
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }

            tail = node;
            size++;
        }
    }

    public void outputSortedList() {
        Node<Integer> temp = tail;
        for (int i = 0; i < size; i++) {
            if (temp != null) {
                System.out.print(temp.current + "\t");
                temp = temp.next;
            }
        }
        System.out.println();
    }


    public boolean full() {
        return size == 10;
    }

    public int size() {
        return size;
    }

    public int equalsToZero() {
        Node<Integer> node = tail;
        int quantifier = 0;
        for (int i = 0; i < size; i++) {
            if (node.current == 0) {
                quantifier++;
            }
        }
        return quantifier;
    }

    public int getNodeByIndex(int index) {
        Node<Integer> node = head.next;
        for (int i = 0; i < index - 3; i++) {
            node = node.next;
        }

        return node.current;
    }

    public void deleteNode(int nodeIndex) {
        if (!empty()) {
            /*Node<Integer> node = head;
            for (int i = 0; i < nodeIndex - 3; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            tail.next = head;
            size--;*/
            if (nodeIndex == 1 && size == 1) {
                size = 0;
                return;
            }

            if (nodeIndex == 1) {
                head = head.next;
                tail = head;
                size--;
                return;
            }

            if (nodeIndex == size) {
                Node<Integer> ptr = head;
                for (int i = 0; i < size - 1; i++) {
                    ptr = ptr.next;
                }
                ptr = head;
                tail = ptr;
                size--;
                return;
            }

            Node<Integer> ptr = head;
            nodeIndex--;
            for (int i = 0; i < size - 1; i++) {
                if (i == nodeIndex) {
                    Node<Integer> temp = ptr.next;
                    temp = temp.next;
                    ptr = temp.next;
                    break;
                }
                ptr = ptr.next;
            }
            size--;

            outputSortedList();
        } else {
            System.out.println("Saraksts ir tukšs!");
        }
    }
}

public class Ld2_30 {
    private static BufferedReader br =
            new BufferedReader(
                    new InputStreamReader(System.in));
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("Sergejs Visockis IRDBD12 171RDB043");

        // User menu to choose answer variant
        System.out.println("1: Izveidot sarakstu");
        System.out.println("2: Izmest no saraksta elementu ar konkrētu pozīciju");
        System.out.println("3: Elementu daudzums sarakstā");
        System.out.println("4: Elementu daudzums kas ir vienādi ar nulli");
        System.out.println("5 (Test): Paņēmt elelemntu ar konkrētu pozīciju");
        System.out.println("0: Slēgt sesiju");

        boolean listCreated = false; // Checks if any value was input
        boolean endSession = false; // checks whether user closed session
        int choiceAnswer; // Operation to be performed
        int elementToInput; // Element to be added to the list

        try {
            do {
                System.out.println();
                System.out.print("Izvēlēties saskarsmes vērtību: ");
                choiceAnswer = Integer.parseInt(br.readLine());
                switch (choiceAnswer) {
                    case 1:
                        while (!list.full()) {

                            for (int i = 0; i < 10; i++) {
                                System.out.print("Ievadiet " + (i + 1) + " elementu: ");
                                elementToInput = Integer.parseInt(br.readLine());
                                list.insert(elementToInput);
                            }
                            System.out.println("\nIzveidots saraksts:");
                            list.outputSortedList();
                        }

                        if (list.full()) {
                            System.out.println("Saraksts ir pilns...");
                        }
                        listCreated = true;
                        break;
                    case 2:
                        if (!listCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }
                        System.out.print("Dzēšamais elements: ");
                        int deletableElementIndex =
                                Integer.parseInt(br.readLine());

                        list.deleteNode(deletableElementIndex);

                        if (list.empty()) {
                            System.out.println("Saraksts ir tukšs...");
                        }
                        break;
                    case 3:
                        System.out.println(list.size());
                        if (!listCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }
                        break;
                    case 4:
                        if (!listCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }

                        System.out.println(list.equalsToZero());
                        break;
                    case 5:
                        if (!listCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }

                        System.out.print("Elementa indekss: ");
                        int nodeIndex =
                                Integer.parseInt(br.readLine());
                        System.out.print(list.getNodeByIndex(nodeIndex));
                        break;
                    case 0:
                        endSession = true;
                        break;
                    default:
                        System.out.print("Ievādīta nepieņēmāma vērtība!");
                }
            } while (!endSession);
        } catch (InputMismatchException | IOException |
                NumberFormatException e) {
            System.out.println("Nepareizs datu formāts!");
        }
        System.out.println("Sesija slēgta...");
    }
}
