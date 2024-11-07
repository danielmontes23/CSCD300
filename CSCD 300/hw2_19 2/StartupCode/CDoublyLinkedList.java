public class CDoublyLinkedList {

	private class Node {
		private Object data;   //Assume data implemented Comparable
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

	// Add Object data to start of this LinkedList
	// Please DO NOT change this addFirst() method.
	// You must keep and include this provided addFirst() method
	//      in your source code.
	public void addFirst(Object data) {
		Node nn = new Node(data, this.head, this.head.next);
		this.head.next.prev = nn;
		this.head.next = nn;
		this.size ++;
	}

	// write a method void addLast(Object data) that will insert
	// the piece of data at the end of the current list.
	// Note: this list is allowed to store null data element in its list node.
	public void addLast(Object data) {
		Node nn = new Node(data, this.head.prev, this.head);
		this.head.prev.next = nn;
		this.head.prev = nn;
		this.size++;
	}

	// Write the subListOfSmallerValues method.
	// It should return a CDoublyLinkedList object
	//     containing data that is smaller than the value passed to the method.
        // If a null data element in this list is encountered, you can skip it.
        // You need to use the CompareTo() method to determine which object is smaller.
        // If list A contains {9, 11, 14, 6, 4, 7} and you call  A.subListOfSmallerValues(10),
        // the method call returns a list that contains data in A that is smaller than 10, the passed-in argument.
        // That is, the returned list contains { 9, 6, 4, 7}.
	public CDoublyLinkedList subListOfSmallerValues(Comparable data) {
		CDoublyLinkedList subList = new CDoublyLinkedList();
		Node cur = this.head.next;

		while(cur != this.head){
			Comparable temp = ((Comparable)cur.data);
			if(data.compareTo(cur.data) > 0){
				subList.addLast(cur.data);
			}
			cur = cur.next;
		}
		return subList;//change this as needed.
	}

	// This method should remove the first occurrence of the data from the list,
        //      starting at the *BACK* of the list. 
        // It scans the list from back to the front by following the prev links. 
	// The method should return true if successful, false otherwise.
	// Note that list node may contain null data element. Please handle this edge case.
	public boolean removeStartingAtBack(Object dataToRemove) {
		Node cur = head.prev;

		if (dataToRemove == null) {
			if (cur != null && cur.data == null) {
				cur.prev.next = cur.next;
				cur.next.prev = cur.prev;
				this.size--;
				return true;
			}
		}
		while (cur != this.head){
			if(cur.data != null && cur.data.equals(dataToRemove)){
				cur.prev.next = cur.next;
				cur.next.prev = cur.prev;
				this.size--;
				return true;
			}
			cur = cur.prev;
		}
		return false;//change this as needed.
	}

	// Returns the index of the last occurrence of the specified element in this list,
	//     or -1 if this list does not contain the element.
	// More formally, returns the highest index i
	//     such that (o==null ? get(i)==null : o.equals(get(i))),
	//     or -1 if there is no such index.
	// Note: a list node may store a null data element. Please handle this edge case.
	public int lastIndexOf(Object o) {
		int lastIndex = -1;
		int currentIndex = 0;

		Node cur = this.head.next;

		while(cur != this.head){
			if(o == null && cur.data == null || o != null && o.equals(cur.data)){
				lastIndex = currentIndex;
			}
			cur = cur.next;
			currentIndex++;
		}
		return lastIndex;//change this as needed.
	}


	// Removes from this list all of its elements that
	//    are NOT contained in the specified linkedlist other.
	// If any element has been removed from this list,
	//    returns true. Otherwise returns false.
	// If other list is null, throws NullPointerException.
        // Helper methods are allowed.
	public boolean retainAll(CDoublyLinkedList other) throws NullPointerException {
		if(other == null)
			throw new NullPointerException();

		Node cur = this.head.next;
		while(cur != this.head){
			if(!other.contains(cur.data)) {
				this.remove(cur.data);
			}
			cur = cur.next;
		}
		return false;//change this as needed.
	}

	public boolean contains(Object d) { //1st Helper method
		Node cur = this.head.next;
		while (cur != this.head) {

			if (cur.data == null && cur.data == d || cur.data != null && cur.data.equals(d))
			{
				return true;
			}
			cur = cur.next;
		}

		return false;
	}
	public void remove(Object o){ //2nd Helper method
		Node cur =this.head.next;
		while(cur != this.head){
			if(cur.data == o || o == null){
				cur.next.prev = cur.prev;
				cur.prev.next = cur.next;
				this.size--;
			}
			cur = cur.next;
		}
	}


	// Write this method to sort this list using insertion sort algorithm,
        //      as we have learned in the classroom.
	public void insertionSort() {
		Node lastSorted;
		Node sortedWalker;
		Comparable firstUnsortedData;

		for(lastSorted = this.head.next; lastSorted != this.head.prev; lastSorted = lastSorted.next) {
			firstUnsortedData = (Comparable)lastSorted.next.data;
			for (sortedWalker = lastSorted; sortedWalker != head && ((Comparable) sortedWalker.data).compareTo(firstUnsortedData) > 0; sortedWalker = sortedWalker.prev) {
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
}
