class Graph{
  private int V;
  private LinkedList<Integer> adj[];
  int time = 0;
  static final int nil = -1;

  Graph(int v){
    V =v;
    adj = new LinkedList[v];
    for(int i = 0; i < v; i++){
      adj[i] = new LinkedList<>();
    }
  }

  void addUndirectedEdge(int v, int w){
    adj[v].add(w);
    adj[w].add(v);
  }

  void addDirectedEdge(int v, int w){
    adj[v].add(w);
  }
}
