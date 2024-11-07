public class Queue {
    private class Node{
        private Object data;
        private Node next;
        public Node(Object element){
            this.data = element;
            this.next = null;
        }
    }
    protected Node head, tail;
    protected int size;
    public Queue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        if(head == null && tail == null || this.size == 0)
            return true;
        return false;
    }
    public void Enqueue(Object element){
        Node node = new Node(element);
        if(size == 0) {
            head = node;
        }else{
            tail.next = node;
        }
        tail = node;
        size++;
    }
    public Object Front() {
        if (size == 0)
            throw new IllegalArgumentException("Queue is empty");
        return head.data;
    }
    public Object Dequeue(){
        Object temp = head.data;
        head = head.next;
        size--;

        if(size == 0)
            tail = null;
        return temp;
    }
}
