import java.util.Arrays;

class SquareOfEachNumberAscending{
    public static int[] sortedSquares(int[] nums){
        int[] a = new int[nums.length];
        int aPointer = a.length-1;
        for(int i=0,j=nums.length-1;i<nums.length&&i<=j;){
            if(Math.abs(nums[i]) < Math.abs(nums[j]))
            {
                a[aPointer--] = nums[j] * nums[j];
                j--;
            }
            else
            {
                a[aPointer--] = nums[i] * nums[i];
                i++;
            }

        }
        return a;
    }

    public static void main(String... args){
        //int[] nums = {-4,-1,0,3,10};
        int[] nums = {-7,-3,2,3,11};
        int[] result = sortedSquares(nums);
        Arrays.stream(result).forEach(System.out::println);
    }
}