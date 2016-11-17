

    // BinarySearchTree class
    //
    // CONSTRUCTION: with no initializer
    //
    // ******************PUBLIC OPERATIONS*********************
    // void insert( x )       --> Insert x
    // void remove( x )       --> Remove x (unimplemented)
    // Comparable find( x )   --> Return item that matches x
    // Comparable findMin( )  --> Return smallest item
    // Comparable findMax( )  --> Return largest item
    // boolean isEmpty( )     --> Return true if empty; else false
    // void makeEmpty( )      --> Remove all items
    // void printTree( )      --> Print tree in sorted order

    /**
     * Implements an AVL tree.
     * Note that all "matching" is based on the compareTo method.
     * @author Mark Allen Weiss, Ananya Das
     */
    public class BinarySearchTree
    {
        /**
         * Construct the tree.
         */
        public BinarySearchTree( )
        {
            root = null;
        }

        /**
         * Insert into the tree; duplicates are ignored.
         * @param x the item to insert.
         */
        public void insert( Comparable x )
        {
            root = insert( x, root );
        }

    
        /**
         * Remove from the tree. Nothing is done if x is not found.
         * @param x the item to remove.
         */
        public void remove( Comparable x )
        {
         	remove(x, root);
        }

        
        
        /**
         * Remove x from the tree. Nothing is done if x is not found.
         * Written by Ananya Das 7/09/10
         */
         public void remove(Comparable x, BSTNode t)
         {
           if( t == null ) // never found x
             return; // do nothing
           else
        	 if(x.compareTo(t.element) < 0) //if x is less than element, go to left  
               remove( x, t.left);
             else
               if( x.compareTo(t.element) > 0 )//if x is greater than element, go to right
                 remove( x, t.right);
               else // x = current (root) value
               {
            	 if(t.right != null  && t.left != null) // if two children
                 {
                   t.element = findMin(t.right).element; 
                   // set this node to minimum of right subtree
                   remove(t.element, t.right);  
                   // remove the element we just duplicated from the right side of the tree
                 }  
                 else // if one or no children
                 {
                   BSTNode temp = null; // default is being a leaf
                   if(t.left != null)  // only left child
                     temp = t.left;
                   else
                     if(t.right != null) // only right child
                       temp = t.right;

                   //delete t;
                   t = temp;
                 }  // else less than two children
               } // found x
           // Now check and restore AVL property.  This is done for whole path from root.
           if(t != null)
        	   //Case 1
             if( height( t.left ) - height( t.right ) == 2 )  // left subtree too high
               if( height(t.left.left) >  height(t.left.right))
                 rotateWithLeftChild( t );
               else
                 doubleWithLeftChild( t );
               else //just flip side of above
                 if( height( t.left ) - height( t.right ) == -2 ) // right subtree too high
                   if( height(t.right.right) > height(t.right.left))
                     rotateWithRightChild( t );
                   else
                     doubleWithRightChild( t );

           if(t!=null)
             t.height = max(height(t.left), height( t.right)) + 1;
         } // remove()
      
        
          
        /**
         * Find the smallest item in the tree.
         * @return smallest item or null if empty.
         */
        public Comparable findMin( )
        {
            return elementAt( findMin( root ) );
        }

        /**
         * Find the largest item in the tree.
         * @return the largest item of null if empty.
         */
        public Comparable findMax( )
        {
            return elementAt( findMax( root ) );
        }

        /**
         * Find an item in the tree.
         * @param x the item to search for.
         * @return the matching item or null if not found.
         */
        public Comparable find( Comparable x )
        {
            return elementAt( find( x, root ) );
        }

        /**
         * Make the tree logically empty.
         */
        public void makeEmpty( )
        {
            root = null;
        }

        /**
         * Test if the tree is logically empty.
         * @return true if empty, false otherwise.
         */
        public boolean isEmpty( )
        {
            return root == null;
        }

        /**
         * Print the tree contents in sorted order.
         */
        public void printTree( )
        {
            if( isEmpty( ) )
                System.out.println( "Empty tree" );
            else
                printTree( root );
        }

        /**
         * Internal method to get element field.
         * @param t the node.
         * @return the element field or null if t is null.
         */
        private Comparable elementAt( BSTNode t )
        {
            return t == null ? null : t.element;
        }

        /**
         * Internal method to insert into a subtree.
         * @param x the item to insert.
         * @param t the node that roots the tree.
         * @return the new root.
         */
        private BSTNode insert( Comparable x, BSTNode t )
        {
            if( t == null )
                t = new BSTNode( x, null, null );
            else if( x.compareTo( t.element ) < 0 )
            {
                t.left = insert( x, t.left );
                if( height( t.left ) - height( t.right ) == 2 )
                    if( x.compareTo( t.left.element ) < 0 )
                        t = rotateWithLeftChild( t );
                    else
                        t = doubleWithLeftChild( t );
            }
            else if( x.compareTo( t.element ) > 0 )
            {
                t.right = insert( x, t.right );
                if( height( t.right ) - height( t.left ) == 2 )
                    if( x.compareTo( t.right.element ) > 0 )
                        t = rotateWithRightChild( t );
                    else
                        t = doubleWithRightChild( t );
            }
            else
                ;  // Duplicate; do nothing
            t.height = max( height( t.left ), height( t.right ) ) + 1;
            return t;
        }

        /**
         * Internal method to find the smallest item in a subtree.
         * @param t the node that roots the tree.
         * @return node containing the smallest item.
         */
        private BSTNode findMin( BSTNode t )
        {
            if( t == null )
                return t;

            while( t.left != null )
                t = t.left;
            return t;
        }

        /**
         * Internal method to find the largest item in a subtree.
         * @param t the node that roots the tree.
         * @return node containing the largest item.
         */
        private BSTNode findMax( BSTNode t )
        {
            if( t == null )
                return t;

            while( t.right != null )
                t = t.right;
            return t;
        }

        /**
         * Internal method to find an item in a subtree.
         * @param x is item to search for.
         * @param t the node that roots the tree.
         * @return node containing the matched item.
         */
        private BSTNode find( Comparable x, BSTNode t )
        {
            while( t != null )
                if( x.compareTo( t.element ) < 0 )
                    t = t.left;
                else if( x.compareTo( t.element ) > 0 )
                    t = t.right;
                else
                    return t;    // Match

            return null;   // No match
        }

        /**
         * Internal method to print a subtree in sorted order.
         * @param t the node that roots the tree.
         */
        private void printTree( BSTNode t )
        {
            if( t != null )
            {
                printTree( t.left );
                System.out.println( t.element );
                printTree( t.right );
            }
        }

        /**
         * Return the height of node t, or -1, if null.
         */
        private static int height( BSTNode t )
        {
            return t == null ? -1 : t.height;
        }

        /**
         * Return maximum of lhs and rhs.
         */
        private static int max( int lhs, int rhs )
        {
            return lhs > rhs ? lhs : rhs;
        }

        /**
         * Rotate binary tree node with left child.
         * For AVL trees, this is a single rotation for case 1.
         * Update heights, then return new root.
         */
        private static BSTNode rotateWithLeftChild( BSTNode k2 )
        {
            BSTNode k1 = k2.left;
            k2.left = k1.right;
            k1.right = k2;
            k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
            k1.height = max( height( k1.left ), k2.height ) + 1;
            return k1;
        }

        /**
         * Rotate binary tree node with right child.
         * For AVL trees, this is a single rotation for case 4.
         * Update heights, then return new root.
         */
        private static BSTNode rotateWithRightChild( BSTNode k1 )
        {
            BSTNode k2 = k1.right;
            k1.right = k2.left;
            k2.left = k1;
            k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
            k2.height = max( height( k2.right ), k1.height ) + 1;
            return k2;
        }

        /**
         * Double rotate binary tree node: first left child
         * with its right child; then node k3 with new left child.
         * For AVL trees, this is a double rotation for case 2.
         * Update heights, then return new root.
         */
        private static BSTNode doubleWithLeftChild( BSTNode k3 )
        {
            k3.left = rotateWithRightChild( k3.left );
            return rotateWithLeftChild( k3 );
        }

        /**
         * Double rotate binary tree node: first right child
         * with its left child; then node k1 with new right child.
         * For AVL trees, this is a double rotation for case 3.
         * Update heights, then return new root.
         */
        private static BSTNode doubleWithRightChild( BSTNode k1 )
        {
            k1.right = rotateWithLeftChild( k1.right );
            return rotateWithRightChild( k1 );
        }


        //Calls the recursive preorder method. 
        //smaller is the lower bounding value and larger is the higher bounding value
        public void preorder(Comparable smaller, Comparable larger)
        {
        	BSTNode t = root;
        	
        	preorder(smaller, larger, t);
        } 
        
        //Calls the recursive postorder method. 
        //smaller is the lower bounding value and larger is the higher bounding value
        public void postorder(Comparable smaller, Comparable larger)
        {
        	BSTNode t = root;
        	
        	postorder(smaller, larger, t);
        }
         
        
        //Calls the recursive inorder method. 
        //smaller is the lower bounding value and larger is the higher bounding value
        public void inorder(Comparable smaller, Comparable larger)
        {
        	BSTNode t = root;
        	
        	inorder(smaller, larger, t);
        }
       
      
        
        public void preorder(Comparable smaller, Comparable larger, BSTNode t )
        {
        	if(smaller.compareTo(t.element)==1){//if(t < smaller)
        		if(t.right==null){//if there is no right child
        		}
        		else
        			preorder(smaller, larger, t.right);//call preorder on the right child
        	}
        	
        	else if(smaller.compareTo(t.element)==0){ // if(smaller = t)
        		System.out.println(t.element);//print the element
        		preorder(smaller,larger,t.right);//call preorder on the right child
        	}
        	
        	else if(larger.compareTo(t.element)==0){// if(larger = t)
        		System.out.println(t.element);//print the element
        		preorder(smaller,larger,t.left);//call preorder on left child
        	}
        	
        	else if(smaller.compareTo(t.element)==-1&&larger.compareTo(t.element)==1){//if(smaller < t < larger )
        		if(t.right==null&&t.left==null)//if there are no children
        			System.out.println(t.element);//print the element
        		else if(t.right==null){//if there is no right child
        			System.out.println(t.element);//print the element
        			preorder(smaller,larger,t.left);//call preorder on left child
        		}
        		else if(t.left==null){//if there is no left child
        			System.out.println(t.element);//print the element
        			preorder(smaller,larger,t.right);//call preorder on the right child
        		}
        		else{
        			System.out.println(t.element);//print the element
        			preorder(smaller,larger,t.left);//call preorder on left child
        			preorder(smaller,larger,t.right);//call preorder on the right child
        		}
        	}
        	
        	else if(larger.compareTo(t.element)==-1){ //if(larger < t)
        		if(t.left==null){//if there is no left child
        		}
        		else
        			preorder(smaller,larger,t.left);//call preorder on left child
        	}

        }   	  
        
   
        public void postorder(Comparable smaller, Comparable larger, BSTNode t )
        {
        	if(smaller.compareTo(t.element)==1){//if(t < smaller)
        		if(t.right==null){
        		}
        		else
        			postorder(smaller, larger, t.right);//call postorder on the right child
        	}
        	
        	else if(smaller.compareTo(t.element)==0){ // if(smaller = t)
        		postorder(smaller,larger,t.right);//call postorder on the right child
        		System.out.println(t.element);//print the element
        	}
        	
        	else if(larger.compareTo(t.element)==0){// if(larger = t)
        		postorder(smaller,larger,t.left);//call postorder on left child
        		System.out.println(t.element);//print the element
        	}
        	
        	else if(smaller.compareTo(t.element)==-1&&larger.compareTo(t.element)==1){//if(smaller < t < larger )
        		if(t.right==null&&t.left==null)//if there are no children
        			System.out.println(t.element);//print the element
        		else if(t.right==null){//if there is no right child
        			postorder(smaller,larger,t.left);//call postorder on left child
        			System.out.println(t.element);//print the element
        		}
        		else if(t.left==null){//if there is no left child
        			postorder(smaller,larger,t.right);//call postorder on the right child
        			System.out.println(t.element);//print the element
        		}
        		else{
        			postorder(smaller,larger,t.left);//call postorder on left child
        			postorder(smaller,larger,t.right);//call postorder on the right child
        			System.out.println(t.element);//print the element
        		}
        	}
        	
        	else if(larger.compareTo(t.element)==-1){ //if(larger < t)
        		if(t.left==null){//if there is no left child
        		}
        		else
        			postorder(smaller,larger,t.left);//call preorder on left child
        	}

        	
          

        } 	


        public void inorder(Comparable smaller, Comparable larger, BSTNode t )
        {
        	if(smaller.compareTo(t.element)==1){//if(t < smaller)
        		if(t.right==null){
        		}
        		else
        			inorder(smaller, larger, t.right);//call inorder on the right child
        	}
        	
        	else if(smaller.compareTo(t.element)==0){ // if(smaller = t)
        		System.out.println(t.element);//print the element
        		inorder(smaller,larger,t.right);//call inorder on the right child
        	}
        	
        	else if(larger.compareTo(t.element)==0){// if(larger = t)
        		System.out.println(t.element);//print the element
        		inorder(smaller,larger,t.left);//call inorder on left child
        	}
        	
        	else if(smaller.compareTo(t.element)==-1&&larger.compareTo(t.element)==1){//if(smaller < t < larger )
        		if(t.right==null&&t.left==null)//if there are no children
        			System.out.println(t.element);//print the element
        		else if(t.right==null){//if there is no right child
        			inorder(smaller,larger,t.left);//call inorder on left child
        			System.out.println(t.element);//print the element
        		}
        		else if(t.left==null){//if there is no left child
        			System.out.println(t.element);//print the element
        			inorder(smaller,larger,t.right);//call inorder on the right child
        		}
        		else{
        			inorder(smaller,larger,t.left);//call inorder on left child
        			System.out.println(t.element);//print the element
        			inorder(smaller,larger,t.right);//call inorder on the right child
        		}
        	}
        	
        	else if(larger.compareTo(t.element)==-1){ //if(larger < t)
        		if(t.left==null){//if there is no left child
        		}
        		else
        			preorder(smaller,larger,t.left);//call inorder on left child
        	}

        } 	

                
        public void levelorder()
        {
          BSTNode node;
          Queue queue = new Queue();

          queue.enqueue(root);

          while(!queue.isEmpty())
          {
            node = (BSTNode) queue.dequeue();
            System.out.println(node.element+" ");
            if(node.left != null)
              queue.enqueue(node.left);
            if(node.right != null)
              queue.enqueue(node.right);
          }  // while more in the queue

        }  // levelorder()
   
 
        
        
          /** The tree root. */
        public static BSTNode root;


             
        
        
}