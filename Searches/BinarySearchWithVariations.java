public int binarySearch(int[] arr, int l, int r, int target){
  int mid = l + (r - l) / 2;
  if(l > r) return -1; //Base case

  if(target == arr[mid]) return mid;
  else if(target < arr[mid]) return binarySearch(arr, l, mid - 1, target);
  else return binarySearch(arr, mid + 1, r, target);
}

/*
  Should operate on any of these in O(logn)
  1, 2, 3, 4, 5
  2, 3, 4, 5, 1
  3, 4, 5, 1, 2
  4, 5, 1, 2, 3
  5, 1, 2, 3, 4

  key insight on this is noticing that one half will always be sorted
*/
public int rotatedBinarySearch(int[] arr, int l, int r, int target){
  int mid = l + (r - l) / 2;
  if(l > r) return -1

  if(arr[mid] == target) return mid;
  else if(l < mid){
    if(target > arr[l] && target < arr[mid]) return rotatedBinarySearch(arr, l, mid - 1, target);
    else return rotatedBinarySearch(arr, mid + 1, r, target);
  }
  else{
    if(target > arr[l] && target < arr[mid]) return rotatedBinarySearch(arr, mid + 1, r, target);
    else return rotatedBinarySearch(arr, l, mid + 1, target);
  }
}
