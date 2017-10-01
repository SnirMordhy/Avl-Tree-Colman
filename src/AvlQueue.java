import sun.misc.Queue;

public class AvlQueue extends Queue {

    private QueueNode front;
    private QueueNode rear;

    public AvlQueue() {
        this.front = this.rear = null;
    }

    public void enqueue(int key)
    {

        // Create a new LL node
        QueueNode temp = new QueueNode(key);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null)
        {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an key from queue.
    public QueueNode dequeue()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return null;

        // Store previous front and move front one node ahead
        QueueNode temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
        return temp;
    }
}
