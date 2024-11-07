
/**
  * Please change this file in the places only when it is directed 
  * by the comments.
  * 
*/
import java.util.Arrays;

public class Tester {

	public static MyLinkedList list1 = new MyLinkedList();
	public static MyLinkedList list2 = new MyLinkedList();
	public static MyLinkedList list3 = new MyLinkedList();

	//init() method is NOT allowed to change
	public void init() {
		list2.addFirst("C");
		list2.addFirst("B");
		list2.addFirst("A");
		list2.addFirst("D");
		list3.addFirst("A");
		list3.addFirst("B");
	}

	// Implement the following method using recursion
	// The method returns the number of white spaces in the input string str.
	// Write this method below.
	public int countSpace(String str) {
		if (str.isEmpty()) {
			return 0;
		} else {
			// Check if the first character of the string is a white space.
			// If it is, add 1 to the count; otherwise, add 0.
			int currentSpaceCount = (str.charAt(0) == ' ') ? 1 : 0;

			// Recursively call countSpace on the remaining substring.
			int remainingSpaceCount = countSpace(str.substring(1));

			// Return the sum of the currentSpaceCount and remainingSpaceCount.
			return currentSpaceCount + remainingSpaceCount;// Change this line of code as needed
		}
	}


	//Check whether s1 is a substring in s2.
	//For example, if s1="an", and s2="banana", it returns true.
	//For another example, if s1="bb" and s2="good", it returns false.
	//If either s1 or s2 is null, return false. 
	//If either s1 or s2 is empty, return false.
	//You are NOT allowed to use the contains() method in Java String class.
	//Write the method below using recursion.
	public boolean myContains(String s1, String s2) {
		if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
			return false;
		}
		if(s2.length() < s1.length()){
			return false;
		}
		if(s2.startsWith(s1)){
			return true;
		}
		return myContains(s1, s2.substring(1));

		//return false; //change this line of code as needed.
	}

	// Compute the quotient of the integer division of (m / n) using recursion,
	// you are NOT allowed to use mathematics operation '/'.
	// Look the problem from another perspective. What does the division mean?
	// Division (m/n) also means how many n (s) is contained in the number m.
	// If n == 0, throw an IllegalArgumentException object.
	// Write this method below using recursion.
	public int div(int m, int n) throws IllegalArgumentException {
		if (n == 0)
			throw new IllegalArgumentException("N is 0. //int div");

		return divHelper(m, n, 0); //change this line of code as needed.
	}

	private int divHelper(int m, int n, int count){
		if(m < n){
			return count;
		}
		return divHelper(m - n, n, count + 1);
	}

	//Check whether the sum of array arr is 24 or not.
	//You are required to implement the *private* helper method in the space below this method.
	//You are NOT allowed to change the provided code in the *public*
	//    method isSum24(int arr[]).
	public boolean isSum24(int arr[]) {
		return isSum24(arr, 24);
	}

	// Implement the private helper method below using recursion.
	// The method checks whether the sum of all elements in arr 
	//       equals to the targetSum or not.
	// Hint:the subproblem is about a subarray.
	private boolean isSum24(int arr[], int targetSum) {
		if(arr.length == 0){
			return false;
		}
		if(arr[0] == targetSum){
			return true;
		}

		boolean num1 = isSum24(Arrays.copyOfRange(arr, 1, arr.length), targetSum - arr[0]);
		boolean num2 = isSum24(Arrays.copyOfRange(arr, 1, arr.length), targetSum);

		return num1 || num2; //change this line of code as needed.
	}

	//You are NOT allowed to change the provided code in the *public* 
	//    reverseArray(int a[]) method below.
	public void reverseArray(int a[]) {
		reverseArray(a, 0, a.length - 1);
	}

	//Please write the private reverseArray() using recursion.
	//The method will reverse the array elements 
	//      that are located at indices ranging from low to high.
	//E.g. if int a[] ={3, 1, 5, 4}, after reverseArray(a, 0, 3) is called,
	//       array a becomes {4, 5, 1, 3}.
	private void reverseArray(int a[], int low, int high) {
		if (low < high) {
			int temp = a[low];
			a[low] = a[high];
			a[high] = temp;

			reverseArray(a, low + 1, high - 1);
		}
	}

	//You are NOT allowed to change the provided code in the *public* 
	//    recursiveSelectionSort(int a[]) method below.
	public void recursiveSelectionSort(int a[]) {
		recursiveSelectionSort(a, 0, a.length - 1); //
	}

	//Please write the private helper method recursiveSelectionSort() using recursion.
	//The method will sort in an ascending order the array elements 
	//      that are located at indices ranging from low to high.
	//This is a version of recursive selection sort.
	private void recursiveSelectionSort(int a[], int low, int high) {
		if (low == high) {
			return;
		}

		int minIndex = low;
		for (int i = low + 1; i <= high; i++) {
			if (a[i] < a[minIndex]) {
				minIndex = i;
			}
		}

		// Swap the minimum element with the first element in the unsorted part.
		int temp = a[minIndex];
		a[minIndex] = a[low];
		a[low] = temp;

		// Recursively sort the remaining array excluding the first element.
		recursiveSelectionSort(a, low + 1, high);
	}//end of method
	
	

	//Please do NOT change the main() method below.
	//If you do change, you get a zero for this project.
	public static void main(String[] args) {
		Tester test = new Tester();
		test.init();
		//System.out.println(list1);
		//System.out.println(list2);
		System.out.println("---------Test Reverse()-------");
		System.out.println(list1.reverse());
		System.out.println(list2.reverse());
		System.out.println(list3.reverse());
		System.out.println("-------Test Reverse2()---------");
		list1.reverse2();
		list2.reverse2();
		list3.reverse2();
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		System.out.println("-------Test countSpace()----------");
		System.out.println(test.countSpace("g  d  "));
		System.out.println(test.countSpace("good "));
		System.out.println(test.countSpace("  good"));
		System.out.println(test.countSpace("good  mornin g "));
		System.out.println("-----Test myContains()------------");
		System.out.println( test.myContains("an", "banana"));
		System.out.println( test.myContains("bn", "banana"));
		System.out.println( test.myContains("er", "richer"));
		System.out.println( test.myContains("a", "a"));
		System.out.println("-----Test div()------------");
		System.out.println( test.div(11, 3) );
		System.out.println( test.div(12, 5) );
		System.out.println( test.div(4, 4) );
		System.out.println( test.div(3, 7) );
		System.out.println( test.div(16, 4) );
		
		System.out.println("-----Test isSum24()------------");
		int a[] = {6, 3, 8, 3, 4};
		int b[] = {5, 6, 7};
		int c[] = {24};
		int d[] = {10, 14};
		int e[] = {};
		System.out.println( test.isSum24(a) ); //true
		System.out.println( test.isSum24(b) ); //false
		System.out.println( test.isSum24(c) ); //true
		System.out.println( test.isSum24(d) ); //true
		System.out.println( test.isSum24(e) ); //false
		
		System.out.println("-----Test reverseArray()------------");
		test.reverseArray(a);
		System.out.println(Arrays.toString(a));//43836
		test.reverseArray(b);
		System.out.println(Arrays.toString(b));//765
		test.reverseArray(d);
		System.out.println(Arrays.toString(d));//14,10
		
		System.out.println("-----Test recursiveSelectionSort()------------");
		test.recursiveSelectionSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a)); //33468
		int f[] = {2, 5, 1, 7, 9, 3, 6, 8};
		test.recursiveSelectionSort(f, 0, f.length - 1);
		System.out.println(Arrays.toString(f));//12356789
		
		
	}

}
