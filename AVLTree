package bst;

import java.util.Random;

public class AVLTree<E extends Comparable<E>> extends BinarySearchTree<E> {

	public AVLTree()
	{
		super();
		setNil(new Node<E>(null));
		root = nil;
	}  

	public static void main(String[] args){

		AVLTree<Integer> at = new AVLTree<Integer>();

		at.testTree(at);

	}
	
	/**
	 * Insert a Node with the data matching param E and 
	 * re-balance the tree from it upwards.
	 * @param E
	 * @return the added Node
	 */
	public Node<E> insert(E data){
		Node<E> z = new Node<E>(data);
		treeInsert(z);

		travBalance(z);

		return z;
	}
	
/**
 * Delete the Node with the data matching param k and 
 * re-balance the tree from it's parent upwards.
 * @param k
 */
	public void delete(Comparable<E> k){

		Node<E> dNode = search(k);

		Node<E> after = dNode.parent;

		delete(dNode);

		travBalance(after);

	}
 
	/**
	 * Return the height of Node z.
	 * @param z
	 * @return height of Node z
	 */
	private int getHeight(Node<E> z) {
		
		if(z == nil) {
			return -1;
		}
		
		if( z.left == nil && z.right == nil ) {
			return 0;
		} else if( z.left == nil ) {
			return 1 + getHeight(z.right);
		} else if( z.right == nil ) {
			return 1 + getHeight(z.left);
		} else {
			return 1 + Math.max(getHeight(z.left),getHeight(z.right));
		}

	}
 
	/**
	 * Update the balance for Node z by subtracting the right-child
	 * node's height by the left-child node's height.
	 * @param Node z
	 */
	private void updateBalance(Node<E> z) {
		z.balance = getHeight(z.right) - getHeight(z.left);
	}

	/**
	 * Perform a right rotation with respect to Node z.
	 * @param k
	 */
	public void rotateRight(Comparable<E> k) {

		Node<E> z = search(k);
		Node<E> y = z.left;

		y.parent = z.parent;

		z.left = y.right;

		if(z.left != nil) {
			z.left.parent = z;
		}

		y.right = z;
		z.parent = y;

		if( root == z ) {
			root = y;
		}

		if(y.parent != nil) {
			if(y.parent.left == z) {
				y.parent.left = y;
			} else if(y.parent.right == z) {
				y.parent.right = y;
			}
		}

		updateBalance(z);
		updateBalance(y);

	}

	/** Perform a left rotation with respect to Node z.
	 * @param k
	 */
	public void rotateLeft(Comparable<E> k) {

		Node<E> z = search(k);
		Node<E> y = z.right;

		y.parent = z.parent;

		z.right = y.left;

		if(z.right != nil) {
			z.right.parent = z;
		}

		y.left = z;
		z.parent = y;

		if( root == z ) {
			root = y;
		}

		if(y.parent != nil) {
			if(y.parent.right == z) {
				y.parent.right = y;
			} else if(y.parent.left == z) {
				y.parent.left = y;
			}
		}

		updateBalance(z);
		updateBalance(y);

	}
	
	/**	Traverse up the tree until the node and find the new balance factor for each Node 
	 * along the way rotating as needed if the balance is 2 or -2.
	 * @param k
	 */
	public void travBalance(Comparable<E> k) {

		Node<E> z = search(k);
		updateBalance(z);

		if( z.balance == 2 ) {
			if( getHeight(z.right.right) >= getHeight(z.right.left) ) {
				rotateLeft(z.data);
			} else {
				rotateRight(z.right.data);
				rotateLeft(z.data);
			}
		}
		else if( z.balance == -2 ) {

			if( getHeight(z.left.left) >= getHeight(z.left.right) ) {
				rotateRight(z.data);
			} else {
				rotateLeft(z.left);
				rotateRight(z.data);
			}
		}

		if(z.parent != nil) {
			z = z.parent;
			travBalance(z.data);
		} else {
			root = z;
		}
	}
	 
	 /**
	  * Add up to ten random integer nodes to the tree and delete one searching each time
	  * if the tree contains the node. Print the tree before the deletion and afterwards 
	  * alongside the PreOrder, InOrder and PostOrder Lists.
	  * 
	  * ## NOTE ## Tilt head to left to see the tree better.
	  * 
	  * @param at
	  */
	 public void testTree(AVLTree<Integer> at){
		 
		 Random rg = new Random();
		 int data = 0;
		 
		 for( int i = 0; i < 10; i++ ){

			 data = rg.nextInt(10)+1;
			 if( at.search(data) == nil ){
			 at.insert(data);
			 } 
			 
		 }

		 System.out.println("Before Deletion:\n\n" + at.toString() + "-------------\n" );
		 
		 	data = 0;
			 while( at.search(data) == nil ){
				 data = rg.nextInt(10)+1;
				 }

			 System.out.println("Deleted: " + data);
			 at.delete(data);
		 
		 System.out.println( "\nFinal Tree:\n\n" + at.toString() );

		 System.out.println("PreOrder List: " + at.preorderWalk().toString());
		 System.out.println("InOrder List: " + at.preorderWalk().toString());
		 System.out.println("PostOrder List: " + at.preorderWalk().toString());
		 
	 }
	 

}
