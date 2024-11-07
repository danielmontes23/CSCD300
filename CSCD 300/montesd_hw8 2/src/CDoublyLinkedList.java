public class CDoublyLinkedList {
    private class Node {
        private Object data;
        private Node next, prev;
        private Node(Object data, Node pref, Node next) {
            this.data = data;
            this.prev = pref;
            this.next = next;
        }
    }
    private Node head;
    private int size;

    public CDoublyLinkedList() {
        this.head = new Node(null, null, null );
        this.head.next = this.head;
        this.head.prev=this.head;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == this.head.next;
    }

    public void addFirst(Object data) {
        Node nn = new Node(data, this.head, this.head.next);
        this.head.next.prev = nn;
        this.head.next = nn;
        this.size ++;
    }

    public void addLast(Object data) {
        Node nn = new Node(data, this.head.prev, this.head);
        this.head.prev.next = nn;
        this.head.prev = nn;
        this.size++;
    }

    public CDoublyLinkedList subListOfSmallerValues(Comparable data) {
        CDoublyLinkedList newList = new CDoublyLinkedList();
        Node cur = this.head.next;
        while (cur != this.head) {
            Comparable temp = ((Comparable) cur.data);
            if(temp.compareTo(data) < 0) {
                newList.addLast(cur.data);
            }
            cur = cur.next;
        }
        return newList;
    }

    public boolean removeStartingAtBack(Object dataToRemove) {
        Node cur = head.prev;
        if (dataToRemove == null) {
            if (cur.data == null) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                this.size--;
                return true;
            }
        }
        while (cur != this.head) {
            if (cur.data == dataToRemove){
                cur.prev = cur.next.prev;
                cur.next = cur.prev.next;
                this.size--;
                return true;
            }
            cur = cur.prev;
        }
        return false;
    }

    public int lastIndexOf(Object o) {
        Node last = this.head.prev;
        int index = this.size -1;

        if (o == null) {
            if(last.data == null) {
                return index;
            }
        }
        while (last != this.head) {
            if(last.data.equals(o)) {
                return index;
            }
            index--;
            last = last.prev;
        }
        return -1;
    }

    public boolean retainAll(CDoublyLinkedList other) throws NullPointerException {
        boolean ret = false;
        Node cur = this.head.next;
        if(other.size == 0) {
            throw new NullPointerException("Null CDLL");
        }
        return false;
    }

    public void InsertionSort() {
        Node lastSorted, sortedWalker;
        Comparable firstUnsortedData;
        for(lastSorted=this.head.next; lastSorted != this.head.prev; lastSorted = lastSorted.next ) {
            firstUnsortedData = (Comparable)lastSorted.next.data;
            for(sortedWalker=lastSorted; sortedWalker != head &&
                    ((Comparable)sortedWalker.data).compareTo(firstUnsortedData) > 0;
                sortedWalker = sortedWalker.prev) {
                sortedWalker.next.data = sortedWalker.data;
            }
            sortedWalker.next.data = firstUnsortedData;
        }

    }

    @Override
    public String toString() {
        String result = "{";
        for (Node node = this.head.next; node != this.head; node = node.next) {
            if(node.next != this.head)
                result += node.data + "->";
            else
                result += node.data;
        }
        return result + "}";
    }

    public Object getFirst(){
        return this.head.next.data;
    }

    public Object removeFirst(){
        Node cur = this.head.next;
        this.head.next = cur.next;
        cur.next.prev = this.head;
        this.size--;

        return cur.data;
    }

    public CDoublyLinkedList merge(CDoublyLinkedList A, CDoublyLinkedList B) {
        CDoublyLinkedList temp = new CDoublyLinkedList();
        while(!A.isEmpty() && !B.isEmpty()) {
            int fa = (int) A.getFirst();
            int fb = (int) B.getFirst();

            if (fa < fb) {
                temp.addLast(fa);
                A.removeFirst();
            } else {
                temp.addLast(fb);
                B.removeFirst();
            }
        }
        while(!A.isEmpty()){
            int fa = (int) A.getFirst();
            temp.addLast(fa);
            A.removeFirst();
        }
        while(!B.isEmpty()){
            int fb = (int) getFirst();
            temp.addLast(fb);
            B.removeFirst();
        }
        return temp;
    }
    public void MergeSort(){
        Queue Q = new Queue();

        for (Node cur = this.head.next; cur != this.head; cur = cur.next) {
            CDoublyLinkedList newList = new CDoublyLinkedList();
            newList.addFirst(cur.data);
            Q.Enqueue(newList);
        }
        while (Q.getSize() > 1) {
            CDoublyLinkedList sublist1 = (CDoublyLinkedList) Q.Dequeue();
            CDoublyLinkedList sublist2 = (CDoublyLinkedList) Q.Dequeue();
            CDoublyLinkedList temp;
            temp = merge(sublist1, sublist2);
            Q.Enqueue(temp);
        }
        CDoublyLinkedList res = (CDoublyLinkedList) Q.Dequeue();
        this.head = res.head;
    }

    public boolean isSorted() {
        return true;
    }

    public int getSize() {
        return this.size;
    }
}