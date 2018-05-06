package crackcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * CC.TreeGraph.4.1 Route Between Nodes
 * 
 * Question : Given a directed graph, design an algorithm to find out whether
 * there is a route between two nodes.
 *
 */
public class CC_TreeGraph_4_1_Routes_Between_Nodes {

	private class DirectedGraphNode {
		int value;
		ArrayList<DirectedGraphNode> neighbors;

		DirectedGraphNode(int v) {
			this.value = v;
			this.neighbors = new ArrayList<DirectedGraphNode>();
		}
	}

	public static boolean search_bfs(DirectedGraphNode start, DirectedGraphNode end) {

		if (start == end)
			return true;

		Queue<DirectedGraphNode> qu = new LinkedList<DirectedGraphNode>();
		HashSet<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();

		qu.offer(start);
		visited.add(start);

		while (!qu.isEmpty()) {
			DirectedGraphNode cur = qu.poll(); // retrieve and remove the head
												// of the queue
			for (DirectedGraphNode n : cur.neighbors) {
				if (n == end)
					return true; // found path

				if (visited.contains(n)) // ignore visited node
					continue;

				visited.add(n); // add new visited node
				qu.offer(n); // enqueue
			}
		}

		return false;
	}

	public boolean search_dfs(DirectedGraphNode start, DirectedGraphNode end) {
		HashSet<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
		return dfs(start, end, visited);
	}

	private boolean dfs(DirectedGraphNode start, DirectedGraphNode end, HashSet<DirectedGraphNode> visited) {
		if (start == end)
			return true;

		for (DirectedGraphNode n : start.neighbors) {
			if (!visited.contains(n)) {
				visited.add(n);
				if (dfs(n, end, visited))
					return true;
			}
		}

		return false;
	}

	public void test() {
		DirectedGraphNode n1 = new DirectedGraphNode(1);
		DirectedGraphNode n2 = new DirectedGraphNode(2);
		DirectedGraphNode n3 = new DirectedGraphNode(3);
		DirectedGraphNode n4 = new DirectedGraphNode(4);

		n1.neighbors.add(n2);
		n2.neighbors.add(n3);
		n2.neighbors.add(n4);

		System.out.println(search_bfs(n1, n3));
		System.out.println(search_bfs(n1, n4));
		System.out.println(search_bfs(n3, n4));

		System.out.println(search_dfs(n1, n3));
		System.out.println(search_dfs(n1, n4));
		System.out.println(search_dfs(n3, n4));
	}

	public static void main(String[] args) {
		CC_TreeGraph_4_1_Routes_Between_Nodes driver = new CC_TreeGraph_4_1_Routes_Between_Nodes();
		driver.test();
	}
}