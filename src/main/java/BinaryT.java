// Java program to convert a ternary 
// expreesion to a tree. 
import java.util.Stack; 

// Class to represent Tree node 

// Class to convert a ternary expression to a Tree 
class BinaryT 
{ 
	
	static final int COUNT = 10;  
	
	static class Node 
	{ 
		int data; 
		Node left, right; 

		public Node(int item) 
		{ 
			data = item; 
			left = null; 
			right = null; 
		} 
	} 
Node root;
	// Function to convert Ternary Expression to a Binary 
	// Tree. It return the root of tree 
	Node convertExpression(char[] expression, int i) 
	{ 
		// Base case 
		if (i >= expression.length) 
			return null; 
	
		// store current character of expression_string 
		// [ 'a' to 'z'] 
		Node root = new Node(expression[i]); 
	
		// Move ahead in str 
		++i; 
	
		// if current character of ternary expression is '?' 
		// then we add next character as a left child of 
		// current node 
		if (i < expression.length && expression[i]=='?') 
			root.left = convertExpression(expression, i+1); 
	
		// else we have to add it as a right child of 
		// current node expression.at(0) == ':' 
		else if (i < expression.length) 
			root.right = convertExpression(expression, i+1); 
	
		return root; 
	} 
	
	static void print2DUtil(Node root, int space)  
	{  
	    // Base case  
	    if (root == null)  
	        return;  
	  
	    // Increase distance between levels  
	    space += COUNT;  
	  
	    // Process right child first  
	    print2DUtil(root.right, space);  
	  
	    // Print current node after space  
	    // count  
	    System.out.print("\n");  
	    for (int i = COUNT; i < space; i++)  
	        System.out.print(" ");  
	    System.out.print(root.data + "\n");  
	  
	    // Process left child  
	    print2DUtil(root.left, space);  
	}  
	
	static void print2D(Node root)  
	{  
	    // Pass initial space count as 0  
	    print2DUtil(root, 0);  
	} 
	
	// function print tree 
	public void printTree( Node root) 
	{ 
		if (root == null) 
			return; 
				
		System.out.print(root.data +" "); 
		printTree(root.left); 
		printTree(root.right); 
	} 
	
	void inorder() 
	{ 
		if (root == null) 
			return; 


		Stack<Node> s = new Stack<Node>(); 
		Node curr = root; 

		// traverse the tree 
		while (curr != null || s.size() > 0) 
		{ 

			/* Reach the left most Node of the 
			curr Node */
			while (curr != null) 
			{ 
				/* place pointer to a tree node on 
				the stack before traversing 
				the node's left subtree */
				s.push(curr); 
				curr = curr.left; 
			} 

			/* Current must be NULL at this point */
			curr = s.pop(); 

			System.out.print(curr.data + " "); 

			/* we have visited the node and its 
			left subtree. Now, it's right 
			subtree's turn */
			curr = curr.right; 
		} 
	} 

	
// Driver program to test above function 
	public static void main(String args[]) 
	{ 
		String exp = "a?b?c:d:e?b"; 
		BinaryT tree = new BinaryT(); 
		char[] expression=exp.toCharArray(); 
		//Node root;
		tree.root = new Node(1);  
	    tree.root.left = new Node(2);  
	    tree.root.right = new Node(3);  
	  
	    tree.root.left.left = new Node(4);  
	    tree.root.left.right = new Node(5);  
	    tree.root.right.left = new Node(6);  
	    tree.root.right.right = new Node(7);  
	  
	/*    root.left.left.left = new Node(8);  
	    root.left.left.right = new Node(9);  
	    root.left.right.left = new Node(10);  
	    root.left.right.right = new Node(11);  
	    root.right.left.left = new Node(12);  
	    root.right.left.right = new Node(13);  
	    root.right.right.left = new Node(14);  
	    root.right.right.right = new Node(15);*/
		//tree.printTree(root) ; 
		print2D(tree.root); 
		tree.inorder(); 
	} 
} 

/* This code is contributed by Mr. Somesh Awasthi */
