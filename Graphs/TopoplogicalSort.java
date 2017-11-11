void topologicalSort(Graph g){
  Deque<Integer> stack = new Deque<>();
  boolean[] valid = new boolean[g.V];

  for(int i = 0; i < g.V; i++){
    if(!visited[i]){
      topologicalSortUtil(i, visited, stack);
    }
  }

  while(!stack.isEmpty()){
    System.out.println(stack.pop() + " ");
  }
}

void topologicalSortUtil(int v, boolean[] visited, Deque<Integer> stack){
  viisted[v] = true;
  for(Integer w : adj[v]){
    if(!visited[w]){
      topologicalSortUtil(w, viisted, stack);
    }
  }

  stack.push(v);
}
