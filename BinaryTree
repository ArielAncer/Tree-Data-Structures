package bst;

import java.util.ArrayList;
import java.util.Random; 

public class BinaryTree<E> extends Node<E> {
	
	public Node<E> root;

	private Node<E> found;
	
	public static void main( String args[] ){
		
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		
		bt.testTree(bt);
	}
	
    public BinaryTree(){	 
    	setNil(new Node<E>(null));
    	root = nil;
    }
    
/**
 * create a new node with the data specified in the param E and call
 * method treeInsert on it.
 * 
 * @param data
 * @return inserted node
 */
	public Node<E> insert(E data){		
	Node<E> z = new Node<E>(data);
	treeInsert(z);
	
	return z;
	}
	/**
	 * Randomly ' flip a coin ' to decide weather to add the node z as a leaf to the
	 * left subtree or to the right subtree provided the left or right subtree is 'nil'.
	 * 
	 * @param z
	 */
	public void treeInsert(Node<E> z){
		
		Node<E> x = root;
		Node<E> y = nil;
		Random rg = new Random();
		int comp = 0;
	
		while( x != nil ){
			y = x;
			comp = rg.nextInt(2);			
			if( comp == 0 ){
				x = x.left;
			}else{
				x = x.right;
			}
		}
		if( y == nil ){
			root = z;
		} else{
		z.parent = y;
		comp = rg.nextInt(2);
		
		if( y.left != nil){
			comp = 1;
		}else if( y.right !=nil ){
			comp = 0;
		}
		
		if( comp == 0 ){
			y.left = z;
		}else{
			y.right = z;
		}
		}
		
	}
	
	/**
	 * Method to assist the calling of search( Node<E> x, Comparable<E> k ) params
	 * 
	 * @param k
	 * @return found node
	 */
    public Node<E> search(Comparable<E> k)
    { 
    found = nil;
	return search(root, k);
    }
    
    /**
     * Search for a node that contains data that matches param k
     * 
     * @param x
     * @param k
     * @return found node
     */
    public Node<E> search(Node<E> x, Comparable<E> k)
    { 	
    	  	
    	if( x != nil){
    		if(x.left != nil){
    		search( x.left , k);
    		}
    		if(x.right != nil){
    		search( x.right , k);
    		}
    	} 

    	if ( x != nil && k.compareTo(x.data) == 0){
    		found = x;
    	}
    	
    	return found;
    }
    
    /**
     * Remove a node from the tree completely by changing
     * it's data, parent, left and right children and replacing 
     * each with a ' nil ' node.
     * 
     * @param x
     */
    public void cut( Node<E> x ){
    	
       	if( x.parent.right == x ){
    		x.parent.right = nil;
    	}else{
    		x.parent.left = nil;
    	}
    	
    	x = nil;
    	x.parent = nil;
    	x.left = nil;
    	x.right = nil;
    	
    }
    
    /**
     * Delete a node and search for a random leaf to replace it.
     * 
     * @param k
     */
    public void delete(Comparable<E> k){
    	
    	Node<E> dNode = search(k);
    	
    	Node<E> x = root;
    	
    	Random rg = new Random();
    	
    	int comp = 0;
    	
    	if( dNode.left != nil && dNode.right != nil){
    	
    	while( x.left != nil || x.right != nil ){
    		
    		comp = rg.nextInt(2);
    		
    		if( comp == 0 ){
    			if( x.right != nil){
    			x = x.right;
    			}else{
    				x = x.left;
    			}
    		}else{
    			if( x.left != nil){
        			x = x.left;
        			}else{
        				x = x.right;
        			}
    		}
    		
    	}
    	
    	dNode.data = x.data;
    	
    	cut(x);
    	
    	}else{
    		
    	cut(dNode);
    	
    	}
    }
	
    /**
     * Creates and returns an inorder ArrayList of the trees nodes'.
     * 
     * @return the ArrayList
     */
    public ArrayList<E> inorderWalk()
    {
    ArrayList<E> inOrder = new ArrayList<E>();
	inorderWalk(root, inOrder);
	return inOrder;
    }

