/*
	For each index i in arr
	-arr[i] = arr[arr[i]]
	The caveat is that these should all be based off the original array and since
	we need to do this in constant space we must figure out a way to keep the original
	value of the element while allowing it to change in the resultant array. This
	lends itself to this dope algo that I definitely didn't figure out myself

	4, 0, 2, 1, 3

	a[0] = a[0] + (a[4] % size * size)
	a[1] = a[1] + (a[0] % size * size)
	.
	.
	a[4] = a[4] + (a[3] % size * size)

	a[0] = a[0] / 5
	a[1] = a[1] / 5
	.
	.
	a[4] = a[4] / 5

	3, 4, 2, 0, 1
*/

public class ReArrangeArrayConstantSpace {
	public void arrange(int[] arr) {
	    int newVal;
	    for(int i = 0; i < arr.length; i++){
	        newVal = arr[arr[i]] % a.length * a.length;
					arr[i] = arr[arr[i] + newVal];
	    }
	    for(int i = 0; i < arr.length; i++){
				arr[i] = arr[i] / a.length;
	    }
	}
}
