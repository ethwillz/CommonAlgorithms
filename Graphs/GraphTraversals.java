public void DFS(Graph g){
  boolean[] visited = new boolean[g.V]; //false by default in java

  for(int i = 0; i < g.V; i++){
    DFSUtil(g[i], visited)
  }
}

public DFSUtil(Graph g, int u, boolean[] visited){
  visited[u] = true;
  System.out.println(u + " ");

  for(Integer w : g.adj[u]){
    if(!visited[w]){
      visited[w] = true;
      DFSUtil(g, w, visited);
    }
  }
}

public void IterativeDFS(int v){
  Stack<Integer> s = new Stack<>();
  s.push(v);

  while(!s.isEmpty()){
    int u = s.pop();
    if(!visited[u]){
      visited[u] = true;
      System.out.println(u + " ");
    }

    for(Integer w : adj[u]){
      if(!viisted[w]) s.add(w);
    }
  }
}

public void BFS(int v){
  boolean[] visited = new boolean[g.V];
  Queue<Integer> q = new ArrayDeque<>();
  q.add(v);

  while(!q.isEmpty()){
    int u = q.poll();
    System.out.println(u + " ");

    for(Integer w : adj[u]){
      if(!visited[w]){
        visited[w] = true;
        q.add(w);
      }
    }
  }
}
