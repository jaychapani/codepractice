package dsproblems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class CourseSchedule {

	public static void main(String[] args) {

		Graph g = new Graph(3);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);

		//System.out.println(g.isCycle());
		
		Graph g1 = new Graph(4); 
		  
		g1.addEdge(0, 1); 
        g1.addEdge(0, 2); 
        g1.addEdge(1, 3); 
        g1.addEdge(2, 3); 
        
        g1.DFS(0);
        
        int numCourses = 3;
        int[][] prerequisites = {{0,1},{1,0},{1,2}};
        
        Graph g2 = new Graph(numCourses);
        
        for(int i = 0; i < prerequisites.length; i++) {
            g2.addEdge(prerequisites[i][1],prerequisites[i][0]);
        }
        
        System.out.println("---" + Arrays.toString(g2.topologicalSort()));
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
	
	public void DFS(int s) {
		
		boolean visited[] = new boolean[v];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		visited[s] = true;
		stack.push(s);
		
		while(stack.size() != 0) {
			
			s = stack.pop();
			System.out.println(s);
			
			Iterator<Integer> it = adj[s].listIterator();
			
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n]) {
					visited[n] = true;
					stack.push(n);
				}
			}
		}
	}
	
	public int[] topologicalSort(){
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[v];
        
        for(int i = 0; i < v; i++){
            if(!topologicalSortUtil(i, visited, stack,new boolean[v]))
            	return new int[0];
        }
        
        int[] arr = new int[v];
        int j = 0;
        
        while(!stack.empty()){
            arr[j++] = Integer.parseInt((new Integer(stack.pop()).toString()));
        }
        
        return arr;
    }
    
    public boolean topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack, boolean[] isLoop){
        
    	if(visited[i])
    		return true;
    	if(isLoop[i])
    		return false;
    	
        isLoop[i] = true;
        
        Iterator<Integer> it = adj[i].listIterator();
        while(it.hasNext()){
            int x = it.next();
            if(!topologicalSortUtil(x,visited,stack,isLoop))
            	return false;
        }
        visited[i] = true;
        stack.push(new Integer(i));
        return true;
    }

}