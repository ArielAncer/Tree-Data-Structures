package bst;

public class Node<E> implements Comparable<E>
{
	
/** The data stored in the node. */
public E data;

/** The node's parent. */
public Node<E> parent;

/** The node's left child. */
public Node<E> left;

/** The node's right child. */
public Node<E> right;

/** The Balance of the Node */
public int balance;

/** The nil node. */
public static Node nil;

/**
 * Initializes a node with the data and makes other pointers
 * nil.
 *
 * @param data Data to save in the node.
 */
public Node(E data)
{
	
    this.data = data;
    parent = nil;
    left = nil;
    right = nil;
}

public Node(){
	
}

public void setNil(Node<E> node)
{
nil = node;
nil.parent = nil;
nil.left = nil;
nil.right = nil;
}

/**
 * Compares this node to another node.  The comparison is
 * based on the data of the
 * two nodes.
 *
 */

// Compare this node to another node.
public int compareTo(Node<E> o)
{
    return ((Comparable<E>) data).compareTo(((Node<E>) o).data);
}

/**
 * Returns the data of the node as a String
 */
public String toString()
{
    if (this == nil)
	return "nil";
    else
	return data.toString();
}

public String toString(int depth)
{
    String result = "";

    if (right != nil)
	result += right.toString(depth + 1);

    for (int i = 0; i < depth; i++)
	result += "  ";

    result += toString() + "\n";

    if (left != nil)
	result += left.toString(depth + 1);

    return result;
}

@Override
public int compareTo(E arg0) {
	// TODO Auto-generated method stub
	return 0;
}

}
