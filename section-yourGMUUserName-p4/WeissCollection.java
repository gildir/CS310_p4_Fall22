//TODO: Nothing, all done.

import java.util.Iterator;

/**
 * Collection interface; the root of all 1.5 collections.
 *
 * @param <T> the type of items in this collection
 */
public interface WeissCollection<T> extends Iterable<T>, java.io.Serializable
{
	/**
	 * Returns the number of items in this collection.
	 * @return the number of items in this collection.
	 */
	int size( );
	
	/**
	 * Tests if this collection is empty.
	 * @return true if the size of this collection is zero.
	 */
	boolean isEmpty( );
	
	/**
	 * Tests if some item is in this collection.
	 * @param x any object.
	 * @return true if this collection contains an item equal to x.
	 */
	boolean contains( Object x );
	
	/**
	 * Adds an item to this collection.
	 * @param x any object.
	 * @return true if this item was added to the collection.
	 */
	boolean add( T x );
	
	/**
	 * Removes an item from this collection.
	 * @param x any object.
	 * @return true if this item was removed from the collection.
	 */
	boolean remove( Object x );
	
	/**
	 * Change the size of this collection to zero.
	 */
	void clear( );
	
	/**
	 * Obtains an Iterator object used to traverse the collection.
	 * @return an iterator positioned prior to the first element.
	 */
	Iterator<T> iterator( );
	
	/**
	 * Obtains a primitive array view of the collection.
	 * @return the primitive array view.
	 */
	Object [ ] toArray( );
	
	/**
	 *  Returns an array copy of this collection as type E.
	 *  
	 *  @param <E> the other type for the new array
	 *  @param arr an example array for using reflection to creates the array desired
	 *  @return the array representation of this collection
	 */
	<E> E [ ] toArray( E [ ] arr );
}