    /**
     * Performs an inorder walk of the the subtree rooted at a Node<E>,
     * applying a <code>Visitor</code> to each Node<E> in the subtree.
     *
     * @param x Root of the subtree.
     * @param visitor Object implementing <code>Visitor</code> whose
     * <code>visit</code> method is applied to each Node<E> in the
     * subtree.
     */
    public void inorderWalk(Node<E> x , ArrayList<E> arr)
    {
	if (x != nil) {
	    inorderWalk(x.left,arr);
	    arr.add(x.data);
	    inorderWalk(x.right,arr);
	}
    }

	
    /**
     * Creates and returns a preorder ArrayList of the trees nodes'.
     * 
     * @return the ArrayList
     */
    public ArrayList<E> preorderWalk()
    {
        ArrayList<E> preOrder = new ArrayList<E>();
    	preorderWalk(root, preOrder);
    	return preOrder;
    }

    /**
     * Performs a preorder walk of the the subtree rooted at a Node<E>,
     * applying a <code>Visitor</code> to each Node<E> in the subtree.
     *
     * @param x Root of the subtree.
     * @param visitor Object implementing <code>Visitor</code> whose
     * <code>visit</code> method is applied to each Node<E> in the
     * subtree.
     */
    public void preorderWalk(Node<E> x, ArrayList<E> arr)
    {
	if (x != nil) {
		arr.add(x.data);
	    preorderWalk(x.left, arr);
	    preorderWalk(x.right, arr);
	}
    }

	
    /**
     * Creates and returns a postorder ArrayList of the trees nodes'.
     * 
     * @return the ArrayList
     */
    public ArrayList<E> postorderWalk()
    {
        ArrayList<E> postOrder = new ArrayList<E>();
    	postorderWalk(root, postOrder);
    	return postOrder;
    }

    /**
     * Performs a postorder walk of the the subtree rooted at a Node<E>,
     * applying a <code>Visitor</code> to each Node<E> in the subtree.
     *
     * @param x Root of the subtree.
     * @param visitor Object implementing <code>Visitor</code> whose
     * <code>visit</code> method is applied to each Node<E> in the
     * subtree.
     */
    public void postorderWalk(Node<E> x, ArrayList<E> arr)
    {
	if (x != nil) {
	    postorderWalk(x.left, arr);
	    postorderWalk(x.right, arr);
	    arr.add(x.data);
	}
    }
    
    /**
     * Returns a multiline <code>String</code> representation of the
     * tree, representing the depth of each Node<E> by two spaces per
     * depth preceding the <code>String</code> representation of the
     * Node<E>.
     */
    public String toString()
    {
	return root.toString(0);
    }
    
	 /**
	  * Add up to ten random integer nodes to the tree and delete one searching each time
	  * if the tree contains the node. Print the tree before the deletion and afterwards 
	  * alongside the PreOrder, InOrder and PostOrder Lists.
	  * 
	  * ## NOTE ## Tilt head to left to see the tree better.
	  * 
	  * @param bt
	  */
	 public void testTree(BinaryTree<Integer> bt){
		 
		 Random rg = new Random();
		 int data = 0;
		 
		 for( int i = 0; i < 10; i++ ){

			 data = rg.nextInt(10)+1;
			 if( bt.search(data) == nil ){
			 bt.insert(data);
			 } 
			 
		 }

		 System.out.println("Before Deletion:\n\n" + bt.toString() + "-------------\n" );
		 
		 	data = 0;
			 while( bt.search(data) == nil ){
				 data = rg.nextInt(10)+1;
				 }

			 System.out.println("Deleted: " + data);
			 bt.delete(data);
		 
		 System.out.println( "\nFinal Tree:\n\n" + bt.toString() );

		 System.out.println("PreOrder List: " + bt.preorderWalk().toString());
		 System.out.println("InOrder List: " + bt.preorderWalk().toString());
		 System.out.println("PostOrder List: " + bt.preorderWalk().toString());
		 
	 }
   
}
