class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1;
        int right=n-1;
        for(int i=m+n-1;i>=0&&left>=0&&right>=0;i--){
            if(nums1[left] < nums2[right]){
                nums1[i] = nums2[right];
                right--;
            }
            else{
                nums1[i] = nums1[left];
                left--;
            }
        }
    }
}