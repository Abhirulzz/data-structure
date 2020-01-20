// Java program to print all paths with sum k. 
import java.util.Stack;
import java.util.Vector; 

class KsumPath
{ 
	static final int COUNT = 10;  
//utility function to print contents of 
//a vector from index i to it's end 
static void printVector( Vector<Integer> v, int i) 
{ 
	for (int j = i; j < v.size(); j++) 
		System.out.print( v.get(j) + " "); 
		System.out.println(); 
} 

// binary tree node 
static class Node 
{ 
	int data; 
	Node left,right; 
	Node(int x) 
	{ 
		data = x; 
		left = right = null; 
	} 
}; 
static Vector<Integer> path = new Vector<Integer>(); 

// This function prints all paths that have sum k 
static void printKPathUtil(Node root, int k) 
{ 
	// empty node 
	if (root == null) 
		return; 

	// add current node to the path 
	path.add(root.data); 

	// check if there's any k sum path 
	// in the left sub-tree. 
	printKPathUtil(root.left, k); 

	// check if there's any k sum path 
	// in the right sub-tree. 
	printKPathUtil(root.right, k); 

	// check if there's any k sum path that 
	// terminates at this node 
	// Traverse the entire path as 
	// there can be negative elements too 
	int f = 0; 
	for (int j = path.size() - 1; j >= 0; j--) 
	{ 
		f += path.get(j); 

		// If path sum is k, print the path 
		if (f == k) 
			printVector(path, j); 
	} 

	// Remove the current element from the path 
	path.remove(path.size() - 1); 
} 


//function to print the 
//zigzag traversal 
static void printZigZagTraversal(Node root) { 
   
 // if null then return 
 if (root == null) { 
 return; 
 } 

 // declare two stacks 
 Stack<Node> currentLevel = new Stack<>(); 
 Stack<Node> nextLevel = new Stack<>(); 

 // push the root 
 currentLevel.push(root); 
 boolean leftToRight = true; 

 // check if stack is empty 
 while (!currentLevel.isEmpty()) { 

 // pop out of stack 
 Node node = currentLevel.pop(); 
   
 // print the data in it 
 System.out.print(node.data + " "); 

 // store data according to current 
 // order. 
 if (leftToRight) { 
     if (node.left != null) { 
     nextLevel.push(node.left); 
     } 
       
     if (node.right != null) { 
     nextLevel.push(node.right); 
     } 
 } 
 else { 
     if (node.right != null) { 
     nextLevel.push(node.right); 
     } 
       
     if (node.left != null) { 
     nextLevel.push(node.left); 
     } 
 } 

 if (currentLevel.isEmpty()) { 
     leftToRight = !leftToRight; 
     Stack<Node> temp = currentLevel; 
     currentLevel = nextLevel; 
     nextLevel = temp; 
 } 
 } 
} 

// A wrapper over printKPathUtil() 
static void printKPath(Node root, int k) 
{ 
	path = new Vector<Integer>(); 
	printKPathUtil(root, k); 
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
// Driver code 
public static void main(String args[]) 
{ 
	//KsumPath tree =new KsumPath();
	Node root = new Node(1); 
	root.left = new Node(3); 
	root.left.left = new Node(2); 
	root.left.right = new Node(1); 
	root.left.right.left = new Node(1); 
	root.right = new Node(-1); 
	root.right.left = new Node(4); 
	root.right.left.left = new Node(1); 
	root.right.left.right = new Node(2); 
	root.right.right = new Node(5); 
	root.right.right.right = new Node(2); 
	print2D(root);
	int k = 5; 
	//printKPath(root, k);
	printZigZagTraversal(root); 
} 
} 

// This code is contributed by Arnab Kundu 
