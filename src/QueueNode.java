/**
 * Created by benya on 20/09/2017.
 */
public class QueueNode {
    public int value;
    public QueueNode next;

    public QueueNode(int val,QueueNode next){
        this.value = val;
        this.next = next;

    }
    public QueueNode(int val){
        this(val, null);
    }
}
