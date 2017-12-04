/*
  The goal of this algorithm seems self-explanatory. The naive approach is using
  recursion while the DP approach uses a 2D table of size n*sum. DP provides
  pseudo-polynomial time complexity whereas the naive approach is exponential
*/

public static boolean isSubsetSumNaive(int[] set, int n, int sum){
    if(sum == 0) return true;
    if(n == 0 && sum != 0) return false;
    if(set[n-1] > sum) return isSubsetSumNaive(set, n-1, sum);
    return isSubsetSumNaive(set, n-1, sum) || isSubsetSumNaive(set, n-1, sum - set[n-1]);
}

public static boolean isSubsetSumDP(int[] set, int n, int sum){
    boolean subset[][] = new boolean[sum+1][n+1];

    for(int i = 0; i <= n; i++){
        subset[0][i] = true;
    }

    for(int j = 0; j <= sum; j++){
        subset[j][0] = false;
    }

    for(int i = 1; i <= sum; i++){
        for(int j = 1; j <= n; j++){
            subset[i][j] = subset[i][j-1];
            if(set[j-1] <= i){
                subset[i][j] = subset[i][j] || subset[i - set[j-1]][j-1];
            }
        }
    }

    return subset[sum][n];
}
