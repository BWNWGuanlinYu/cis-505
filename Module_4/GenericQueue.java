import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> list = new LinkedList<E>();

    // Enqueue an item to the queue
    public void enqueue(E item) {
        list.addFirst(item);
    }

    // Dequeue and return the first item from the queue
    public E dequeue() {
        if (!isEmpty()) {
            return list.removeFirst();
        } else {
            throw new IllegalStateException("Queue is empty.");
        }
    }

    // Get the size of the queue
    public int size() {
        return list.size();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
