import java.util.LinkedList;
import java.util.Queue;
// Java program to convert a ternary 
// expreesion to a tree. 

// Class to represent Tree node 

// Class to convert a ternary expression to a Tree 
class Tennis 
{ 
	
	static final int COUNT = 10;  
	
	static class Node 
	{ 
		int key; 
		Node left, right; 

		public Node(int item) 
		{ 
			key = item; 
			left = null; 
			right = null; 
		} 
	} 

	
	static Node root; 
	// Function to convert Ternary Expression to a Binary 
	// Tree. It return the root of tree 
/*	Node convertExpression(Node curr) 
	{ 
		Boolean  Aflag= false;
		Boolean Bflag = false;
		int aScore=AScore;
		int bScore=BScore;
		int times =2;	
		int set =Set;
		
		set++;
		Node root = new Node(expression); 
		if(set > 4 )
		{
			return root;
		}
		if (BScore < times * AScore)
		{
			Aflag=true;
			//root.left = new Node('A');
			Bflag=true;
			//root.right = new Node('B');
			
		}
		else
		{
			Aflag=true;
			//root.right = new Node('B');
			
		}
	
		
	
		
		if (Aflag) 
		{
			aScore++;
			expression ='A';
			set++;
			if(set > 4)
			{
				return root;
			}
			root.left = convertExpression(expression, aScore,bScore,set);
			//return root; 
		}
	
	
		if (Bflag) {
			if(Aflag)
			{
				aScore--;
				set--;
			}
			expression ='B';
			bScore++;
			set++;
			root.right = convertExpression(expression, aScore,bScore,set); 
			//return root; 
		}
		//convertExpression(expression, aScore,bScore,set);
	
		return root; 
	}  */
	
	
/*	Map<Node, Integer> maxDepth(Map<Node, Integer> Score)  
    { 
		//Map<Node, Integer> Score = new HashMap<Node, Integer>();
		
        if (node == null) 
        {
        	
            return null; 
        }
        else 
        { 
        	System.out.println("Node " +node.data);
             compute the depth of each subtree 
        	Map<Node, Integer> lDepth = maxDepth(Score); 
        	Map<Node, Integer> rDepth = maxDepth(Score); */
   
            /* use the larger one */
          /*  if (lDepth.get(Score.get)> 2*rDepth.get(node)) 
            { 	
            	Score.put(lDepth.get(node), node);
            	Score.get(key).right = new Node('A'); 
            	 root.left = new Node('B'); 
            	  
            	 System.out.println("L" + " " +lDepth+ " " + node.data);
                return (lDepth + 1); 
            }
             else 
             {
            	 root.right = new Node('A');  
            	 
            	 System.out.println("R" +" " + rDepth +" " + node.data);
                return (rDepth + 1); 
             }
        } 
    } */
	
	
	int maxDepth1(Node node)  
    { 	
		Queue<Node> q = new LinkedList<Node>(); 
        q.add(node); 
        
        
		
        if (node == null) 
        {
        	//node=node.left;
            return 0; 
        }
        else 
        { 
        	
        	System.out.println("Node " +node.key);
            /* compute the depth of each subtree */
            int lDepth = maxDepth1(node.left); 
            int rDepth = maxDepth1(node.right); 
   
            /* use the larger one */
         
            	 if (lDepth > rDepth) 
            		 
            		 
                     return (lDepth + 1); 
            	 
                  else 
                     return (rDepth + 1); 
            	 
            	 
        }
    }
        
	void printLevelOrder() 
    { 
       // int h = height(root); 
        int i; 
        for (i=1; i<=4; i++) 
            printGivenLevel(root, i,0,0); 
    } 
	
