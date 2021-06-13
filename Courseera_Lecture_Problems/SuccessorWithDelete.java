class SuccessorWithDelete {
    int[] S;

    SuccessorWithDelete(int[] S) {
        this.S = Arrays.sort(S);
    }

    int find(int x) {
        int start = 0;
        int end = S.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (x == S[mid]) {
                return mid;
            } else if (Sh[mid] > x) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public void remove(int x) {
        int index = find(x);
        // As this is a set of positive integers just replacing the element to remove with -1
        // to indicate the element at that position is removed
        if (index != -1)
            S[index] = -1;
        else
            System.out.println("No such element " + x + " is found in the set");
    }

    public int successor(int x) {
        int index = find(x);
        // I assume set is not duplicate. If So, As the Set is sorted in the constructor, the element sits next
        // to x is the successor
        if (index != -1)
            return S[index + 1];
        System.out.println("No such element " + x + " is found in the set");
        return -1;
    }

}
