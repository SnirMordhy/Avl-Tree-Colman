/**
 * Created by benya on 20/09/2017.
 */
public class NumQueue {
    private QueueNode head;
    public  NumQueue(){
        this.head=null;
    }
    public NumQueue(int val){
        this.head=new QueueNode(val);
    }
    public boolean IsEmpty(){
        return (this.head == null);
    }
    public void EnQueue(int val){
        QueueNode newNode = new QueueNode(val);
        if(this.IsEmpty()){
            this.head = newNode;
            return;
        }


        QueueNode pointer = this.head;

        while(pointer.next != null){
            pointer = pointer.next;
        }

        pointer.next = new QueueNode(val);
    }

    public int DeQueue(){
        int value;
        if(this.IsEmpty()){
            value = -1;
        }else{
            value=this.head.value;
            this.head = this.head.next;
        }

        return value;
    }
}
