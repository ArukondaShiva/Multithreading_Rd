import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> q;
    private int capacity;

    public BlockingQueue(int cap) {
        q = new LinkedList<>();
        capacity = cap;
    }

    public boolean add(int item) {
        synchronized (q) {

            // if q is full. this thread cannot add new element
            // make it wait until some other thread removes from the q.
            while (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            q.add(item);

            // calling notifyAll after adding for the threads
            // which were in the waiting state
            q.notifyAll();

            return true;
        }
    }

    public int remove(int item) {
        synchronized (q) {

            // if the q size is zero. nothing to remove
            // so make this thread to wait until some thread
            // insert into this queue
            while (q.size() == 0) {

                try {
                    q.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            int element = q.poll();

            // calling notifyAll after removing
            // for the threads which were in the waiting state
            q.notifyAll();

            return element;
        }
    }

}
