package dsproblems;

import java.util.Iterator;
import java.util.LinkedList;

public class CourseSchedule {

	public static void main(String[] args) {

		Graph g = new Graph(3);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);

		System.out.println(g.isCycle());
	}
}

class Graph {

	private int v;
	private LinkedList<Integer> adj[];

	Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public boolean isCycle() {

		boolean[] visited = new boolean[v];
		boolean[] recStack = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (isCycleUtil(i, visited, recStack))
				return true;
		}

		return false;
	}

	private boolean isCycleUtil(int i, boolean[] visited, boolean[] recStack) {

		if (recStack[i])
			return true;

		if (visited[i])
			return false;

		recStack[i] = true;
		visited[i] = true;

		Iterator<Integer> it = adj[i].listIterator();

		while (it.hasNext()) {
			int x = it.next();
			if (isCycleUtil(x, visited, recStack)) {
				return true;
			}
		}

		recStack[i] = false;

		return false;
	}

}