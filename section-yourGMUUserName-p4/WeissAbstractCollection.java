//TODO: Nothing, all done.

import java.util.Iterator;

/**
 * AbstractCollection provides default implementations for
 * some of the easy methods in the Collection interface.
 * 
 * @param <T> type of items in the collection
 */
public abstract class WeissAbstractCollection<T> implements WeissCollection<T>
{
	/**
	 * Tests if this collection is empty.
	 * @return true if the size of this collection is zero.
	 */
	public boolean isEmpty( )
	{
		return size( ) == 0;
	}
	
	/**
	 * Change the size of this collection to zero.
	 */
	public void clear( )
	{
		Iterator<T> itr = iterator( );
		while( itr.hasNext( ) )
		{
			itr.next( );
			itr.remove( );
		}
	}	
	
	/**
	 * Obtains a primitive array view of the collection.
	 * @return the primitive array view.
	 */
	public Object [ ] toArray( )
	{
		Object [ ] copy = new Object[ size( ) ];
		
		int i = 0;
		
		for( T val : this )
			copy[ i++ ] = val;
		
		return copy;	
	}
	
	/**
	 *  Returns an array copy of this collection as type E.
	 *  
	 *  @param <E> the other type for the new array
	 *  @param arr an example array for using reflection to creates the array desired
	 *  @return the array representation of this collection
	 */
	@SuppressWarnings("unchecked")
	public <E> E [ ] toArray( E [ ] arr )
	{
		int size = size( );
		
		if( arr.length < size )
			arr = ( E [ ] )java.lang.reflect.Array.newInstance( arr.getClass( ).getComponentType( ), size );
		else if( size < arr.length )
			arr[ size ] = null;
		
		Object [ ] result = arr;	
		Iterator<T> itr = iterator( );
		
		for( int i = 0; i < size; i++ )
			result[ i ] = itr.next( );
			
		return arr;
	}
	
	/**
	 * Returns true if this collection contains x.
	 * If x is null, returns false.
	 * (This behavior may not always be appropriate.)
	 * @param x the item to search for.
	 * @return true if x is not null and is found in this collection.
	 */
	public boolean contains( Object x )
	{
		if( x == null )
			return false;
		  
		for( T val : this )  
			if( x.equals( val ) )
				return true;
			
		return false;		
	}
	
	/**
	 * Adds x to this collections.
	 * This default implementation always throws an exception.
	 * @param x the item to add
	 * @return whether or not something was added to the collection
	 * @throws UnsupportedOperationException always
	 */
	public boolean add( T x )
	{
		throw new UnsupportedOperationException( );
	}
	
	 
	/**
	 * Removes non-null x from this collection.
	 * (This behavior may not always be appropriate.)
	 * @param x the item to remove.
	 * @return true if remove succeeds.
	 */
	public boolean remove( Object x )
	{
		if( x == null )
			return false;
			
		Iterator<T> itr = iterator( );
		while( itr.hasNext( ) )
			if( x.equals( itr.next( ) ) )
			{
				itr.remove( );
				return true;
			}
			
		return false;
	}
	
	/**
	 * Return true if items in other collection
	 * are equal to items in this collection
	 * (same order, and same according to equals).
	 * @param other the item to compare with this one
	 * @return whether or not the two objects are equal
	 */
	public final boolean equals( Object other )
	{
		if( other == this )
			return true;
			
		if( ! ( other instanceof WeissCollection ) )
			return false;
		
		WeissCollection rhs = (WeissCollection) other;
		if( size( ) != rhs.size( ) )
			return false;
		
		Iterator<T> lhsItr = this.iterator( );
		Iterator rhsItr = rhs.iterator( );
		
		while( lhsItr.hasNext( ) )
			if( !isEqual( lhsItr.next( ), rhsItr.next( ) ) )
				return false;
				
		return true;			
	}
	
	/**
	 * Return the hashCode.
	 * @return the hash code for this collection
	 */
	public final int hashCode( )
	{
		int hashVal = 1;
		
		for( T obj : this )
			hashVal = 31 * hashVal + ( obj == null ? 0 : obj.hashCode( ) );
		
		return hashVal;
	}
	
	/**
	 * Return true if two objects are equal; works
	 * if objects can be null.
	 * @param lhs the first item
	 * @param rhs the second item
	 * @return whether or not the two objects are equal
	 */
	private boolean isEqual( Object lhs, Object rhs )
	{
		if( lhs == null )
			return rhs == null;
		return lhs.equals( rhs );	
	}
	
	/**
	 * Return a string representation of this collection.
	 * @return the string representation of the collection
	 */
	public String toString( )
	{
		StringBuilder result = new StringBuilder( "[ " );
		
		for( T obj : this )
			result.append( obj + " " );
			
		result.append( "]" );
		
		return result.toString( );
	}	
}
