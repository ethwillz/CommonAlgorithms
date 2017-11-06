public static char[] mergeSort(char[] numArr, int left, int right){
    if (left < right)
    {
        int middle = (left + right) / 2;

        mergeSort(numArr, left, middle);
        mergeSort(numArr , middle + 1, right);

        merge(numArr, left, middle, right);
    }
}

public static void merge(char[] numArr, int left, int middle, int right){
    int numLeft = middle - left + 1;
    int numRight = right - middle;

    char leftSubArray[] = new char[numLeft];
    char rightSubArray[] = new char[numRight];

    for (int i=0; i < numLeft; ++i)
        leftSubArray[i] = numArr[left + i];
    for (int j=0; j < numRight; ++j)
        rightSubArray[j] = numArr[middle + 1+ j];

    int i = 0, j = 0;

    int k = left;
    while (i < numLeft && j < numRight)
    {
        if (leftSubArray[i] <= rightSubArray[j])
        {
            numArr[k] = leftSubArray[i];
            i++;
        }
        else
        {
            numArr[k] = rightSubArray[j];
            j++;
        }
        k++;
    }

    while (i < numLeft)
    {
        numArr[k] = leftSubArray[i];
        i++;
        k++;
    }

    while (j < numRight)
    {
        numArr[k] = rightSubArray[j];
        j++;
        k++;
    }
}
