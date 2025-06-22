public class payment_stack {
    Node top;


    class Node 
    {
        String data;
        Node next;

        Node(String data) 
            {
                this.data = data;
            }
    }

    void push(String data) // Insert at Head method in SLL
    {
        //Overflow condition not required
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println(data + " is inserted successfully");
    }

    String pop() //Delete at head method in SLL
    {
        if (top == null) {
            System.out.println("Stack underflow");
            return null;
        } else {
            String poppedItem = top.data;
            top = top.next;
            return poppedItem;
        }
    }

    boolean isEmpty() {
        return top == null;
    }
}



