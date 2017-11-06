//left, root, right
public void inOrder(Node root){
  if(root == null) return;
  inOrder(root.left);
  System.out.println(root.data);
  inOrder(root.right);
}

//root, left, right
public void preOrder(Node root){
  if(root == null) return;
  System.out.println(root.data);
  preOrder(root.left);
  preOrder(root.right);
}

//left, right, root
public void postOrder(Node root){
  if(root == null) return;
  postOrder(root.left);
  postOrder(root.right);
  System.out.println(root.data);
}
