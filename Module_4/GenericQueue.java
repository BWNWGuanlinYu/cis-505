import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> list = new LinkedList<E>();

    public void enqueue(E item) {
        list.addFirst(item);
    }

    public E dequeue() {
        if (!isEmpty()) {
            return list.removeFirst();
        } else {
            throw new IllegalStateException("Queue is empty.");
        }
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
