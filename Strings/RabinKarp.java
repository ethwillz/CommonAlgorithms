/*
  Basic idea of this algorithm is that each substring hash will be unique
  For a given frame of size k
  Hash = s[0] * k^0 + s[1] * k^1 + ... + s[k] * s^k
  Next hash (starting at index 1) = ()(hash - s[0]) / prime) + s[k+1] * s^k
  Check each frame's hash until a match is found
*/

static boolean patternExists(String s, String toMatch){
    int prime = 31, patternHash = 0, hash = 0;

    for(int i = 0; i < toMatch.length(); i++){
        patternHash += toMatch.charAt(i) * Math.pow(prime, i);
    }

    for(int i = 0; i < toMatch.length(); i++){
        hash += s.charAt(i) * Math.pow(prime, i);
    }
    if(hash == patternHash) return true;

    for(int i = 0; i < s.length() - toMatch.length(); i++){
        hash -= s.charAt(i);
        hash /= prime;
        hash += s.charAt(i + toMatch.length()) * Math.pow(prime, toMatch.length() - 1);
        if(hash == patternHash) return true;
    }

    return false;
}
