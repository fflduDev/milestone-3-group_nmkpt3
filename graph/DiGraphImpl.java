package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiGraphImpl implements DiGraph {

	private List<GraphNode> nodeList = new ArrayList<>();

	@Override
	public Boolean addNode(GraphNode node) {

		if (getNode(node.getValue()) == null) {
			nodeList.add(node);
			return true;
		}

		// otherwise the node is there, and cannot be added.
		return false;
	}

	@Override
	public Boolean removeNode(GraphNode node) {
		if (nodeList.contains(node)) {
			nodeList.remove(node);
			for (GraphNode otherNode : nodeList) {
				otherNode.removeNeighbor(node);
			}
			return true;
		}
		return false;
	}

	@Override
	public Boolean setNodeValue(GraphNode node, String newNodeValue) {
		if (getNode(newNodeValue) == null) {
			GraphNode targetNode = getNode(node.getValue());
			targetNode.setValue(newNodeValue);
			return true;
		}
		return false;
	}

	@Override
	public String getNodeValue(GraphNode node) {
		return node.getValue();
	}

	@Override
	public Boolean addEdge(GraphNode fromNode, GraphNode toNode, Integer weight) {
		// TODO Auto-generated method stub
		// get the source and target nodes from the existing graph
		if (getNode(fromNode.getValue()) == null || getNode(toNode.getValue()) == null) {

			// if either dont exist, cant make the edge
			return false;
		}

		GraphNode targetFromNode = getNode(fromNode.getValue());
		GraphNode targetToNode = getNode(toNode.getValue());

		// otherwise ( they both exist ) add neighbor & weight
		targetFromNode.addNeighbor(targetToNode, weight);
		return true;
	}

	@Override
	public Boolean removeEdge(GraphNode fromNode, GraphNode toNode) {
		if (getNode(fromNode.getValue()) != null && getNode(toNode.getValue()) != null) {
			fromNode.removeNeighbor(toNode);
			return true;
		}
		return false;
	}

	@Override
	public Boolean setEdgeValue(GraphNode fromNode, GraphNode toNode, Integer newWeight) {
		if (getEdgeValue(fromNode, toNode) != null) {
			removeEdge(fromNode, toNode);
			addEdge(fromNode, toNode, newWeight);
			return true;
		}
		return false;
	}

	@Override
	public Integer getEdgeValue(GraphNode fromNode, GraphNode toNode) {
		GraphNode from = getNode(fromNode.getValue());
		GraphNode to = getNode(toNode.getValue());

		if (from == null || to == null) {
			return null;
		}

		return from.getDistanceToNeighbor(to);

	}

	@Override
	public List<GraphNode> getAdjacentNodes(GraphNode node) {
		GraphNode newNode = getNode(node.getValue());

		if (newNode == null) {
			return null;
		}

		return newNode.getNeighbors();
	}

	@Override
	public Boolean nodesAreAdjacent(GraphNode fromNode, GraphNode toNode) {
		return getEdgeValue(fromNode, toNode) != null;
	}

	@Override
	public Boolean nodeIsReachable(GraphNode fromNode, GraphNode toNode) {
		GraphNode start = getNode(fromNode.getValue());
		GraphNode end = getNode(toNode.getValue());

		if (start == null || end == null) {
			return false;
		}

		List<GraphNode> visited = new ArrayList<>();
		Queue<GraphNode> queue = new LinkedList<>();

		queue.add(start);
		visited.add(start);

		while (!queue.isEmpty()) {
			GraphNode current = queue.poll();

			if (current.getValue().equals(end.getValue())) {
				return true;
			}

			for (GraphNode neighbor : current.getNeighbors()) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.add(neighbor);
				}
			}
		}
		return false;
	}

	@Override
	public Boolean hasCycles() {
		for (GraphNode node : nodeList) {
			if (nodeIsReachable(node, node)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<GraphNode> getNodes() {
		return nodeList;
	}

	@Override
	public GraphNode getNode(String nodeValue) {
		for (GraphNode node : nodeList) {
			if (node.getValue().equals(nodeValue))
				return node;
		}
		return null;
	}

	@Override
	public int fewestHops(GraphNode fromNode, GraphNode toNode) {
		if (fromNode == null || toNode == null) {
			return -1;
		}

		Queue<GraphNode> queue = new LinkedList<>();
		Map<GraphNode, Integer> distances = new HashMap<>();

		queue.add(fromNode);
		distances.put(fromNode, 0);

		while (!queue.isEmpty()) {
			GraphNode current = queue.poll();
			int currentDistance = distances.get(current);

			if (current.equals(toNode)) {
				return currentDistance;
			}

			for (GraphNode neighbor : current.getNeighbors()) {
				if (!distances.containsKey(neighbor)) {
					distances.put(neighbor, currentDistance + 1);
					queue.add(neighbor);
				}
			}
		}

		return -1;
	}

	@Override
	public int shortestPath(GraphNode fromNode, GraphNode toNode) {
		Map<GraphNode, Integer> distances = new HashMap<>();
		PriorityQueue<GraphNode> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

		for (GraphNode node : nodeList) {
			distances.put(node, Integer.MAX_VALUE);
		}

		distances.put(fromNode, 0);
		pq.add(fromNode);

		while (!pq.isEmpty()) {
			GraphNode current = pq.poll();

			if (current.equals(toNode)) {
				return distances.get(toNode);
			}

			for (GraphNode neighbor : current.getNeighbors()) {
				Integer weightObj = current.getDistanceToNeighbor(neighbor);
				if (weightObj == null) {
					continue;
				}
				int weight = weightObj.intValue();
				int newDistance = distances.get(current) + weight;

				if (newDistance < distances.get(neighbor)) {
					distances.put(neighbor, newDistance);
					pq.add(neighbor);
				}
			}

		}

		return -1;
	}

}
