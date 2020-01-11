// A Java program to demonstrate 
// the printing of Linked List middle 
// to left right order 
class recurlink 
{ 

// A linked list node 
static class Node 
{ 
	int data; 
	Node next; 
}; 

// Given a reference (pointer to pointer) 
// to the head of a list and an int, appends 
// a new node at the end 
static Node append(Node head_ref, int new_data) 
{ 
	// Allocate node 
	Node new_node = new Node(); 

	// Used in step 5 
	Node last = head_ref; 

	// Put in the data 
	new_node.data = new_data; 

	// This new node is going to be 
	// the last node, so make next of 
	// it as null 
	new_node.next = null; 

	// If the Linked List is empty, 
	// then make the new node as head 
	if (head_ref == null) 
	{ 
		head_ref = new_node; 
		return head_ref; 
	} 

	// Else traverse till the last node 
	while (last.next != null) 
		last = last.next; 

	// Change the next of last node 
	last.next = new_node; 
	return head_ref; 
} 

// This function prints contents of 
// linked list starting from head 
static void printList(Node node) 
{ 
	while (node != null) 
	{ 
		System.out.print( " " + node.data); 

		if (node.next != null) 
			System.out.print("->"); 
		node = node.next; 
	} 
} 

// Function to get the size of linked list 
static int getSize(Node head) 
{ 
	if (head == null) 
		return 0; 
	return 1 + getSize(head.next); 
} 

// Utility function to print the Linked List 
// from middle to left right order 
static Node printMiddleToLeftRightUtil(Node head, 
						int counter, int lSize) 
{ 
	// Base Condition 
	// When size of list is odd 
	if (counter == 1 && lSize % 2 != 0) 
	{ 

		// Print node value 
		System.out.print( head.data); 

		// Returns address of next node 
		return head.next; 
	} 

	// Base Condition 
	// When size of list is even 
	else if (counter == 1) 
	{ 

		// Print node value 
		// and next node value 
		System.out.print(head.data); 
		System.out.print( " , " + head.next.data); 

		// Returns address of next to next node 
		return head.next.next; 
	} 
	else
	{ 

		// Recursive function call and 
		// store return address 
		Node ptr = printMiddleToLeftRightUtil(head.next, 
									counter - 1, lSize); 

		// Print head data 
		System.out.print(" , " + head.data); 

		// Print ptr data 
		System.out.print(" , " + ptr.data); 

		// Returns address of next node 
		return ptr.next; 
	} 
} 

// Function to print Middle to 
// Left-right order 
static void printMiddleToLeftRight(Node head) 
{ 
	// Function call to get the size 
	// Of Linked List 
	int listSize = getSize(head); 

	int middle = 0; 

	// Store middle when Linked 
	// List size is odd 
	if (listSize % 2 != 0) 
	{ 
		middle = (listSize + 1) / 2; 
	} 

	// Store middle when Linked 
	// List size is even 
	else
	{ 
		middle = listSize / 2; 
	} 

	// Utility function call print 
	// Linked List from Middle 
	// to left right order 
	System.out.print("Output : "); 

	printMiddleToLeftRightUtil(head, middle, listSize); 
} 

// Driver code 
public static void main(String args[]) 
{ 
	// Start with the empty list 
	Node head = null; 

	// Insert 6. So linked list 
	// becomes 6.null 
	head = append(head, 6); 

	// Insert 6. So linked list 
	// becomes 6.4.null 
	head = append(head, 4); 
	head = append(head, 8); 
	head = append(head, 7); 
	head = append(head, 9); 
	head = append(head, 11); 
	head = append(head, 2); 

	// After inserting linked list 
	// becomes 6.4.8.7.9.11.2.null 
	System.out.print("Created Linked list is: "); 

	// Function to display Linked List content 
	printList(head); 
	System.out.println(); 

	// Function call print Linked List from 
	// Middle to left right order 
	printMiddleToLeftRight(head); 
} 
} 

// This code is contributed by Arnab Kundu 
