//This is the question that was asked at my ISU Microsoft interview
public void deleteNode(Node toDelete){
  if(toDelete.next == null) toDelete = null;
  toDelete.data = toDelete.next.data;
  toDelete.next = toDelete.next.next;
}
