


// Basic node stored in BST trees

public class BSTNode
{
	
	 // Friendly data; accessible by other package routines
    Comparable element;      // The data in the node
    BSTNode    left;         // Left child
    BSTNode    right;        // Right child
    int        height;       // Height
    
        // Constructors
    BSTNode( Comparable theElement )
    {
        this( theElement, null, null );
    }

    BSTNode( Comparable theElement, BSTNode lt, BSTNode rt )
    {
        element  = theElement;
        left     = lt;
        right    = rt;
        height   = 0;
    }


}