class MaxConsecutive1s{
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes=0;
        int tmpmaxconsecutiveOnes=0;
        for(int i=0;i<nums.length;i++) {
            while (i < nums.length && nums[i] == 1) {
                tmpmaxconsecutiveOnes += 1;
                i++;
            }
            if (tmpmaxconsecutiveOnes > maxConsecutiveOnes) {
                maxConsecutiveOnes = tmpmaxconsecutiveOnes;
            }
            tmpmaxconsecutiveOnes = 0;
        }
        return maxConsecutiveOnes;
    }
    public static void main(String... args){
        //int[] nums = {1,1,0,1,1,1};
        int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}