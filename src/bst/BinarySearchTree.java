package bst;

import java.util.Random;

	public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>
	{  
	 
	    
	 public static void main(String args[]){
		 
		  BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();  
		  
		  bst.testTree(bst);
		  		  
	 }	 

	    /**
	     * Creates a binary search tree with just a <code>nil</code>,
	     * which is the root.
	     */
	    public BinarySearchTree()
	    {
		setNil(new Node<E>(null));
		root = nil;
	    }    
 
	    /**
	     * Inserts a node into the tree.
	     *
	     * @param z The node to insert.
	     */
	    public void treeInsert(Node<E> z)
	    {
		Node<E> y = nil;
		Node<E> x = root;

		while (x != nil) {
		    y = x;
		    if (z.compareTo(x) <= 0)
			x = x.left;
		    else
			x = x.right;
		}

		z.parent = y;
		if (y == nil)
		    root = z;		
		else {
		    if (z.compareTo(y) <= 0)
			y.left = z;
		    else
			y.right = z;
		}
	    }    
		 
	    /**
	     * Removes a node from the tree.
	     *
	     * @param k The data of the node to be removed.
	     */
	    
	    public void delete(Comparable<E> k){
	    	
	    	Node<E> dNode = search(k);
	    	delete(dNode);
	    }
	    
	    /**
	     * Removes a node from the tree.
	     *
	     * @param node The node to be removed.
	     */
	    
	    
	    public void delete(Node<E> d){
	    	
	    	Node<E> y = nil;
	    	
	    	if( d.right == nil && d.left == nil ){
	    		if( d.parent.left == d ){
	    			d.parent.left = nil;
	    		}else{
	    			d.parent.right = nil;
	    		}
	    	}else{
	    		
	    	y = successor(d);
	    	
	    	d.data = y.data;
	    			
	    	if( y.right != nil){
	    		d.right = y.right;
	    		y.right.parent = d;
	    	}
	    	
	    	if( y.parent.left == y ){
    			y.parent.left = nil;
    		}else{
    			y.parent.right = nil;
    		}
	    	
	    	}

	    	cut(y);
	    }


	    /**
	     * Returns the node with the minimum key in the subtree rooted at
	     * a node.
	     *
	     * @param x Root of the subtree.
	     * @return A <code>Node</code> object with the minimum key in the
	     * tree, or the sentinel <code>nil</code> if the tree is empty.
	     */
	 
	    public Node<E> treeMinimum(Node<E> x)
	    {
		while (x.left != nil)
		    x = x.left;

		return x;
	    }
	 
	    /**
	     * Returns the successor of a given node in the tree.
	     *
	     */
	    
	    public Node<E> successor(Node<E> node)
	    {
		Node<E> x = (Node<E>) node;
		
		if (x.right != nil)
		    return treeMinimum(x.right);

		Node<E> y = x.parent;
		while (y != nil && x == y.right) {
		    x = y;
		    if (y.parent == nil) /// NOT SURE
			    return treeMinimum(y.right);
		    y = y.parent;
		}

		
		return y;
	    }
	    
		 
		 /**
		  * Add up to ten random integer nodes to the tree and delete one searching each time
		  * if the tree contains the node. Print the tree before the deletion and afterwards 
		  * alongside the PreOrder, InOrder and PostOrder Lists.
		  * 
		  * ## NOTE ## Tilt head to left to see the tree better.
		  * 
		  * @param bst
		  */
		 public void testTree(BinarySearchTree<Integer> bst){
			 
			 Random rg = new Random();
			 int data = 0;
			 
			 for( int i = 0; i < 10; i++ ){

				 data = rg.nextInt(10)+1;
				 if( bst.search(data) == nil ){
				 bst.insert(data);
				 } 
				 
			 }

			 System.out.println("Before Deletion:\n\n" + bst.toString() + "-------------\n" );
			 
			 	data = 0;
				 while( bst.search(data) == nil ){
					 data = rg.nextInt(10)+1;
					 }

				 System.out.println("Deleted: " + data);
				 bst.delete(data);
			 
			 System.out.println( "\nFinal Tree:\n\n" + bst.toString() );

			 System.out.println("PreOrder List: " + bst.preorderWalk().toString());
			 System.out.println("InOrder List: " + bst.preorderWalk().toString());
			 System.out.println("PostOrder List: " + bst.preorderWalk().toString());
			 
		 }
		 

	}
