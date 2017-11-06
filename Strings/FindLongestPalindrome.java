/*
  Note: Currently looking on ways to improve this implementation

  This algoreithm finds the largest palindrome inside a String employing the idea
  that you can have 2n ways to center the string, illustrated below:

  String: a  |  j  |  n  |  j  |  w  |  n  |  r
  Index:  0  1  2  3  4  5  6  7  8  9  10 11 12

  Thus substrings can be checked based on whether you're centering on a letter
  or a space. Finally, the string is actually returned using the same notion
*/

public String longestPalindrome(String s) {
    int longest = -1, longestIndex = -1, result;
    for(int i = 1; i < s.length() * 2; i++){
        if(i % 2 == 0) result = findLongestAtCenter((i / 2) - 1, true, s);
        else result = findLongestAtCenter((i - 1) / 2, false, s);

        if(result > longest){
            longest = result;
            longestIndex = i;
        }
    }

    return getLongestString(longestIndex, longest, s);
}

public String getLongestString(int longestIndex, int longest, String s){
    int halfLength = longest / 2;
    if(longestIndex % 2 == 0){
        longestIndex = longestIndex / 2 - 1;
        return s.substring(longestIndex - halfLength + 1, longestIndex + halfLength + 1);
    }
    halfLength = (longest - 1) / 2;
    longestIndex = (longestIndex - 1) / 2;
    return s.substring(longestIndex - halfLength, longestIndex + halfLength + 1);
}

public int findLongestAtCenter(int index, boolean isBetween, String s){
    int left = index, right = index + 1, longest = isBetween ? 0 : 1;
    if(!isBetween){
        left = index - 1;
        right = index + 1;
    }

    while(left != -1 && right != s.length()){
        if(s.charAt(left) != s.charAt(right)) break;
        longest += 2;
        left--;
        right++;
    }

    return longest;
}
