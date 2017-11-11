String convertToRadix(int num, int radix) {
    int quotient = num / radix;
    int remainder = num % radix;

    if(quotient == 0) return Integer.toString(remainder);

		return convertToRadix(quotient, radix) + Integer.toString(remainder);
}

int isPrime(int num) {
    if(num <= 1) return 0;
    for (int i = 2; i <= (int)(Math.sqrt(num)); i++) {
        if (num % i == 0) return 0;
    }

    return 1;
}

/*
  I don't think this counts as a math operation but fuck you I'm giving these
  out for free so it counts. Bascially this just determins whether a sum exists
  in O(n) time. Pretty easy and common algorithm.
*/
boolean hasSum(int[] arr, int sum){
  HashSet<Integer> numbersSeen = new HashSet<>();
  for(int i = 0; i < arr.length; i++){
    if(numbersSeen.contains(sum - arr[i])){
      return true;
    }
    numbersSeen.add(arr[i]);
  }
  return false;
}

/*
  Simulation of C's atoi function which converts a string to an int. Contraints:
  1. First discards all whitespace preceding
  2. Takes an optional plus or minus sign
  3. Takes in all numerical digits
  4. If no number exists or number is not valid a 0 is returned
  5. On overflow or underflow Integer.MAX_VALUE or Integer.MIN_VALUE is returned
*/
public int myAtoi(String str) {
  int index = 0, result = 0;
  while(index < str.length() && Character.isWhitespace(str.charAt(index))) index++;
  if(index == str.length()) return 0;

  boolean isNegative = false;
  if(str.charAt(index) == '-'){
      isNegative = true;
      index++;
  }
  else if(str.charAt(index) == '+') index++;

  while(index < str.length() && str.charAt(index) > 47 && str.charAt(index) < 58){
      try{
          result = Math.multiplyExact(result, 10);
          result = Math.addExact(result, str.charAt(index) - 48);
          index++;
      }
      catch(Exception e){
          if(isNegative) return Integer.MIN_VALUE;
          return Integer.MAX_VALUE;
      }
  }

  if(isNegative) return result * -1;
  return result;
}


public int reverseInt(int x){
  int reversed = 0;
  while(x > 0){
      try{
          reversed = Math.multiplyExact(reversed, 10);
          reversed = Math.addExact(reversed, x % 10);
          x = x / 10;
      }
      catch(Exception e){ return 0; }
  }
  return reversed;
}

/*
  The goal is to multiply 2 numbers without using the * operator. This can be
  accomplished using the MIPS processor approach of shifting multiplier left and
  the multiplicand right, adding multiplicand to result is LSB of multiplier is 1.
  This continues until one number reaches 0.
*/
public static int multiplyWithoutOp(int multiplier, int multiplicand){
    int multiplierShifted, result = 0;
    while(multiplier > 0 && multiplicand > 0){
        if(multiplier - (multiplier >> 1 * 2) == 1) result += multiplicand;
        multiplier = multiplier >> 1;
        multiplicand = multiplicand << 1;
    }
    return result;
}
