package ces2.entidades;

public class Queue <T> implements DataStructure {
    private Node<T> front;
    private Node<T> rear;

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            T data = front.value;
            front = front.next;
            if (front != null) {
                front.prev = null;
            } else {
                rear = null;
            }
            return data;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public String imprimir() {
        if (isEmpty()) return "Queue vacio";

        String out = "";

        Node<T> current = rear;

        while (current != null) {
            out += "<div class=\"node-box\">" + current.value + "</div><br />";

            current = current.prev;
        }

        return out;
    }
}
