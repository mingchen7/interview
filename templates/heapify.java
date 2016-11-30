public void heapify(int[] A) {
    // write your code here
    if (A == null || A.length == 0) {
        return;
    }

    for (int i = A.length /2; i >= 0; i--) {
        siftdown(A, i);
    }
}

private void siftdown(int[] A, int k) {
    while (k < A.length) {
        int smallest = k;
        int leftChild = 2 * k + 1;
        int rightChild = 2 * k + 2;

        if (leftChild < A.length && A[leftChild] < A[smallest]) {
            smallest = leftChild;
        }
        if (rightChild < A.length && A[rightChild] < A[smallest]) {
            smallest = rightChild;
        }
        if (smallest == k) {
            break;
        }

        //swap
        int tmp = A[k];
        A[k] = A[smallest];
        A[smallest] = tmp;

        k = smallest;
    }
}
