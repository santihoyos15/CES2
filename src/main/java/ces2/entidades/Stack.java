package ces2.entidades;

public class Stack<T> implements DataStructure {

    private Node<T> head;
    private int length;

    public Stack() {
        this.head = null;
        this.length = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack vacio");
        }

        Node<T> poppedNode = head;
        head = poppedNode.next;
        length--;
        return poppedNode.value;
    }

    public T peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack vacio");
        }

        return head.value;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    // Use a "DataStructure" interface and include this method that renders html
    @Override
    public String imprimir() {
        if (isEmpty()) return "Stack vacio";

        String out = "";

        Node<T> current = head;

        while (current != null) {
            out += "<div class=\"node-box\">" + current.value + "</div>";

            current = current.next;
        }

        return out;
    }

}
