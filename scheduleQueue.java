import java.sql.Time;

public class scheduleQueue {
    schedule schedule;
    private Node front;
    private Node rear;
    private int size;
    public scheduleQueue()
    {
        this.front = this.rear = null;
        this.size = 0;
    }
    public class Node {
        schedule schedule;
        Node next;
        Node(schedule schedule){
            this.schedule = schedule;
            this.next = null;
        }
    }
    public  void enqueue(schedule schedule){
        Node node = new Node(schedule);
        if(front==null){
            front = rear = node;
            size++;
            return;
        }else{
            Node pointer = front;
            while (pointer!=rear) {
                pointer = pointer.next;
            }
            pointer.next = node;
            rear = node;
            size++;
        }
    }
    public schedule dequeue(){
        if(front==null){
            System.out.println("Queue is Empty");
            return null;
        }else if(size==1){
            Node deletedNode = front;
            front = rear = null;
            size--;
            return deletedNode.schedule;
        }else{
            Node deletedNode = front;
            front = front.next;
            size--;
            return deletedNode.schedule;
        }
    }
    public int size(){
        return size;
    }
    public static void main(String[] args) {
        
    }
}

    
