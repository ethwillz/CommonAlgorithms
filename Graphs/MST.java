/*
  Prim's Algorithm
  Essentially the algorithm has a node cost intialized to infinity to begin with.
  From there, we go through every vertex in the array, starting with the first.
  For this vertex we look at the cost for each edge to its neighbors, if the neighbor
  isn't in the mst and the edge to this neighbor is smaller than the neighbor's
  key, we add this to the forest and update its key.

  Note: the end of this algorithm will be parent[] where element--index is an edge
*/
public void Prims(int[][] g){
  int[] parent = new int[g.length];
  int[] key = new int[g.length];
  boolean[] MstSet = new boolean[g.length];

  for(int i = 0; i < g.length; i++){
    key[i] = Integer.MAX_VALUE;
    MstSet[i] = false;
  }

  key[0] = 0;
  parent[0] = -1;

  for(int count = 0; count < g.length - 1; count++){
    int u = minKey(key, mstSet);

    mstSet[u] = true;

    for(int v = 0; v < g.length; v++){
      if(g[u][v] != 0 && !mstSet[v] && g[u][v] < key[v]){
        parent[v] = u;
        key[v] = graph[u][v];
      }
    }
  }
}

public int minKey(int[] key, boolean[] mstSet){
  int min = Integer.MAX_VALUE, minIndex = -1;
  for(int i = 0; i < key.length; i++){
    if(key[i] < min && mstSet[i] == false){
      min = key[i];
      minIndex = i;
    }
  }

  return minIndex;
}

//Kruskal's Algorithm
