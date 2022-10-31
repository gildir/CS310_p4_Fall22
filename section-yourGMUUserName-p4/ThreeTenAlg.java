//TODO: Nothing, all done.

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

import javax.swing.JPanel;

/**
 *  Interface for graph algorithms in the simulator.
 *  
 *  @author Katherine (Raven) Russell
 */
interface ThreeTenAlg {
	/**
	 *  Indicates the edge type required by the algotithm.
	 *  
	 *  @return the edge type expected by the algorithm
	 */
	public EdgeType graphEdgeType();
	
	/**
	 *  Indicates if the algorithm has been started.
	 *  
	 *  @return true if the algorithm has been started
	 */
	public boolean isStarted();
	
	/**
	 *  What to do before the simulator begins.
	 */
	public void start();
	
	/**
	 *  What to do after a step to "clean up".
	 */
	public void cleanUpLastStep();
	
	/**
	 *  What to do before a step to "get started".
	 *  
	 *  @return true if there was another step setup
	 */
	public boolean setupNextStep();
	
	/**
	 *  What to actually do during a step.
	 *  
	 */
	public void doNextStep();
	
	/**
	 *  What to do when the simulator is stepped.
	 *  
	 *  @return whether or not there are more steps.
	 */
	public default boolean step() {
		if(!isStarted()) {
			start();
			return true;
		}
		
		cleanUpLastStep();
		if(!setupNextStep()) {
			finish();
			return false;
		}
		doNextStep();
		
		return true;
	}
	
	/**
	 *  What to do after the simulator finishes all steps.
	 */
	public void finish();
	
	/**
	 *  Resets the algorithm for a new graph.
	 *  
	 *  @param graph the new graph
	 */
	public void reset(Graph<GraphNode, GraphEdge> graph);
}