	void printGivenLevel (Node root ,int level,int L,int R) 
    { 
		
        if (root == null) 
            return; 
        if (level == 1) 
        	
            System.out.print(root.key + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1,L+1, R); 
            printGivenLevel(root.right, level-1,L,R+1); 
        } 
    } 
    
	void printLevelOrder1()  
    { 
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
        int LDepth =1;
        int RDepth=1;
        while (!queue.isEmpty())  
        { 
        	
        	
            /* poll() removes the present head. 
            For more information on poll() visit  
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.poll(); 
            if (LDepth <= 2*RDepth)
            {
            	tempNode.right =null;
            	// tempNode.left = new Node('L'); 
            }
            /*else  {
            	tempNode.left = new Node('L');
            	tempNode.right = new Node('R');
            	
            }*/
            System.out.print(tempNode.key + " "); 
  
            /*Enqueue left child */
            if (tempNode.left != null) { 
                queue.add(tempNode.left); 
                LDepth++;
            } 
           tempNode = queue.poll(); 
            if (LDepth <= 2*RDepth)
            {
            	tempNode.right =null;
            	// tempNode.left = new Node('L'); 
            }
  
            /*Enqueue right child */
            if (tempNode.right != null) { 
                queue.add(tempNode.right); 
                LDepth--;
                RDepth++;
            } 
        } 
    } 
	
	static void insert(Node temp) 
    { 
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(temp); 
       
        // Do level order traversal until we find 
        // an empty place.  
        while (!q.isEmpty()) { 
            temp = q.peek(); 
            q.remove(); 
       
            if (temp.left == null) { 
                temp.left = new Node('L'); 
                break; 
            } else
                q.add(temp.left); 
       
            if (temp.right == null) { 
                temp.right = new Node('R'); 
                break; 
            } else
                q.add(temp.right); 
        } 
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
	    System.out.print(root.key + "\n");  
	  
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
				
		System.out.print(root.key +" "); 
		printTree(root.left); 
		printTree(root.right); 
	} 
	
	void insert(int key) { 
	       root = insertRec(root, key); 
	    } 
	      
	    /* A recursive function to insert a new key in BST */
	    Node insertRec(Node root, int key) { 
	  
	        /* If the tree is empty, return a new node */
	        if (root == null) { 
	            root = new Node(key); 
	            return root; 
	        } 
	  
	        /* Otherwise, recur down the tree */
	        if (key =='L') 
	            root.left = insertRec(root.left, key); 
	        else if (key == 'R') 
	            root.right = insertRec(root.right, key); 
	  
	        /* return the (unchanged) node pointer */
	        return root; 
	    } 
	    
	    
	    void inorderRec(Node root) { 
	        if (root != null) { 
	            inorderRec(root.left); 
	            System.out.println(root.key); 
	            inorderRec(root.right); 
	        } 
	    } 
	    
	    
	    void printPaths(Node node)  
	    { 
	        int path[] = new int[1000]; 
	        printPathsRecur(node, path, 0); 
	    } 
	    
	    /* Recursive helper function -- given a node, and an array 
	       containing the path from the root node up to but not  
	       including this node, print out all the root-leaf paths.*/
	    void printPathsRecur(Node node, int path[], int pathLen)  
	    { 
	        if (node == null) 
	            return; 
	   
	        /* append this node to the path array */
	        path[pathLen] = node.key; 
	        pathLen++; 
	   
	        /* it's a leaf, so print the path that led to here  */
	        if (node.left == null && node.right == null) 
	            printArray(path, pathLen); 
	        else 
	        { 
	            /* otherwise try both subtrees */
	            printPathsRecur(node.left, path, pathLen); 
	            printPathsRecur(node.right, path, pathLen); 
	        } 
	    } 
	    
	    
	    void printArray(int ints[], int len)  
	    { 
	        int i; 
	        for (i = 0; i < len; i++)  
	        { 
	            System.out.print(ints[i] + " "); 
	        } 
	        System.out.println(""); 
	    } 
	
// Driver program to test above function 
	public static void main(String args[]) 
	{ 
		String exp = "a?b?c:d:e?b"; 
		Tennis tree = new Tennis(); 
		char[] expression=exp.toCharArray(); 
		//Node root; 
		//Tennis.root = new Node(1); 
		//Node root =tree.convertExpression('1', 0,0,0); 
		tree.root = new Node(1);  
	/*    root.left = new Node(2);  
	    root.right = new Node(3);  
	  
	    root.left.left = new Node(4);  
	    root.left.right = new Node(5);  
	    root.right.left = new Node(6);  
	    root.right.right = new Node(7);  
	  
	    root.left.left.left = new Node(8);  
	    root.left.left.right = new Node(9);  
	    root.left.right.left = new Node(10);  
	   root.left.right.right = new Node(11);  
	    root.right.left.left = new Node(12);  
	   root.right.left.right = new Node(13);  
	  root.right.right.left = new Node(14);  
	    root.right.right.right = new Node(15); */
	    
	//	tree.printTree(root) ; 
	//	print2D(root); 
		int level=0;
			for(int i=0;i<15;i++)
		{
			//level =tree.maxDepth1(root); 
			tree.insert(root);
			tree.insert(root);
			// tree.insert('L');
			// tree.insert('R');
		}
		
	/*	tree.root= new Node(1); 
	       tree.root.left= new Node(2); 
	       tree.root.right= new Node(3); 
	       tree.root.left.left= new Node(4); 
	       tree.root.left.right= new Node(5); */ 
	         
	//	level =tree.maxDepth1(root); 
		print2D(root);
	//	tree.printTree(root) ; 
		//tree.printLevelOrder();
		tree.printLevelOrder1();
		
		print2D(root);
		
		 tree.printPaths(tree.root); 
		
		
		
	/*	System.out.println("Height of tree is : " + level + " " +
                tree.maxDepth1(root)); */
	} 
} 

/* This code is contributed by Mr. Somesh Awasthi */
