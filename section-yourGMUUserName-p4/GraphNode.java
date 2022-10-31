//TODO: Nothing, all done.

import org.apache.commons.collections15.Factory;

import java.awt.Color;

/**
 *  A node representation for the graph simulation.
 *  
 *  @author Katherine (Raven) Russell
 */
class GraphNode extends GraphComp {
	/**
	 *  The number of nodes created so far (for gerating unique ids
	 *  from the factory method).
	 */
	public static int nodeCount = 0;
	
	/**
	 *  The boolean flag to indicate whether a node is active or not.
	 *  Used to support certain graph algorithms.
	 */
	private boolean active; 
	
	/**
	 *  The integer cost associated with each node.
	 *  Used to support certain graph algorithms.
	 */
	private int cost;

	/**
	 *  The byte used as 8 boolean bits used to support graph coloring algorithms.
	 *  Assume no more than 8 possible color and they are defined in ThreeTenColor.COLORS.
	 *  nbrColorFlag[i] == 1: this node has a nbr taking color ThreeTenColor.COLORS[i]
	 *  nbrColorFlag[i] == 0: this node has no nbr taking color ThreeTenColor.COLORS[i]
	 */
	private byte nbrColors; 
	
	/**
	 *  Constructs a node with a given id.
	 *  
	 *  @param id the unique id of the node
	 */
	public GraphNode(int id) { 
		this.id = id; this.color = Color.WHITE; 
		this.active = false;
		this.cost = 0;
		this.nbrColors = 0;
	}
	
	/**
	 *  Set this node to be active.
	 */
	public void setActive(){ active = true; }

	/**
	 *  Set this node to be inactive.
	 */
	public void unsetActive(){ active = false; }

	/**
	 *  Report the active status of this node.
	 *  @return whether this node is active or not
	 */
	public boolean isActive() {return active; }

	/**
	 *  Set the cost of this node to be the incoming value.
	 *  
	 *  @param cost the cost to set for this node
	 */
	public void setCost(int cost) { this.cost = cost; }

	/**
	 *  Report the cost of this node.
	 *  @return the cost of this node
	 */
	public int getCost() { return this.cost; }
								
	/**
	 *  Clear the information about the colors of neighbor nodes.
	 *  Set all 8 bits to be 0.
	 */
	public void clearNbrColors(){
		nbrColors = 0;
	}
	
	/**
	 *  One neighbor of this node has been assigned color ThreeTenColor.COLORS[index].
	 *  Update the record of nbrColors of this node based on this color assignment. 
	 *  
	 *  @param index the color index assigned to one neighbor
	 *  @return return false if invalid index; return true otherwise
	 */
	public boolean setNbrColor(int index){
		if (index<0 || index>=ThreeTenColor.COLORS.length)
			return false;
		
		nbrColors = (byte) (nbrColors | (1<<index));
		return true;
	}

	/**
	 *  Report whether this node has any neighbor with the color 
	 *  defined as ThreeTenColor.COLORS[index].
	 * 
	 *  @param index the color index 
	 *  @return return true if there is a neighbor of this node taken the color; false otherwise
	 */	
	public boolean nbrHasColor(int index){
		if (index<0 || index>=ThreeTenColor.COLORS.length)
			throw new IllegalArgumentException("Invalid color index.");

		return (((nbrColors>>index) & 1) != 0);
	}
	
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public int compareTo(GraphComp n) { 
		if (!(n instanceof GraphNode)){
			return super.compareTo(n);
		}
		GraphNode node = (GraphNode) n;
		if (this.cost!=node.cost)
			return node.cost - this.cost;
		else
			return this.id-n.id; //use id to break the tie
	}

	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "" + id + (active ? ":"+cost : "");
	}
	
	/**
	 *  Generates a new node with a (probably) unique id.
	 *  
	 *  @return a new node
	 */
	public static Factory<GraphNode> getFactory() { 
		return new Factory<GraphNode> () {
			public GraphNode create() {
				return new GraphNode(nodeCount++);
			}
		};
	}
}
