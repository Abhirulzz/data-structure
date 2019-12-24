public class SingleValue {

	static class Node {

		int data;
		Node left;
		Node right;

		// Constructor
		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	int count = 0;

	boolean is_uni(Node node) {

		// base case - if the node has no children this is a univalue subtree
		if (node.left == null && node.right == null) {

			// found a univalue subtree - increment
			count++;
			return true;
		}

		boolean is_unival = true;

		// check if all of the node's children are univalue subtrees and if they have
		// the same value
		// also recursively call is_uni for children
		if (node.left != null) {
			is_unival = is_uni(node.left) && is_unival && node.left.data == node.data;
		}

		if (node.right != null) {
			is_unival = is_uni(node.right) && is_unival && node.right.data == node.data;
		}

		// return if a univalue tree exists here and increment if it does
		if (!is_unival)
		{
			return false;
		}
		count++;
		return true;
	}

	public int countUnivalSubtrees(Node root) {
		if (root == null)
			return 0;
		is_uni(root);
		return count;
	}

	Node root;

	SingleValue() {
		root = null;
	}

	public static void main(String args[])

	{
		SingleValue tree = new SingleValue();
		tree.root = new Node(1);
		tree.root.left = new Node(5);
		tree.root.right = new Node(1);
		tree.root.right.right = new Node(5);

		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(5);
		int count = tree.countUnivalSubtrees(tree.root);
		System.out.print("SingleValued " + count);
	}
}