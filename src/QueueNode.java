/**
 * Created by benya on 20/09/2017.
 */
public class QueueNode {
    public int value;
    public QueueNode next;
    public QueueNode prev;

    public QueueNode(int val, QueueNode prev,QueueNode next){
        this.value=val;

        this.next = next == null ? this : next;
        this.prev = prev == null ? this : prev;
    }
    public QueueNode(int val){
        this(val, null, null);
    }
}
