public class stationLinkedList {
    node head = null;
    static class node
    {
        station station;
        node next;
        node(station station)
        {
            this.station = station;
            next = null;
        }
    }
    public void addLast(station station)
    {
        node new_node = new node(station);
        if(head == null)
        {
            head = new_node;
        }
        else
        {
            node temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = new_node;
            
        }
    }
    public node getHeadNode()
    {
        return head;
    }
    public void emptyList()
    {
        boolean choice = delFirst();
        while(choice)
        {
            choice = delFirst();
        }
    }
    boolean delFirst()
    {
        node temp = head;
        if(head == null)
        {
            System.out.println("LinkedList is empty ");
            return false;
        }
        else
        {
            head = temp.next;
            temp.next = null;
            return true;
        }
    }
}
