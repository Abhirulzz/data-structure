public class LinkList {
	Node head; // head of list 
	  
    // Linked list Node. 
    // This inner class is made static 
    // so that main() can access it 
    static class Node { 
  
        int data; 
        Node next; 
  
        // Constructor 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
    // Method to insert a new node 
    public static LinkList insert(LinkList list, int data) 
    { 
        // Create a new node with given data 
        Node new_node = new Node(data); 
        new_node.next = null; 
  
        // If the Linked List is empty, 
        // then make the new node as head 
        if (list.head == null) { 
            list.head = new_node; 
        } 
        else { 
            // Else traverse till the last node 
            // and insert the new_node there 
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
  
            // Insert the new_node at last node 
            last.next = new_node; 
        } 
  
        // Return the list by head 
        return list; 
    } 
  
    // Method to print the LinkedList. 
    public void printList() 
    { 
        Node currNode =null;
        currNode=head;
   
        System.out.print("LinkedList: "); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
            
            // Go to next node 
            currNode = currNode.next; 
        } 
        
      
      /*  System.out.println("LinkedList: " +list.head); 
        currNode = list.head; 
        while (currNode.next != null) { 
            // Print the data at current node 
            //System.out.print((currNode.next).toString() + " "); 
   
            // Go to next node 
            currNode = currNode.next; 
        } */
    } 
    
    void insertAtMid() 
	{ 
	
			// get a new node 
			Node newNode=null;

			Node ptr = head; 
			int len = 0; 

			// calculate length of the linked list 
			//, i.e, the number of nodes 
			while (len!=3) { 
				len++;
				newNode=ptr;
			//	newNode.data=ptr.data;
			//	newNode.next=ptr.next;
				ptr = ptr.next; 
			} //

			// 'count' the number of nodes after which 
			// the new node is to be inserted 
			//int count = ((len % 2) == 0) ? (len / 2) : 
			//							(len + 1) / 2; 
			ptr = head; 

			// 'ptr' points to the node after which 
			// the new node is to be inserted 
			while (ptr.next!=null) 
			{
				ptr = ptr.next; 
			}

			// insert the 'newNode' and adjust 
			// the required links 
			//ptr=newNode;
			ptr.next=newNode.next;
			//ptr.data=newNode.data;
		} 
	

    Node nthtolast(int n) {     
    	if (head == null || n < 1) {                               
    	return null;                                               
    	}                                                          
    	Node p1 = head;                                  
    	Node p2 = head;                                  
    	for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead  
    	if (p2 == null) {                                          
    	return null; // not found since list size < n              
    	 }                                                         
    	 p2 = p2.next;                                             
    	 }                                                         
    	 while (p2.next != null) {                                 
    	 p1 = p1.next;                                             
    	 p2 = p2.next;                                             
    	 }   
    	 
    	 Node currNode=null;
         currNode=head;
         while (currNode != null) { 
             // Print the data at current node 
             System.out.print(currNode.data + " "); 
             
             // Go to next node 
             currNode = currNode.next; 
         } 
         currNode.next=p1;
    	 return p1;                                                
    	 }          
    
    Node findbeginning() {                
    	Node f1 = head;                                          
    	Node f2 = head;                                          
    	                                                                   
    	// find meeting point                                              
    	while (f2.next!= null) {                                          
    	
    	f1 = f1.next;                                                      
    	f2 = f2.next.next;                                                 
    	if (f1 == f2) {                                                    
    	 break;                                                            
    	 }                                                                 
    	 }                                                                 
    	                                                                   
    	 // error check - there is no meeting point, and therefore no loop 
    	 if (f2.next == null) {                                            
    	 return null;                                                      
    	 }                                                                 
    	                                                                   
    	 /* move n1 to head. keep n2 at meeting point. each are k steps    
    	 /* from the loop start. if they move at the same pace, they must  
    	 * meet at loop start. */                                          
    	 f1 = head;                                                        
    	 while (f1 != f2) {                                                
    	 f1 = f1.next;                                                     
    	 f2 = f2.next;                                                     
    	 }                                                                 
    	 // now n2 points to the start of the loop.                        
    	 return f2;                                                        
    	 }                                                                 
   
    
    
    void remove_duplicates() { 
        Node ptr1 = null, ptr2 = null, dup = null; 
        ptr1 = head; 
  
        /* Pick elements one by one */
        while (ptr1 != null && ptr1.next != null) { 
            ptr2 = ptr1; 
  
            /* Compare the picked element with rest 
                of the elements */
            while (ptr2.next != null) { 
  
                /* If duplicate then delete it */
                if (ptr1.data == ptr2.next.data) { 
  
                    /* sequence of steps is important here */
                    dup = ptr2.next; 
                    ptr2.next = ptr2.next.next; 
                    System.gc(); 
                } else /* This is tricky */ { 
                    ptr2 = ptr2.next; 
                } 
            } 
            ptr1 = ptr1.next; 
        } 
    } 
    
	void deleteNode(Node n) {
		if (n == null || n.next == null) {
			return;
		}
		Node next = n.next; //2
		n.data = next.data;
		n.next = next.next; //2=3;
		//return true;
	}
   
    // Driver code 
    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
        LinkList list = new LinkList(); 
        
  
        // 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 3); 
        list = insert(list, 4); 
        list = insert(list, 5); 
        list = insert(list, 6); 
        list = insert(list, 7); 
        list = insert(list, 8); 
        list = insert(list, 9); 
        //list = insert(list, 5); 
        // Print the LinkedList 
        list.insertAtMid();
    //    list.printList(); 
    
        //list.remove_duplicates();
        // Print the LinkedList 
        //System.out.printf("%n");
      //  list.printList(); 
        System.out.printf("%n");
        Node p1Node=null;
       // p1Node=list.head;
        //p1Node.data=6;
       // list.deleteNode( 6);
        //list.printList(); 
        //System.out.printf("%n");
        //p1Node=list.nthtolast(3);
        //p1Node.data.printList(); 
        //System.out.println(p1Node.data);
       
        //currNode.next=list.nthtolast(3);
        p1Node=list.findbeginning();
        System.out.printf("%n");
        System.out.println(p1Node.data);
        //list.printList(); 
    } 

}
