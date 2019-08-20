package dsproblems;

import java.util.LinkedList;
import java.util.Queue;

class GraphNode {
	int x, y, dist;

	GraphNode(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class BinaryMaze {

	public static void main(String[] args) {

		// [[1, 1, 1, 1], [0, 0, 0, 1], [1, 1, 1, 1]]
		// sr = 0, sc = 0, tr = 2, tc = 0

		int mat[][] = {
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
			};

		int sr = 0, sc = 0, tr = 7, tc = 5;

		System.out.println(getShortestPath(mat, sr, sc, tr, tc));
	}

	private static int getShortestPath(int[][] mat, int sr, int sc, int tr, int tc) {

		int dist = -1;

		boolean[][] visited = new boolean[mat.length][mat[0].length];

		Queue<GraphNode> q = new LinkedList<GraphNode>();

		visited[sr][sc] = true;
		q.add(new GraphNode(sr, sc, 0));

		while (q.size() > 0) {
			GraphNode n = q.poll();

//			sr = n.x;
//			sc = n.y;
//			dist = n.dist;

			if (n.x == tr && n.y == tc) {
				return n.dist;
			}

			if (isValid(mat, n.x - 1, n.y, visited)) {
				visited[n.x - 1][n.y] = true;
				q.add(new GraphNode(n.x - 1, n.y, n.dist + 1));
			}
			if (isValid(mat, n.x, n.y + 1, visited)) {
				visited[n.x][n.y + 1] = true;
				q.add(new GraphNode(n.x, n.y + 1, n.dist + 1));
			}
			if (isValid(mat, n.x + 1, n.y, visited)) {
				visited[n.x + 1][n.y] = true;
				q.add(new GraphNode(n.x + 1, n.y, n.dist + 1));
			}
			if (isValid(mat, n.x, n.y - 1, visited)) {
				visited[n.x][n.y - 1] = true;
				q.add(new GraphNode(n.x, n.y - 1, n.dist + 1));
			}
		}

		return dist;
	}

	private static boolean isValid(int[][] mat, int row, int col, boolean[][] visited) {

		return (row >= 0 && row < mat.length) && (col >= 0 && col < mat[0].length)
				&& !visited[row][col] && mat[row][col] > 0;
	}

}
