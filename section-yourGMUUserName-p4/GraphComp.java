//TODO: Nothing, all done.

import java.awt.Color;

/**
 *  An parent class for graph components, such as nodes and edges.
 *  
 *  @author Katherine (Raven) Russell
 */
class GraphComp implements Comparable<GraphComp> {
	/**
	 *  A unique identifier for this item.
	 */
	protected int id;
	
	/**
	 *  Fetches the id of the component.
	 *  
	 *  @return the id of the component
	 */
	public int getId() { return id; }
	
	/**
	 *  The color of the component (for the GUI).
	 */
	protected Color color;
	
	/**
	 *  Fetches the color of the component.
	 *  
	 *  @return the color of the component
	 */
	public Color getColor() { return color; }
	
	/**
	 *  Sets the color of the component.
	 *  
	 *  @param color the color of the component
	 */
	public void setColor(Color color) { this.color = color; }
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof GraphComp) {
			return this.id == ((GraphComp)o).id;
		}
		return false;
	}
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public int compareTo(GraphComp n) { return this.id-n.id; }
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public int hashCode() { return id; }
}