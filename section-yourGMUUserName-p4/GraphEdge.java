//TODO: Nothing, all done.

import org.apache.commons.collections15.Factory;

import java.awt.Color;

/**
 *  An edge representation for the graph simulation.
 *  
 *  @author Katherine (Raven) Russell
 */
class GraphEdge extends GraphComp {
	/**
	 *  The number of edges created so far (for gerating unique ids
	 *  from the factory method).
	 */
	public static int edgeCount = 0;
	
	/**
	 *  Constructs an edge with a given id.
	 *  
	 *  @param id the unique id of the edge
	 */
	public GraphEdge(int id) { this.id = id; this.color = Color.BLACK; }
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public String toString() { return ""; }
	
	/**
	 *  Generates a new edge with a random weight and a (probably)
	 *  unique id.
	 *  
	 *  @return a new edge with a random weight
	 */
	public static Factory<GraphEdge> getFactory() { 
		return new Factory<GraphEdge> () {
			public GraphEdge create() {
				return new GraphEdge(edgeCount++);
			}
		};
	}
}
