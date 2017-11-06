class BST{
  Node root;

  class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
      this.data = data;
    }
  }

  public BST(){
    root = null;
  }

  public void add(int data){
    if(root == null){
      root = new Node(data);
      return;
    }

    Node cur = root;
    while(cur != null){
      if(data > cur.data){
        if(cur.right == null) cur.right = new Node(data);
        else cur = cur.right;
      }
      else{
        if(cur.left == null) cur.left = new Node(data);
        else cur = cur.left;
      }
    }
  }
}
