/*
  The problem statement on this was a pretty common. It said that the points in the
  array were walls and to find th emaximum area of water that could be held between
  two of these walls. It's a good example of the usefulness of 2 pointers solving
  algorithms like this.
*/

public int maxArea(int[] height) {
    int leftIndex = 0;
    int rightIndex = height.length - 1;
    int maxArea = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
    while(leftIndex < rightIndex){
        maxArea = Math.max(maxArea, Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));
        if(height[leftIndex] < height[rightIndex]){
            leftIndex++;
        }
        else{
            rightIndex--;
        }
    }
    return maxArea;
}
