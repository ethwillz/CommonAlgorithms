/*
  For each item we will go calculate the best value we can get for each weight
  value until our actual limit. For each possible weight then we have 2 options:

  1. Add the current item to the largest value we can get including the current
     item's weight (which is in the row above).
  2. Not add the current item which we already have stored in the above index

  Then, of course, if the current item's weight exceeds the current limit we
  definitely can't include it so we'll just grab the computed value. At the end
  the max will be in the lower right hand corner of the matrix.

  The runtime of this is O(nw) where w is the weight limit and n is the number
  of possible items.

  For a good explanation of what's going on check out this video:
  https://www.youtube.com/watch?v=8LusJS5-AGo
  They use a slightly simpler approach which adds extra steps to the algorithm
  but is easier to understand.
*/

int knapsack(int weight, int[] weights, int[] values, int num){
  int[][] KS = new int[num+1][weight+1];

  for(int i = 0; i < num; i++){
    for(int w = 0; w < weight; i++){
      if(i == 0 || w == 0) KS[i][w] = 0;
      else if(weights[i-1] <= weight){
        KS[i][w] = Math.max(val[i-1] + KS[i-1][w - weights[i-1]], KS[i-1][w]);
      }
      else k[i][w] = k[i-1][w];
    }
  }

  return KS[n][weight];
}
