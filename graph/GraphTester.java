package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphTester {

	private static DiGraph graph;

	// helper function - print every node's value in a node list
	public static void printNodesValues(List<GraphNode> nodeList) {
		System.out.println("Nodes are:");
		if (nodeList == null)
			System.out.println("---- no nodes ----");
		else
			nodeList.forEach((n) -> System.out.println(n.getValue()));
	}

	public static void printPath(List<GraphNode> path) {
		System.out.println("Path is:");
		if (path == null)
			System.out.println("---- no path found ----");
		else {
			List<String> pathStr = new ArrayList<String>();
			path.forEach((node) -> pathStr.add(node.getValue()));
			System.out.println(String.join(" -> ", pathStr));
		}
	}

	public static void main(String[] args) {
		graph = new DiGraphImpl();

		// Store node references
		GraphNode A = new GraphNode("A");
		GraphNode B = new GraphNode("B");
		GraphNode C = new GraphNode("C");
		GraphNode D = new GraphNode("D");
		GraphNode E = new GraphNode("E");
		GraphNode F = new GraphNode("F");
		GraphNode G = new GraphNode("G");
		GraphNode H = new GraphNode("H");

		// add nodes
		graph.addNode(A);
		graph.addNode(B);
		graph.addNode(C);
		graph.addNode(D);
		graph.addNode(E);
		graph.addNode(F);
		graph.addNode(G);
		graph.addNode(H);

		// add edges
		graph.addEdge(A, B, 5);
		graph.addEdge(B, C, 5);
		graph.addEdge(C, D, 1);
		graph.addEdge(E, F, 1);
		graph.addEdge(F, A, 1);
		graph.addEdge(C, F, 2);
		graph.addEdge(D, B, 15);
		graph.addEdge(G, C, 5);
		graph.addEdge(G, E, 8);

		// describe
		printNodesValues(graph.getNodes());
		graph.getNodes().forEach(n -> n.printNeighbors());

		// test reachability
		System.out.print("F is reachable to E: ");
		System.out.println(graph.nodeIsReachable(new GraphNode("F"), new GraphNode("E"))); // false
		System.out.print("F is reachable to D: ");
		System.out.println(graph.nodeIsReachable(new GraphNode("F"), new GraphNode("D"))); // true

		// test hasCycles
		System.out.print("Graph has cycles: ");
		System.out.println(graph.hasCycles());

		// test fewest hops
		System.out.println("Fewest hop from G to B is: " + graph.fewestHops(G, B));
		// printPath(graph.getFewestHopsPath(new GraphNode("G"), new GraphNode("B")));

		// test shortest path
		System.out.println("Shortest from G to B is: " + graph.shortestPath(G, B));
		// printPath(graph.getShortestPath(new GraphNode("G"), new GraphNode("B")));
	}

}
