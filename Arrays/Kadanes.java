/*
	Kadane's algorithm is used to find the maximum subarray in an array of ints
	The premise is that you keep a current largest sum, comparing it to the next element
	If the element is larger the current largest becomes that element, otherwise it
	is added to the current largest. Each iteration current sum is checked against the overall
	largest so that the overall largest is correct after the tarversal ends
*/

public int maxSubArray(int[] a) {
    int largestSum = a[0], currentSum = a[0];
    for(int i = 1; i < a.length; i++){
        if(a[i]] > currentSum + a[i]) currentSum = a[i];
        else currentSum += a[i];

        largestSum = Math.max(currentSum, largestSum);
    }
    return largestSum;
}
