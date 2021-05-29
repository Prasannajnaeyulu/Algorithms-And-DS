class FindElementInSortedArray{
    public static int findElement(int[] a, int x){
        int left = 0;
        int right = a.length-1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if (a[middle] == x)
                return middle;
            if (a[middle] > x)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }

    public static void main(String... args) {
        int[] a = {1,2,3,4,5,8,9};
        System.out.println(findElement(a, 9));
    }
}