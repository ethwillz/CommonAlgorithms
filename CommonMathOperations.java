public String convertToRadix(int num, int radix) {
    int quotient = num / radix;
    int remainder = num % radix;

    if(quotient == 0) return Integer.toString(remainder);

		return convertToRadix(quotient, radix) + Integer.toString(remainder);
}

public int isPrime(int num) {
    if(num <= 1) return 0;
    for (int i = 2; i <= (int)(Math.sqrt(num)); i++) {
        if (num % i == 0) return 0;
    }

    return 1;
}
