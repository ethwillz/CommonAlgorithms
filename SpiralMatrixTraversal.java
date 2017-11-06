public class SpiralMatrixTraversal {
    
    /*
     Print the elements of the array going in a spiral.
     For example, the 2D array below will print in ascending order
     
     1  2  3  4
     12 13 14 5
     11 16 15 6
     10 9  8  7
     
     */

	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 int top = 0, bottom = a.size()-1, left = 0, right = a.get(0).size()-1;
		 int dir = 0;
		 while(top <= bottom && left <= right){
		     if(dir == 0){
		         for(int i = left; i <= right; i++){
		             result.add(a.get(top).get(i));
		         }
		         top++;
		         dir = 1;
		     }
		     else if(dir == 1){
		         for(int i = top; i <= bottom; i++){
		             result.add(a.get(i).get(right));
		         }
		         right--;
		         dir = 2;
		     }
		     else if(dir == 2){
		         for(int i = right; i >= left; i--){
		             result.add(a.get(bottom).get(i));
		         }
		         bottom--;
		         dir = 3;
		     }
		     else{
		         for(int i = bottom; i >= top; i--){
		             result.add(a.get(i).get(left));
		         }
		         left++;
		         dir = 0;
		     }
		 }

		 return result;
	}
}
