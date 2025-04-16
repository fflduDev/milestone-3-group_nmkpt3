package graph;

import java.util.ArrayList;
import java.util.List;

import graph.GraphNode;
 

public class DiGraphImpl implements DiGraph{

	private List<GraphNode> nodeList = new ArrayList<>();

	@Override
	public Boolean addNode(GraphNode node) {
		// TODO Auto-generated method stub
		if (getNode(node.getValue()) == null) {
			nodeList.add(node);
			return true;
		}
		
		//otherwise the node is there, and cannot be added.
		return false; 	
	}

	@Override
	public Boolean removeNode(GraphNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean setNodeValue(GraphNode node, String newNodeValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNodeValue(GraphNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addEdge(GraphNode fromNode, GraphNode toNode, Integer weight) {
		// TODO Auto-generated method stub
		//get the source and target nodes from the existing graph
			if (getNode(fromNode.getValue()) == null || getNode(toNode.getValue()) == null) {
					
			//if either dont exist, cant make the edge
			return false; 
			} 
				
			GraphNode targetFromNode = getNode(fromNode.getValue());
			GraphNode targetToNode = getNode(toNode.getValue());
				
			//otherwise ( they both exist ) add neighbor & weight 
			targetFromNode.addNeighbor(targetToNode, weight);
			return true;
	}

	@Override
	public Boolean removeEdge(GraphNode fromNode, GraphNode toNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean setEdgeValue(GraphNode fromNode, GraphNode toNode, Integer newWeight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getEdgeValue(GraphNode fromNode, GraphNode toNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GraphNode> getAdjacentNodes(GraphNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean nodesAreAdjacent(GraphNode fromNode, GraphNode toNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean nodeIsReachable(GraphNode fromNode, GraphNode toNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hasCycles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GraphNode> getNodes() {
		// TODO Auto-generated method stub
		return nodeList;
	}

	@Override
	public GraphNode getNode(String nodeValue) {
		// TODO Auto-generated method stub
		for (GraphNode thisNode : nodeList) {
			if (thisNode.getValue().equals(nodeValue))
				return thisNode;
		}
		return null;
	}

	@Override
	public int fewestHops(GraphNode fromNode, GraphNode toNode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int shortestPath(GraphNode fromNode, GraphNode toNode) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
