/*
  Goal: find bridges in an undirected, connected graph
                ⮑ Any edge that when deleted would increase the num of connected components

  To do this we'll do a modified DFS, during the traversal of each vertex we will
  create a discovery time and a low value corresponding to the sequential time
  when it was discovered and the lowest discovery time its seen through its subtree.

  If the child's DFS tree has not seen a vertex with a smaller discovery time this
  means that the subtree rooted at this child does not have any connection to an
  ancestor of this vertex, so therefore the edge between them is a bridge.
*/

void findBridges(Graph G){
  boolean[] visited = new boolean[g.V];
  int[] disc = new int[g.V];
  int[] low = new int[g.V];
  int[] parent = new int[g.V];

  for(int i = 0; i < g.V; i++){
    parent[i] = -1;
    visited[i] = false;
  }

  for(int i = 0; i < g.V; i++){
    if(!visited[i]) bridgeUtil(i, visited, disc, low, 0, parent);
  }
}

void bridgeUtil(Graph g, int u, boolean[] visited, int[] disc, int[] low, int[] parent, int time, ArrayList<Integer> nonBridgeVertices){
  visited[u] = true;
  disc[u] = low[u] = ++time; //sets discovery time and low value
  for(Integer w : g.adj[i]){
    if(!visited[w]){
      parent[w] = u;
      bridgeUtil(w, visited, disc, low, time, parent);
      low[u] = Math.min(low[u], low[w]);

      if(low[w] > disc[u]) System.out.println(u + " to " + w + "is a bridge");
    }
    else if(w != parent[u]){
      low[u] = Math.min(low[u], disc[w]);
    }
  }
}
