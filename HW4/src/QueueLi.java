//Weiss Queue using Linked List Implementation

public class QueueLi {
	
	
    /** 
     * Construct the queue.
     */
    public QueueLi( ) {
        front = back = null;
    }
    
    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return front == null;
    }
    
    /**
     * Insert a new item into the queue.
     * @param x the item to insert.
     */
    public void enqueue( Object x ) {
        if( isEmpty( ) )    // Make queue of one element
            back = front = new ListNode( x );
        else                // Regular case
            back = back.next = new ListNode( x );
    }
    
    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     * @throws UnderflowException if the queue is empty.
     */
    public Object dequeue( ) {
        if( isEmpty( ) )
        	System.err.println("Queue empty!");
        
        Object returnValue = front.element;
        front = front.next;
        return returnValue;
    }

    //put in new for Index.java
    public Object peek()
    {
    	if(front != null)
    		return front.element;
    	else
    		return null;
    }
    
    
    private ListNode front;
    private ListNode back;
}